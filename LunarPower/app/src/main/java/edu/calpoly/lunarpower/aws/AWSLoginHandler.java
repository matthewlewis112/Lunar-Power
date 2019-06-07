package edu.calpoly.lunarpower.aws;
/**
 * Callback used for model {@link AWSLoginModel}. This needs to be implemented when the constructor
 * of {@link AWSLoginModel} is called.
 */
public interface AWSLoginHandler {

    /**
     * Successful completion of the sign in process.
     */
    void onSignInSuccess();

    /**
     * Failure of the process called.
     *
     * @param process       what process was called.
     * @param exception     failure details.
     */
    void onFailure(int process,Exception exception);

}