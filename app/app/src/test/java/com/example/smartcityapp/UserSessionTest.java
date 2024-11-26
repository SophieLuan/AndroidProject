package com.example.smartcityapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.smartcityapp.Login.UserSession;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * @author Zhengyu Peng u7727795
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = {30})
public class UserSessionTest {

    @Mock
    Context mockContext;

    @Mock
    SharedPreferences mockSharedPreferences;

    @Mock
    SharedPreferences.Editor mockEditor;

    @Mock
    FirebaseDatabase mockFirebaseDatabase;

    @Mock
    DatabaseReference mockUserLikesRef;

    private UserSession userSession;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        when(mockContext.getSharedPreferences("UserSession", Context.MODE_PRIVATE)).thenReturn(mockSharedPreferences);
        when(mockSharedPreferences.edit()).thenReturn(mockEditor);
        when(mockEditor.putString(anyString(), anyString())).thenReturn(mockEditor);
        when(mockEditor.putBoolean(anyString(), anyBoolean())).thenReturn(mockEditor);
        when(mockEditor.clear()).thenReturn(mockEditor);
        when(mockFirebaseDatabase.getReference("user_likes")).thenReturn(mockUserLikesRef);


        userSession = UserSession.getInstance(mockContext);
    }

    @Test
    public void testSingletonInstance() {

        UserSession session1 = UserSession.getInstance(mockContext);
        UserSession session2 = UserSession.getInstance(mockContext);
        assertSame(session1, session2);
    }

    @Test
    public void testIsLoggedIn() {

        when(mockSharedPreferences.getBoolean("isLoggedIn", false)).thenReturn(true);
        assertTrue(userSession.isLoggedIn());
    }

    @Test
    public void testIsLoggedInWhenNotLoggedIn() {
        when(mockSharedPreferences.getBoolean("isLoggedIn", false)).thenReturn(false);

        assertFalse(userSession.isLoggedIn());
    }



}
