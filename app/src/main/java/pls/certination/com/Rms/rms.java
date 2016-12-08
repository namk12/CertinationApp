package pls.certination.com.Rms;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
import javax.mail.Message.RecipientType;
import javax.mail.Session;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pls.certination.com.certination.R;

public class rms extends AppCompatActivity implements View.OnClickListener
{
    public Session session = null;
    public ProgressDialog pDialog = null;
    Context context = null;

    public String strname;
    public String stremail;
    public String strdes;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText ed1,ed2,ed3;
    Typeface typeface;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    Button btn;
    RadioButton rd1,rd2,rd3,rd4,rd5;
    RadioGroup rdg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rms);

        context = this;

       // ActionBar actionBar = getSupportActionBar();
       // actionBar.hide();

        rd1 = (RadioButton) findViewById(R.id.suggest);
        rd2 = (RadioButton) findViewById(R.id.complaint);
        rd3 = (RadioButton) findViewById(R.id.request);
        rd4 = (RadioButton) findViewById(R.id.enquiry);
        rd5 = (RadioButton) findViewById(R.id.compliment);


        btn = (Button) findViewById(R.id.btn);
        ed1 = (EditText) findViewById(R.id.input_name);
        ed2 = (EditText) findViewById(R.id.input_email);
        ed3 = (EditText) findViewById(R.id.input_des);

        t1 = (TextView) findViewById(R.id.few);
        t2 = (TextView) findViewById(R.id.detail);
        t3 = (TextView) findViewById(R.id.text2);
        rdg = (RadioGroup) findViewById(R.id.rdg);


        t4 = (TextView) findViewById(R.id.texttype);
        t5 = (TextView) findViewById(R.id.department);
        t6 = (TextView) findViewById(R.id.subDepartment);
        t7 = (TextView) findViewById(R.id.nametext);
        t7 = (TextView) findViewById(R.id.emailtext);
        t8 = (TextView) findViewById(R.id.desctext);




        typeface = Typeface.createFromAsset(getAssets(),"fonts/VarelaRound.ttf");


        ed1.setTypeface(typeface);
        ed2.setTypeface(typeface);
        ed3.setTypeface(typeface);

        //t1.setTypeface(typeface);
        //t2.setTypeface(typeface);
        t3.setTypeface(typeface);
        t4.setTypeface(typeface);
        t5.setTypeface(typeface);
        t6.setTypeface(typeface);
        t7.setTypeface(typeface);
        t8.setTypeface(typeface);

        btn.setTypeface(typeface);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {


        strname = ed1.getText().toString();

        stremail = ed2.getText().toString();

        strdes = ed3.getText().toString();

        if(strname.isEmpty())
        {
            ed1.setError("Field cannot be Empty");
        }

        if(stremail.isEmpty() )
        {
            ed2.setError("Invalid Email");
        }

        if (strdes.isEmpty())
        {
            ed3.setError("Field cannot be Empty");
        }









       // if (  strname.isEmpty() && stremail.isEmpty() && strdes.isEmpty()) {
            //Toast.makeText(getApplicationContext(),"Fill details",Toast.LENGTH_SHORT).show();
        //}
        else if(rd1.isChecked()|| rd2.isChecked() || rd3.isChecked() || rd4.isChecked() || rd5.isChecked() )
        {

            //Toast.makeText(getApplicationContext(),"Please Select Enquiry Type",Toast.LENGTH_SHORT).show();
           // Toast.makeText(getApplicationContext(), "Query Forwarded Successfully", Toast.LENGTH_LONG).show();

            if (!Patterns.EMAIL_ADDRESS.matcher(stremail).matches()) {
                ed2.setError("Invalid Email");
            }

            else
            {

            strname = ed1.getText().toString();

            stremail = ed2.getText().toString();

            strdes = ed3.getText().toString();


            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");


            session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication("rms.certination@gmail.com", "certination@123");
                }
            });

            pDialog = ProgressDialog.show(context, "", "Sending Query....", true);


            RetrieveFeedTask task = new RetrieveFeedTask();
            task.execute();
        }

    }}

    public boolean isValidEmail(String stremail)
    {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(stremail);
        return matcher.matches();
    }



    public void onCheckedChanged(CompoundButton buttonView, boolean c) {
        switch (btn.getId()) {
            case R.id.suggest:
                if (rd1.isChecked())
                {
                    rd1.setChecked(true);
                    rd2.setChecked(false);
                    rd3.setChecked(false);
                    rd4.setChecked(false);
                    rd5.setChecked(false);
                    break;
                }



            case R.id.complaint:
                if (rd2.isChecked()) {
                    rd2.setChecked(true);
                    rd1.setChecked(true);
                    rd1.setChecked(false);
                    rd3.setChecked(false);
                    rd4.setChecked(false);
                    rd5.setChecked(false);
                    break;
                }




            case R.id.request:
                if (rd3.isChecked()) {
                    rd3.setChecked(true);
                    rd1.setChecked(false);
                    rd2.setChecked(false);
                    rd4.setChecked(false);
                    rd5.setChecked(false);
                    break;
                }



            case R.id.enquiry:
                if (rd4.isChecked()) {
                    rd4.setChecked(true);
                    rd1.setChecked(false);
                    rd2.setChecked(false);
                    rd3.setChecked(false);
                    rd5.setChecked(false);
                    break;
                }



            case R.id.compliment:
                if (rd5.isChecked()) {
                    rd5.setChecked(true);
                    rd1.setChecked(false);
                    rd2.setChecked(false);
                    rd3.setChecked(false);
                    rd4.setChecked(false);
                    break;
                }




            default:
                break;
        }



    }


    public class RetrieveFeedTask extends AsyncTask<String,Void,String>
    {


        @Override
        protected String doInBackground(String... params) {

            try {
                //Creating MimeMessage object
                MimeMessage mm = new MimeMessage(session);

                //Setting sender address
                mm.setFrom(new InternetAddress(stremail));
                //Adding receiver
                mm.addRecipient(javax.mail.Message.RecipientType.TO,
                        new InternetAddress("rms.certination@gmail.com"));

                //Adding subject
                mm.setSubject("User Comments");
                //Adding message
                mm.setText("From : " + stremail + "\n \n" + strdes );

                //mm.setContent(textMessage, "text/html; charset");

                //Sending email
                Transport.send(mm);

            } catch (Exception e) {
            }
            return null;

        }

        protected void onPostExecute(String result) {
            pDialog.dismiss();
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
           // Toast.makeText(getApplicationContext(), "Query Forwarded Successfully", Toast.LENGTH_LONG).show();

        }

    }
}