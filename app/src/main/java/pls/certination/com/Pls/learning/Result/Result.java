package pls.certination.com.Pls.learning.Result;

/**
 * Created by Kulwinder Singh on 8/19/2016.
 */
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.backendless.Backendless;
        import com.backendless.BackendlessUser;
        import com.backendless.async.callback.AsyncCallback;
        import com.backendless.exceptions.BackendlessFault;

        import pls.certination.com.certination.R;


public class Result extends AppCompatActivity{

    EditText user;
    EditText pass;
    public ProgressDialog pDialog = null;
    Context context = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_result);

        Backendless.initApp(this, BackendSettings.APPLICATION_ID, BackendSettings.ANDROID_SECRET_KEY, BackendSettings.VERSION);

        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);

        Button b = (Button)findViewById(R.id.login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                LoadingCallback<BackendlessUser> loginCallback = createLoginCallback();

                loginCallback.showLoading();


                Backendless.UserService.login(user.getText().toString(), pass.getText().toString(), new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {

                        String users = (String)response.getProperty("user");
                        Toast.makeText(Result.this, users, Toast.LENGTH_SHORT).show();

                        if(users.equals("student")) {
                            Toast.makeText(Result.this, ""+user.getText().toString(), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Result.this, StudentAccessActivity.class);
                            i.putExtra("name",user.getText().toString());
                            startActivity(i);
                        }else if(users.equals("teacher")){
                            Intent i = new Intent(Result.this,TeacherAccessActivity.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                        Toast.makeText(Result.this, "Error - "+fault, Toast.LENGTH_SHORT).show();
                    }
                });

                // pDialog = ProgressDialog.show(context, "", "Sending Query....", true);
            }

            private LoadingCallback<BackendlessUser> createLoginCallback()
            {
                return new LoadingCallback<BackendlessUser>(Result.this, getString(R.string.loading_login)) {
                    @Override

                    public void handleResponse(BackendlessUser loggedInUser) {
                        super.handleResponse(loggedInUser);

                    }
                };
            }
        });




    }
}
