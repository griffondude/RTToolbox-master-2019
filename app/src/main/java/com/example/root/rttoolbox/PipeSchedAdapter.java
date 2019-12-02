package com.example.root.rttoolbox;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
    private final ArrayList values1;
    private final ArrayList values2;
    private final ArrayList values3;

    public PipeSchedAdapter(Context context, ArrayList values1, ArrayList values2, ArrayList values3) {
        super(context, R.layout.sched_view_item);
        this.context = context;
        this.values1 = values1;
        this.values2 = values2;
        this.values3 = values3;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.sched_view_item,parent, false);
        //this code gets references to objects in the layout file
        TextView schedid = (TextView) rowView.findViewById(R.id.textView3);
        TextView WTi = (TextView) rowView.findViewById(R.id.textView4);
        TextView WTm = (TextView) rowView.findViewById(R.id.textView5);

        //this code sets the values of the objects to values from the arrays

            /*schedid.setText(scheduleIdList[position]);
            WTi.setText(placeHolderWTi[position]);
            WTm.setText(placeHolderWTm[position]);
*/

        return rowView;
    }

    void setmPipes (List < PipeSizeEntity > pipes) {
        PipeDataList = pipes;
        notifyDataSetChanged();
    }
}


