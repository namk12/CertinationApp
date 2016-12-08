package pls.certination.com.Pls.Account_managment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import pls.certination.com.certination.R;

public class DetailActivity extends AppCompatActivity {
    private LinearLayout btnmore;
    ImageView profileimg;
    TextView name, designation, department, about;
    String email;
    String phone;
    String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_managment);
        profileimg = (ImageView) findViewById(R.id.ivImage);
        Backendless.initApp(this, BackendlessSettings.APP_ID, BackendlessSettings.SECRET_KEY, BackendlessSettings.VER);

        name = (TextView) findViewById(R.id.name);
        designation = (TextView) findViewById(R.id.designation);
        department = (TextView) findViewById(R.id.department);
        about = (TextView) findViewById(R.id.tabout);
        btnmore = (LinearLayout) findViewById(R.id.btnmore);


        Intent i = getIntent();
        String namec = i.getExtras().getString("name");


        String whereClause = "name = '" + namec + "'";

        BackendlessDataQuery dataQuery = new BackendlessDataQuery();

        dataQuery.setWhereClause(whereClause);

        Backendless.Persistence.of(Supervisor.class).find(dataQuery, new AsyncCallback<BackendlessCollection<Supervisor>>() {
            @Override
            public void handleResponse(BackendlessCollection<Supervisor> response) {
                for (Supervisor sup : response.getData()) {
                    name.setText(sup.getName());
                    designation.setText(sup.getDesignation());
                    department.setText(sup.getDepartment());
                    about.setText(sup.getAbout());
                    email = sup.getEmail();
                    phone = sup.getPhone();
                    image = sup.getImage();
                    break;
                }
                new DownloadImageTask((ImageView) findViewById(R.id.ivImage)).execute(image);
                Toast.makeText(DetailActivity.this, "DOne", Toast.LENGTH_LONG).show();


            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(DetailActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

        btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DetailActivity.this);

                alertDialog.setTitle("Contact");


                alertDialog.setIcon(android.R.drawable.stat_sys_phone_call_forward);


                alertDialog.setPositiveButton("Phone", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + phone));
                        startActivity(intent);
                    }
                });

                alertDialog.setNegativeButton("Email", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                        sendIntent.setType("plain/text");
                        sendIntent.setData(Uri.parse(email));
                        sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                        startActivity(sendIntent);
                        dialog.cancel();
                    }
                });


                alertDialog.show();
            }
        });


    }
}
