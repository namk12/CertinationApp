package pls.certination.com.Pls.student_ambassador;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;

import pls.certination.com.certination.R;

public class Student_ambassador extends AppCompatActivity {

    FragmentManager myFragmentManager;
    FragmentTransaction myFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_student_ambasador);

        myFragmentManager = getSupportFragmentManager();
        myFragmentTransaction = myFragmentManager.beginTransaction();
        myFragmentTransaction.replace(R.id.containerViewstudent, new FragmentPageAdapter()).commit();
    }
}
