package com.example.root.rttoolbox;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

// Based on the PipeSizeAdapter,which is based on the Miwok App model
// Used to build each item in the list of pipe schedules.
public class PipeSchedAdapter extends RecyclerView.Adapter<com.example.root.rttoolbox.PipeSchedAdapter.SchedViewHolder> {

    public class SchedViewHolder extends RecyclerView.ViewHolder {
        private final TextView pipeItemView3;
        private final TextView pipeItemView4;
        private final TextView pipeItemView5;

        private SchedViewHolder(View itemView) {
            super(itemView);
            pipeItemView3 = itemView.findViewById(R.id.textView3);
            pipeItemView4 = itemView.findViewById(R.id.textView4);
            pipeItemView5 = itemView.findViewById(R.id.textView5);
        }
    }

    private final LayoutInflater mInflater;
    private List<PipeSizeEntity> mPipe;

    PipeSchedAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public SchedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.sched_view_item, parent, false);
        return new SchedViewHolder(itemView);
        //TODO: Atempting to retrieve variable from other activity. Not working.
        /*Intent intent = intent.getCharArrayExtra("NPSchosen");
        String id = intent.getStringExtra("NPSchosen");
        Bundle extras = getExtras();
        Toast toast = Toast.makeText(getApplicationContext(),
                "This is a message displayed in a Toast",
                Toast.LENGTH_SHORT);
        toast.show();*/
    }

    @Override
    public void onBindViewHolder(com.example.root.rttoolbox.PipeSchedAdapter.SchedViewHolder holder, int position) {

        if (mPipe != null) {
            PipeSizeEntity current = mPipe.get(position);
            holder.pipeItemView3.setText(current.getMsched20i());
            holder.pipeItemView4.setText(current.getMsched20m());
            holder.pipeItemView5.setText(current.getMOutsideDiameterImp());
        } else {
            // Covers the case of data not being ready yet.
            holder.pipeItemView3.setText("No Word");
        }

        //Added based on https://stackoverflow.com/questions/28767413/how-to-open-a-different-activity-on-recyclerview-item-onclick
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(view.getContext(), displaySchedTable.class);
                //view.getContext().startActivity(intent);
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


