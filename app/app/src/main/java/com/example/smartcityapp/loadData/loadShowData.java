package com.example.smartcityapp.loadData;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcityapp.ActivityAdapter;
import com.example.smartcityapp.R;


import java.util.List;


public class loadShowData extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_load_show_data);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //测试代码：start
        DataManagement dataManagement=new DataManagement();
        dataManagement.loadDataFromJson(this);
        String s="type=social AND participants=2 AND date=1105";
        List<DataActivity> results=dataManagement.avlTree.search(s);
        //end
        ActivityAdapter dataAdapter = new ActivityAdapter(results);
        recyclerView.setAdapter(dataAdapter);

    }
}