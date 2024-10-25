package controllers;

import controllers.Account_Controllers.EmailverificationController;
import controllers.Account_Controllers.NewPasswordController;
import controllers.Account_Controllers.RecoveryController;
import controllers.Account_Controllers.SigninController;
import controllers.Account_Controllers.SignupController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static Main instance; // Singleton instance for page management

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this; // Store the instance for access from other controllers
        showSigninPage(primaryStage);  // Start with the Signin page
    }

    public static Main getInstance() {
        return instance; // Provide global access to this instance
    }

    // Method to display Signin page
    public void showSigninPage(Stage primaryStage) {
        SigninController signinController = new SigninController();
        signinController.start(primaryStage);  // Display the Signin page
    }

    // Method to display Signup page
    public void showSignupPage(Stage primaryStage) {
        SignupController signupController = new SignupController();
        signupController.start(primaryStage);  // Display the Signup page
    }

    // Method to display Recovery page
    public void showRecoveryPage(Stage primaryStage) {
        RecoveryController recoveryController = new RecoveryController();
        recoveryController.start(primaryStage);  // Display the Recovery page
    }

    // Method to display Email verification page
    public void showEmailverificationPage(Stage primaryStage) {
        EmailverificationController emailverificationController = new EmailverificationController();
        emailverificationController.start(primaryStage);  // Display the email verification
    }

    // Method to display Email verification page
    public void showNewPasswordPage(Stage primaryStage) {
        NewPasswordController newPasswordController = new NewPasswordController();
        newPasswordController.start(primaryStage);  // Display the email verification
    }
    

    public static void main(String[] args) {
        launch(args);  // Start the JavaFX application
    }
}
