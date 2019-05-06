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
    private TextView attemptsInfo;
    private Button login;
    private int counter = 5;        //users are given 5 attempts before lock out


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        //attempts = (TextView) findViewById(R.id.attempts);
        login = findViewById(R.id.login);

        attemptsInfo.setText("");   //display nothing until a failed attempt

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View e) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(String username, String password){
        // TODO authentication
        if((username.equals("Admin")) && (password.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            MainActivity.this.startActivity(intent);
        }
        else{
            counter--;

            attemptsInfo.setText("attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                login.setEnabled(false);
            }
        }
    }
}
