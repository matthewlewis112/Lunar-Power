package edu.calpoly.lunarpower;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;

public class AuthenticatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String errorTag = "AuthenticatorActivity";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
            @Override
            public void onResult(UserStateDetails result) {
                switch (result.getUserState()) {
                    case SIGNED_IN:
                        Log.d(errorTag, "User Signed In");
                        break;
                    case SIGNED_OUT:
                        Log.d(errorTag, "User Signed Out");
                        break;
                    default:
                        AWSMobileClient.getInstance().signOut();
                }
            }

            @Override
            public void onError(Exception e) {
                Log.d(errorTag, "Error: " + e.getMessage());
            }
        });
    }
}