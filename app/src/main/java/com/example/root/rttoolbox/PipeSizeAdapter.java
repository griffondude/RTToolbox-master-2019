package com.example.root.rttoolbox;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.Settings.System.getString;


// Based on the Miwok App model
public class PipeSizeAdapter extends ArrayAdapter<PipeSize> {

    public PipeSizeAdapter(Activity context, ArrayList<PipeSize> PipeSizes) {
        super(context, 0, PipeSizes);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check to see if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        // Get the object located at this position in the list
        PipeSize currentSize = getItem(position);

        // Find the TextView in the list_item.xml layout with the
        TextView npsPipeSizeTextView = (TextView) listItemView.findViewById(R.id.NPSSize);
        // Get the data from the current object and
        // set this text on the TextView
        npsPipeSizeTextView.setText(R.string.nps_size_display);
        npsPipeSizeTextView.append(currentSize.getmNPSPipeSize());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView dnPipeSizeTextView = (TextView) listItemView.findViewById(R.id.DNSize);

        // Get the data from the current object and
        // set this text on the TextView
        dnPipeSizeTextView.setText(R.string.dn_size_display);
        dnPipeSizeTextView.append(currentSize.getmDNPipeSize());

        // Find the TextView in the list_item.xml layout
        TextView odImpTextView = (TextView) listItemView.findViewById(R.id.ODImp);
        // Get the data from the current object and
        // set this text on the TextView
        odImpTextView.setText(R.string.od);
        odImpTextView.append(currentSize.getmOutsideDiameterImp());
        odImpTextView.append("in");

        // Find the TextView in the list_item.xml layout
        TextView odMetTextView = (TextView) listItemView.findViewById(R.id.ODMet);
        // Get the data from the current object and
        // set this text on the TextView
        odMetTextView.setText(R.string.od);
        odMetTextView.append(currentSize.getmOutsideDiameterMet());
        odMetTextView.append("mm");

        //TODO: Use a string builder instead of append.

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

