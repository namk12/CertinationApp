package pls.certination.com.Coupons;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import pls.certination.com.certination.R;

public class Coupon extends AppCompatActivity {

    private RecyclerView horizontal_recycler_view;
    private Map map;
    Button button;
    private Horizontal_SingleItemActivity horizontalAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);


        start();
    }

    public void start() {

        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view1);
        startAgain();

        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view2);
        startAgain2();

        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view3);
        startAgain3();

        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view4);
        startAgain4();

        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view5);
        startAgain5();

    }
    public void startAgain() {

        int[] imgs = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5,
                R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10};

        map = new HashMap();

        for (int i = 0; i < imgs.length; i++)
            map.put(Integer.toString(i), imgs[i]);

        horizontalAdapter = new Horizontal_SingleItemActivity(map);

//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        vertical_recycler_view.setLayoutManager(mLayoutManager);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(Coupon.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);

        horizontal_recycler_view.setAdapter(horizontalAdapter);

    }

    public void startAgain2() {

        int[] imgs = {R.drawable.a10, R.drawable.a9, R.drawable.a8, R.drawable.a7, R.drawable.a6,
                R.drawable.a5, R.drawable.a4, R.drawable.a3, R.drawable.a2, R.drawable.a1};

        map = new HashMap();

        for (int i = 0; i < imgs.length; i++)
            map.put(Integer.toString(i), imgs[i]);

        horizontalAdapter = new Horizontal_SingleItemActivity(map);

//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        vertical_recycler_view.setLayoutManager(mLayoutManager);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(Coupon.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);

        horizontal_recycler_view.setAdapter(horizontalAdapter);

    }

    public void startAgain3() {

        int[] imgs = {R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9,
                R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a10};

        map = new HashMap();

        for (int i = 0; i < imgs.length; i++)
            map.put(Integer.toString(i), imgs[i]);

        horizontalAdapter = new Horizontal_SingleItemActivity(map);

//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        vertical_recycler_view.setLayoutManager(mLayoutManager);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(Coupon.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);

        horizontal_recycler_view.setAdapter(horizontalAdapter);

    }

    public void startAgain4() {

        int[] imgs = {R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a4,
                R.drawable.a3, R.drawable.a2, R.drawable.a6, R.drawable.a1, R.drawable.a5};

        map = new HashMap();

        for (int i = 0; i < imgs.length; i++)
            map.put(Integer.toString(i), imgs[i]);

        horizontalAdapter = new Horizontal_SingleItemActivity(map);

//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        vertical_recycler_view.setLayoutManager(mLayoutManager);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(Coupon.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);

        horizontal_recycler_view.setAdapter(horizontalAdapter);

    }

    public void startAgain5() {

        int[] imgs = {R.drawable.a9, R.drawable.a8, R.drawable.a7, R.drawable.a6, R.drawable.a5,
                R.drawable.a4, R.drawable.a3, R.drawable.a2, R.drawable.a1, R.drawable.a10};

        map = new HashMap();

        for (int i = 0; i < imgs.length; i++)
            map.put(Integer.toString(i), imgs[i]);

        horizontalAdapter = new Horizontal_SingleItemActivity(map);

//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        vertical_recycler_view.setLayoutManager(mLayoutManager);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(Coupon.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);

        horizontal_recycler_view.setAdapter(horizontalAdapter);

    }



}
