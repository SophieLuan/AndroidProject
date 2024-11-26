package com.example.smartcityapp.loadData;

import android.content.Context;
import android.util.Log;

import com.example.smartcityapp.R;
import com.example.smartcityapp.Search.AVLTree;
import com.example.smartcityapp.Search.CreateUniqueID;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * load the data from Json, then generate a list which includes all the activities.
 * And insert the activities into an AVL tree.
 * author: Zhizhao Sun  (u7799455)
 */

public class DataManagement {
    public  AVLTree avlTree = new AVLTree();
    public List<DataActivity> activityList;
    /**
     * Load data from the JSON file and give each activity an unique ID, then insert it into the AVL tree.
     * @param context
     */
    public void loadDataFromJson(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.activity);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            reader.close();
            activityList = new ArrayList<>();
            JsonElement jsonElement = JsonParser.parseString(jsonString.toString());
            if (jsonElement.isJsonArray()) {
                for (JsonElement element : jsonElement.getAsJsonArray()) {
                    JsonObject jsonObject = element.getAsJsonObject();
                    String aName = jsonObject.get("activity").getAsString();
                    String type = jsonObject.get("type").getAsString();
                    int participants = jsonObject.get("parts").getAsInt();
                    String time = jsonObject.get("time").getAsString();
                    String date = jsonObject.get("date").getAsString();
                    DataActivity activity = new DataActivity(aName, type, participants, time, date);
                    activityList.add(activity);
                }
                for (DataActivity activity : activityList) {
                    String id = CreateUniqueID.createID(activity.getType(), activity.getParticipants(),activity.getDate(),activity.getTime());
                    activity.setId(id);
                    // insert the activities into the AVLTree.
                    avlTree.insert(activity);
                }
            }

        } catch(Exception e){
            Log.e("DataLoader", "Wrong message", e);

        }
    }
}
