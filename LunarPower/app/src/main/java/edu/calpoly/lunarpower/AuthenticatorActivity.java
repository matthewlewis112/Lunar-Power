package edu.calpoly.lunarpower;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.SignInStateChangeListener;
import com.amazonaws.mobile.auth.ui.SignInUI;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserState;
import com.amazonaws.mobile.client.UserStateDetails;

public class AuthenticatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String errorTag = "AuthenticatorActivity";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Add a call to initialize AWSMobileClient
        AWSMobileClient.getInstance().initialize(this, new Callback<UserStateDetails>() {
            @Override
            public void onResult(UserStateDetails result) {
                if(result.getUserState() == UserState.SIGNED_IN) {
                    Log.d(errorTag, "User Signed In");
                }
                else {
                    SignInUI signIn = (SignInUI) AWSMobileClient.getInstance().getClient(AuthenticatorActivity.this, SignInUI.class);
                    signIn.login(AuthenticatorActivity.this, HomeActivity.class).execute();
                    Log.d(errorTag, "User is Signed Out");
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
        SignInUI signIn = (SignInUI) AWSMobileClient.getInstance().getClient(AuthenticatorActivity.this, SignInUI.class);
        signIn.login(AuthenticatorActivity.this, HomeActivity.class).execute();
    }
}