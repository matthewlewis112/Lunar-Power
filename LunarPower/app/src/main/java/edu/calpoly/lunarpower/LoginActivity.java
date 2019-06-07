package edu.calpoly.lunarpower;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.calpoly.lunarpower.aws.AWSLoginHandler;
import edu.calpoly.lunarpower.aws.AWSLoginModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, AWSLoginHandler {

    AWSLoginModel awsLoginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // instantiating AWSLoginModel(context, callback)
        awsLoginModel = new AWSLoginModel(this, this);

        findViewById(R.id.loginButton).setOnClickListener(this);
        findViewById(R.id.signUpButton).setOnClickListener(this);

    }

    @Override
    public void onSignInSuccess() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("frag","HomeFragment");
        LoginActivity.this.startActivity(intent);
    }

    @Override
    public void onFailure(int process, Exception exception) {
        Log.d("Login Activity", exception.getMessage());
        String whatProcess = "";
        switch (process) {
            case AWSLoginModel.PROCESS_SIGN_IN:
                whatProcess = "Sign In:";
                break;
            default:
                break;
        }
        Toast.makeText(LoginActivity.this, whatProcess + exception.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if( view.getId() == R.id.loginButton){
            loginAction();
        }
        else if( view.getId() ==  R.id.signUpButton) {
            signUpAction();
        }
    }

    private void loginAction() {
        EditText userOrEmail = findViewById(R.id.loginUserOrEmail);
        EditText password = findViewById(R.id.loginPassword);

        // do sign in and handles on interface
        awsLoginModel.signInUser(userOrEmail.getText().toString(), password.getText().toString());
    }

    private void signUpAction() {
        // go to sign up
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}
