package pls.certination.com.Pls.Account_managment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import java.util.ArrayList;

import pls.certination.com.certination.R;

/**
 * Created by Arpit on 8/1/2016.
 */
public class Account_managment extends AppCompatActivity {
    //private ProgressDialog pg = new ProgressDialog(MainActivity.this);
    android.widget.ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        list = (ListView) findViewById(R.id.listView);
        // pg.setMessage("Please Wait..");
        //p///g.show();

        Backendless.initApp(this, BackendlessSettings.APP_ID, BackendlessSettings.SECRET_KEY, BackendlessSettings.VER);

        BackendlessDataQuery query = new BackendlessDataQuery();
        String where = "name !=''";
        query.setWhereClause(where);

        Backendless.Persistence.of(Supervisor.class).find(query, new AsyncCallback<BackendlessCollection<Supervisor>>() {
            @Override
            public void handleResponse(BackendlessCollection<Supervisor> response) {
                for (Supervisor s : response.getData()) {
                    arrayList.add(s.getName());
                }
                //      pg.dismiss();
                adapter = new ArrayAdapter<>(Account_managment.this, android.R.layout.simple_list_item_1, arrayList);

                list.setAdapter(adapter);

                Toast.makeText(Account_managment.this, "List Retrieved", Toast.LENGTH_SHORT).show();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent();
                        intent.setClass(Account_managment.this, DetailActivity.class);
                        intent.putExtra("name", arrayList.get(i));
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(Account_managment.this, "Fault in list retrieval", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
