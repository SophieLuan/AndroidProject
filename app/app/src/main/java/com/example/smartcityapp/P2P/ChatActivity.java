package com.example.smartcityapp.P2P;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcityapp.MainActivity;
import com.example.smartcityapp.Profile.Profile;
import com.example.smartcityapp.R;
import com.example.smartcityapp.postActivity.PostActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
/**
 * ChatActivity class handles displaying the list of users and navigating to specific chat pages.
 * This activity allows the user to see a list of available users and start a chat.
 * author: Lujin Sun (u7897414)
 */
public class ChatActivity extends AppCompatActivity {
    private RecyclerView recyclerViewUsers;
    private UserAdapter userAdapter;
    private List<User> userList = new ArrayList<>();
    private DatabaseReference usersRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Initialize and set up the Home button to navigate to the MainActivity
        Button homeButton = findViewById(R.id.btnHome);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Initialize and set up the Post button to navigate to the PostActivity
        Button postButton = findViewById(R.id.btnPost);
        postButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

        // Initialize and set up the Like button to navigate to the Profile activity
        Button likeButton = findViewById(R.id.btnLike);
        likeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        // Set up RecyclerView to display the list of users
        recyclerViewUsers = findViewById(R.id.recyclerViewUsers);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));

        // Initialize UserAdapter with a click listener for starting a chat with a selected user
        userAdapter = new UserAdapter(userList, user -> {
            // Clicking on a user starts a chat
            if (user.getUid() != null) {
                // Show a toast message when the user is clicked
                Toast.makeText(ChatActivity.this, "Start chatting", Toast.LENGTH_SHORT).show();

                // Proceed to navigate to the chat detail page
                Intent intent = new Intent(ChatActivity.this, ChatDetailActivity.class);
                intent.putExtra("RECIPIENT_ID", user.getUid());  // Pass the recipient ID
                startActivity(intent);
            } else {
                Toast.makeText(ChatActivity.this, "User ID is null", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerViewUsers.setAdapter(userAdapter);

        // Fetch all users from Firebase Database
        usersRef = FirebaseDatabase.getInstance().getReference("users");
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userList.clear();
                // Iterate over each user snapshot and add the user to the list
                for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);
                    if (user != null) {
                        userList.add(user);
                    }
                }
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ChatActivity.this, "Failed to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


