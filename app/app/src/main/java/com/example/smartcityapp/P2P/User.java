package com.example.smartcityapp.P2P;
/**
 * User class representing a user in the chat application.
 * This class contains information about the user ID, name, and avatar.
 *
 * author: Lujin Sun (u7897414)
 */
public class User {
    private String uid;
    private String name;
    private String avatar;

    public User() {
        // Default constructor for Firebase
    }

    /**
     * Constructor for creating a new User instance.
     *
     * @param uid    The unique ID of the user.
     * @param name   The name of the user.
     * @param avatar The avatar URL or path of the user.
     */
    public User(String uid, String name, String avatar) {
        this.uid = uid;
        this.name = name;
        this.avatar = avatar;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }
}
