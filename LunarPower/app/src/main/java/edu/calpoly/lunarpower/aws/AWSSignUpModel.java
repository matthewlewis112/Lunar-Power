package edu.calpoly.lunarpower.aws;

import android.content.Context;
import android.content.SharedPreferences;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;

/**
 * This represents a model for login operations on AWS Mobile Hub. It manages login operations
 * such as:
 * - Sign Up
 * - Confirm Sign Up
 * - Get User Name (current signed in)
 * - Get User E-mail (current signed in)
 *
 */
@SuppressWarnings("unused")
public class AWSSignUpModel extends BaseAWSModel{

    // interface handler
    private AWSSignUpHandler mCallback;




    /**
     * Constructs the model for sign up functions in AWS Mobile Hub.
     *
     * @param context         REQUIRED: Android application context.
     * @param callback        REQUIRED: Callback handler for login operations.
     *
     */
    public AWSSignUpModel(Context context, AWSSignUpHandler callback) {
        init(context);

        mCallback = callback;
    }

    /**
     * Registers new user to the AWS Cognito User Pool.
     *
     * This will trigger {@link AWSSignUpHandler} interface defined when the constructor was called.
     *
     * @param userName         REQUIRED: Username to be registered. Must be unique in the User Pool.
     * @param userEmail        REQUIRED: E-mail to be registered. Must be unique in the User Pool.
     * @param userPassword     REQUIRED: Password of this new account.
     *
     */
    public void registerUser(String userName, String userEmail, String userPassword) {
        CognitoUserAttributes userAttributes = new CognitoUserAttributes();
        userAttributes.addAttribute(ATTR_EMAIL, userEmail);

        final SignUpHandler signUpHandler = new SignUpHandler() {
            @Override
            public void onSuccess(CognitoUser user, boolean signUpConfirmationState, CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
                mCognitoUser = user;
                mCallback.onRegisterSuccess(!signUpConfirmationState);
            }

            @Override
            public void onFailure(Exception exception) {
                mCallback.onFailure(PROCESS_REGISTER, exception);
            }
        };

        mCognitoUserPool.signUpInBackground(userName, userPassword, userAttributes, null, signUpHandler);
    }

    /**
     * Confirms registration of the new user in AWS Cognito User Pool.
     *
     * This will trigger {@link AWSSignUpHandler} interface defined when the constructor was called.
     *
     * @param confirmationCode      REQUIRED: Code sent from AWS to the user.
     */
    public void confirmRegistration(String confirmationCode) {
        final GenericHandler confirmationHandler = new GenericHandler() {
            @Override
            public void onSuccess() {
                mCallback.onRegisterConfirmed();
            }

            @Override
            public void onFailure(Exception exception) {
                mCallback.onFailure(PROCESS_CONFIRM_REGISTRATION, exception);
            }
        };

        mCognitoUser.confirmSignUpInBackground(confirmationCode, false, confirmationHandler);
    }

    /**
     * Gets the user name saved in SharedPreferences.
     *
     * @param context               REQUIRED: Android application context.
     * @return                      user name saved in SharedPreferences.
     */
    public static String getSavedUserName(Context context) {
        SharedPreferences savedValues = context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE);
        return savedValues.getString(PREFERENCE_USER_NAME, "");
    }

    /**
     * Gets the user e-mail saved in SharedPreferences.
     *
     * @param context               REQUIRED: Android application context.
     * @return                      user e-mail saved in SharedPreferences.
     */
    public static String getSavedUserEmail(Context context) {
        SharedPreferences savedValues = context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE);
        return savedValues.getString(PREFERENCE_USER_EMAIL, "");
    }
}