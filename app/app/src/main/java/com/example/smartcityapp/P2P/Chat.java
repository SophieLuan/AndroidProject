package com.example.smartcityapp.P2P;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.HashMap;
import java.util.Map;
/**
 * Chat class for handling sending and receiving messages between users.
 * Uses Firebase Firestore to store and retrieve messages.
 * author: Lujin Sun (u7897414)
 */
public class Chat {
    // Firestore database instance
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    /**
     * Sends a message from a sender to a recipient.
     *
     * @param senderId    The ID of the sender.
     * @param recipientId The ID of the recipient.
     * @param messageText The message content to be sent.
     */
    public void sendMessage(String senderId, String recipientId, String messageText) {
        String chatId = generateChatId(senderId, recipientId);
        long timestamp = System.currentTimeMillis();
        // Create a map to store message data, including sender, text, and timestamp.
        Map<String, Object> message = new HashMap<>();
        message.put("sender", senderId);
        message.put("text", messageText);
        message.put("timestamp", timestamp);
        // Add the message to the "messages" collection within the specific chat document.
        db.collection("chats").document(chatId)
                .collection("messages")
                .add(message)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
     }

    /**
     * Listens for new messages between a sender and recipient.
     *
     * @param senderId    The ID of the sender.
     * @param recipientId The ID of the recipient.
     * @param listener    The listener to handle new messages.
     */
     public void listenForMessage(String senderId, String recipientId, MessageListener listener){
        String chatId = generateChatId(senderId, recipientId);
         // Listen for changes in the "messages" collection within the chat document.
        db.collection("chats").document(chatId)
                .collection("messages")
                .orderBy("timestamp")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots, @Nullable FirebaseFirestoreException e) {
                     if(e != null){
                         return;
                     }
                     if(snapshots != null && !snapshots.isEmpty()){
                         for (DocumentChange dc : snapshots.getDocumentChanges()){
                            if (dc.getType() == DocumentChange.Type.ADDED){
                             Map<String, Object> messageData = dc.getDocument().getData();
                             String messageText = messageData.get("text").toString();
                             String sender = messageData.get("sender").toString();
                             long timestamp = (long) messageData.get("timestamp");

                             listener.onNewMessage(sender,messageText, timestamp);
                             }
                         }
                     }
                    }
                });
     }
    /**
     * Generates a unique chat ID based on the sender and recipient IDs.
     * The chat ID is always consistent regardless of the order of the IDs.
     *
     * @param senderId    The ID of the sender.
     * @param recipientId The ID of the recipient.
     * @return A unique chat ID for the sender and recipient.
     */
     private String generateChatId(String senderId, String recipientId){
         // Ensure the chat ID is always the same regardless of the order of sender and recipient
        return senderId.compareTo(recipientId) < 0? senderId + "_" + recipientId : recipientId + "_" + senderId;
     }

     public interface MessageListener{
        void onNewMessage(String sender, String messageText, long timestamp);
     }
}

