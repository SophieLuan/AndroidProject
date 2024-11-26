package com.example.smartcityapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcityapp.P2P.ChatActivity;
import com.example.smartcityapp.Profile.Profile;
import com.example.smartcityapp.Login.Login;
import com.example.smartcityapp.Login.UserSession;
import com.example.smartcityapp.loadData.DataActivity;
import com.example.smartcityapp.loadData.DataManagement;
import com.example.smartcityapp.postActivity.CreatePostActivity;
import com.example.smartcityapp.postActivity.PostActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Collections;
import java.util.List;

/**
 * MainActivity class is the central activity of the smart city app, responsible for managing the
 * user interface and user interactions on the main screen. This activity allows users to search for
 * community activities and view existing activities.
 * It also handles user session management, ensuring that only logged-in users can access the features.
 * The MainActivity also supports dynamic updates to the activity list and provides navigation to
 * other key features like posting and person-to-person chat.
 *
 * @author Lujin Sun(u7897414), Zhengyu Peng(u7727795), Zhizhao Sun(u7799455), Ziang Wang(u7748243)
 */

public class MainActivity extends AppCompatActivity {



    List<DataActivity> activityList;
    String searchQuery = "";

    //DataStream: author: Lujin Sun u7897414
    private final Handler handler = new Handler();
    private final Runnable dataStreamRunnable = new Runnable(){
        @Override
        public void run(){
            loadShowData();
            handler.postDelayed(this, 10000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        //Check login: author: Zhengyu Peng u7727795
        if (!UserSession.getInstance(MainActivity.this).isLoggedIn()) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_main);


       //search: author: Zhizhao Sun(u7799455), Ziang Wang(u7748243)
        EditText editText = findViewById(R.id.searchEditText);
        Button searchButton = (Button) findViewById(R.id.btnSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               searchQuery = editText.getText().toString();
              onStop();
               loadSearchData(searchQuery);

               // Show a toast message for viewing search results
               Toast.makeText(MainActivity.this, "View results", Toast.LENGTH_SHORT).show();

               editText.setText("");
           }
       });

       // return to home: author: Zhizhao Sun
        Button homeButton=(Button) findViewById(R.id.btnHome);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onResume();
                loadShowData();
            }
        });

        Button chatButton=(Button) findViewById(R.id.btnInfo);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent to navigate to ChatActivity
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        Button postButton = findViewById(R.id.btnPost);
        postButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Intent to navigate to PostActivity
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

        // like: author: Zhengyu Peng u7727795
        Button likeB = findViewById(R.id.btnLike);
        likeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        // Find the "Create Post" button
        Button btnCreatePost = findViewById(R.id.btnCreatePost);

        // Set up a click listener for the "Create Post" button
        btnCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to CreatePostActivity when button is clicked
                Intent intent = new Intent(MainActivity.this, CreatePostActivity.class);
                startActivity(intent);
            }
        });
    }

    /***
     * When MainActivity is launched, immediately load the data from loadShowData.
     * @author Ziang Wang(u7748243), Zhizhao Sun(u7799455)
     */
    private void loadShowData() {
        RecyclerView recyclerView ;
        ActivityAdapter adapter;
        DataManagement dataManagement=new DataManagement();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataManagement.loadDataFromJson(this);
        activityList=dataManagement.activityList;
        Collections.shuffle(activityList);
        adapter = new ActivityAdapter(activityList.subList(0,10));
        recyclerView.setAdapter(adapter);
        Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
    }

    /**
     * when click the button search, return the result data from search
     * @author Zhizhao Sun(u7799455)
     * @param s
     */
    private void loadSearchData(String s){
        RecyclerView recyclerView ;
        DataManagement dataManagement=new DataManagement();
        ActivityAdapter dataAdapter ;
        recyclerView = findViewById(R.id.recyclerView);
        dataManagement.loadDataFromJson(this);
        //String s="type=social AND participants=2 AND date=1105";
        List<DataActivity> results=dataManagement.avlTree.search(s);
        dataAdapter = new ActivityAdapter(results);
        recyclerView.setAdapter(dataAdapter);
    }



    /**
     * Define the logic when the application is destroyed and paused
     * @author : Zhengyu Peng
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(dataStreamRunnable);
        logout();
    }
    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(dataStreamRunnable);

    }
    @Override
    protected void onPause(){
        super.onPause();
        handler.removeCallbacks(dataStreamRunnable);
    }
    @Override
    protected void onResume(){
        super.onResume();
        handler.post(dataStreamRunnable);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        UserSession.getInstance(getApplicationContext()).setLoggedIn(false, null,null);

    }


    /**
     * switch between portrait and landscape layouts when the orientation changes.
     * @param newConfig
     * @author Ziang Wang(u7748243)
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Check if the orientation has changed to landscape or portrait
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main);  // Assuming you have a landscape layout
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);  // Reload the portrait layout
        }

        // Re-setup your buttons and listeners after orientation change
        setupListeners();
    }

    // Method to setup listeners again after orientation change
    private void setupListeners() {
        Button btnHome = findViewById(R.id.btnHome);
        Button btnPost = findViewById(R.id.btnPost);
        Button btnInfo = findViewById(R.id.btnInfo);
        Button btnLike = findViewById(R.id.btnLike);
        Button btnSearch = findViewById(R.id.btnSearch);

        // Set up the click listeners for each button
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onResume();
                loadShowData();
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Intent to navigate to PostActivity
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent to navigate to ChatActivity
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        EditText editText = findViewById(R.id.searchEditText);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchQuery = editText.getText().toString();
                onStop();
                loadSearchData(searchQuery);

                // Show a toast message for viewing search results
                Toast.makeText(MainActivity.this, "View results", Toast.LENGTH_SHORT).show();

                editText.setText("");
            }
        });

        // Find the "Create Post" button
        Button btnCreatePost = findViewById(R.id.btnCreatePost);

        // Set up a click listener for the "Create Post" button
        btnCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to CreatePostActivity when button is clicked
                Intent intent = new Intent(MainActivity.this, CreatePostActivity.class);
                startActivity(intent);
            }
        });

    }


}