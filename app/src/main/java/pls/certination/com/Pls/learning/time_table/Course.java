package pls.certination.com.Pls.learning.time_table;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import java.util.ArrayList;
import java.util.List;

import pls.certination.com.certination.R;

public class Course extends Activity {
    ListView listView ;
    ArrayAdapter<String> adapter1;
    ArrayList<String> course_list = new ArrayList<>();
    ProgressDialog pg ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView);

        Backendless.initApp(this, "03479974-A6D3-8701-FF6B-48B0B3350A00", "406F4226-19FD-BD3C-FF3F-1324B6560A00", "v1");

        BackendlessDataQuery dataQuery = new BackendlessDataQuery();

        Intent i = getIntent();
        int sno = i.getIntExtra("sno",0)+1;

        pg = new ProgressDialog(this);
        pg.show();
        String whereClause = "sno ="+"'"+sno+"'";
        dataQuery.setWhereClause(whereClause);

        Backendless.Persistence.of(Course_details.class).find(dataQuery, new AsyncCallback<BackendlessCollection<Course_details>>() {
            @Override
            public void handleResponse(BackendlessCollection<Course_details> response) {
                for (Course_details sup : response.getData()) {

                    course_list.add(sup.getCourse());

                }

                adapter1 = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, course_list);
                listView.setAdapter(adapter1);


            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }

        });

        pg.dismiss();

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getApplicationContext(), Tab.class);
                intent.putExtra("course",course_list.get(position));
                startActivity(intent);

            }

        });
    }

}
