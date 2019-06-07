package edu.calpoly.lunarpower.aws;

import android.content.Context;
import android.util.Log;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.regions.Regions;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseAWSModel {

    // constants
    protected static final String ATTR_EMAIL = "email";
    protected static final String SHARED_PREFERENCE = "SavedValues";
    protected static final String PREFERENCE_USER_NAME = "awsUserName";
    protected static final String PREFERENCE_USER_EMAIL = "awsUserEmail";
    public static final int PROCESS_SIGN_IN = 1;
    public static final int PROCESS_REGISTER = 2;
    public static final int PROCESS_CONFIRM_REGISTRATION = 3;

    // control variables
    protected Context mContext;
    protected CognitoUserPool mCognitoUserPool;
    protected CognitoUser mCognitoUser;

    protected void init(Context context) {
        mContext = context;
        IdentityManager identityManager = IdentityManager.getDefaultIdentityManager();
        try{
            JSONObject myJSON = identityManager.getConfiguration().optJsonObject("CognitoUserPool");
            final String COGNITO_POOL_ID = myJSON.getString("PoolId");
            final String COGNITO_CLIENT_ID = myJSON.getString("AppClientId");
            final String COGNITO_CLIENT_SECRET = myJSON.getString("AppClientSecret");
            final String REGION = myJSON.getString("Region");
            mCognitoUserPool = new CognitoUserPool(context, COGNITO_POOL_ID, COGNITO_CLIENT_ID, COGNITO_CLIENT_SECRET, Regions.fromName(REGION));
        } catch (JSONException e) {
            Log.e("LunarPower","",e);
        }
    }
}
