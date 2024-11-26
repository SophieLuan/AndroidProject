package com.example.smartcityapp.postActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.smartcityapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * This class handles the display of post data,
 * including user information, title, content, likes, and the ability to like/unlike a post or add comments.
 * It uses Firebase to store and retrieve post-related data, and Glide for loading user avatars.

 * Dependencies: Firebase Realtime Database, Firebase Authentication, Glide (for image loading)
 *
 * @author Xuefei Luan (u7604123)
 * @author Zhengyu Peng u7727795(Optimize the like logic)
 * @author Ziang Wang u7748243(Add informative feedback for user actions)
 */
public class PostAdapter extends ArrayAdapter<Post> {
    private Context context;
    private DatabaseReference postDatabase;

    public PostAdapter(Context context, List<Post> posts) {
        super(context, 0, posts);
        this.context = context;
        this.postDatabase = FirebaseDatabase.getInstance().getReference("post");
    }

    /**
     * Formats a timestamp into a human-readable date and time.
     *
     * @param timestamp The timestamp to format.
     * @return A formatted date and time string (e.g., "Oct 16, 2024 08:45 AM").
     */
    // Helper method to format the timestamp
    private String formatTime(long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.getDefault());
        return sdf.format(date);
    }


    /**
     * It handles populating data into the views, such as post content, likes, user info, and buttons.
     * Returns a view for displaying a post at a specific position in the ListView.
     *
     * @param position    The position of the post in the ListView.
     * @param convertView The view to reuse, if possible.
     * @param parent      The parent view group.
     * @return A populated view for the post at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Post post = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_post, parent, false);
        }

        // Find views
        TextView userName = convertView.findViewById(R.id.userName);
        ImageView avatar = convertView.findViewById(R.id.avatar);
        TextView postTitle = convertView.findViewById(R.id.postTitle);
        TextView postContent = convertView.findViewById(R.id.postContent);
        TextView likes = convertView.findViewById(R.id.likes);
        Button likeButton = convertView.findViewById(R.id.thumbup);
        TextView postTime = convertView.findViewById(R.id.postTime);
        Button commentButton = convertView.findViewById(R.id.commentButton);

        // Populate data
        userName.setText(post.getUser());
        postTitle.setText(post.getPostTitle());
        postContent.setText(post.getPostContent());
        likes.setText(post.getLikes() + " Likes");

        // Use Glide to load avatar images from URL
        Glide.with(getContext()).load(post.getAvatar()).into(avatar);

        // Format and set the timestamp
        long timestamp = post.getTimestamp();
        String formattedTime = formatTime(timestamp);
        postTime.setText(formattedTime);

        // Handle the like button click
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid(); // Get current user ID

        // Check if the user has already liked the post (this will be loaded from Firebase)
        updateLikeButtonFromFirebase(post, userId, likes, likeButton);

        // Like/Unlike button click logic
        likeButton.setOnClickListener(v -> {
            if (!post.isLikedByUser(userId)) {

                // Show a toast message indicating the user liked this post
                Toast.makeText(context, "Liked this post", Toast.LENGTH_SHORT).show();

                likePost(post, userId, likes, likeButton);
            } else {

                // Show a toast message indicating the user unliked this post
                Toast.makeText(context, "Unliked this post", Toast.LENGTH_SHORT).show();

                unlikePost(post, userId, likes, likeButton);
            }
        });

        // Handle the comment button click
        commentButton.setOnClickListener(v -> {

            // Show a toast message indicating the user can comment
            Toast.makeText(context, "Comment here", Toast.LENGTH_SHORT).show();

            // Create an intent to start CreateCommentActivity
            Intent intent = new Intent(context, CreateCommentActivity.class);

            // Pass the post ID to the activity
            intent.putExtra("id", post.getId());

            // Start the CreateCommentActivity
            context.startActivity(intent);
        });

        return convertView;
    }

    /**
     * Updates the like button text and like count by fetching the liked status from Firebase.
     *
     * @param post        The post object containing the current post data.
     * @param userId      The ID of the current user.
     * @param likesView   The TextView showing the number of likes.
     * @param likeButton  The Button to be updated with the correct "Like" or "Unlike" text.
     */
    private void updateLikeButtonFromFirebase(Post post, String userId, TextView likesView, Button likeButton) {
        String postId = post.getId();

        // Check for null postId
        if (postId == null || postId.isEmpty()) {
            Toast.makeText(context, "Error: Invalid post ID", Toast.LENGTH_SHORT).show();
            return;
        }

        DatabaseReference postRef = postDatabase.child(postId).child("likedBy");

        // Check if the current user has liked this post
        postRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && (Boolean) dataSnapshot.getValue()) {
                    // User has liked the post
                    post.setLikedByUser(userId, true);
                    likeButton.setText("Unlike");
                } else {
                    // User has not liked the post
                    post.setLikedByUser(userId, false);
                    likeButton.setText("Like");
                }

                // Update the like count
                likesView.setText(post.getLikes() + " Likes");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(context, "Failed to load like status", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Handles liking a post by updating the Firebase database and UI.
     */
    private void likePost(Post post, String userId, TextView likesView, Button likeButton) {
        String postId = post.getId(); // Ensure postId is correctly retrieved

        // Check for null postId
        if (postId == null || postId.isEmpty()) {
            Toast.makeText(context, "Error: Invalid post ID", Toast.LENGTH_SHORT).show();
            return;
        }

        // Increment the likes and mark the post as liked by the user
        DatabaseReference postRef = postDatabase.child(postId);
        postRef.child("likes").setValue(post.getLikes() + 1);
        postRef.child("likedBy").child(userId).setValue(true);

        // Update UI
        post.setLikes(post.getLikes() + 1);
        post.setLikedByUser(userId, true);
        likesView.setText(post.getLikes() + " Likes");

        // Update button text
        updateLikeButtonText(post, userId, likeButton);
    }


    /**
     * Handles unliking a post by updating the Firebase database and UI.
     */
    private void unlikePost(Post post, String userId, TextView likesView, Button likeButton) {
        String postId = post.getId(); // Ensure postId is correctly retrieved

        // Check for null postId
        if (postId == null || postId.isEmpty()) {
            Toast.makeText(context, "Error: Invalid post ID", Toast.LENGTH_SHORT).show();
            return;
        }

        // Decrement the likes and mark the post as unliked by the user
        DatabaseReference postRef = postDatabase.child(postId);
        postRef.child("likes").setValue(post.getLikes() - 1);
        postRef.child("likedBy").child(userId).removeValue();

        // Update UI
        post.setLikes(post.getLikes() - 1);
        post.setLikedByUser(userId, false);
        likesView.setText(post.getLikes() + " Likes");

        // Update button text
        updateLikeButtonText(post, userId, likeButton);
    }

    /**
     * Updates the like button text based on whether the user has liked the post.
     *
     * @param post        The post object.
     * @param userId      The ID of the current user.
     * @param likeButton  The Button to update with "Like" or "Unlike".
     */
    private void updateLikeButtonText(Post post, String userId, Button likeButton) {
        if (post.isLikedByUser(userId)) {
            likeButton.setText("Unlike");
        } else {
            likeButton.setText("Like");
        }
    }

}
