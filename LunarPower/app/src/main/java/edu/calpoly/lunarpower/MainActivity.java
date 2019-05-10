package edu.calpoly.lunarpower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    private void validate(String username, String password){
        // authentication dummy
        if(username.equals("Admin")){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }
}
