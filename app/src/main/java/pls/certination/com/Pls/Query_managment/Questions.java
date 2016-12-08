package pls.certination.com.Pls.Query_managment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import java.util.ArrayList;

import pls.certination.com.certination.R;


public class Questions extends AppCompatActivity {

    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<String> ques = new ArrayList<>();
    ArrayList<String> ans = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);


        Backendless.initApp(this,BackendlessSettings.APP_ID,BackendlessSettings.SEC_KEY,BackendlessSettings.VER);


        lv = (ListView) findViewById(R.id.listView_ques);


        String whereClause = "question != ''";
        BackendlessDataQuery query = new BackendlessDataQuery();
        query.setWhereClause(whereClause);

        Backendless.Persistence.of(QuesAns.class).find(query, new AsyncCallback<BackendlessCollection<QuesAns>>() {
            @Override
            public void handleResponse(BackendlessCollection<QuesAns> quesAnsBackendlessCollection) {
                for(QuesAns q : quesAnsBackendlessCollection.getData()){
                    ques.add(q.getQuestion());
                    ans.add(q.getAnswer());
                }

                adapter = new ArrayAdapter<>(Questions.this, android.R.layout.simple_list_item_1,ques);

                lv.setAdapter(adapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                        Intent intent = new Intent(Questions.this, SingleQuestion.class);
                        intent.putExtra("QUESTION",ques.get(position));
                        intent.putExtra("ANSWER", ans.get(position));

                        Questions.this.startActivity(intent);
                    }
                });
            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                Toast.makeText(Questions.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });



    }
}