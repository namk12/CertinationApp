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

public class Gkmain extends AppCompatActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_gkmain);


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
            t1.setText("1.Grand Central Terminal, Park Avenue, New York is the world's");
            r1.setText("largest railway station");
            r2.setText("highest railway station");
            r3.setText("longest railway station");
            r4.setText("none of these");
            answer="a";
        }
        if(qn==2)
        {
            t1.setText("2.Brass gets discoloured in air because of the presence of which of the following gases in air?");
            r1.setText("Oxygen");
            r2.setText("Hydrogen sulphide");
            r3.setText("Carbon dioxide");
            r4.setText("Nitrogen");
            answer="b";
        }
        if(qn==3)
        {
            t1.setText("3.Which of the following is used in pencils?");
            r1.setText("Graphite");
            r2.setText("Silicon");
            r3.setText("Charcoal");
            r4.setText("Phosphorous");
            answer="b";
        }
        if(qn==4)
        {
            t1.setText("4.The percentage of irrigated land in India is about");
            r1.setText("45");
            r2.setText("65");
            r3.setText("35");
            r4.setText("25");
            answer="c";
        }
        if(qn==5)
        {
            t1.setText("5.The Centre for Cellular and Molecular Biology is situated at");
            r1.setText("Patna");
            r2.setText("Jaipur");
            r3.setText("Hyderabad");
            r4.setText("New Delhi");
            answer="c";
        }
        if(qn==6)
        {
            t1.setText("6.Gandhi Peace Prize for the year 2000 was awarded to the former President of South Africa along with");
            r1.setText("Sathish Dawan");
            r2.setText("C. Subramanian");
            r3.setText("Grameen Bank of Bangladesh");
            r4.setText("World Health Organisation");
            answer="c";
        }
        if(qn==7)
        {
            t1.setText("7.Who has been awarded the first lifetime Achievement Award for his/her contribution in the field of Cinema?");
            r1.setText("Ashok Kumar");
            r2.setText("Hou Hsio-hsein");
            r3.setText("Akiro Burosova");
            r4.setText("Bernardo Burtolucci");
            answer="a";
        }
        if(qn==8)
        {
            t1.setText("8.Which of the following is not associated with the UNO?");
            r1.setText("ILO");
            r2.setText("WHO");
            r3.setText("ASEAN");
            r4.setText("All Of The Above");
            answer="c";
        }
        if(qn==9)
        {
            t1.setText("9.Which of the following is not a chief organ of the United Nations Organisations?");
            r1.setText("International Labour Organisation");
            r2.setText("Security Council");
            r3.setText("International Court of Justice");
            r4.setText("General Assembly");
            answer="a";
        }
        if(qn==10)
        {
            t1.setText("10.Rabindranath Tagore's 'Jana Gana Mana' has been adopted as India's National Anthem. How many stanzas of the said song were adopted?");
            r1.setText("Only the first stanza");
            r2.setText("The whole song");
            r3.setText("Third and Fourth stanza");
            r4.setText("First and Second stanza");
            answer="a";
        }
        if(qn==11)
        {
            t1.setText("11.The words 'Satyameva Jayate' inscribed below the base plate of the emblem of India are taken from");
            r1.setText("Rigveda");
            r2.setText("Satpath Brahmana");
            r3.setText("Mundak Upanishad");
            r4.setText("Ramayana");
            answer="c";
        }
        if(qn==12)
        {
            t1.setText("12.The central banking functions in India are performed by the \n I.Central Bank of India\n II.Reserve Bank of India\n III.State Bank of India\n IV.Punjab National Bank");
            r1.setText("I, II");
            r2.setText("II");
            r3.setText("I");
            r4.setText("II, III");
            answer="b";
        }
        if(qn==13)
        {
            t1.setText("13.In which decade was the American Institute of Electrical Engineers (AIEE) founded?\n");
            r1.setText("1850s");
            r2.setText("1880s");
            r3.setText("1930");
            r4.setText("1950");
            answer="b";
        }
        if(qn==14)
        {
            t1.setText("14. OS' computer abbreviation usually means ?");
            r1.setText("Order of Significance");
            r2.setText("Open Software");
            r3.setText("Operating System");
            r4.setText("Optical Sensor");
            answer="c";
        }
        if(qn==15)
        {
            t1.setText("15.Who wrote the famous book - 'We the people'?");
            r1.setText("T.N.Kaul");
            r2.setText("J.R.D. Tata");
            r3.setText("Khushwant Singh");
            r4.setText("Nani Palkhivala");
            answer="d";
        }
        if(qn==16)
        {
            t1.setText("16.Who is the author of the book 'Forbidden Verses'?");
            r1.setText("Salman RushDie");
            r2.setText("Abu Nuwas");
            r3.setText("Ms. Taslima Nasrin");
            r4.setText("D.H. Lawrence");
            answer="b";
        }
        if(qn==17)
        {
            t1.setText("17.The name of the Laccadive, Minicoy and Amindivi islands was changed to Lakshadweep by an Act of Parliament in\n");
            r1.setText("1970");
            r2.setText("1971");
            r3.setText("1972");
            r4.setText("1973");
            answer="c";
        }
        if(qn==18)
        {
            t1.setText("18.The power to decide an election petition is vested in the\n");
            r1.setText("Parliament");
            r2.setText("Supreme Court");
            r3.setText("High Court");
            r4.setText("Election Commission");
            answer="c";
        }
        if(qn==19)
        {
            t1.setText("19.Look at this series: 0.15, 0.3, ____, 1.2, 2.4, ... What number shoul20th August is celebrated and fill the blank?\n");
            r1.setText("Earth Day");
            r2.setText("Sadbhavana Divas");
            r3.setText("No Tobacco Day");
            r4.setText("None of these");
            answer="b";
        }
        if(qn==20)
        {
            t1.setText("20.January 15 is celebrated as the\n");
            r1.setText("Republic Day");
            r2.setText("Ugadhi");
            r3.setText("Teachers' Day");
            r4.setText("Army Day");
            answer="d";
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
                Intent it=new Intent(this,Gkmain.class);
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

                Intent it=new Intent(this,Gkmain.class);
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
                Intent it=new Intent(this,Gkmain.class);
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
                Intent it=new Intent(this,Gkmain.class);
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
                        Intent it=new Intent(Gkmain.this,Gkmain.class);
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
                Intent it=new Intent(Gkmain.this,Gkmain.class);
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