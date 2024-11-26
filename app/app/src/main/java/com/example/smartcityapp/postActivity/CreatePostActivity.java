package com.example.smartcityapp.postActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcityapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * This class represents the activity where a user can create a new post. It handles the UI interactions,
 * user input validation, and saves the post to Firebase. The user can either confirm to create the post
 * or cancel to go back to the previous screen.
 * Function:
 * - Allows users to create new posts which are stored in Firebase.
 * - New added posts are Displayed on the post page after submitting.
 * Dependencies: Firebase (for database and user authentication)
 *
 * @author Xuefei Luan (u7604123)
 */
public class CreatePostActivity extends AppCompatActivity {

    private EditText postTitleInput, postContentInput;  // Updated variable names to avoid confusion
    private Button btnConfirm, btnCancel;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        // Initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("post");

        // UI References
        postTitleInput = findViewById(R.id.postTitle);
        postContentInput = findViewById(R.id.postContent);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnCancel = findViewById(R.id.btnCancel);

        // Get the current logged-in user details
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        // Confirm button logic to create a post
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = postTitleInput.getText().toString().trim();
                String content = postContentInput.getText().toString().trim();

                // Validation check
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
                    Toast.makeText(CreatePostActivity.this, "Please fill both fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // If currentUser is not null (user is logged in)
                if (currentUser != null) {
                    String userName = currentUser.getEmail();

                    // Retrieve the user's avatar URL
                    String avatarUrl;
                    if (currentUser.getPhotoUrl() != null) {
                        avatarUrl = currentUser.getPhotoUrl().toString();  // Use the user's own avatar
                    } else {
                        avatarUrl = "https://i.pravatar.cc/150?img=67";  // Default avatar URL
                    }

                    // Get the current timestamp
                    long timestamp = System.currentTimeMillis();

                    // Get a reference to the Firebase node and generate a unique post ID
                    DatabaseReference newPostRef = databaseReference.push();
                    String id = newPostRef.getKey(); // Retrieve the unique post ID

                    // Create the Post object with the determined avatar URL and timestamp
                    Post post = new Post(id, userName, avatarUrl, title, content, 0, timestamp);  // Ensure consistent names

                    // Save the post to Firebase using the newPostRef and set the postId in the Post object
                    newPostRef.setValue(post).addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(CreatePostActivity.this, "Post created successfully", Toast.LENGTH_SHORT).show();
                            // Redirect to the post page or homepage
                            Intent intent = new Intent(CreatePostActivity.this, PostActivity.class);
                            startActivity(intent);
                            finish();  // Close the current activity
                        } else {
                            Toast.makeText(CreatePostActivity.this, "Failed to create post", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });

        // Cancel button to go back to the homepage
        btnCancel.setOnClickListener(v -> {
            finish();  // Close the activity and go back to homepage
        });
    }
}
