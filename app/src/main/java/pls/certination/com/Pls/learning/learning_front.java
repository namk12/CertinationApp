package pls.certination.com.Pls.learning;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pls.certination.com.Pls.learning.Result.Result;
import pls.certination.com.Pls.learning.time_table.table;
import pls.certination.com.certination.R;

/**
 * Created by AtreeTech on 8/4/2016.
 */
public class learning_front  extends AppCompatActivity {



    Button assignments,research,attendence,result,timetable,syllabus,library;

    Typeface flaticon;


    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_learning_front);


        assignments = (Button) findViewById(R.id.button);
        research = (Button) findViewById(R.id.button2);
        attendence = (Button) findViewById(R.id.button3);
        result = (Button) findViewById(R.id.button4);
        timetable = (Button) findViewById(R.id.button5);
        syllabus = (Button) findViewById(R.id.button6);
        library = (Button) findViewById(R.id.button7);


        flaticon = Typeface.createFromAsset(getAssets(),"fonts/VarelaRound.ttf");

        //Typeface

        assignments.setTypeface(flaticon);
        research.setTypeface(flaticon);
        attendence.setTypeface(flaticon);
        result.setTypeface(flaticon);
        timetable.setTypeface(flaticon);
        syllabus.setTypeface(flaticon);
        library.setTypeface(flaticon);

    }

    public void on_time_table(View view) {
        Intent i = new Intent(learning_front.this,table.class);
        startActivity(i);

    }

    public void on_create_assignment(View view) {
        Uri uri = Uri.parse("https://drive.google.com/open?id=0B0E5etVXXB0jbkVGSzdBczRCcFU");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        
        startActivity(intent);
    }

    public void on_create_result(View view) {
        Intent i = new Intent(learning_front.this,Result.class);
        startActivity(i);

    }
}
