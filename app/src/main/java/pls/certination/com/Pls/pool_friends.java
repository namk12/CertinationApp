package pls.certination.com.Pls;

/**
 * Created by Kulwinder Singh on 8/9/2016.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import pls.certination.com.certination.R;


public class pool_friends extends AppCompatActivity {

    int counter = 1, totalPerson, totalAmount;
    float calculate;
    TextView txtCounter, txtResult, txtAmount;
    EditText etTotal;
    ImageButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pool_friend);

        fab = (ImageButton) findViewById(R.id.fab_pool);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick (View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                String text = "You guys need to pay me  " + txtResult.getText().toString();

                intent.setPackage("com.whatsapp");

                intent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(intent);
            }

        });

        txtCounter = (TextView) findViewById(R.id.txtCounter);
        txtResult = (TextView) findViewById(R.id.txtResult);
        txtAmount = (TextView) findViewById(R.id.txtAmount);

    }

    public void bMale(View view){

        txtCounter.setText(Integer.toString(counter++));
        totalPerson = Integer.parseInt(txtCounter.getText().toString());


    }
    public void bFemale(View view){

        txtCounter.setText( Integer.toString(counter++));
        totalPerson = Integer.parseInt(txtCounter.getText().toString());

    }

    public void bDivide(View view){

        try{
            calculate = Float.parseFloat(Integer.toString(totalAmount / totalPerson));
            txtResult.setText(Float.toString(calculate));
        }

        catch (ArithmeticException DivideByZero){
            Toast.makeText(pool_friends.this,"Please enter the number of persons",Toast.LENGTH_LONG).show();

        }
    }

    public void bMain(View view){

        LayoutInflater inflater = getLayoutInflater();
        final View v = inflater.inflate(R.layout.total_amount, null);

        etTotal = (EditText) v.findViewById(R.id.etTotal);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Amount");
        dialog.setView(v);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                txtAmount.setText(etTotal.getText().toString());
                totalAmount = Integer.parseInt(txtAmount.getText().toString());


            }
        });
        dialog.show();

    }

    @Override


    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0, 0, "Msg").setIcon(R.drawable.msg)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;

    }


}


