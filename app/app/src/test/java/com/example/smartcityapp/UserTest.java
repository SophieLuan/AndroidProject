package com.example.smartcityapp;

import static org.junit.Assert.assertEquals;

import com.example.smartcityapp.P2P.User;

import org.junit.Test;

/**
 * Unit tests for the User class.
 *
 * author: Lujin Sun
 */
public class UserTest {

    @Test
    public void testUserConstructorAndGetters() {
        String uid = "user1";
        String name = "John Doe";
        String avatar = "avatarPath";

        User user = new User(uid, name, avatar);

        assertEquals(uid, user.getUid());
        assertEquals(name, user.getName());
        assertEquals(avatar, user.getAvatar());
    }
}

