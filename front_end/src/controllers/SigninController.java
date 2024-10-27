// SigninController.java (수정됨)
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SigninController extends Application {
	boolean loginSuccessful = false;
	
    @Override
    public void start(Stage primaryStage) {
    	
    	
        // Create UI components
        Label titleLabel = new Label("Welcome SunDevil!");
        titleLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label subtitleLabel = new Label("Devil's Reads");
        subtitleLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: white;");

        // Cart Icon Placeholder
        Label cartIcon = new Label("🛒");
        cartIcon.setStyle("-fx-font-size: 60px; -fx-text-fill: white;");

        // Username and Password Fields
        TextField usernameField = new TextField();
        usernameField.setPromptText("USERNAME");
        usernameField.setPrefWidth(300);
        usernameField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("PASSWORD");
        passwordField.setPrefWidth(300);
        passwordField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");

        // RadioButton for Seller and Buyer
        ToggleGroup roleGroup = new ToggleGroup();
        RadioButton sellerOption = new RadioButton("SELLER");
        sellerOption.setToggleGroup(roleGroup);
        RadioButton buyerOption = new RadioButton("BUYER");
        buyerOption.setToggleGroup(roleGroup);

        sellerOption.setStyle("-fx-text-fill: #ffffff;");
        buyerOption.setStyle("-fx-text-fill: #ffffff;");

        HBox roleBox = new HBox(20, sellerOption, buyerOption);
        roleBox.setAlignment(Pos.CENTER);

        //Login Button
        Button loginButton = new Button("SIGN IN - FIND YOUR BOOK");
        loginButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold;");
        loginButton.setPrefWidth(300);
        
        loginButton.setOnAction(f->
        {
        	//Only runs if our fields aren't empty and our buttons are selected
        	if(!usernameField.getText().isBlank() && !passwordField.getText().isBlank() && roleGroup.getSelectedToggle() != null)
        	{
	        	try
	        	{
	        		//Connects to the database
	        		Connection conn = DriverManager.getConnection(Main.dbURL, Main.user, Main.pass);
	        		Statement stmt = conn.createStatement();
	        		
	        		//SQL query
	        		ResultSet rs = stmt.executeQuery("SELECT * FROM users");
	        		
	        		//Iterate through our users table
	        		while(rs.next())
	        		{
	        			//If everything matches then login
	        			if(rs.getString("username").equals(usernameField.getText()) && rs.getString("password").equals(passwordField.getText()) && 
	        			((rs.getString("user_type").equals("buyer") && roleGroup.getSelectedToggle() == buyerOption) || (rs.getString("user_type").equals("seller") && roleGroup.getSelectedToggle() == sellerOption)))
	        			{
	        				signIn();
	        			}
	        		}
	        	}
	        	
	        	catch(SQLException e)
	        	{
	        		e.printStackTrace();
	        	}
        	}
        	
        	if(!loginSuccessful)
    		{
    			System.out.println("Sign in not successful");
    		}
        });

        // Sign Up and Forgot Password Links
        Hyperlink signupLink = new Hyperlink("Sign up");
        signupLink.setStyle("-fx-text-fill: white;");
        signupLink.setOnAction(e -> {
            openSignupPage(primaryStage);  // Open Signup page and close Login window
        });

        Hyperlink forgotPasswordLink = new Hyperlink("Forgot password?");
        forgotPasswordLink.setStyle("-fx-text-fill: white;");

        HBox linksBox = new HBox(30, signupLink, forgotPasswordLink);
        linksBox.setAlignment(Pos.CENTER);

        // Inner layout (Login Form)
        VBox layout = new VBox(30, titleLabel, subtitleLabel, cartIcon, usernameField, passwordField, roleBox, loginButton, linksBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #8b0000;");
        layout.setMaxWidth(450);
        layout.setMaxHeight(650);

        // Outer layout to center the inner layout
        StackPane outerLayout = new StackPane(layout); // Use StackPane to center
        outerLayout.setStyle("-fx-background-color: #8b0000;"); // Background color
        outerLayout.setPadding(new Insets(50)); // Padding for centering

        Scene scene = new Scene(outerLayout, 1200, 800); // Larger scene size
        primaryStage.setScene(scene);
        primaryStage.setTitle("Devil's Reads - Login");

        primaryStage.setMaximized(true);  // Full-screen

        primaryStage.show();
    }

    // Open the Signup page and close the Login page
    private void openSignupPage(Stage primaryStage) {
        // Close the Signin window
        primaryStage.close();

        // Create a new Stage (window) for the Signup page
        Stage signupStage = new Stage();
        SignupController signupController = new SignupController();
        try {
            signupController.start(signupStage);  // Call SignupController's start method to open the new window
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void signIn()
    {
    	System.out.println("Successfully signed in");
		loginSuccessful = true;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}