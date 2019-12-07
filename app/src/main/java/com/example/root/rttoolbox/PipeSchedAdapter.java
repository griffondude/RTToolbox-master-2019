package com.example.root.rttoolbox;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// Based on the PipeSizeAdapter,which is based on the Miwok App model
// Used to build each item in the list of pipe schedules.
public class PipeSchedAdapter extends ArrayAdapter<String> {
    //private final Activity activity;
    private final Context context;
    private List<PipeSizeEntity> PipeDataList;
    private String[] values1;
    private String[] values2;
    private String[] values3;

    public PipeSchedAdapter(Context context, String[] values1, String[] values2, String[] values3) {
        super(context, R.layout.sched_view_item);
        this.context = context;
        this.values1 = values1;
        this.values2 = values2;
        this.values3 = values3;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.sched_view_item,parent, true);
        //this code gets references to objects in the layout file
        TextView schedid = (TextView) rowView.findViewById(R.id.textView3);
        TextView WTi = (TextView) rowView.findViewById(R.id.textView4);
        TextView WTm = (TextView) rowView.findViewById(R.id.textView5);

        //this code sets the values of the objects to values from the arrays

            schedid.setText(values1[position]);
            WTi.setText(values2[position]);
            WTm.setText(values3[position]);

        return rowView;
    }

    void setmPipes (List < PipeSizeEntity > pipes) {
        PipeDataList = pipes;
        notifyDataSetChanged();
    }
}


