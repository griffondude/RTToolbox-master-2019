package com.example.root.rttoolbox;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class displaySchedTable extends AppCompatActivity {
    private PipeViewModel mPipeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sched_table);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Pipe Schedule Table");

        //This evaluates which set of pipe schedules to display based on the size clicked.
        //Testing code is an exact copy of PipeDImensionsGateway code.
        mPipeViewModel = ViewModelProviders.of(this).get(PipeViewModel.class);
        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.sched_list);
        final PipeSchedAdapter adapter = new PipeSchedAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
