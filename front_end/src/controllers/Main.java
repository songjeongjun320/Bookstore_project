package controllers;

import java.util.Locale.Category;

import controllers.Account_Pages_Controllers.*;
import controllers.Book_Detail_Pages_Controllers.*;
import controllers.Main_Pages_Controllers.*;
import controllers.Purchase_Pages_Controllers.*;
import controllers.Purchase_Pages_Controllers.*;
import controllers.Signin_Signup_Pages_Controllers.*;


import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static Main instance; // Singleton instance for page management

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this; // Store the instance for access from other controllers
        showBuyingPage(primaryStage); 
    }

    public static Main getInstance() {
        return instance; // Provide global access to this instance
    }
    
    // Main_Pages Controllers /////////////////////////////////////////////////////////////////////////////////
    // Method to display Main page
    public void showMainPage(Stage primaryStage){
        SearchBookController searchBookController = new SearchBookController();
        searchBookController.start(primaryStage);
    }

    // Signin_Signup_Pages Controllers /////////////////////////////////////////////////////////////////////////
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
    // Method to display Recovery page
    public void showRecoveryPage(Stage primaryStage) {
        RecoveryController recoveryController = new RecoveryController();
        recoveryController.start(primaryStage);  // Display the Recovery page
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


    // Purchase_Pages Controllers ////////////////////////////////////////////////////////////////////////////
    // Method to display Buying page
    public void showBuyingPage(Stage primaryStage) {
        BuyingController buyingController = new BuyingController();
        buyingController.start(primaryStage);  // Display the buying page
    }

    public void showInformationPage(Stage primaryStage) {
        System.out.println("Primary Stage in showInformationPage: " + primaryStage);
        InformationController informationController = new InformationController();
        informationController.start(primaryStage);
    }

    public void showOrderConfirmationPage(Stage primaryStage){
        OrderConfirmController orderConfirmController = new OrderConfirmController();
        orderConfirmController.start(primaryStage);
    }

    public void showOverviewPage(Stage primaryStage){
        OverviewController overviewController = new OverviewController();
        overviewController.start(primaryStage);
    }
    
    public static void main(String[] args) {
        launch(args);  // Start the JavaFX application
    }
}
