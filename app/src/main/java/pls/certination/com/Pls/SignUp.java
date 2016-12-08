package pls.certination.com.Pls;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;

import pls.certination.com.certination.R;

public class SignUp extends AppCompatActivity {

    EditText edit_name,edit_email,edit_password,edit_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_password = (EditText) findViewById(R.id.edit_password);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_phone = (EditText) findViewById(R.id.edit_phone);

        Backendless.initApp( this, BackendSettings.APPLICATION_ID, BackendSettings.ANDROID_SECRET_KEY, BackendSettings.VERSION );

    }


    public void registerUser( String name, String email, String password,
                              AsyncCallback<BackendlessUser> registrationCallback )
    {
        BackendlessUser user = new BackendlessUser();
        user.setEmail( email );
        user.setPassword( password );
        user.setProperty( "name", name );


        //Backendless handles password hashing by itself, so we don't need to send hash instead of plain text
        Backendless.UserService.register( user, registrationCallback );





    }







    public LoadingCallback<BackendlessUser> createRegistrationCallback()
    {
        return new LoadingCallback<BackendlessUser>( this, getString( R.string.loading_register ) )
        {
            @Override
            public void handleResponse( BackendlessUser registeredUser )
            {
                super.handleResponse( registeredUser );
                Toast.makeText( SignUp.this, String.format( getString( R.string.info_registered ), registeredUser.getObjectId() ), Toast.LENGTH_LONG ).show();
            }
        };
    }

    public void registerNow(View view) {

        CharSequence name = edit_name.getText();
        CharSequence email = edit_email.getText();
        CharSequence password = edit_password.getText();
        CharSequence phone = edit_phone.getText();


        LoadingCallback<BackendlessUser> registrationCallback = createRegistrationCallback();

        registrationCallback.showLoading();
        registerUser(name.toString(), email.toString(), password.toString(), registrationCallback);
    }
}
