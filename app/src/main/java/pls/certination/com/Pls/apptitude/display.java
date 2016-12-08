package pls.certination.com.Pls.apptitude;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import pls.certination.com.certination.R;

public class display extends AppCompatActivity {
    Aptitude apt = new Aptitude();
    EditText name;
    Button submit;
    TextView t6, t8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Backendless.initApp(this, BackendSettings.APPLICATION_ID, BackendSettings.ANDROID_SECRET_KEY, BackendSettings.VERSION);
        t6 = (TextView) findViewById(R.id.t6);
        t8 = (TextView) findViewById(R.id.t8);
        name = (EditText) findViewById(R.id.et_Name);
        submit = (Button) findViewById(R.id.submit);
        Bundle extras = getIntent().getExtras();
        String datas = extras.getString("mark");
        String data = extras.getString("i");
        t6.setText(datas);
        t8.setText(data);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty()) {
                    name.setError("Please Enter Your Name");
                } else {
                    savedDetails();
                }
            }
        });
    }
        public void savedDetails(){

                    apt.setName(name.getText().toString());
                    apt.setAns(t6.getText().toString());
                    apt.setMarksScore(t8.getText().toString());
                    Log.i("naman",apt.toString());

                    Backendless.Persistence.save(apt, new AsyncCallback<Aptitude>() {
                        @Override
                        public void handleResponse(Aptitude response) {
                            Toast.makeText(display.this, "Saved", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(display.this, "Submitted", Toast.LENGTH_SHORT).show();

                        }
                    });
    }
}



