package pls.certination.com.Pls.Job_portal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pls.certination.com.certination.R;


/**
 * Created by AtreeTech on 8/14/2016.
 */
public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder> {

    private ArrayList<DataModel> dataSet;
    private Context context;
    LayoutInflater inflater;

    public CustomAdapter2(ArrayList<DataModel> data,Context context) {
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int position) {
        View view = inflater.inflate(R.layout.applied_jobs, parent, false);

        //view.setOnClickListener(MainActivity.onActivityCreated());

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder( final MyViewHolder holder, final int listPosition) {

        holder.jobPost.setText(dataSet.get(listPosition).getJobPost());
        holder.keySkill.setText(dataSet.get(listPosition).getKeySkill());
        if(dataSet.get(listPosition).getJobDescription().length()<10) {
            holder.jobDescription.setText(dataSet.get(listPosition).getJobDescription());
        }else{
            holder.seeMore.setVisibility(View.VISIBLE);
            holder.jobDescription.setText(dataSet.get(listPosition).getJobDescription().substring(0,7)+"...");
            holder.seeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "see more clicked", Toast.LENGTH_SHORT).show();
                    holder.c.setMinimumHeight(View.MEASURED_HEIGHT_STATE_SHIFT);
                    holder.jobDescription.setText(dataSet.get(listPosition).getJobDescription());
                    holder.seeMore.setVisibility(View.INVISIBLE);
                }
            });


        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView jobPost;
        TextView keySkill;
        TextView jobDescription;
        CardView c;
        TextView seeMore;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            jobPost = (TextView) itemView.findViewById(R.id.title1);
            c = (CardView) itemView.findViewById(R.id.cardView1);
            keySkill = (TextView) itemView.findViewById(R.id.key_skill1);
            jobDescription = (TextView) itemView.findViewById(R.id.description1);
            seeMore  = (TextView)itemView.findViewById(R.id.btnSeeMore1);

        }

    }

}