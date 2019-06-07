package edu.calpoly.lunarpower;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;

import static com.amazonaws.mobile.client.UserState.SIGNED_IN;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AWSMobileClient.getInstance().initialize(SplashActivity.this, new Callback<UserStateDetails>() {
            private static final String LOG_TAG = "Splash Activity";

            @Override
            public void onResult(UserStateDetails result) {
                if (result.getUserState() == SIGNED_IN) {
                    Log.d(LOG_TAG, "Signed in");
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("frag","HomeFragment");
                    startActivity(intent);
                } else {
                    Log.d(LOG_TAG, "Need to sign in");
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }
            }

            @Override
            public void onError(Exception e) {
                Log.d(LOG_TAG, "Error signing in: " + e.getMessage());
            }
        });

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}