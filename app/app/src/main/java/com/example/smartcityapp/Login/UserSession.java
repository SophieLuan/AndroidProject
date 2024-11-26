package com.example.smartcityapp.Login;



import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * @author Zhengyu Peng u7727795
 * Use the singleton design pattern to design login states.
 */

public class UserSession extends AppCompatActivity{

    private static UserSession instance;
    private boolean isLoggedIn = false;
    private String username;
    private Context context;
    private String userid;

    private UserSession(Context context){
        this.context = context.getApplicationContext();
        SharedPreferences prefs = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        this.username = prefs.getString("username", null);
        this.isLoggedIn = prefs.getBoolean("isLoggedIn", false);
        this.userid = prefs.getString("id","0");
    }

    public static synchronized UserSession getInstance(Context context) {
        if (instance == null) {
            instance = new UserSession(context);
        }
        return instance;
    }

    public void setLoggedIn(boolean loggedIn, String username, String userid) {
        this.isLoggedIn = loggedIn;
        this.username = username;
        this.userid = userid;

        SharedPreferences.Editor editor = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE).edit();
        if (loggedIn && username != null && userid != null) {
            editor.putString("username", username);
            editor.putString("userId", userid);
            editor.putBoolean("isLoggedIn", true);
            editor.apply();


            DatabaseReference userLikesRef = FirebaseDatabase.getInstance().getReference("user_likes").child(userid);
            userLikesRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (!dataSnapshot.exists()) {

                        userLikesRef.setValue(new HashMap<>());
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(context, "Failed to check user likes folder.", Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            editor.clear();
            editor.apply();
        }
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public String getUsername() {
        if (this.username == null) {
            SharedPreferences prefs = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE);
            this.username = prefs.getString("username", null);
        }
        return this.username;
    }


}
