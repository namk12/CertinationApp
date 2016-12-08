package pls.certination.com.Pls.learning.time_table;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pls.certination.com.certination.R;


public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    private Context context;
    int position=0;
    private ArrayList<Information> data;

    private LayoutInflater inflater;

    public MyCustomAdapter(Context context, ArrayList<Information> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {

        myViewHolder.textview.setText(data.get(position).title);
        myViewHolder.imageView.setImageResource(data.get(position).imageId);

        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(context, "OnClick Called at position " + position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent();
                i.setClass(context,Course.class);
                i.putExtra("sno",position);
                v.getContext().startActivity(i);

            }
        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textview;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textview = (TextView) itemView.findViewById(R.id.title1);
            imageView = (ImageView) itemView.findViewById(R.id.thumbnail);

        }
    }


}
