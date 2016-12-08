package pls.certination.com.certination.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import pls.certination.com.certination.R;


public class Profile_first extends AppCompatActivity {

    ImageView profileimg;
    String img, course1, course2, course3, course4, course5;
    TextView name, email, contact;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profile);
        listView = (ListView) findViewById(R.id.listView);
        profileimg = (ImageView) findViewById(R.id.image);
        Backendless.initApp(this, "57D3BB62-EC7D-C4D9-FF94-FAA45FFFE300", "87858D89-A5C9-16A3-FF2A-E64D34F3EE00", "v1");

        name = (TextView) findViewById(R.id.textView);
        email= (TextView) findViewById(R.id.textView2);
        contact=(TextView)findViewById(R.id.textView3);
        BackendlessDataQuery dataQuery = new BackendlessDataQuery();

        String whereClause = "email='riya1234@gmail.com'";
        dataQuery.setWhereClause(whereClause);
        Backendless.Persistence.of(Details.class).find(dataQuery, new AsyncCallback<BackendlessCollection<Details>>() {
            @Override
            public void handleResponse(BackendlessCollection<Details> response) {
                for (Details sup : response.getData()) {
                    name.setText(sup.getName());
                    email.setText(sup.getEmail());
                    contact.setText(sup.getContact());
                    img=sup.getImg();
                    break;
                }
                new DownloadImageTask((ImageView)findViewById(R.id.image)).execute(img);

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }

        });

        Backendless.Persistence.of(Course.class).find(dataQuery, new AsyncCallback<BackendlessCollection<Course>>() {
            @Override
            public void handleResponse(BackendlessCollection<Course> response) {
                for (Course sup1 : response.getData()) {

                    if(sup1.getCourse1()!= null)
                        course1=sup1.getCourse1();
                    else
                        course1="";
                    if(sup1.getCourse2()!= null)
                        course2=sup1.getCourse2();
                    else
                        course2="";
                    if(sup1.getCourse3()!= null)
                        course3=sup1.getCourse3();
                    else
                        course3="";
                    if(sup1.getCourse4()!= null)
                        course4=sup1.getCourse4();
                    else
                        course4="";
                    if(sup1.getCourse5()!= null)
                        course5=sup1.getCourse5();
                    else
                        course5="";

                    break;
                }
                if(course1.equals("") && course2.equals("") && course3.equals("") && course4.equals("") && course5.equals(""))
                    Toast.makeText(Profile_first.this,"Not enrolled in any Course",Toast.LENGTH_LONG).show();

                String values[]=new String[]{
                        course1,course2,course3,course4,course5
                };


                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Profile_first.this, android.R.layout.simple_list_item_1, values);
                listView.setAdapter(adapter);


            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(Profile_first.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
