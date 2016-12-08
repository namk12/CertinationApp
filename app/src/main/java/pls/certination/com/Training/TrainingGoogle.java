package pls.certination.com.Training;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import pls.certination.com.Training.GoogleAndroid.GoogleAndroids;
import pls.certination.com.certination.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrainingGoogle extends Fragment {

    ImageView i;
    public TrainingGoogle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_training_google, container, false);

        i=(ImageView)view.findViewById(R.id.imageView);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),GoogleAndroids.class);
                startActivity(i);
            }
        });
        return view;
    }

}
