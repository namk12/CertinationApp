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

public class Frontpage extends AppCompatActivity implements View.OnClickListener {
    Button bt1,bt2,bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        bt1=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);
        bt3=(Button)findViewById(R.id.button3);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button)
        {
            Intent it= new Intent(this,testinfo.class);
            startActivity(it);
            finish();
        }
        if(view.getId()==R.id.button2)
        {
            Intent it= new Intent(this,logicaltest.class);
            startActivity(it);
            finish();
        }
        if(view.getId()==R.id.button3)
        {
            Intent it= new Intent(this,Gktest.class);
            startActivity(it);
            finish();
        }
    }
}
