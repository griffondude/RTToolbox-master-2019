package com.example.root.rttoolbox;

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
    private PipeViewModel mPipeViewModel;
    public String sDNPipeSize;
    public String sODi;
    public String sODm;
    public String sIDi;
    public String sIDm;
    public LiveData<List<PipeSizeEntity>> chosenPipe;
    public List PipeScheduleList;
    public String[] PipeScheduleArray;

    public PipeDao mDao;
    public String toastText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sched_table);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Pipe Schedule Table");
        //arrays
        String[] scheduleIdList = {"5", "10", "20", "30", "40", "60", "80", "100", "120", "140", "160", "STD", "XS", "XXS"};
        String[] placeHolderWTi = {"5a", "10a", "20a", "30a", "40a", "60a", "80a", "100a", "120a", "140a", "160a", "STDa", "XSa", "XXSa"};
        String[] placeHolderWTm = {"5b", "10b", "20b", "30b", "40b", "60b", "80b", "100b", "120b", "140b", "160b", "STDb", "XSb", "XXSb"};

        final ArrayList<String> list1 = new ArrayList<String>();
        for (int i = 0; i < scheduleIdList.length; ++i) {
            list1.add(scheduleIdList[i]);
        }

        final ArrayList<String> list2 = new ArrayList<String>();
        for (int i = 0; i < scheduleIdList.length; ++i) {
            list2.add(placeHolderWTi[i]);
        }

        final ArrayList<String> list3 = new ArrayList<String>();
        for (int i = 0; i < scheduleIdList.length; ++i) {
            list3.add(placeHolderWTm[i]);
        }


        mPipeViewModel = ViewModelProviders.of(this).get(PipeViewModel.class);


        //Retrieve pipe size chosen from previous activity.
        Intent intent = getIntent();
        String id = getIntent().getStringExtra("NPSchosen");

        //Query database to transfer desired pipe size data to an array
        //troubleshoot out: chosenPipe = mDao.getPipeSched("2");
        //PipeScheduleList = chosenPipe.getValue();
        //toastText = PipeScheduleList.get(1).toString();

        //TODO:Feed data from PipeScheduleList array to a view for display.

        //This evaluates which set of pipe schedules to display based on the size clicked.
        //Testing code is an exact copy of PipeDImensionsGateway code.
        mPipeViewModel = ViewModelProviders.of(this).get(PipeViewModel.class);
        ListView listView;
        listView = findViewById(R.id.sched_list);
        PipeSchedAdapter adapter = new PipeSchedAdapter(this, list1, list2, list3);
        listView.setAdapter(adapter);
        mPipeViewModel.getmAllPipes().observe(this,pipes->adapter.setmPipes((pipes)));

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
