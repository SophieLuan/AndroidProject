package com.example.smartcityapp.P2P;
/**
 * Message class representing a chat message.
 * This class contains information about the sender, message text, timestamp, and sender ID.
 * author: Lujin Sun (u7897414)
 */
public class Message {
    private String sender;
    private String text;
    private long timestamp;
    private String senderId;

    /**
     * Default constructor for Firebase.
     * Required for deserialization of data from Firebase.
     */
    public Message(){
        //default constructor for firebase
    }
    /**
     * Constructor for creating a new Message instance.
     *
     * @param sender    The name of the sender.
     * @param text      The content of the message.
     * @param timestamp The time the message was sent.
     * @param senderId  The unique ID of the sender.
     */
    public Message(String sender, String text, long timestamp, String senderId){
        this.sender = sender;
        this.text = text;
        this.timestamp = timestamp;
        this.senderId = senderId;
    }
    public String getSender(){
        return sender;
    }
    public String getText(){
        return text;
    }
    public long getTimestamp(){
        return timestamp;
    }
    public String getSenderId(){return senderId;}
}
