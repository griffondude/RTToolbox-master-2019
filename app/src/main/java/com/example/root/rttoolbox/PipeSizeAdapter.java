package com.example.root.rttoolbox;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.provider.Settings.System.getString;


// Based on the Miwok App model
// Used to build each item in the list of pipesizes.
public class PipeSizeAdapter extends RecyclerView.Adapter<PipeSizeAdapter.PipeViewHolder> {

    public class PipeViewHolder extends RecyclerView.ViewHolder {
        private final TextView pipeItemView;
        private final TextView pipeItemView2;

        private PipeViewHolder(View itemView) {
            super(itemView);
            pipeItemView = itemView.findViewById(R.id.textView);
            pipeItemView2 = itemView.findViewById(R.id.textView2);
        }
    }

    private final LayoutInflater mInflater;
    private List<PipeSizeEntity> mPipe;

    PipeSizeAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public PipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new PipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PipeViewHolder holder, int position) {

        if (mPipe != null) {
            PipeSizeEntity current = mPipe.get(position);
            holder.pipeItemView.setText(current.getMNPSPipeSize());
            holder.pipeItemView2.setText(current.getMDNPipeSize());
        } else {
            // Covers the case of data not being ready yet.
            holder.pipeItemView.setText("No Word");
        }

        //Added based on https://stackoverflow.com/questions/28767413/how-to-open-a-different-activity-on-recyclerview-item-onclick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), displaySchedTable.class);
                String current = mPipe.get(position).toString();
                intent.putExtra("NPSchosen",current);
                view.getContext().startActivity(intent);
            }
        });
    }

    void setmPipes(List<PipeSizeEntity> pipes){
        mPipe = pipes;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mPipe != null)
            return mPipe.size();
        else return 0;
    }
}
