package com.example.smartcityapp.loadData;

/**
 * add some fields about activity
 * The field of type, participants and date will be in the Search part.
 * author: Zhizhao Sun  (u7799455)
 */

public class DataActivity {
    // the unique id for each activity which will be create in the class of CreateUniqueID
    private String id;
    private String activity;
    private String type;
    private int participants;
    private String time;
    private String date;

    public DataActivity(String activity, String type, int participants, String time,String date) {
        this.activity = activity;
        this.type = type;
        this.participants = participants;
        this.time=time;
        this.date=date;
    }
    public String getActivity(){
        return activity;
    }
    public String getType(){
        return type;
    }
    public int getParticipants(){
        return participants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
