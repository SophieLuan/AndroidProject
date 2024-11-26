package com.example.smartcityapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.smartcityapp.postActivity.CommentModel;

/**
 * @author Zhengyu Peng u7727795
 */
public class CommentModelTest {

    private CommentModel commentModel;

    @Before
    public void setUp() {
        // Initialize the CommentModel before each test
        commentModel = new CommentModel("user123", "https://example.com/avatar.png", "This is a comment.");
    }

    @Test
    public void testConstructorAndGetters() {
        // Test the constructor and getters
        assertEquals("user123", commentModel.getUser());
        assertEquals("https://example.com/avatar.png", commentModel.getAvatar());
        assertEquals("This is a comment.", commentModel.getComment());
    }

    @Test
    public void testSetUser() {
        // Test setUser method
        commentModel.setUser("newUser");
        assertEquals("newUser", commentModel.getUser());
    }

    @Test
    public void testSetAvatar() {
        // Test setAvatar method
        commentModel.setAvatar("https://newexample.com/avatar.png");
        assertEquals("https://newexample.com/avatar.png", commentModel.getAvatar());
    }

    @Test
    public void testSetComment() {
        // Test setComment method
        commentModel.setComment("New comment");
        assertEquals("New comment", commentModel.getComment());
    }

    @Test
    public void testDefaultConstructor() {
        // Test the default constructor
        CommentModel emptyModel = new CommentModel();
        assertNull(emptyModel.getUser());
        assertNull(emptyModel.getAvatar());
        assertNull(emptyModel.getComment());
    }
}
