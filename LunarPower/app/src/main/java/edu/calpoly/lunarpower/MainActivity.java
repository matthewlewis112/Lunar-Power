package edu.calpoly.lunarpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.IdentityHandler;
import com.amazonaws.mobile.client.*;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.android.volley.VolleyError;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private AWSCredentialsProvider credentialsProvider;
    private AWSConfiguration configuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AWSMobileClient.getInstance().initialize(this, new AWSStartupHandler() {
            @Override
            public void onComplete(AWSStartupResult awsStartupResult) {
                Log.d("MainActivity", "AWS is running!");
                credentialsProvider = AWSMobileClient.getInstance().getCredentialsProvider();
                configuration = AWSMobileClient.getInstance().getConfiguration();
                IdentityManager.getDefaultIdentityManager().getUserID(new IdentityHandler() {
                    @Override
                    public void onIdentityId(String identityId) {
                        Log.d("MainActivity", "Identity ID =" + identityId);
                        final String cahcedIdentiyId = IdentityManager.getDefaultIdentityManager().getCachedUserID();
                    }

                    @Override
                    public void handleError(Exception exception) {
                        Log.d("MainActivity", "Error in retrieving the identity" + exception);
                    }
                });
            }
        }).execute();

        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View e) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });

    }

    private void validate(final String username, final String password) {
        NetworkService.createAndValidateInstance(this, username, password, new NetworkService.Callback<Object>() {
            @Override
            public Class<Object> getEntityType() {
                return Object.class;
            }

            @Override
            public void onSucceed(Object response) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                MainActivity.this.startActivity(intent);
            }

            @Override
            public void onFailure(VolleyError error) {
                Log.d("login", "Fail!");
                // TODO error message for user
            }
        });
    }
}