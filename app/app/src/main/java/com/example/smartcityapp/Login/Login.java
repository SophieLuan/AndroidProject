package com.example.smartcityapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.smartcityapp.MainActivity;
import com.example.smartcityapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * @author Zhengyu Peng u7727795
 */

public class Login extends AppCompatActivity {
    public EditText userNameText;
    public EditText passWordText;
    public Signup signup;
    public FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        auth = FirebaseAuth.getInstance();
        signup = new Signup(this);

        // find all elements
        userNameText = findViewById(R.id.UserNameEdit);
        passWordText = findViewById(R.id.PassWordEdit);

        Button loginButton = findViewById(R.id.Login_button);
        // add the listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

        Button signUpButton = findViewById(R.id.signUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userNameText.getText().toString().trim();
                String password = passWordText.getText().toString().trim();
                signup.registerUser(email, password);
            }
        });

    }

    public void checkLogin(){
        String username = userNameText.getText().toString().trim();
        String password = passWordText.getText().toString().trim();
//        checkUserJson(username, password);

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username or Password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }


        auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {

                        FirebaseUser user = auth.getCurrentUser();
                        if (user != null) {
                            String userId = user.getUid();

                            UserSession.getInstance(this).setLoggedIn(true, username, userId);
                            Toast.makeText(getApplicationContext(), "Login success! "+username+", Welcome!", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    } else {

                        Toast.makeText(this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
