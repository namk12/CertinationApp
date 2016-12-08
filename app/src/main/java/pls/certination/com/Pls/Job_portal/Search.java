package pls.certination.com.Pls.Job_portal;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import pls.certination.com.certination.R;

public class Search extends AppCompatActivity {

    ArrayList<DataModel> data = new ArrayList<>();
    CustomAdapter adapter;
    RecyclerView mRootView;
    EditText inputSearch;
    Button search;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        search = (Button) findViewById(R.id.searchbtn);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data = new ArrayList<DataModel>();
                for (int i = 0; i < MyData.jobPostArray.length; i++) {
                    if (inputSearch.getText().toString().equalsIgnoreCase(MyData.jobPostArray[i])) {
                        DataModel d = new DataModel(MyData.jobPostArray[i], MyData.jobDescriptionArray[i], MyData.keySkillArray[i], MyData.id_[i]);
                        data.add(d);
                    }
                    inputSearch.clearComposingText();
                }

                mRootView = (RecyclerView) findViewById(R.id.recyview);
                adapter = new CustomAdapter(data, getApplicationContext());
                mRootView.setAdapter(adapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search.this);
                mRootView.setLayoutManager(layoutManager);
                mRootView.setItemAnimator(new DefaultItemAnimator());

            }
        });


    }


}

