package pls.certination.com.Pls.student_ambassador;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pls.certination.com.certination.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ObjectiveFragment extends Fragment {


    public ObjectiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_objective, container, false);
    }

}
