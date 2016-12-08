package pls.certination.com.Pls.apptitude;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import pls.certination.com.certination.R;

public class Gktest extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gktest);
        b = (Button) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int mark = 0;
                int qn = 1;
                int i=0;
                String v="ffffffffffffffffffff";
                Intent it = new Intent(Gktest.this,Gkmain.class);
                it.putExtra("mark", String.valueOf(mark));
                it.putExtra("qn", String.valueOf(qn));
                it.putExtra("i",String.valueOf(i));
                it.putExtra("v",v);
                startActivity(it);
                finish();
            }
        });

//        }
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }

    }

}