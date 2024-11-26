package com.example.smartcityapp;

import com.example.smartcityapp.P2P.ChatAdapter;
import com.example.smartcityapp.P2P.Message;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * @author Zhengyu Peng u7727795
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = {30})
public class ChatAdapterTest {

    private ChatAdapter chatAdapter;
    private List<Message> messageList;

    @Mock
    FirebaseDatabase mockFirebaseDatabase;

    @Mock
    FirebaseStorage mockFirebaseStorage;

    @Before
    public void setUp() {

        MockitoAnnotations.openMocks(this);

        messageList = new ArrayList<>();
        System system = null;
        messageList.add(new Message("A", "Hello there!", system.currentTimeMillis(), "a"));
        messageList.add(new Message("B", "How are you?", system.currentTimeMillis(), "b"));

        chatAdapter = new ChatAdapter(messageList, "A");

        when(mockFirebaseDatabase.getReference("users")).thenReturn(mock(DatabaseReference.class));
        when(mockFirebaseStorage.getReference()).thenReturn(mock(StorageReference.class));
    }

    @Test
    public void testGetItemCount() {
        assertEquals(2, chatAdapter.getItemCount());
    }

    @Test
    public void testCurrentUserMessage() {

        Message message = messageList.get(0);
        assertEquals("a", message.getSenderId());
    }

    @Test
    public void testOtherUserMessage() {

        Message message = messageList.get(1);
        assertNotEquals("a", message.getSenderId());
    }

    @Test
    public void testEmptyMessageList() {

        messageList.clear();
        chatAdapter = new ChatAdapter(messageList, "a");

        assertEquals(0, chatAdapter.getItemCount());
    }
    @Test
    public void testMessageContent() {
        Message message = messageList.get(0);
        assertEquals("Hello there!", message.getText());
    }

    @Test
    public void testMessageSenderName() {
        Message message1 = messageList.get(0);
        Message message2 = messageList.get(1);

        assertEquals("A", message1.getSender());
        assertEquals("B", message2.getSender());
    }

}
