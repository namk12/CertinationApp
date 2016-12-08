package pls.certination.com.Pls.Query_managment;

/**
 * Created by Kulwinder Singh on 8/11/2016.
 */

import pls.certination.com.certination.R;



        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.Toast;

        import com.backendless.Backendless;

public class Query_managment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.querry_managment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Backendless.initApp(this,BackendlessSettings.APP_ID,BackendlessSettings.SEC_KEY,BackendlessSettings.VER);



        Button b1 = (Button)findViewById(R.id.button_ask);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(Query_managment.this,Questions.class);
                startActivity(i1);
            }
        });

        Button b2= (Button)findViewById(R.id.button_ask2);
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent askques=new Intent(Query_managment.this,Asking.class);
                startActivity(askques);
            }

        });
    }



}
