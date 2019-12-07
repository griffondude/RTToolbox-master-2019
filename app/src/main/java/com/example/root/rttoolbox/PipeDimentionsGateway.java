// https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
// https://developer.android.com/guide/topics/ui/layout/recyclerview
package com.example.root.rttoolbox;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PipeDimentionsGateway extends AppCompatActivity {

    private PipeViewModel mPipeViewModel;

// Based on the Miwok App model

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gateway_layout);
        setTitle(R.string.PipeDimensionsGateway_Title);

        mPipeViewModel = ViewModelProviders.of(this).get(PipeViewModel.class);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: Verify accuracy of this table. Source: https://en.wikipedia.org/wiki/Nominal_Pipe_Size

        //TODO: Use fragment to create schedule table.

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.pipe_list);
        final PipeSizeAdapter adapter = new PipeSizeAdapter(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPipeViewModel.getmAllPipes().observe(this,pipes->adapter.setmPipes((pipes)));
    }

    public void startSchedTableExp(View view) {

        Intent myIntent = new Intent(this, schedTableExp.class);

        startActivity(myIntent);
    }


}
