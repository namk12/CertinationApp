package pls.certination.com.Pls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pls.certination.com.SocialCallback;
import pls.certination.com.certination.R;

public class Login extends AppCompatActivity {

    EditText name, password;
    private in.championswimmer.libsocialbuttons.fabs.FABFacebook fb;
    private in.championswimmer.libsocialbuttons.fabs.FABGoogleplus gplus;


    private static final int REGISTER_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Backendless.initApp(this, BackendSettings.APPLICATION_ID, BackendSettings.ANDROID_SECRET_KEY, BackendSettings.VERSION);

        Button loginButton = (Button) findViewById(R.id.btn);
        fb = (in.championswimmer.libsocialbuttons.fabs.FABFacebook) findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> facebookFieldsMapping = new HashMap<>();
                facebookFieldsMapping.put("name", "name");
                facebookFieldsMapping.put("gender", "gender");
                facebookFieldsMapping.put("email", "email");

                List<String> facebookPermissions = new ArrayList<>();
                facebookPermissions.add("email");

                Backendless.UserService.loginWithFacebook(Login.this, null, facebookFieldsMapping, facebookPermissions, new SocialCallback<BackendlessUser>(Login.this) {
                    @Override
                    public void handleResponse(BackendlessUser backendlessUser) {
                        Intent i = new Intent(Login.this, Pls.class);
                        startActivity(i);
                        finish();
                    }
                });
            }
        });

        gplus = (in.championswimmer.libsocialbuttons.fabs.FABGoogleplus) findViewById(R.id.gplus);

        gplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> googleFieldsMapping = new HashMap<>();
                googleFieldsMapping.put("name", "name");
                googleFieldsMapping.put("gender", "gender");
                googleFieldsMapping.put("email", "email");

                List<String> googlePermissions = new ArrayList<>();

                Backendless.UserService.loginWithGooglePlus(Login.this, null, googleFieldsMapping, googlePermissions, new SocialCallback<BackendlessUser>(Login.this) {
                    @Override
                    public void handleResponse(BackendlessUser backendlessUser) {
                        Intent i = new Intent(Login.this, Pls.class);
                        startActivity(i);
                        finish();
                    }
                });

            }
        });

        loginButton.setOnClickListener(createLoginButtonListener());


    }

    public void startRegistrationActivity(View view) {
        Intent registrationIntent = new Intent(this, SignUp.class);
        startActivity(registrationIntent);
    }

    public void loginUser(String email, String password, AsyncCallback<BackendlessUser> loginCallback) {
        Backendless.UserService.login(email, password, loginCallback);
    }

    private View.OnClickListener createLoginButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameField = (EditText) findViewById(R.id.username);
                EditText passwordField = (EditText) findViewById(R.id.password);

                CharSequence uname = nameField.getText();
                CharSequence upassword = passwordField.getText();


                LoadingCallback<BackendlessUser> loginCallback = createLoginCallback();

                loginCallback.showLoading();
                loginUser(uname.toString(), upassword.toString(), loginCallback);

            }
        };

    }


    public LoadingCallback<BackendlessUser> createLoginCallback() {
        return new LoadingCallback<BackendlessUser>(this, getString(R.string.loading_login)) {
            @Override
            public void handleResponse(BackendlessUser loggedInUser) {
                super.handleResponse(loggedInUser);
                Intent i = new Intent(Login.this, Pls.class);
                startActivity(i);
            }
        };
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REGISTER_REQUEST_CODE:

                    String email = data.getStringExtra(BackendlessUser.EMAIL_KEY);
                    EditText name = (EditText) findViewById(R.id.username);
                    name.setText(email);

                    EditText password = (EditText) findViewById(R.id.password);
                    password.requestFocus();

                    Toast.makeText(this, getString(R.string.info_registered_success), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
