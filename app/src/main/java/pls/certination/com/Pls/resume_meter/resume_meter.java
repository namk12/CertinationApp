package pls.certination.com.Pls.resume_meter;

/**
 * Created by Kulwinder Singh on 8/19/2016.
 */


        import android.content.Intent;
        import android.graphics.Typeface;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;


        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.RelativeLayout;
        import android.widget.TextView;


        import pls.certination.com.certination.R;

public class resume_meter extends AppCompatActivity {
    TextView t1, t2, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25;
    RadioButton r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20,
            r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40;


RelativeLayout rl1;
    Typeface typeface;
    EditText ed1;

    int count = 0;
    int percentage = 0;
    String edName;

    RadioGroup rd1,rd2,rd3,rd4,rd5,rd6,rd7,rd8,rd9,rd10,rd11,rd12,rd13,rd14,rd15,rd16,rd17,rd18,rd19,rd20;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resume_progress);
rl1=(RelativeLayout)findViewById(R.id.relative_resume);
        t1 = (TextView) findViewById(R.id.txt1);
        t2 = (TextView) findViewById(R.id.txt2);
        t7 = (TextView) findViewById(R.id.txt7);
        t8 = (TextView) findViewById(R.id.txt8);
        t9 = (TextView) findViewById(R.id.txt9);
        t10 = (TextView) findViewById(R.id.txt10);
        t11 = (TextView) findViewById(R.id.txt11);
        t12 = (TextView) findViewById(R.id.txt12);
        t13 = (TextView) findViewById(R.id.txt13);
        t14 = (TextView) findViewById(R.id.txt14);
        t15 = (TextView) findViewById(R.id.txt15);
        t16 = (TextView) findViewById(R.id.txt16);
        t17 = (TextView) findViewById(R.id.txt17);
        t18 = (TextView) findViewById(R.id.txt18);
        t19 = (TextView) findViewById(R.id.txt19);
        t20 = (TextView) findViewById(R.id.txt20);
        t21 = (TextView) findViewById(R.id.txt21);
        t22 = (TextView) findViewById(R.id.txt22);
        t23 = (TextView) findViewById(R.id.txt23);
        t24 = (TextView) findViewById(R.id.txt24);
        t25 = (TextView) findViewById(R.id.txt25);

        ed1 = (EditText) findViewById(R.id.ed_name);
      //  ed2 = (EditText) findViewById(R.id.ed_email);




        typeface = Typeface.createFromAsset(getAssets(), "fonts/VarelaRound.ttf");


        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t7.setTypeface(typeface);
        t8.setTypeface(typeface);
        t9.setTypeface(typeface);
        t10.setTypeface(typeface);
        t11.setTypeface(typeface);
        t12.setTypeface(typeface);
        t13.setTypeface(typeface);
        t14.setTypeface(typeface);
        t15.setTypeface(typeface);
        t16.setTypeface(typeface);
        t17.setTypeface(typeface);
        t18.setTypeface(typeface);
        t19.setTypeface(typeface);
        t20.setTypeface(typeface);
        t21.setTypeface(typeface);
        t22.setTypeface(typeface);
        t23.setTypeface(typeface);
        t24.setTypeface(typeface);
        t25.setTypeface(typeface);
        ed1.setTypeface(typeface);
        //ed2.setTypeface(typeface);

        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        r5 = (RadioButton) findViewById(R.id.r5);
        r6 = (RadioButton) findViewById(R.id.r6);
        r7 = (RadioButton) findViewById(R.id.r7);
        r8 = (RadioButton) findViewById(R.id.r8);
        r9 = (RadioButton) findViewById(R.id.r9);
        r10 = (RadioButton) findViewById(R.id.r10);
        r11 = (RadioButton) findViewById(R.id.r11);
        r12 = (RadioButton) findViewById(R.id.r12);
        r13 = (RadioButton) findViewById(R.id.r13);
        r14 = (RadioButton) findViewById(R.id.r14);
        r15 = (RadioButton) findViewById(R.id.r15);
        r16 = (RadioButton) findViewById(R.id.r16);
        r17 = (RadioButton) findViewById(R.id.r17);
        r18 = (RadioButton) findViewById(R.id.r18);
        r19 = (RadioButton) findViewById(R.id.r19);
        r20 = (RadioButton) findViewById(R.id.r20);
        r21 = (RadioButton) findViewById(R.id.r21);
        r22 = (RadioButton) findViewById(R.id.r22);
        r23 = (RadioButton) findViewById(R.id.r23);
        r24 = (RadioButton) findViewById(R.id.r24);
        r25 = (RadioButton) findViewById(R.id.r25);
        r26 = (RadioButton) findViewById(R.id.r26);
        r27 = (RadioButton) findViewById(R.id.r27);
        r28 = (RadioButton) findViewById(R.id.r28);
        r29 = (RadioButton) findViewById(R.id.r29);
        r30 = (RadioButton) findViewById(R.id.r30);
        r31 = (RadioButton) findViewById(R.id.r31);
        r32 = (RadioButton) findViewById(R.id.r32);
        r33 = (RadioButton) findViewById(R.id.r33);
        r34 = (RadioButton) findViewById(R.id.r34);
        r35 = (RadioButton) findViewById(R.id.r35);
        r36 = (RadioButton) findViewById(R.id.r36);
        r37 = (RadioButton) findViewById(R.id.r37);
        r38 = (RadioButton) findViewById(R.id.r38);
        r39 = (RadioButton) findViewById(R.id.r39);
        r40 = (RadioButton) findViewById(R.id.r40);


        rd1 = (RadioGroup) findViewById(R.id.rd1);
        rd2 = (RadioGroup) findViewById(R.id.rd2);
        rd3 = (RadioGroup) findViewById(R.id.rd3);
        rd4 = (RadioGroup) findViewById(R.id.rd4);
        rd5 = (RadioGroup) findViewById(R.id.rd5);
        rd6 = (RadioGroup) findViewById(R.id.rd6);
        rd7 = (RadioGroup) findViewById(R.id.rd7);
        rd8 = (RadioGroup) findViewById(R.id.rd8);
        rd9 = (RadioGroup) findViewById(R.id.rd9);
        rd10 = (RadioGroup) findViewById(R.id.rd10);
        rd11 = (RadioGroup) findViewById(R.id.rd11);
        rd12 = (RadioGroup) findViewById(R.id.rd12);
        rd13 = (RadioGroup) findViewById(R.id.rd13);
        rd14 = (RadioGroup) findViewById(R.id.rd14);
        rd15 = (RadioGroup) findViewById(R.id.rd15);
        rd16 = (RadioGroup) findViewById(R.id.rd16);
        rd17 = (RadioGroup) findViewById(R.id.rd17);
        rd18 = (RadioGroup) findViewById(R.id.rd18);
        rd19 = (RadioGroup) findViewById(R.id.rd19);
        rd20 = (RadioGroup) findViewById(R.id.rd20);


        submitButton =  (Button) findViewById(R.id.btn);











        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edName = ed1.getText().toString();

                if (edName.isEmpty()) {
                    ed1.setError("Field cannot be Empty");
                } else {

                    int CheckedRadioButtonId = rd1.getCheckedRadioButtonId();

                    switch (CheckedRadioButtonId) {
                        case R.id.r1:
                            if (r1.isChecked()) {

                                count += 20;


                            }
                            break;

                        case R.id.r2:
                            if (r2.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId2 = rd2.getCheckedRadioButtonId();

                    switch (CheckedRadioButtonId2) {
                        case R.id.r3:
                            if (r3.isChecked()) {

                                count += 20;

                            }
                            break;

                        case R.id.r4:
                            if (r4.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId3 = rd3.getCheckedRadioButtonId();

                    switch (CheckedRadioButtonId3) {
                        case R.id.r5:
                            if (r5.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r6:
                            if (r4.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId4 = rd4.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId4) {
                        case R.id.r7:
                            if (r7.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r8:
                            if (r8.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId5 = rd5.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId5) {
                        case R.id.r9:
                            if (r9.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r10:
                            if (r10.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId6 = rd6.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId6) {
                        case R.id.r11:
                            if (r11.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r12:
                            if (r12.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId7 = rd7.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId7) {
                        case R.id.r13:
                            if (r13.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r14:
                            if (r14.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId8 = rd8.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId8) {
                        case R.id.r15:
                            if (r15.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r16:
                            if (r16.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId9 = rd9.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId9) {
                        case R.id.r17:
                            if (r17.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r18:
                            if (r18.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId10 = rd10.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId10) {
                        case R.id.r19:
                            if (r19.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r20:
                            if (r20.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId11 = rd11.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId11) {
                        case R.id.r21:
                            if (r21.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r22:
                            if (r22.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId12 = rd12.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId12) {
                        case R.id.r23:
                            if (r23.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r24:
                            if (r24.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId13 = rd13.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId13) {
                        case R.id.r25:
                            if (r25.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r26:
                            if (r26.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId14 = rd14.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId14) {
                        case R.id.r27:
                            if (r27.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r28:
                            if (r28.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId15 = rd15.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId15) {
                        case R.id.r29:
                            if (r29.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r30:
                            if (r30.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId16 = rd16.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId16) {
                        case R.id.r31:
                            if (r31.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r32:
                            if (r32.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId17 = rd17.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId17) {
                        case R.id.r33:
                            if (r33.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r34:
                            if (r34.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId18 = rd18.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId18) {
                        case R.id.r35:
                            if (r35.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r36:
                            if (r36.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId19 = rd19.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId19) {
                        case R.id.r37:
                            if (r37.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r38:
                            if (r38.isChecked()) {

                            }
                            break;
                    }

                    int CheckedRadioButtonId20 = rd20.getCheckedRadioButtonId();
                    switch (CheckedRadioButtonId20) {
                        case R.id.r39:
                            if (r39.isChecked()) {
                                count += 20;

                            }
                            break;

                        case R.id.r40:
                            if (r40.isChecked()) {

                            }
                            break;
                    }


                    percentage = count / 4;

                    Intent i = new Intent(resume_meter.this, ProgressActivity.class);
                    i.putExtra("per", percentage);
                    i.putExtra("name", edName);
                    startActivity(i);
                }
 //               rl1.removeAllViews();
                rd1.clearCheck();
                rd2.clearCheck();
                rd3.clearCheck();
                rd4.clearCheck();
                rd5.clearCheck();
                rd6.clearCheck();
                rd7.clearCheck();
                rd8.clearCheck();
                rd9.clearCheck();
                rd10.clearCheck();
                rd11.clearCheck();
                rd12.clearCheck();
                rd13.clearCheck();
                rd14.clearCheck();
                rd15.clearCheck();
                rd16.clearCheck();
                rd17.clearCheck();
                rd18.clearCheck();
                rd19.clearCheck();
                rd20.clearCheck();
                ed1.setText("");
                count=0;
            }


        });
    }
}