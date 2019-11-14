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
    // private int sizeCat = 0;

// Based on the Miwok App model

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gateway_layout);
        setTitle(R.string.PipeDimensionsGateway_Title);

        mPipeViewModel = ViewModelProviders.of(this).get(PipeViewModel.class);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: Verify accuracy of this table. Source: https://en.wikipedia.org/wiki/Nominal_Pipe_Size

        //TODO: Convert array list to database.

        //TODO: Use fragment to create schedule table.

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.pipe_list);
        final PipeSizeAdapter adapter = new PipeSizeAdapter(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPipeViewModel.getmAllPipes().observe(this,pipes->adapter.setmPipes((pipes)));
    }

    //@Override
    //public int getItemCount() {
    //    return mValues.size();
    //}

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mNPSSize;
        final TextView mODImp;

        ViewHolder(View view) {
            super(view);
            mNPSSize = (TextView) view.findViewById(R.id.NPSSize);
            mODImp = (TextView) view.findViewById(R.id.ODImp);
        }
    }

    /*// Placeholder code for testing.
    private void showSchedTable(int sizeCat) {
        //convert sizeCat to string for troubleshooting.
        String sizeCatStr = Integer.toString(sizeCat);
        // Select proper schedules data table to display
        switch (sizeCat) {
            case 1:
                //Intent myIntent;
                //myIntent = new Intent(this,  EMERG.class);
                //startActivity(myIntent);
                Toast toast1 = Toast.makeText(getApplicationContext(), "Size Category is: "+sizeCatStr, Toast.LENGTH_LONG);
                toast1.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast1.show();
                break;

            case 2:
                //Intent myIntent2 = new Intent(this, EMERG.class);
                //startActivity(myIntent2);
                //break;
                Toast toast2 = Toast.makeText(getApplicationContext(), "Size Category is: "+sizeCatStr, Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast2.show();
                break;

            case 3:
                //Intent myIntent3 = new Intent(this, EMERG.class);
                //startActivity(myIntent3);
                //break;
                Toast toast3 = Toast.makeText(getApplicationContext(), "Size Category is: "+sizeCatStr, Toast.LENGTH_LONG);
                toast3.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast3.show();
                break;

            case 4:
                //Intent myIntent3 = new Intent(this, EMERG.class);
                //startActivity(myIntent3);
                //break;
                Toast toast4 = Toast.makeText(getApplicationContext(), "Size Category is: "+sizeCatStr, Toast.LENGTH_LONG);
                toast4.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast4.show();
                break;

            case 5:
                //Intent myIntent3 = new Intent(this, EMERG.class);
                //startActivity(myIntent3);
                //break;
                Toast toast5 = Toast.makeText(getApplicationContext(), "Size Category is: "+sizeCatStr, Toast.LENGTH_LONG);
                toast5.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast5.show();
                break;

            default:
                Toast toast6 = Toast.makeText(getApplicationContext(), "Size Category Out Of Range", Toast.LENGTH_LONG);
                toast6.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast6.show();
        }
    }*/


}
