package pls.certination.com.Pls.Query_managment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import pls.certination.com.certination.R;

/**
 * Created by Raman Singh on 8/3/2016.
 */
public class Asking extends Activity{

    EditText txt ;
    QuesAns newQues = new QuesAns();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asking);
        Button btn = (Button)findViewById(R.id.btn_sbmt);

        txt = (EditText)findViewById(R.id.et_user_ques);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ques = txt.getText().toString();
                newQues.setAnswer("answer");
                newQues.setQuestion(ques);

                Backendless.Persistence.of(QuesAns.class).save(newQues, new AsyncCallback<QuesAns>() {
                    @Override
                    public void handleResponse(QuesAns quesAns) {
                        Toast.makeText(Asking.this, "Submitted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {

                        Toast.makeText(Asking.this, "Error"+backendlessFault, Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


    }
}
