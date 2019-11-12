package com.example.root.rttoolbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Toools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toools);
        setTitle(R.string.title_tools);
    }

    public void startSafeDist(View view) {
        Intent myIntent = new Intent(this, safeDist.class);
        startActivity(myIntent);
    }

    public void startExpCalc (View view) {
        Intent myIntent = new Intent(this, exposureCalc.class);
        startActivity(myIntent);
    }

    public void startpipeSched (View view) {
        Intent myIntent = new Intent(this, PipeDimentionsGateway.class);
        startActivity(myIntent);
    }
}
