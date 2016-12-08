package pls.certination.com.Pls.learning.time_table;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Context;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.content.res.Resources.Theme;

import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import pls.certination.com.certination.R;

public class Tab extends AppCompatActivity implements OnItemSelectedListener{


    Course_details details = new Course_details();
    String[] days;
    ArrayAdapter<String> adapter;
    Spinner spinner;
    String course;
    String day1;
    TextView textView;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Backendless.initApp(this, "03479974-A6D3-8701-FF6B-48B0B3350A00", "406F4226-19FD-BD3C-FF3F-1324B6560A00", "v1");

        // Setup spinner
        days = new String[]{
                "Select Day",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,days);
        spinner.setAdapter(adapter);

        pd = new ProgressDialog(this);

        Intent i = getIntent();
        course = i.getStringExtra("course");

        String w = "course = '"+course+"'";
        BackendlessDataQuery q = new BackendlessDataQuery();
        q.setWhereClause(w);
        pd.show();

        Backendless.Persistence.of(Course_details.class).find(q, new AsyncCallback<BackendlessCollection<Course_details>>() {
            @Override
            public void handleResponse(BackendlessCollection<Course_details> response) {
                for(Course_details d:response.getData()){
                    details = d;
                }
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(Tab.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
        pd.dismiss();

        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        day1 = spinner.getItemAtPosition(position).toString();
        textView = (TextView)findViewById(R.id.tv);
        if(day1.equals("Select Day")) {
            textView.setText("Select Day");
        }else if(day1.equals("Monday")){
            textView.setText(details.getMonday());
        }else if(day1.equals("Tuesday")){
            textView.setText(details.getTuesday());
        }else if(day1.equals("Wednesday")){
            textView.setText(details.getWednesday());
        }else if(day1.equals("Thursday")){
            textView.setText(details.getThursday());
        }else if(day1.equals("Friday")){
            textView.setText(details.getFriday());
        }else if(day1.equals("Saturday")){
            textView.setText(details.getSaturday());
        }else{
            textView.setText("ERROR");
        }




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        textView.setText("Select Day");
    }

}
