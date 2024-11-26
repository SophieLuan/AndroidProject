package com.example.smartcityapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.example.smartcityapp.postActivity.Post;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
/**
 * @author Zhengyu Peng u7727795
 */
public class PostTest {
    private Post post;

    @Before
    public void setUp() {

        post = new Post("1", "testuser", "avatar1.png", "Test Title", "This is a test content", 0, System.currentTimeMillis());
    }

    @Test
    public void testConstructorAndGetters() {

        assertEquals("1", post.getId());
        assertEquals("testuser", post.getUser());
        assertEquals("avatar1.png", post.getAvatar());
        assertEquals("Test Title", post.getPostTitle());
        assertEquals("This is a test content", post.getPostContent());
        assertEquals(0, post.getLikes());
        assertNotNull(post.getTimestamp());
        assertTrue(post.getLikedBy().isEmpty());
    }

    @Test
    public void testSetLikes() {

        post.setLikes(5);
        assertEquals(5, post.getLikes());
    }

    @Test
    public void testSetLikedByUserAndIsLikedByUser() {

        post.setLikedByUser("user1", true);
        assertTrue(post.isLikedByUser("user1"));

        post.setLikedByUser("user1", false);
        assertFalse(post.isLikedByUser("user1"));
    }

    @Test
    public void testLikedByMapInitialization() {

        assertNotNull(post.getLikedBy());
        assertTrue(post.getLikedBy().isEmpty());

        post.setLikedByUser("user1", true);
        assertFalse(post.getLikedBy().isEmpty());
    }

    @Test
    public void testSetId() {

        post.setId("123");
        assertEquals("123", post.getId());
    }

    @Test
    public void testLikedByFunctionality() {

        post.setLikedByUser("user1", true);
        post.setLikedByUser("user2", true);

        Map<String, Boolean> likedBy = post.getLikedBy();
        assertTrue(likedBy.containsKey("user1"));
        assertTrue(likedBy.containsKey("user2"));
        assertTrue(post.isLikedByUser("user1"));
        assertTrue(post.isLikedByUser("user2"));


        post.setLikedByUser("user1", false);
        assertFalse(post.isLikedByUser("user1"));
    }
}
