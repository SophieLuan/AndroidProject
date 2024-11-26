package com.example.smartcityapp.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.smartcityapp.Login.Login;
import com.example.smartcityapp.MainActivity;
import com.example.smartcityapp.P2P.ChatActivity;
import com.example.smartcityapp.R;
import com.example.smartcityapp.postActivity.Post;
import com.example.smartcityapp.postActivity.PostActivity;
import com.example.smartcityapp.postActivity.PostAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

/**
 * The activity retrieves user data from Firebase Authentication
 * and loads liked posts from Firebase Database.
 * users can view their profile information,
 * including their avatar, display name, email, and the list of posts they have liked.
 * Dependencies: Firebase Authentication, Firebase Realtime Database, Glide (for image loading)
 *
 * @author
 * - Initial implemented by Zhengyu Peng (u7727795)
 * - Firebase data retrieved by Xuefei Luan (u7604123)
 *
 */
public class Profile extends AppCompatActivity {

    private ImageView userAvatar;
    private TextView userName, userEmail;
    private ListView likedPostsListView;
    public DatabaseReference postsDatabase;
    public ArrayList<Post> likedPostsList;
    private PostAdapter likedPostsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // UI elements
        userAvatar = findViewById(R.id.profileAvatar);
        userName = findViewById(R.id.profileName);
        userEmail = findViewById(R.id.profileEmail);
        likedPostsListView = findViewById(R.id.likeList);

        // Get current user info
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {
            String displayName = currentUser.getDisplayName();
            String email = currentUser.getEmail();
            String avatarUrl = currentUser.getPhotoUrl() != null ? currentUser.getPhotoUrl().toString() : "https://i.pravatar.cc/150?img=67";

            // Set user information
            userName.setText(displayName);
            userEmail.setText(email);
            Glide.with(this).load(avatarUrl).into(userAvatar);

            // Load liked posts
            loadLikedPosts(currentUser.getUid());
        }

        // Post button click listener
        Button postButton = findViewById(R.id.btnPost);
        postButton.setOnClickListener(view -> {
            Intent intent = new Intent(Profile.this, PostActivity.class);
            startActivity(intent);
        });

        Button infoButton = findViewById(R.id.btnInfo);
        infoButton.setOnClickListener(view -> {
            Intent intent = new Intent(Profile.this, ChatActivity.class);
            startActivity(intent);
        });
        // Home button click listener
        Button homeButton = findViewById(R.id.btnHome);
        homeButton.setOnClickListener(view -> {
            Intent intent = new Intent(Profile.this, MainActivity.class);
            startActivity(intent);
        });


        /**
         * After logging out return to login page, and firebase sign out.
         * @author Zhengyu Peng (u7727795)
         * @author Xuefei Luan (u7604123)
         */
        // Logout button click listener
        Button logoutButton = findViewById(R.id.logout);
        logoutButton.setOnClickListener(view -> {
            // Perform Firebase sign out
            FirebaseAuth.getInstance().signOut();

            // Show a toast message indicating successful logout
            Toast.makeText(Profile.this, "Logout successfully", Toast.LENGTH_SHORT).show();

            // Redirect to the login activity
            Intent intent = new Intent(Profile.this, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);  // Clear previous activities
            startActivity(intent);
            finish();  // Finish the current activity to prevent going back to it
        });
    }

    /**
     * Loads the posts that the current user has liked from Firebase Database.
     * The method queries the "post" node in the database and checks if the user has liked each post.
     * The liked posts are then displayed in the ListView using the PostAdapter.
     *
     * @param userId The unique ID of the user whose liked posts are being loaded.
     *
     * @author Zhengyu Peng (u7727795)(Initial implementation)
     * @author Xuefei Luan(u7604123)(Debug and load data from firebase)
     */
    // Load liked posts from Firebase
    public void loadLikedPosts(String userId) {
        likedPostsList = new ArrayList<>();
        postsDatabase = FirebaseDatabase.getInstance().getReference("post");

        // Query to get posts that the user has liked
        postsDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                likedPostsList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    if (post != null && post.isLikedByUser(userId)) {
                        likedPostsList.add(post);  // Add liked post to the list
                    }
                }
                likedPostsAdapter.notifyDataSetChanged(); // Notify the adapter
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });

        // Initialize the adapter and set it to the ListView
        likedPostsAdapter = new PostAdapter(this, likedPostsList);
        likedPostsListView.setAdapter(likedPostsAdapter);
    }
}
