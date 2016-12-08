package pls.certination.com.certination;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.View.OnClickListener;

import pls.certination.com.GuestLectures.GuestLecture;
import pls.certination.com.Internship.Internship;
import pls.certination.com.Jobs.Jobs;
import pls.certination.com.ParentConnection.ParentConnection;
import pls.certination.com.Pls.*;
import pls.certination.com.Resume.ResumeBuilder;
import pls.certination.com.Training.Training;
import pls.certination.com.Workshop.Workshop;

public class HomeFragment extends Fragment {
    ImageView img;
    ImageView pls,workshop,internship,training,jobs,lectures,parents,resume,coupon;

    public HomeFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_home, container, false);

        pls=(ImageView)view.findViewById(R.id.ib_pls);
        pls.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Login.class);
                startActivity(i);
            }
        });

        training=(ImageView)view.findViewById(R.id.imageButton);
        training.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Training.class);
                startActivity(i);

            }
        });

        internship=(ImageView)view.findViewById(R.id.imageButton2);
        internship.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Internship.class);
                startActivity(i);

            }
        });

        jobs=(ImageView)view.findViewById(R.id.imageButton3);
        jobs.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Jobs.class);
                startActivity(i);
            }
        });

        lectures=(ImageView)view.findViewById(R.id.imageButton4);
        lectures.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),GuestLecture.class);
                startActivity(i);
            }
        });

        workshop=(ImageView)view.findViewById(R.id.imageButton5);
        workshop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Workshop.class);
                startActivity(i);
            }
        });

        parents=(ImageView)view.findViewById(R.id.imageButton7);
        parents.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),ParentConnection.class);
                startActivity(i);
            }
        });

        resume=(ImageView)view.findViewById(R.id.imageButton8);
        resume.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),ResumeBuilder.class);
                startActivity(i);
            }
        });
//        coupon=(ImageView)view.findViewById(R.id.imageView21);
//        coupon.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),Coupon.class);
//                startActivity(i);
//            }
//        });

return view;

    }


}