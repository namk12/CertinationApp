package pls.certination.com.Pls.learning.Result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import pls.certination.com.certination.R;


public class TeacherAccessActivity extends Activity {

    Student student_ = new Student();
    EditText et1, et2, et3;
    EditText name, id;
    TextView tv1;
    float n, a, b, c;
    Button bt, bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tchr_access_act);
        et1 = (EditText) findViewById(R.id.et1_marks);
        et2 = (EditText) findViewById(R.id.et2_marks);
        et3 = (EditText) findViewById(R.id.et3_marks);
        bt = (Button) findViewById(R.id.bt_marks2);
        bt2 = (Button) findViewById(R.id.bt_graph);
        tv1 = (TextView) findViewById(R.id.textView7);

        name = (EditText) findViewById(R.id.nametxt);
        id = (EditText) findViewById(R.id.idtxt);

        Backendless.initApp(this, BackendSettings.APPLICATION_ID, BackendSettings.ANDROID_SECRET_KEY, BackendSettings.VERSION);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (et1.getText().toString().isEmpty()) {
                    et1.setError("Field cannot be empty");
                }  if (et2.getText().toString().isEmpty()) {
                    et2.setError("Field cannot be empty");
                }  if (et3.getText().toString().isEmpty()) {
                    et3.setError("Field cannot be empty");
                }  if (name.getText().toString().isEmpty()) {
                    name.setError("Field cannot be empty");
                }  if (id.getText().toString().isEmpty()) {
                    id.setError("Field cannot be empty");
                } else {
                    a = Float.parseFloat(et1.getText().toString());
                    b = Float.parseFloat(et2.getText().toString());
                    c = Float.parseFloat(et3.getText().toString());
                    n = (a + b + c) / 3;
                    tv1.setText("" + n);
                    saveNewContact();
                    bt2.setVisibility(View.VISIBLE);
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), graph_view.class);
                Bundle extras = new Bundle();
                float[] values = {Integer.parseInt(et1.getText().toString()), Integer.parseInt(et2.getText().toString()), Integer.parseInt(et3.getText().toString())};
                extras.putFloatArray("marks", values);
                i.putExtras(extras);
                startActivity(i);
            }
        });

    }

    public void saveNewContact() {
        student_.setMarks1(et1.getText().toString());
        student_.setMarks2(et2.getText().toString());
        student_.setMarks3(et3.getText().toString());
        student_.setId(id.getText().toString());
        student_.setName(name.getText().toString());

        Backendless.Persistence.of(Student.class).save(student_, new AsyncCallback<Student>() {
            @Override
            public void handleResponse(Student response) {
                Toast.makeText(TeacherAccessActivity.this, "saved", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(TeacherAccessActivity.this, "error" + fault, Toast.LENGTH_SHORT).show();

            }
        });
    }


}



