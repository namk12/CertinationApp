package pls.certination.com.Pls.learning;

/**
 * Created by Kulwinder Singh on 8/8/2016.
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import pls.certination.com.certination.R;

//import com.backendless.Backendless;
//import com.backendless.BackendlessCollection;
//import com.backendless.async.callback.AsyncCallback;
//import com.backendless.exceptions.BackendlessFault;
//import com.backendless.persistence.BackendlessDataQuery;

public class assignment_student extends AppCompatActivity {

    Spinner s1;

    String ssubjects[] = {"Physics", "Maths", "Chemistry", "Mathematics",
            "JAVA", "Android"};
    ArrayAdapter<String> subjects;
    TextView name;
    TextView subndate;
    TextView compldate;
    TextView subnid;


    String sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_assignment_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        s1 = (Spinner) findViewById(R.id.spinnersubject);

        name = (TextView) findViewById(R.id.tv_Teach_Name);
        subndate = (TextView) findViewById(R.id.tv_submition);
        compldate = (TextView) findViewById(R.id.tv_completion);
        subnid = (TextView) findViewById(R.id.tv_submitionid);

        subjects = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ssubjects);

        subjects.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        s1.setAdapter(subjects);

//        s1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//
////                BackendlessDataQuery query = new BackendlessDataQuery();
////                String wc = "tchr_subject = "+"'"+ssubjects[i]+"'";
////                query.setWhereClause(wc);
////                Backendless.Persistence.of(Teacher.class).find(query, new AsyncCallback<BackendlessCollection<Teacher>>() {
////                    @Override
////                    public void handleResponse(BackendlessCollection<Teacher> teacherBackendlessCollection) {
////
////                        for(Teacher t:teacherBackendlessCollection.getData()){
////
////                            name.setText(t.getTchr_name());
////                            subndate.setText(t.getSubmission_date());
////                            compldate.setText(t.getCompletion_date());
////                            subnid.setText(t.getSubn_id());
////
////                        }
////                    }
////
////                    @Override
////                    public void handleFault(BackendlessFault backendlessFault) {
////
////                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
////                    }
////                });
//
//            }
//        });
//
//}
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
    }
}