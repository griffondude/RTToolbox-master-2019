package com.example.root.rttoolbox;

import android.app.Activity;
import android.app.ListActivity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
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
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class displaySchedTable extends AppCompatActivity implements Serializable {
    //arrays
    String[] scheduleIdList = {"5", "10", "20", "30", "40", "60", "80", "100", "120", "140", "160", "STD", "XS", "XXS"};
    String[] placeHolderWTi = {"5a", "10a", "20a", "30a", "40a", "60a", "80a", "100a", "120a", "140a", "160a", "STDa", "XSa", "XXSa"};
    String[] placeHolderWTm = {"5b", "10b", "20b", "30b", "40b", "60b", "80b", "100b", "120b", "140b", "160b", "STDb", "XSb", "XXSb"};
    ListView listView;
    private PipeViewModel mPipeViewModel;
    LiveData<List<PipeSizeEntity>> pipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sched_table);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Pipe Schedule Table");

        mPipeViewModel = ViewModelProviders.of(this).get(PipeViewModel.class);


        //Retrieve intent extra from previous click
        Intent intent = getIntent();
        String pipeSize = intent.getStringExtra("NPSchosen");

        //Display chosen pipe size in the header.
        TextView chosenPipe = (TextView) findViewById(R.id.chosenPipeSize);
        chosenPipe.setText(pipeSize);

        //Query database.
        PipeSizeEntity pipe = mPipeViewModel.getmPipeSched(pipeSize);
        pipeList = mPipeViewModel.getmAllPipes();

        //Populate String Arrays.
        placeHolderWTi[0] = pipe.getMsched5i();
        placeHolderWTi[1] = pipe.getMsched10i();
        placeHolderWTi[2] = pipe.getMsched20i();
        placeHolderWTi[3] = pipe.getMsched30i();
        placeHolderWTi[4] = pipe.getMsched40i();
        placeHolderWTi[5] = pipe.getMsched60i();
        placeHolderWTi[6] = pipe.getMsched80i();
        placeHolderWTi[7] = pipe.getMsched100i();
        placeHolderWTi[8] = pipe.getMsched120i();
        placeHolderWTi[9] = pipe.getMsched140i();
        placeHolderWTi[10] = pipe.getMsched160i();
        placeHolderWTi[11] = pipe.getMschedSTDi();
        placeHolderWTi[12] = pipe.getMschedXSi();
        placeHolderWTi[13] = pipe.getMschedXXSi();

        placeHolderWTm[0] = pipe.getMsched5m();
        placeHolderWTm[1] = pipe.getMsched10m();
        placeHolderWTm[2] = pipe.getMsched20m();
        placeHolderWTm[3] = pipe.getMsched30m();
        placeHolderWTm[4] = pipe.getMsched40m();
        placeHolderWTm[5] = pipe.getMsched60m();
        placeHolderWTm[6] = pipe.getMsched80m();
        placeHolderWTm[7] = pipe.getMsched100m();
        placeHolderWTm[8] = pipe.getMsched120m();
        placeHolderWTm[9] = pipe.getMsched140m();
        placeHolderWTm[10] = pipe.getMsched160m();
        placeHolderWTm[11] = pipe.getMschedSTDm();
        placeHolderWTm[12] = pipe.getMschedXSm();
        placeHolderWTm[13] = pipe.getMschedXXSm();

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
