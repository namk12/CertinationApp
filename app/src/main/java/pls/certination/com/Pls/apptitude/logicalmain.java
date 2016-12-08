package pls.certination.com.Pls.apptitude;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import pls.certination.com.certination.R;

public class logicalmain extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    TextView t1;
    RadioButton r1,r2,r3,r4;
    int i;
    RadioGroup rd1;
    String answer;
    int qn,mark;
    String v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logicalmain);

        Bundle extras = getIntent().getExtras();
        String datas = extras.getString("qn").toString();
        String datass = extras.getString("mark").toString();
        String n=extras.getString("i").toString();
        i=Integer.valueOf(n);
        mark = Integer.valueOf(datass);
        qn = Integer.valueOf(datas);
        v = extras.getString("v").toString();

        t1 = (TextView) findViewById(R.id.t1);
        r1 = (RadioButton) findViewById(R.id.r1);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        rd1 = (RadioGroup) findViewById(R.id.rd1);

        if(qn==1)
        {
            t1.setText("1. Look at this series: 21, 9, 21, 11, 21, 13, 21, ... What number should come next?\n");
            r1.setText("14");
            r2.setText("15");
            r3.setText("21");
            r4.setText("none of these");
            answer="b";
        }
        if(qn==2)
        {
            t1.setText("2.Which word does NOT belong with the others?\n");
            r1.setText("unimportant");
            r2.setText("familiar");
            r3.setText("trivial");
            r4.setText("none of these");
            answer="b";
        }
        if(qn==3)
        {
            t1.setText("3.Middletown is north of Centerville.\n" +
                    "Centerville is east of Penfield.\n" +
                    "Penfield is northwest of Middletown.\n" +
                    "If the first two statements are true, the third statement is :\n");
            r1.setText("True");
            r2.setText("False");
            r3.setText("Uncertain");
            r4.setText("none of these");
            answer="b";
        }
        if(qn==4)
        {
            t1.setText("4.Look at this series: 2, 6, 18, 54, ... What number should come next?");
            r1.setText("108");
            r2.setText("408");
            r3.setText("162");
            r4.setText("none of these");
            answer="c";
        }
        if(qn==5)
        {
            t1.setText("5.ere are some words translated from an artificial language.\n" +
                    "myncabel means saddle horse\n" +
                    "conowir means trail ride\n" +
                    "cabelalma means horse blanket\n" +
                    "Which word could mean horse ride ?\n");
            r1.setText("cabelwir");
            r2.setText("conocabel");
            r3.setText("conocabel");
            r4.setText("none of these");
            answer="a";
        }
        if(qn==6)
        {
            t1.setText("6.Look at this series: 5.2, 4.8, 4.4, 4, ... What number should come next?\n");
            r1.setText("3.5");
            r2.setText("3");
            r3.setText("3.6");
            r4.setText("3.3");
            answer="c";
        }
        if(qn==7)
        {
            t1.setText("7.\t\n" + "FAG, GAF, HAI, IAH, ____\n");
            r1.setText("JAC");
            r2.setText("HAL");
            r3.setText("HAC");
            r4.setText("JAY");
            answer="a";
        }
        if(qn==8)
        {
            t1.setText("8.Look at this series: 80, 10, 70, 15, 60, ... What number should come next?\n");
            r1.setText("20");
            r2.setText("35");
            r3.setText("30");
            r4.setText("50");
            answer="a";
        }
        if(qn==9)
        {
            t1.setText("9.Look at this series: 8, 43, 11, 41, __, 39, 17, ... What number should fill in the blank?");
            r1.setText("8");
            r2.setText("14");
            r3.setText("44");
            r4.setText("33");
            answer="b";
        }
        if(qn==10)
        {
            t1.setText("10.CMM, EOO, GQQ, _____, KUU");
            r1.setText("GRR");
            r2.setText("GSS");
            r3.setText("ISS");
            r4.setText("ITT");
            answer="c";
        }
        if(qn==11)
        {
            t1.setText("11.P5QR, P4QS, P3QT, _____, P1QV");
            r1.setText("PQW");
            r2.setText("PQV2");
            r3.setText("P2QU");
            r4.setText("PQ3U");
            answer="c";
        }
        if(qn==12)
        {
            t1.setText("12.Which word does NOT belong with the others?\n");
            r1.setText("eel");
            r2.setText("lobster");
            r3.setText("crab");
            r4.setText("shrimp");
            answer="a";
        }
        if(qn==13)
        {
            t1.setText("13.Look at this series: 8, 6, 9, 23, 87 , ... What number should come next?\n");
            r1.setText("128");
            r2.setText("324");
            r3.setText("226");
            r4.setText("429");
            answer="d";
        }
        if(qn==14)
        {
            t1.setText("14. 17 32 19 29 21 26 23:");
            r1.setText("15 25");
            r2.setText("25 25");
            r3.setText("23 25");
            r4.setText("27 32");
            answer="c";
        }
        if(qn==15)
        {
            t1.setText("15.A and B invest in a business in the ratio 3 : 2. If 5% of the total profit goes to charity and A's share is Rs. 855, the total profit is:");
            r1.setText("1425");
            r2.setText("1500");
            r3.setText("1537.25");
            r4.setText("1576");
            answer="b";
        }
        if(qn==16)
        {
            t1.setText("16.\n" +
                    "Q18 QAR, RAS, SAT, TAU, _____\n");
            r1.setText("UAV");
            r2.setText("UAT");
            r3.setText("TAS");
            r4.setText("TAT");
            answer="a";
        }
        if(qn==17)
        {
            t1.setText("17.Which word does NOT belong with the others?\n");
            r1.setText("fair");
            r2.setText("just");
            r3.setText("favorable");
            r4.setText("equitable");
            answer="c";
        }
        if(qn==18)
        {
            t1.setText("18. 75 65 85 55 45 85 35\n");
            r1.setText("25 15");
            r2.setText("25 85");
            r3.setText("35 25");
            r4.setText("25 75");
            answer="b";
        }
        if(qn==19)
        {
            t1.setText("19.Look at this series: 0.15, 0.3, ____, 1.2, 2.4, ... What number should fill the blank?\n");
            r1.setText("4.8");
            r2.setText("0.006");
            r3.setText("0.6");
            r4.setText("0.9");
            answer="c";
        }
        if(qn==20)
        {
            t1.setText("20.Look at this series: U32, V29, __, X23, Y20, ... What number should fill the blank?\n");
            r1.setText("W26");
            r2.setText("W17");
            r3.setText("Z26");
            r4.setText("Z17");
            answer="a";
        }

        if(qn==21)
        {
            Intent it=new Intent(this,display.class);
            it.putExtra("qn",String.valueOf(qn));
            it.putExtra("mark",String.valueOf(mark));
            it.putExtra("i",String.valueOf(i));
            it.putExtra("v",v);

            startActivity(it);
            finish();
        }

        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view)
    {
        int marks=2;
        if(view.getId()==R.id.b2) {
            /*if(qn==21)
            {
                Intent it=new Intent(this,display.class);
                it.putExtra("qn",String.valueOf(qn));
                it.putExtra("mark",String.valueOf(mark));
                it.putExtra("i",String.valueOf(i));
                it.putExtra("v",v);


                startActivity(it);
            }*/
            if (rd1.getCheckedRadioButtonId() == R.id.r1) {
                if(answer.equals("a"))
                {
                    mark+=marks;
                    char []z=v.toCharArray();
                    z[qn-1]='t';
                    v=String.valueOf(z);
                    i++;


                }
                qn++;
                Intent it=new Intent(this,logicalmain.class);
                it.putExtra("qn",String.valueOf(qn));
                it.putExtra("mark",String.valueOf(mark));
                it.putExtra("i",String.valueOf(i));
                it.putExtra("v",v);
                startActivity(it);
                finish();
            } else if (rd1.getCheckedRadioButtonId() == R.id.r2) {
                if(answer.equals("b"))
                {
                    mark+=marks;
                    char []z=v.toCharArray();
                    z[qn-1]='t';
                    v=String.valueOf(z);
                    i++;


                }
                qn++;
                Intent it=new Intent(this,logicalmain.class);
                it.putExtra("qn",String.valueOf(qn));
                it.putExtra("mark",String.valueOf(mark));
                it.putExtra("i",String.valueOf(i));
                it.putExtra("v",v);
                startActivity(it);
                finish();
            } else if (rd1.getCheckedRadioButtonId() == R.id.r3) {
                if(answer.equals("c"))
                {
                    mark+=marks;
                    i++;

                    char []z=v.toCharArray();
                    z[qn-1]='t';
                    v=String.valueOf(z);

                }
                qn++;
                Intent it=new Intent(this,logicalmain.class);
                it.putExtra("qn",String.valueOf(qn));
                it.putExtra("mark",String.valueOf(mark));
                it.putExtra("i",String.valueOf(i));
                it.putExtra("v",v);
                startActivity(it);
                finish();
            } else if (rd1.getCheckedRadioButtonId() == R.id.r4) {
                if(answer.equals("d"))
                {
                    mark+=marks;
                    char []z=v.toCharArray();
                    z[qn-1]='t';
                    v=String.valueOf(z);
                    i++;
                }
                qn++;
                Intent it=new Intent(this,logicalmain.class);
                it.putExtra("qn",String.valueOf(qn));
                it.putExtra("mark",String.valueOf(mark));
                it.putExtra("i",String.valueOf(i));
                it.putExtra("v",v);
                startActivity(it);
                finish();

            }
            else
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Are you sure,You wanted skip");

                alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent it=new Intent(logicalmain.this,logicalmain.class);
                        qn++;
                        it.putExtra("qn",String.valueOf(qn));
                        it.putExtra("mark",String.valueOf(mark));
                        it.putExtra("i",String.valueOf(i));
                        it.putExtra("v",v);
                        startActivity(it);
                        finish();

                    }
                });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }





        }
        if(view.getId()==R.id.b1)
        {
            if(qn==1)
            {

            }
            else
            {
                qn--;

                char []z=v.toCharArray();

                v=String.valueOf(z);

                if(z[qn-1]=='t')
                {
                    z[qn-1]='f';
                    v=String.valueOf(z);
                    mark=mark-marks;
                    i--;
                }
                if(z[qn]=='t')
                {
                    z[qn]='f';
                    v=String.valueOf(z);

                }
                Intent it=new Intent(logicalmain.this,logicalmain.class);
                it.putExtra("qn",String.valueOf(qn));
                it.putExtra("mark",String.valueOf(mark));
                it.putExtra("v",v);
                it.putExtra("i",String.valueOf(i));
                startActivity(it);
                finish();
            }



        }
    }


}