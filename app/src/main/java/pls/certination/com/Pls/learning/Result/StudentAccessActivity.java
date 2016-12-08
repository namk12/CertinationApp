package pls.certination.com.Pls.learning.Result;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import pls.certination.com.certination.R;


public class StudentAccessActivity extends AppCompatActivity {

    TextView mks1, mks2, mks3,percentage;
    TextView nametxt,id;
    float a,b,c,n;
    Button button;

    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_access_act);
        pd = new ProgressDialog(StudentAccessActivity.this);

        mks1 = (TextView) findViewById(R.id.mk1);
        mks2 = (TextView) findViewById(R.id.mk2);
        mks3 = (TextView) findViewById(R.id.mk3);
        nametxt = (TextView) findViewById(R.id.name);
        id = (TextView) findViewById(R.id.id);
        percentage = (TextView) findViewById(R.id.percentage);

      //  button = (Button) findViewById(R.id.bt_marks2);

        pd.show();
        pd.dismiss();
        Backendless.initApp(this, BackendSettings.APPLICATION_ID, BackendSettings.ANDROID_SECRET_KEY, BackendSettings.VERSION);

        Intent i = getIntent();
        String name = i.getStringExtra("name");

        String whereClause = "name = '"+name+"'";
        BackendlessDataQuery query = new BackendlessDataQuery();
        query.setWhereClause(whereClause);

        Backendless.Persistence.of(Student.class).find(query, new AsyncCallback<BackendlessCollection<Student>>() {
            @Override
            public void handleResponse(BackendlessCollection<Student> response) {
                for(Student stud : response.getData()){
                    mks1.setText(stud.getMarks1().toString());
                    mks2.setText(stud.getMarks2().toString());
                    mks3.setText(stud.getMarks3().toString());
                    nametxt.setText(stud.getName().toString());
                    id.setText(stud.getId().toString());
                    break;
                }
                a = Float.parseFloat(mks1.getText().toString());
                b = Float.parseFloat(mks2.getText().toString());
                c = Float.parseFloat(mks3.getText().toString());
                n = (a + b + c ) / 3;
                percentage.setText("" + n);
                Toast.makeText(StudentAccessActivity.this, "passed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(StudentAccessActivity.this, "Failed:="+fault, Toast.LENGTH_SHORT).show();
            }
        });

        button = (Button)findViewById(R.id.graph);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), graph_view.class);
                Bundle extras = new Bundle();
                float[] values = {Integer.parseInt(mks1.getText().toString()),Integer.parseInt(mks2.getText().toString()), Integer.parseInt(mks3.getText().toString())};
                extras.putFloatArray("marks", values);
                i.putExtras(extras);
                startActivity(i);
            }
        });

    }
}
