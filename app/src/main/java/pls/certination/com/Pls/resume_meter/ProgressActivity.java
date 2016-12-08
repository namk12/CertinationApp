package pls.certination.com.Pls.resume_meter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import pls.certination.com.Pls.Pls;
import pls.certination.com.certination.R;

public class ProgressActivity extends Activity
{
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView, t2,t3;
    private Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_layout);


        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        textView = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
t3=(TextView)findViewById(R.id.progress_name);

        Intent i = getIntent();
        String s4=i.getStringExtra("name");
t3.setText(s4);
        int s1 = i.getIntExtra("per", 0);

        progressStatus = i.getIntExtra("per", 0);
        ;
//
        progressBar.setProgress(progressStatus);
        textView.setText(progressStatus + "/" + progressBar.getMax());
//
//
        if(s1<40) {
            t2.setText(s1 + "% your resume is not efficient.");
        }
        else if (s1>40 && s1<80)
        {
            t2.setText(s1 + "% your resume is  efficient.");
        }
        else if(s1>80)
        {
            t2.setText(s1 + "% your resume is  Excellent.");
        }
ProgressBar pb=(ProgressBar)findViewById(R.id.progressBar1);
        pb.setProgress(s1);


    }

}
