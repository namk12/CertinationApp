package pls.certination.com.Pls.Job_portal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pls.certination.com.certination.R;

public class Applied extends Fragment {

    public CustomAdapter2 adapter;
    RecyclerView mRootView;
    ArrayList<DataModel> data = new ArrayList<>();
    Button refresh;
    View drawer;
    LinearLayout lay;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        drawer = inflater.inflate(R.layout.fragment_applied_jobs, container, false);
        lay = (LinearLayout) drawer.findViewById(R.id.lay1);
        mRootView = (RecyclerView) drawer.findViewById(R.id.applied_rv);

        refresh = (Button) drawer.findViewById(R.id.refreshbtn);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data = new ArrayList<DataModel>();
                for (int i = 0; i < MyData.jobPostArray.length; i++) {
                    if (MyData.map.containsKey(MyData.jobPostArray[i])) {
                        DataModel d = new DataModel(MyData.jobPostArray[i], MyData.jobDescriptionArray[i], MyData.keySkillArray[i], MyData.id_[i]);
                        data.add(d);
                    }
                }
                adapter = new CustomAdapter2(data, getContext());
                mRootView.setAdapter(adapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                mRootView.setLayoutManager(layoutManager);
                mRootView.setItemAnimator(new DefaultItemAnimator());

            }
        });

        return lay;

    }


}
