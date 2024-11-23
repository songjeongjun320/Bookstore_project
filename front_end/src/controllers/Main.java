package controllers;

import java.util.ArrayList;

import controllers.Account_Pages_Controllers.*;
import controllers.Book_Detail_Pages_Controllers.*;
import controllers.Main_Pages_Controllers.*;
import controllers.Purchase_Pages_Controllers.*;
import controllers.Seller_Pages_Controllers.Buyer_view.*;
import controllers.Seller_Pages_Controllers.Seller_view.*;
import controllers.Signin_Signup_Pages_Controllers.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private static Main instance; // Singleton instance for page management
    private static String testUsername = "tuhina..aa";
    private static String testFullname = "Tuhina Singh";

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this; // Store the instance for access from other controllers
        showEmailverificationPage(primaryStage); 
    }

    public static Main getInstance() {
        return instance; // Provide global access to this instance
    }

    // Account_Pages Controllers ///////////////////////////////////////////////////////////////////////////
    // Method to display Edit Info Page
    public void showEditInfoPage(Stage primaryStage, User user, UserProfileView parentView) {
        EditInfoView editInfoView = new EditInfoView(primaryStage, user, parentView);
        editInfoView.show();
    }

    // Main_Pages Controllers /////////////////////////////////////////////////////////////////////////////////
    // Method to display Main page
    public void showMainPage(Stage primaryStage) {
        MainPageLayout mainPageLayout = new MainPageLayout();
        mainPageLayout.start(primaryStage);
    }

    // Signin_Signup_Pages Controllers /////////////////////////////////////////////////////////////////////////
    // Method to display Email verification page
    public void showEmailverificationPage(Stage primaryStage) {
        EmailverificationController emailverificationController = new EmailverificationController();
        emailverificationController.start(primaryStage); // Display the email verification
    }

    public void showNewPasswordPage(Stage primaryStage) {
        NewPasswordController newPasswordController = new NewPasswordController();
        newPasswordController.start(primaryStage); // Display the email verification
    }

    public void showRecoveryPage(Stage primaryStage) {
        RecoveryController recoveryController = new RecoveryController();
        recoveryController.start(primaryStage); // Display the Recovery page
    }

    public void showSigninPage(Stage primaryStage) {
        SigninController signinController = new SigninController();
        signinController.start(primaryStage); // Display the Signin page
    }

    public void showSignupPage(Stage primaryStage) {
        SignupController signupController = new SignupController();
        signupController.start(primaryStage); // Display the Signup page
    }

    public void showBuyingPage(Stage primaryStage) {
        BuyingController buyingController = new BuyingController();
        buyingController.start(primaryStage); // Display the buying page
    }

    public void showInformationPage(Stage primaryStage) {
        System.out.println("Primary Stage in showInformationPage: " + primaryStage);
        InformationController informationController = new InformationController();
        informationController.start(primaryStage);
    }

    public void showOrderConfirmationPage(Stage primaryStage) {
        OrderConfirmController orderConfirmController = new OrderConfirmController();
        orderConfirmController.start(primaryStage);
    }

    public void showOverviewPage(Stage primaryStage) {
        OverviewController overviewController = new OverviewController();
        overviewController.start(primaryStage);
    }


    public void showUserProfilePage(Stage primaryStage, User user) {
        UserProfileView userProfileView = new UserProfileView(primaryStage, user);
        userProfileView.show();
    }
    
    public void showOtherUserAccountPage(Stage primaryStage, String username, String fullName) {
        OtherUserAccountView otherUserAccountView = new OtherUserAccountView(primaryStage, username, fullName);
        otherUserAccountView.show();
    }
    
    public void showMessagePage(Stage primaryStage, String username) {
        MessageView messageView = new MessageView(primaryStage, username);
        messageView.show();
    }
    
    public void showReportPage(Stage primaryStage, String username, String fullName) {
        ReportView reportView = new ReportView(primaryStage, username, fullName);
        reportView.show();
    }
    
    public void showReportConfirmationPage(Stage primaryStage) {
        ReportConfirmationView reportConfirmationView = new ReportConfirmationView(primaryStage);
        reportConfirmationView.show();
    }
    public void showSellerAccountView(Stage primaryStage, String username, String fullName) {
    SellerAccountView sellerAccountView = new SellerAccountView(
        primaryStage, 
        username, 
        fullName,
        0.0,  // default rating
        new ArrayList<>(),  // empty listed books
        new ArrayList<>()   // empty sold books
    );
    sellerAccountView.show();
}
    
    public void showSellerMessage(Stage primaryStage, String username) {
        SellerMessage sellerMessage = new SellerMessage(primaryStage, username);
        sellerMessage.show();
    }
    
    public void showReportSeller(Stage primaryStage, String username, String fullName) {
        ReportSeller reportSeller = new ReportSeller(primaryStage, username, fullName);
        reportSeller.show();
    }
    
    public void showReportConfirm(Stage primaryStage) {
        ReportConfirm reportConfirm = new ReportConfirm(primaryStage);
        reportConfirm.show();
    }

    public static void main(String[] args) {
        launch(args); // Start the JavaFX application
    }
}
