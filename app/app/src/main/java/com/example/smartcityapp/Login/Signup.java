package com.example.smartcityapp.Login;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;


import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhengyu Peng u7727795
 */
public class Signup extends AppCompatActivity {
    private FirebaseAuth auth;
    private DatabaseReference databaseRef;
    private StorageReference storageRef;
    private Context context;

    public Signup(Context context) {
        this.context = context;
        auth = FirebaseAuth.getInstance();
        databaseRef = FirebaseDatabase.getInstance().getReference("users");
        storageRef = FirebaseStorage.getInstance().getReference();
    }

    public Signup(Context context, FirebaseAuth auth, DatabaseReference databaseRef, StorageReference storageRef) {
        this.context = context;
        this.auth = auth;
        this.databaseRef = databaseRef;
        this.storageRef = storageRef;
    }


    public void registerUser(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Invalid information", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Registration successful, get the user ID
                        String userId = task.getResult().getUser().getUid();
                        saveUserToDatabase(userId, email);

                        Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void saveUserToDatabase(String userId, String email) {
        Map<String, Object> userInfo = new HashMap<>();
        int atIndex = email.indexOf("@");
        String name = (atIndex != -1) ? email.substring(0, atIndex) : "defaultUsername";  // Handle email without @ case

        // Assign avatar path
        String avatarPath = assignAvatar(userId);

        userInfo.put("name", name);
        userInfo.put("avatar", avatarPath);
        userInfo.put("uid", userId);

        // Save user info to Firebase Database
        databaseRef.child(userId).setValue(userInfo)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(context, "User information saved to Firebase", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Failed to save user information", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private String assignAvatar(String userId) {
        // Assign an avatar path based on userId, now using 9 available images
        int avatarIndex = Math.abs(userId.hashCode()) % 9 + 1;  // Ensure index is between 1 and 9
        return "avatars/img" + avatarIndex + ".jpg";
    }
}

