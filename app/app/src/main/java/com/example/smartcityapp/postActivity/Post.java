package com.example.smartcityapp.postActivity;

import java.util.HashMap;
import java.util.Map;
/**
 * This class represents a post in the application. Each post contains information such as
 * the user who created it, the post's content, the number of likes, and the timestamp of
 * when it was created. It also tracks which users liked the post using a map.
 *
 * @author Xuefei Luan
 */
public class Post {
    private String id; // Post ID
    public String user; // This will uniquely identify the user
    public String avatar;
    public String post_title;
    public String post_content;
    public int likes;
    public long timestamp;
    public Map<String, Boolean> likedBy; // Track which users liked the post

    public Post() {
        likedBy = new HashMap<>(); // Initialize likedBy map
    }

    public Post(String id, String user, String avatar, String post_title, String post_content, int likes, long timestamp) {
        this.id = id;
        this.user = user;
        this.avatar = avatar;
        this.post_title = post_title;
        this.post_content = post_content;
        this.likes = likes;
        this.timestamp = timestamp;
        this.likedBy = new HashMap<>(); // Initialize likedBy map
    }

    // Getters and Setters
    public String getId() { // Changed from getPostId to getId
        return id;
    }

    public void setId(String id) { // Changed from setPostId to setId
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPostTitle() {
        return post_title;
    }

    public String getPostContent() {
        return post_content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Map<String, Boolean> getLikedBy() {
        return likedBy;
    }

    public boolean isLikedByUser(String user) {
        return likedBy != null && likedBy.containsKey(user) && likedBy.get(user);
    }

    public void setLikedByUser(String user, boolean liked) {
        if (likedBy == null) {
            likedBy = new HashMap<>();
        }
        likedBy.put(user, liked);
    }
}
