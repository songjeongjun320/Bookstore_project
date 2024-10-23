package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SignupController extends Application {

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

        // Username, Password, Legal Last Name, Legal First Name, ASURITE, Phone Fields
        TextField usernameField = new TextField();
        usernameField.setPromptText("USERNAME");
        usernameField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("PASSWORD");
        passwordField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("LEGAL LAST NAME");
        lastNameField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");
        
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("LEGAL FIRST NAME");
        firstNameField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");
        
        TextField asuriteField = new TextField();
        asuriteField.setPromptText("ASURITE");
        asuriteField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");
        
        TextField phoneField = new TextField();
        phoneField.setPromptText("PHONE");
        phoneField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");

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

        // Sign Up Button
        Button signupButton = new Button("SIGN UP");
        signupButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold;");
        signupButton.setMaxWidth(Double.MAX_VALUE);  // 최대 너비 설정
        signupButton.setOnAction(f ->
        {
        	List<TextInputControl> fields = Arrays.asList(usernameField, passwordField, lastNameField, firstNameField, asuriteField, phoneField);
        	if(!fields.stream().anyMatch(e -> e.getText().isBlank()) && roleGroup.getSelectedToggle() != null)
        	{
	        	try
	        	{
	        		Connection conn = DriverManager.getConnection(Main.dbURL, Main.user, Main.pass);
	        		Statement stmt = conn.createStatement();
	        		stmt.executeUpdate("INSERT INTO users (username, password, last_name, first_name, asurite, phone, user_type)\n"
	        				+ "VALUES ('" + usernameField.getText() + "', '" + passwordField.getText() + "', '" + 
	        				lastNameField.getText() + "', '" + firstNameField.getText() + "', " + Integer.parseInt(asuriteField.getText()) + ", " 
	        				+ Integer.parseInt(phoneField.getText()) + ", '" + (roleGroup.getSelectedToggle() == sellerOption ? "seller" : "buyer") + "');");
		        	openSigninPage(primaryStage);
	        	}
	        	catch(SQLException e)
	        	{
	        		e.printStackTrace();
	        	}
        	}
        });  // Sign up 후 로그인 페이지로 이동

        // Inner layout (Signup Form)
        VBox layout = new VBox(20, titleLabel, subtitleLabel, cartIcon, usernameField, passwordField, lastNameField, firstNameField, asuriteField, phoneField, roleBox, signupButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #8b0000;");
        layout.setMaxWidth(450);  // 최대 너비 설정
        layout.setFillWidth(true);  // 내부 요소가 레이아웃에 맞게 확장됨

        // Outer layout to center the inner layout
        StackPane outerLayout = new StackPane(layout);
        outerLayout.setStyle("-fx-background-color: #8b0000;");
        outerLayout.setPadding(new Insets(50)); // Padding for centering

        Scene scene = new Scene(outerLayout, 600, 800);  // Revise Scene size
        primaryStage.setScene(scene);
        primaryStage.setTitle("Devil's Reads - Sign Up");

        primaryStage.setMaximized(true);  // Full-screen
        primaryStage.show();
    }

    // Open the Signin page after successful signup
    private void openSigninPage(Stage primaryStage) {
        // 회원가입 후 로그인 페이지로 전환
        SigninController signinController = new SigninController();
        signinController.start(primaryStage); // SigninController로 페이지 이동
    }

    public static void main(String[] args) {
        launch(args);
    }
}