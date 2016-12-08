package pls.certination.com.Pls.apptitude;

/**
 * Created by Kulwinder Singh on 8/20/2016.
 */


        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.PopupWindow;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.AdapterView.OnItemSelectedListener;
        import android.widget.Toast;

        import pls.certination.com.certination.R;


public class Apptitude extends AppCompatActivity implements android.view.View.OnClickListener {
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
        setContentView(R.layout.apptitude);

        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

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
            t1.setText("1.A train passes a station platform in 36 seconds and a man standing on the platform in 20 seconds. If the speed of the train is 54 km/hr, what is the length of the platform?");
            r1.setText("120 m");
            r2.setText("240 m");
            r3.setText("300 m");
            r4.setText("none of these");
            answer="b";
        }
        if(qn==2)
        {
            t1.setText("2.An observer 1.6 m tall is 203 away from a tower. The angle of elevation from his eye to the top of the tower is 30º. The heights of the tower is:");
            r1.setText("21.6 m");
            r2.setText("23.2 m");
            r3.setText("24.72 m");
            r4.setText("none of these");
            answer="a";
        }
        if(qn==3)
        {
            t1.setText("3.An automobile financier claims to be lending money at simple interest, but he includes the interest every six months for calculating the principal. If he is charging an interest of 10%, the effective rate of interest becomes:");
            r1.setText("10%");
            r2.setText("10.25% ");
            r3.setText("10.5%");
            r4.setText("none of these");
            answer="b";
        }
        if(qn==4)
        {
            t1.setText("4.Alfred buys an old scooter for Rs. 4700 and spends Rs. 800 on its repairs. If he sells the scooter for Rs. 5800, his gain percent is:");
            r1.setText("5.5%");
            r2.setText("5.45%");
            r3.setText("10%");
            r4.setText("none of these");
            answer="b";
        }
        if(qn==5)
        {
            t1.setText("5.A batsman scored 110 runs which included 3 boundaries and 8 sixes. What percent of his total score did he make by running between the wickets?");
            r1.setText("45%");
            r2.setText("45.45%");
            r3.setText("46%");
            r4.setText("none of these");
            answer="b";
        }
        if(qn==6)
        {
            t1.setText("6.It was Sunday on Jan 1, 2006. What was the day of the week Jan 1, 2010?");
            r1.setText("Sunday");
            r2.setText("Saturday");
            r3.setText("Friday");
            r4.setText("Wednesday");
            answer="c";
        }
        if(qn==7)
        {
            t1.setText("7.In the first 10 overs of a cricket game, the run rate was only 3.2. What should be the run rate in the remaining 40 overs to reach the target of 282 runs?");
            r1.setText("6.25");
            r2.setText("6.5");
            r3.setText("6.75");
            r4.setText("7");
            answer="a";
        }
        if(qn==8)
        {
            t1.setText("8.A hollow iron pipe is 21 cm long and its external diameter is 8 cm. If the thickness of the pipe is 1 cm and iron weighs 8 g/cm3, then the weight of the pipe is:");
            r1.setText("3.6 kg");
            r2.setText("3.696 kg");
            r3.setText("36 kg");
            r4.setText("36.9 kg");
            answer="b";
        }
        if(qn==9)
        {
            t1.setText("9.It is being given that (2^32 + 1) is completely divisible by a whole number. Which of the following numbers is completely divisible by this number?");
            r1.setText("(2^16 + 1)");
            r2.setText("(2^16 - 1)");
            r3.setText("(7 x 2^23)");
            r4.setText("(2^96 + 1)");
            answer="d";
        }
        if(qn==10)
        {
            t1.setText("10.Six bells commence tolling together and toll at intervals of 2, 4, 6, 8 10 and 12 seconds respectively. In 30 minutes, how many times do they toll together ?");
            r1.setText("4");
            r2.setText("10");
            r3.setText("15");
            r4.setText("16");
            answer="d";
        }
        if(qn==11)
        {
            t1.setText("11.If a - b = 3 and a2 + b2 = 29, find the value of ab.");
            r1.setText("10");
            r2.setText("12");
            r3.setText("15");
            r4.setText("18");
            answer="a";
        }
        if(qn==12)
        {
            t1.setText("12.Excluding stoppages, the speed of a bus is 54 kmph and including stoppages, it is 45 kmph. For how many minutes does the bus stop per hour?");
            r1.setText("9");
            r2.setText("10");
            r3.setText("12");
            r4.setText("20");
            answer="b";
        }
        if(qn==13)
        {
            t1.setText("13.A can lay railway track between two given stations in 16 days and B can do the same job in 12 days. With help of C, they did the job in 4 days only. Then, C alone can do the job in:");
            r1.setText("9");
            r2.setText("46/5");
            r3.setText("48/5");
            r4.setText("20");
            answer="b";
        }
        if(qn==14)
        {
            t1.setText("14.The difference between simple and compound interests compounded annually on a certain sum of money for 2 years at 4% per annum is Re. 1. The sum (in Rs.) is:");
            r1.setText("625");
            r2.setText("630");
            r3.setText("640");
            r4.setText("650");
            answer="a";
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
            t1.setText("16.Father is aged three times more than his son Ronit. After 8 years, he would be two and a half times of Ronit's age. After further 8 years, how many times would he be of Ronit's age?");
            r1.setText("2 times");
            r2.setText("2.5 times");
            r3.setText("2.74 times");
            r4.setText("3 times");
            answer="a";
        }
        if(qn==17)
        {
            t1.setText("17.A watch which gains 5 seconds in 3 minutes was set right at 7 a.m. In the afternoon of the same day, when the watch indicated quarter past 4 o'clock, the true time is:");
            r1.setText("3.54 pm");
            r2.setText("4 pm");
            r3.setText("5 pm");
            r4.setText("6 pm");
            answer="b";
        }
        if(qn==18)
        {
            t1.setText("18.How many 3-digit numbers can be formed from the digits 2, 3, 5, 6, 7 and 9, which are divisible by 5 and none of the digits is repeated?");
            r1.setText("5");
            r2.setText("10");
            r3.setText("15");
            r4.setText("20");
            answer="d";
        }
        if(qn==19)
        {
            t1.setText("19.A two-digit number is such that the product of the digits is 8. When 18 is added to the number, then the digits are reversed. The number is:");
            r1.setText("18");
            r2.setText("24");
            r3.setText("42");
            r4.setText("81");
            answer="b";
        }
        if(qn==20)
        {
            t1.setText("20.Two numbers are respectively 20% and 50% more than a third number. The ratio of the two numbers is:");
            r1.setText("2 : 5");
            r2.setText("3 : 5");
            r3.setText("4 : 5");
            r4.setText("6 : 7");
            answer="c";
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
                Intent it=new Intent(this,Apptitude.class);
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

                Intent it=new Intent(this,Apptitude.class);
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
                Intent it=new Intent(this,Apptitude.class);
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
                Intent it=new Intent(this,Apptitude.class);
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
                        Intent it=new Intent(Apptitude.this,Apptitude.class);
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
                Intent it=new Intent(Apptitude.this,Apptitude.class);
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
