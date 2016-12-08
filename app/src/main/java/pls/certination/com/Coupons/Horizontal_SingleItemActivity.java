package pls.certination.com.Coupons;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import pls.certination.com.certination.R;

public class Horizontal_SingleItemActivity extends RecyclerView.Adapter<Horizontal_SingleItemActivity.MyViewHolder> {

    pls.certination.com.Coupons.Coupon coupon;
    private Map<String,Integer> horizontalList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgView;
        public TextView title, author;

        public MyViewHolder(View view) {
            super(view);
            coupon = new pls.certination.com.Coupons.Coupon();
            imgView = (ImageView) view.findViewById(R.id.imgView);

        }
    }

    public Horizontal_SingleItemActivity(Map horizontalList) {
        this.horizontalList = horizontalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_horizontal_single_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Log.i("Value", Integer.toString(position));
        holder.imgView.setImageResource(horizontalList.get(Integer.toString(position)));

        holder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(coupon, "Clicked", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}
