package com.example.root.rttoolbox;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class achedTableExpAdapter extends ArrayAdapter {


    private final Activity context;
    private String[] values1;
    private String[] values2;
    private String[] values3;

    public achedTableExpAdapter(Activity context, String[] values1, String[] values2, String[] values3) {
        super(context, R.layout.listview_row,values1);
        this.context = context;
        this.values1 = values1;
        this.values2 = values2;
        this.values3 = values3;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        //this code gets references to objects in the layout file
        TextView schedid = (TextView) rowView.findViewById(R.id.textViewa);
        TextView WTi = (TextView) rowView.findViewById(R.id.textViewb);
        TextView WTm = (TextView) rowView.findViewById(R.id.textViewc);

        //this code sets the values of the objects to values from the arrays

        schedid.setText(values1[position]);
        WTi.setText(values2[position]);
        WTm.setText(values3[position]);

        return rowView;
    }
}
