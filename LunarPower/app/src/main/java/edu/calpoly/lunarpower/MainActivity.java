package edu.calpoly.lunarpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.VolleyError;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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