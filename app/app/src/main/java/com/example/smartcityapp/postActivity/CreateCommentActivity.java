package com.example.smartcityapp.postActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcityapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the creation of comments for a specific post. It allows users
 * to view a post, read existing comments, and add new comments to Firebase.
 * Functions:
 * - Loads post details from Firebase.
 * - Displays existing comments.
 * - Allows users to add new comments which are stored in Firebase.
 * Dependencies: Firebase Realtime Database, Firebase Authentication, Glide (for image loading)
 *
 * @author Xuefei Luan (u7604123)
 */

public class CreateCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_comment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String id = getIntent().getStringExtra("id");
        // Now use the postId to load the post and comments
        if (id != null) {
            loadPostData(id); // Load post data based on postId

        }
        Button submitButton = findViewById(R.id.btnConfirmComment);
        Button cancelButton = findViewById(R.id.btnCancelComment);

        submitButton.setOnClickListener(v -> {

            if (id != null) {
                submitComment(id); // Submit the comment
            }
            // After submitting, navigate to PostActivity
            Intent intent = new Intent(CreateCommentActivity.this, PostActivity.class);
            startActivity(intent);
            finish(); // Close the current activity
        });

        cancelButton.setOnClickListener(v -> {

            // Show a toast message for cancelled comment
            Toast.makeText(CreateCommentActivity.this, "Cancelled comment", Toast.LENGTH_SHORT).show();

            // When the user clicks cancel, navigate to PostActivity
            Intent intent = new Intent(CreateCommentActivity.this, PostActivity.class);
            startActivity(intent);
            finish(); // Close the current activity
        });
    }

    /**
     * Loads the data for a specific post from Firebase, including the post's title, content,
     * avatar, and user information. It also retrieves and displays any existing comments for the post.
     *
     * @param postId The ID of the post to be loaded.
     */
    private void loadPostData(String postId) {
        // Get a reference to the specific post in Firebase
        DatabaseReference postRef = FirebaseDatabase.getInstance().getReference("post").child(postId);

        // Fetch the post data, including postTitle, postContent, and comments
        postRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Retrieve post data
                String post_title = snapshot.child("post_title").getValue(String.class);
                String post_content = snapshot.child("post_content").getValue(String.class);
                String avatar = snapshot.child("avatar").getValue(String.class); // Retrieve avatar URL
                String userName = snapshot.child("user").getValue(String.class);

                // Set post data into UI elements
                TextView postTitleTextView = findViewById(R.id.postTitle);
                TextView postContentTextView = findViewById(R.id.postContent);
                TextView postUser = findViewById(R.id.userName);
                postUser.setText(userName);
                postTitleTextView.setText(post_title);
                postContentTextView.setText(post_content);
                ImageView postAvatarImageView = findViewById(R.id.avatar);
                // Load the avatar image using Glide or any other image loading library
                Glide.with(CreateCommentActivity.this).load(avatar).into(postAvatarImageView);

                // Now retrieve comments from the "comments" node
                if (snapshot.hasChild("comments")) {
                    List<CommentModel> commentList = new ArrayList<>();
                    for (DataSnapshot commentSnapshot : snapshot.child("comments").getChildren()) {
                        CommentModel comment = commentSnapshot.getValue(CommentModel.class);
                        if (comment != null) {
                            commentList.add(comment);
                        }
                    }

                    // Set the adapter with the comments
                    RecyclerView recyclerView = findViewById(R.id.commentsRecyclerView);
                    CommentAdapter adapter = new CommentAdapter(commentList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(CreateCommentActivity.this));
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CreateCommentActivity.this, "Failed to load post data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Submits a new comment to Firebase under the specified post's "comments" node. It retrieves the
     * user's avatar URL and display name or email, then pushes the comment data to Firebase.
     *
     * @param id The unique ID of the post to which the comment is being added.
     */
    private void submitComment(String id) {
        EditText commentEditText = findViewById(R.id.commentContent);
        String commentText = commentEditText.getText().toString().trim();

        if (commentText.isEmpty()) {
            Toast.makeText(CreateCommentActivity.this, "Please enter a comment.", Toast.LENGTH_SHORT).show();
            return;
        }
        Uri photoUri = FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl();
        String avatarUrl = (photoUri != null) ? photoUri.toString() : "https://i.pravatar.cc/150?img=67";
        // Get the user display name if not null, otherwise use email
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String user = (currentUser.getDisplayName() != null) ? currentUser.getDisplayName() : currentUser.getEmail();

        // Create a new comment object
        CommentModel comment = new CommentModel(user, avatarUrl, commentText);

        // Push the comment to Firebase under the post's "comments" node
        DatabaseReference commentRef = FirebaseDatabase.getInstance().getReference("post").child(id).child("comments");
        commentRef.push().setValue(comment).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                commentEditText.setText(""); // Clear the input field
                Toast.makeText(CreateCommentActivity.this, "Comment added!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(CreateCommentActivity.this, "Failed to add comment.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}