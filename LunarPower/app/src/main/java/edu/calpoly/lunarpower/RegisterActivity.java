package edu.calpoly.lunarpower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.calpoly.lunarpower.aws.AWSSignUpModel;
import edu.calpoly.lunarpower.aws.AWSSignUpHandler;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, AWSSignUpHandler {

    AWSSignUpModel awsSignUpModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        awsSignUpModel =  new AWSSignUpModel(this, this);

        // instantiating AWSSignUpModel(context, callback)
        findViewById(R.id.registerButton).setOnClickListener(this);
        findViewById(R.id.confirmButton).setOnClickListener(this);
    }

    @Override
    public void onRegisterSuccess(boolean mustConfirmToComplete) {
        if (mustConfirmToComplete) {
            Toast.makeText(RegisterActivity.this, "Almost done! Confirm code to complete registration", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(RegisterActivity.this, "Registered! Login Now!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRegisterConfirmed() {
        Toast.makeText(RegisterActivity.this, "Registered! Login Now!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(int process, Exception exception) {
        Log.d("Register Activity", exception.getMessage());
        String whatProcess = "";
        switch (process) {
            case AWSSignUpModel.PROCESS_REGISTER:
                whatProcess = "Registration:";
                break;
            case AWSSignUpModel.PROCESS_CONFIRM_REGISTRATION:
                whatProcess = "Registration Confirmation:";
                break;
            default:
                break;
        }
        Toast.makeText(RegisterActivity.this, whatProcess + exception.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registerButton:
                registerAction();
                break;
            case R.id.confirmButton:
                confirmAction();
                break;
            default:
                break;
        }
    }

    private void registerAction() {
        EditText userName = findViewById(R.id.registerUsername);
        EditText email = findViewById(R.id.registerEmail);
        EditText password = findViewById(R.id.registerPassword);

        // do register and handles on interface
        awsSignUpModel.registerUser(userName.getText().toString(), email.getText().toString(), password.getText().toString());
    }

    private void confirmAction() {
        EditText confirmationCode = findViewById(R.id.confirmationCode);

        // do confirmation and handles on interface
        awsSignUpModel.confirmRegistration(confirmationCode.getText().toString());
    }
}
