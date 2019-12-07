package com.example.root.rttoolbox;

import android.app.ListActivity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class displaySchedTable extends AppCompatActivity {
    //arrays
    String[] scheduleIdList = {"5", "10", "20", "30", "40", "60", "80", "100", "120", "140", "160", "STD", "XS", "XXS"};
    String[] placeHolderWTi = {"5a", "10a", "20a", "30a", "40a", "60a", "80a", "100a", "120a", "140a", "160a", "STDa", "XSa", "XXSa"};
    String[] placeHolderWTm = {"5b", "10b", "20b", "30b", "40b", "60b", "80b", "100b", "120b", "140b", "160b", "STDb", "XSb", "XXSb"};
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sched_table);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Pipe Schedule Table");

        //TODO:Feed data from PipeScheduleList array to a view for display.
        //experimental code
        PipeSchedAdapter adapter = new PipeSchedAdapter(this, scheduleIdList, placeHolderWTi, placeHolderWTm);
        listView = findViewById(R.id.sched_list);
        listView.setAdapter(adapter);

        //Button not used yet.
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
