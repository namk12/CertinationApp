package pls.certination.com.Pls.Query_managment;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import pls.certination.com.certination.R;


public class SingleQuestion extends AppCompatActivity {

    private TextView txtques, txtanswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_question);

        txtques = (TextView) findViewById(R.id.txtques);
        txtanswer = (TextView) findViewById(R.id.txtans);


        Bundle extra = getIntent().getExtras();
        if(extra!=null) {




            txtques.setText(extra.getString("QUESTION"));
            txtanswer.setText(extra.getString("ANSWER"));

        }


    }


}
