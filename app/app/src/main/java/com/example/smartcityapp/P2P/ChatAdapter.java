package com.example.smartcityapp.P2P;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.text.format.DateFormat;

import com.bumptech.glide.Glide;
import com.example.smartcityapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;
/**
 * ChatAdapter class for managing the display of messages in a RecyclerView.
 * This adapter binds message data to the view components for each item in the RecyclerView.
 *
 * author: Lujin Sun (u7897414)
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MessageViewHolder> {
    private List<Message> messageList;
    private String currentUserId;

    /**
     * Constructor for ChatAdapter.
     *
     * @param messageList   List of messages to be displayed.
     * @param currentUserId ID of the current user.
     */
    public ChatAdapter(List<Message> messageList, String currentUserId){
        this.messageList = messageList;
        this.currentUserId = currentUserId;
    }
    /**
     * ViewHolder class for representing each message item.
     */
    public static class MessageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewSender;
        public TextView textViewMessage;
        public TextView textViewTimestamp;
        public ImageView imageViewAvatar;

        /**
         * Constructor for MessageViewHolder.
         *
         * @param itemView The view of the individual message item.
         */
    public MessageViewHolder(View itemView){
            super(itemView);
            textViewSender = itemView.findViewById(R.id.textViewSender);
            textViewMessage = itemView.findViewById(R.id.textViewName);
            textViewTimestamp = itemView.findViewById(R.id.textViewTimestamp);
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
    }
}

    /**
     * Called when RecyclerView needs a new ViewHolder for a message item.
     *
     * @param parent   The ViewGroup into which the new view will be added.
     * @param viewType The view type of the new view.
     * @return A new instance of MessageViewHolder.
     */
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    /**
     * Called to bind data to the view for a specific position in the RecyclerView.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the item.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position){
        Message message = messageList.get(position);

        // Set the sender's name: "You" for current user, otherwise display the sender's name
        if (message.getSenderId().equals(currentUserId)) {
            holder.textViewSender.setText("You");
        } else {
            holder.textViewSender.setText(message.getSender());  // 显示对方的名字
        }

        holder.textViewMessage.setText(message.getText());

        String formattedTime = DateFormat.format("hh:mm a", message.getTimestamp()).toString();
        holder.textViewTimestamp.setText(formattedTime);

        // Load the sender's avatar from Firebase
        String senderId = message.getSenderId();
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(senderId);
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String avatarPath = dataSnapshot.child("avatar").getValue(String.class);
                    if (avatarPath != null) {
                        // Get the download URL from Firebase Storage
                        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child(avatarPath);
                        storageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                            String avatarUrl = uri.toString();

                            // Load the avatar into the ImageView using Glide
                            Glide.with(holder.itemView.getContext())
                                    .load(avatarUrl)
                                    .placeholder(R.drawable.ic_avatar_placeholder)
                                    .error(R.drawable.ic_avatar_error)
                                    .into(holder.imageViewAvatar);
                        }).addOnFailureListener(exception -> {
                            // Set default error avatar if loading fails
                            holder.imageViewAvatar.setImageResource(R.drawable.ic_avatar_error);
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("ChatAdapter", "Failed to load user avatar: " + databaseError.getMessage());
            }
        });
    }
    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The size of the message list.
     */
    @Override
    public int getItemCount(){
        return messageList.size();
    }
}
