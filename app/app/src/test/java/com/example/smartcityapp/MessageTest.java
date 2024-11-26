package com.example.smartcityapp;

import static org.junit.Assert.assertEquals;

import com.example.smartcityapp.P2P.Message;

import org.junit.Test;

/**
 * Unit tests for the Message class.
 *
 * author: Lujin Sun
 */
public class MessageTest {

    @Test
    public void testMessageConstructorAndGetters() {
        String sender = "User1";
        String text = "Test Message";
        long timestamp = System.currentTimeMillis();
        String senderId = "user1";

        Message message = new Message(sender, text, timestamp, senderId);

        assertEquals(sender, message.getSender());
        assertEquals(text, message.getText());
        assertEquals(timestamp, message.getTimestamp());
        assertEquals(senderId, message.getSenderId());
    }
}
