package com.example.smartcityapp;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.example.smartcityapp.Login.Signup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import android.content.Context;

import com.google.android.gms.tasks.Task;

/**
 * @author Zhengyu Peng u7727795
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = {30})
public class SignupTest {

    @Mock
    private FirebaseAuth mockAuth;
    @Mock
    private DatabaseReference mockDatabaseRef;
    @Mock
    private StorageReference mockStorageRef;
    @Mock
    private Context mockContext;
    @Mock
    private Task<AuthResult> mockAuthTask;
    @Mock
    private AuthResult mockAuthResult;

    private Signup signup;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        signup = new Signup(mockContext, mockAuth, mockDatabaseRef, mockStorageRef);
    }



    @Test
    public void testRegisterUser_successfulRegistration() {
        // Arrange
        String email = "test@example.com";
        String password = "password123";
        when(mockAuth.createUserWithEmailAndPassword(email, password)).thenReturn(mockAuthTask);
        when(mockAuthTask.isSuccessful()).thenReturn(true);
        when(mockAuthTask.getResult()).thenReturn(mockAuthResult);
        when(mockAuthResult.getUser()).thenReturn(mock(FirebaseUser.class));

        // Act
        signup.registerUser(email, password);

        // Assert
        verify(mockAuth).createUserWithEmailAndPassword(email, password);
    }

    @Test
    public void testSaveUserToDatabase() {
        // Arrange
        String userId = "123";
        String email = "test@example.com";

        DatabaseReference mockChildRef = mock(DatabaseReference.class);
        when(mockDatabaseRef.child(userId)).thenReturn(mockChildRef);
        when(mockChildRef.setValue(any())).thenReturn(mock(Task.class));
        // Act
        signup.saveUserToDatabase(userId, email);

        // Assert
        verify(mockDatabaseRef).child(userId);
        verify(mockChildRef).setValue(any());
    }
}
