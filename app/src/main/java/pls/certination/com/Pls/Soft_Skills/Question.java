package pls.certination.com.Pls.Soft_Skills;



import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import pls.certination.com.certination.R;


public class Question extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    RadioGroup rg;
    RadioButton rb1, rb2, rb3, rb4;
    Button bt1, bt2;
    int qn, mark, i;
    String answer;
    String v;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ques_act);
        tv = (TextView) findViewById(R.id.tv_ques);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        bt1 = (Button) findViewById(R.id.bt_prev);
        bt2 = (Button) findViewById(R.id.bt_next);
        Bundle extras = getIntent().getExtras();
        String datas = extras.getString("qn").toString();
        String datass = extras.getString("mark").toString();
        String n = extras.getString("i").toString();
        i = Integer.valueOf(n);
        mark = Integer.valueOf(datass);
        qn = Integer.valueOf(datas);
        if (qn == 1) {
            tv.setText(R.string.commu);
            rb1.setText(R.string.commu_A);
            rb2.setText(R.string.commu_B);
            rb3.setText(R.string.commu_C);
            rb4.setText(R.string.commu_D);
            answer="";

        }
        if (qn == 2) {
            tv.setText(R.string.deter);
            rb1.setText(R.string.deter_A);
            rb2.setText(R.string.deter_B);
            rb3.setText(R.string.deter_C);
            rb4.setText(R.string.deter_D);
            answer = "";

        }
        if (qn == 3) {
            tv.setText(R.string.mentor);
            rb1.setText(R.string.mentor_A);
            rb2.setText(R.string.mentor_B);
            rb3.setText(R.string.mentor_C);
            rb4.setText(R.string.mentor_D);
            answer = "";
        }
        if (qn == 4) {
            tv.setText(R.string.leader);
            rb1.setText(R.string.leader_A);
            rb2.setText(R.string.leader_B);
            rb3.setText(R.string.leader_C);
            rb4.setText(R.string.leader_D);
            answer = "";
        }
        if (qn == 5) {
            tv.setText(R.string.team);
            rb1.setText(R.string.team_A);
            rb2.setText(R.string.team_B);
            rb3.setText(R.string.team_C);
            rb4.setText(R.string.team_D);
            answer = "";
        }
        if (qn == 6) {
            tv.setText(R.string.creative);
            rb1.setText(R.string.creative_A);
            rb2.setText(R.string.creative_B);
            rb3.setText(R.string.creative_C);
            rb4.setText(R.string.creative_D);
            answer = "";
        }
        if (qn == 7) {
            tv.setText(R.string.presentation);
            rb1.setText(R.string.presentation_A);
            rb2.setText(R.string.presentation_B);
            rb3.setText(R.string.presentation_C);
            rb4.setText(R.string.presentation_D);
            answer = "";
        }
        if (qn == 8) {
            Intent it = new Intent(this, Display.class);
            it.putExtra("qn", String.valueOf(qn));
            it.putExtra("mark", String.valueOf(mark));
            it.putExtra("i", String.valueOf(i));
            it.putExtra("v", v);
            startActivity(it);
            finish();


        }
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);

    }

//    private void MarksScore() {
//        int marks = 5;
//        if(qn==1&&rb1.isChecked()){
//
//            mark +=marks;
//        }
//        if(qn==2&rb3.isChecked()){
//            mark+=marks;
//        }
//
//    }


    @Override
    public void onClick(View view) {
        int marks = 5;

        if (view.getId() == R.id.bt_next) {
            if (rg.getCheckedRadioButtonId() == R.id.rb1) {
                if (answer.equals("a")) {
                   // MarksScore();
                    mark += marks;
//                    char[] z = v.toCharArray();
//                    z[qn - 1] = 't';
//                    v = String.valueOf(z);
//                    i++;
                }

                    qn++;
                    Intent it = new Intent(this, Question.class);
                    it.putExtra("qn", String.valueOf(qn));
                    it.putExtra("mark", String.valueOf(mark));
                    it.putExtra("i", String.valueOf(i));
                    it.putExtra("v", v);
                    startActivity(it);
                    finish();

            } else if (rg.getCheckedRadioButtonId() == R.id.rb2) {
                if (answer.equals("b")) {
                    //mark += marks;
//                    char[] z = v.toCharArray();
//                    z[qn - 1] = 't';
//                    v = String.valueOf(z);
//                    i++;


                }
                qn++;

                Intent it = new Intent(this, Question.class);
                it.putExtra("qn", String.valueOf(qn));
                it.putExtra("mark", String.valueOf(mark));
                it.putExtra("i", String.valueOf(i));
                it.putExtra("v", v);
                startActivity(it);
                finish();
            } else if (rg.getCheckedRadioButtonId() == R.id.rb3) {
                if (answer.equals("c")) {
                   mark += marks;
                    i++;

//                    char[] z = v.toCharArray();
//                    z[qn - 1] = 't';
//                    v = String.valueOf(z);

                }
                qn++;
                Intent it = new Intent(this, Question.class);
                it.putExtra("qn", String.valueOf(qn));
                it.putExtra("mark", String.valueOf(mark));
                it.putExtra("i", String.valueOf(i));
                it.putExtra("v", v);
                startActivity(it);
                finish();
            } else if (rg.getCheckedRadioButtonId() == R.id.rb4) {
                if (answer.equals("d")) {
                   mark += marks;
                    i++;
//                    char[] z = v.toCharArray();
//                    z[qn - 1] = 't';
//                    v = String.valueOf(z);
//                    i++;


                }
                qn++;
                Intent it = new Intent(this, Question.class);
                it.putExtra("qn", String.valueOf(qn));
                it.putExtra("mark", String.valueOf(mark));
                it.putExtra("i", String.valueOf(i));
                it.putExtra("v", v);
                startActivity(it);
                finish();


            } else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Are you sure,You wanted skip");

                alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent it = new Intent(Question.this, Question.class);
                        qn++;
                        it.putExtra("qn", String.valueOf(qn));
                        it.putExtra("mark", String.valueOf(mark));
                        it.putExtra("i", String.valueOf(i));
                        it.putExtra("v", v);
                        startActivity(it);
                        finish();

                    }
                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        }
        if (view.getId() == R.id.bt_prev) {
            if (qn == 1) {

            } else {
                qn--;

                char[] z = v.toCharArray();

                v = String.valueOf(z);

                if (z[qn - 1] == 't')
                {
                    z[qn - 1] = 'f';
                    v = String.valueOf(z);
//
                    i--;
                }
                if (z[qn] == 't')
                {

                    z[qn] = 'f';
                    v = String.valueOf(z);


                }

            }
        }
    }
}


