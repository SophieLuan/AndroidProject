package com.example.smartcityapp.postActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.smartcityapp.P2P.ChatActivity;
import com.example.smartcityapp.Profile.Profile;
import com.example.smartcityapp.MainActivity;
import com.example.smartcityapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Display a list of posts retrieved from Firebase.
 * With the most recent posts shown first.
 * Dependencies: Firebase Realtime Database, Custom PostAdapter for displaying posts.
 *
 * @author Xuefei Luan (u7604123)
 */
public class PostActivity extends AppCompatActivity {
    private ListView postsListView;
    private PostAdapter postAdapter;
    private ArrayList<Post> postList;
    private DatabaseReference postDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        // Home button click listener
        Button homeButton = findViewById(R.id.btnHome);
        homeButton.setOnClickListener(view -> {
            Intent intent = new Intent(PostActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button infoButton = findViewById(R.id.btnInfo);
        infoButton.setOnClickListener(view -> {
            Intent intent = new Intent(PostActivity.this, ChatActivity.class);
            startActivity(intent);
        });

        // Like button click listener
        Button likeButton = findViewById(R.id.btnLike);
        likeButton.setOnClickListener(view -> {
            Intent intent = new Intent(PostActivity.this, Profile.class);
            startActivity(intent);
        });

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        postsListView = findViewById(R.id.postsListView);
        postList = new ArrayList<>();
        postAdapter = new PostAdapter(this, postList);
        postsListView.setAdapter(postAdapter);

        // Firebase ref
        postDatabase = FirebaseDatabase.getInstance().getReference("post");

        // Retrieve posts data
        postDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                postList.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Post post = postSnapshot.getValue(Post.class);
                        if (post != null) {
                            // Use the "id" field from the database directly as a String
                            String id = postSnapshot.child("id").getValue(String.class);
                            post.setId(id); // Set the postId directly from Firebase
                            postList.add(post);
                        }
                    }

                    // Sort posts by timestamp
                    Collections.sort(postList, (post1, post2) -> Long.compare(post2.getTimestamp(), post1.getTimestamp()));
                    postAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(PostActivity.this, "No posts available", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
