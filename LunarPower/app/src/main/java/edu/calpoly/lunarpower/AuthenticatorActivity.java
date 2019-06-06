package edu.calpoly.lunarpower;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.SignInStateChangeListener;
import com.amazonaws.mobile.auth.ui.SignInUI;
import com.amazonaws.mobile.client.AWSMobileClient;

public class AuthenticatorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String errorTag = "AuthenticatorActivity";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Add a call to initialize AWSMobileClient
        AWSMobileClient.getInstance().initialize(this).execute();
        IdentityManager.getDefaultIdentityManager().addSignInStateChangeListener(new SignInStateChangeListener() {
            @Override
            public void onUserSignedOut() {
                Log.d(errorTag, "User Signed Out");
                SignInUI signin = (SignInUI) AWSMobileClient.getInstance().getClient(AuthenticatorActivity.this, SignInUI.class);
                signin.login(AuthenticatorActivity.this, HomeActivity.class).execute();
            }

            @Override
            public void onUserSignedIn() {
                Log.d(errorTag, "User Signed In");
            }
        });
        Log.d(errorTag, "User Signed Out");
        SignInUI signin = (SignInUI) AWSMobileClient.getInstance().getClient(AuthenticatorActivity.this, SignInUI.class);
        signin.login(AuthenticatorActivity.this, HomeActivity.class).execute();
    }
}