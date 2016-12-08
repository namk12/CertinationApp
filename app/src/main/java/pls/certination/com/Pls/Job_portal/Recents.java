package pls.certination.com.Pls.Job_portal;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pls.certination.com.certination.R;

/**
 * Created by AtreeTech on 8/10/2016.
 */
public class Recents extends Fragment {


    public CustomAdapter adapter;
    RecyclerView mRootView;
    ArrayList<DataModel> data = new ArrayList<>();
    TextView btn;

    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {


        for (int i = 0; i < MyData.jobPostArray.length; i++) {
            DataModel d = new DataModel(MyData.jobPostArray[i], MyData.jobDescriptionArray[i], MyData.keySkillArray[i], MyData.id_[i]);
            data.add(d);
        }
        View drawer = inflater.inflate(R.layout.fragment_recent_jobs, container, false);


        btn = (TextView) drawer.findViewById(R.id.btnSeeMore);


        mRootView = (RecyclerView) drawer.findViewById(R.id.my_recycler_view);
        adapter = new CustomAdapter(data, getContext());
        mRootView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRootView.setLayoutManager(layoutManager);
        mRootView.setItemAnimator(new DefaultItemAnimator());

        return mRootView;


    }


}
