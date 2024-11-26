package com.example.smartcityapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcityapp.loadData.DataActivity;

import java.util.ArrayList;
import java.util.List;

/***
 * An adapter class to bind data from activity.json to the RecyclerView.
 * This is responsible for creating and binding views to the data in the list.
 * @author Ziang Wang(u7748243), Zhizhao Sun(u7799455)
 */

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    // A list of DataActivity items representing the data for each item in the RecyclerView
    private List<DataActivity> activityList;

    // initialize the activityList with data
    public ActivityAdapter(List<DataActivity> activityList) {
        this.activityList = activityList;
    }

    // inflate the item layout and creates a ViewHolder for each item
    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item, parent, false);
        return new ActivityViewHolder(view);
    }

    // bind the data to the views for each item in the RecyclerView
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        // Get the current data item from the list based on position
       DataActivity dataItem = activityList.get(position);

        // Set the data in the corresponding TextViews
        holder.activityViewName.setText(dataItem.getActivity());
        holder.typeView.setText(dataItem.getType());
        holder.participantView.setText("nps: "+String.valueOf(dataItem.getParticipants()));
        holder.dateView.setText("date: "+String.valueOf(dataItem.getDate()).substring(0,2)+"/"+String.valueOf(dataItem.getDate()).substring(2,4));
        holder.timeView.setText("time: "+String.valueOf(dataItem.getTime()).substring(0,2)+":"+String.valueOf(dataItem.getTime()).substring(2,4));
    }

    // Returns the total number of items in the data list
    @Override
    public int getItemCount() {
        return activityList.size();
    }

    // ViewHolder class to hold references to the views for each item
    public static class ActivityViewHolder extends RecyclerView.ViewHolder {
        // TextViews to display the activity details
        TextView activityViewName;
        TextView typeView;
        TextView participantView;
        TextView dateView;
        TextView timeView;

        // initialize the TextViews from the layout file
        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            activityViewName= itemView.findViewById(R.id.activityViewName);
            typeView=itemView.findViewById(R.id.typeView);
            participantView=itemView.findViewById(R.id.participantView);
            dateView=itemView.findViewById(R.id.dateView);
            timeView=itemView.findViewById(R.id.timeView);
        }

    }
}
