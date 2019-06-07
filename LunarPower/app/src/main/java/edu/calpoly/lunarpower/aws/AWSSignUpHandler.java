package edu.calpoly.lunarpower.aws;
/**
 * Callback used for model {@link AWSLoginModel}. This needs to be implemented when the constructor
 * of {@link AWSLoginModel} is called.
 */
public interface AWSSignUpHandler {

    /**
     * Successful completion of the first step of the registration process.
     * This will output mustConfirmToComplete in case there's the need to confirm registration to complete this process.
     *
     * @param mustConfirmToComplete     will be {@code true} if there's the need to confirm registration,
     *                                  otherwise {@code false}.
     */
    void onRegisterSuccess(boolean mustConfirmToComplete);

    /**
     * Successful completion of the registration process.
     */
    void onRegisterConfirmed();

    /**
     * Failure of the process called.
     *
     * @param process       what process was called.
     * @param exception     failure details.
     */
    void onFailure(int process, Exception exception);

}