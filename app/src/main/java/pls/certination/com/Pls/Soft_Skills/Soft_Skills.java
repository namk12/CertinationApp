package pls.certination.com.Pls.Soft_Skills;

/**
 * Created by Kulwinder Singh on 8/20/2016.
 */



        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.animation.Animation;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.Serializable;

        import pls.certination.com.certination.R;

public class Soft_Skills extends AppCompatActivity {

    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_skills);
        bt1=(Button)findViewById(R.id.bt_softskill);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mark = 0;
                int qn = 1;
                int i=0;
                String v="ffffffffffffffffffff";
                Intent i1 = new Intent(getApplicationContext(),Question.class);
                i1.putExtra("mark", String.valueOf(mark));
                i1.putExtra("qn", String.valueOf(qn));
                i1.putExtra("i",String.valueOf(i));
                i1.putExtra("v",v);
                startActivity(i1);
            }
        });
    }


}
