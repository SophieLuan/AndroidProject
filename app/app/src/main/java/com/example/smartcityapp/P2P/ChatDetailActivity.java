package com.example.smartcityapp.P2P;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcityapp.MainActivity;
import com.example.smartcityapp.Profile.Profile;
import com.example.smartcityapp.R;
import com.example.smartcityapp.postActivity.PostActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
/**
 * ChatDetailActivity class handles displaying and sending messages between the current user and a recipient.
 * This activity allows the user to see the message history and send new messages in real time.
 * author: Lujin Sun (u7897414)
 */
public class ChatDetailActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMessages;
    private ChatAdapter chatAdapter;
    private List<Message> messageList = new ArrayList<>();
    private String currentUserId;
    private String recipientId;
    private Chat chat;
    private EditText editTextMessage;
    private Button buttonSend;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        // Initialize and set up the Home button to navigate to the MainActivity
        Button homeButton = findViewById(R.id.btnHome);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ChatDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button postButton = findViewById(R.id.btnPost);
        postButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ChatDetailActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

        Button likeButton = findViewById(R.id.btnLike);
        likeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ChatDetailActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        // Get the current user's ID and the recipient's ID from the intent
        currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        recipientId = getIntent().getStringExtra("RECIPIENT_ID");

        if (recipientId == null) {
            Toast.makeText(this, "Recipient ID is null", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Initialize views
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        recyclerViewMessages = findViewById(R.id.recyclerViewUsers);
        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setText(R.string.Back);


        chatAdapter = new ChatAdapter(messageList, currentUserId);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(chatAdapter);
        // Initialize Chat instance for sending and receiving messages
        chat = new Chat();

        // Set up send button to send a message
        buttonSend.setOnClickListener(v -> {
            sendMessage(); // This sends the message
            // Show a toast message indicating the message was sent successfully
            Toast.makeText(ChatDetailActivity.this, "Send successfully", Toast.LENGTH_SHORT).show();
        });

        // Inside the onCreate method, modify the buttonBack's OnClickListener
        buttonBack.setOnClickListener(v -> {
            // Show a toast message when the back button is clicked
            Toast.makeText(ChatDetailActivity.this, "Back to Contacts", Toast.LENGTH_SHORT).show();

            // Navigate back to the previous activity (contacts)
            onBackPressed();
        });


        // Listen for new messages in real-time
        chat.listenForMessage(currentUserId, recipientId, new Chat.MessageListener() {
            @Override
            public void onNewMessage(String senderId, String messageText, long timestamp) {
                // If the current user sent the message, display "You" as the sender
                if (senderId.equals(currentUserId)) {
                    messageList.add(new Message("You", messageText, timestamp, senderId));
                    chatAdapter.notifyItemInserted(messageList.size() - 1);
                    recyclerViewMessages.scrollToPosition(messageList.size() - 1);
                } else {
                    // If the message is from the recipient, get their name from the database
                    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(senderId);
                    userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                String senderName = dataSnapshot.child("name").getValue(String.class);
                                messageList.add(new Message(senderName, messageText, timestamp, senderId));
                                chatAdapter.notifyItemInserted(messageList.size() - 1);
                                recyclerViewMessages.scrollToPosition(messageList.size() - 1);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("ChatDetailActivity", "Failed to get sender name: " + databaseError.getMessage());
                        }
                    });
                }
            }
        });
    }

    /**
     * Sends a message to the recipient.
     * If the message is not empty, it sends the message using the Chat instance.
     */
    private void sendMessage() {
        String messageText = editTextMessage.getText().toString().trim();
        if (!messageText.isEmpty()) {
            chat.sendMessage(currentUserId, recipientId, messageText);
            editTextMessage.setText("");
        }
    }
}
