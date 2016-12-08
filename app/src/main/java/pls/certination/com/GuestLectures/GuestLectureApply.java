package pls.certination.com.GuestLectures;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import pls.certination.com.certination.R;

public class GuestLectureApply extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_lecture_apply);

        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> listview, View view, int position, long id)
            {
                Intent intent=new Intent(GuestLectureApply.this,GuestLectureRequest.class);
                startActivity(intent);

            }
        };
        ListView listView= (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(itemClickListener);
    }
}
