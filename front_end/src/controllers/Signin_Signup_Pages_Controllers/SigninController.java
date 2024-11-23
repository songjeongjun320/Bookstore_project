package controllers.Signin_Signup_Pages_Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import controllers.Main;
import controllers.Main_Pages_Controllers.MainPageLayout;
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
    private VBox layout;

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

        // Sign Up and Forgot Password Links
        Hyperlink signupLink = new Hyperlink("Sign up");
        signupLink.setStyle("-fx-text-fill: white;");
        signupLink.setOnAction(e -> {
            Main.getInstance().showSignupPage(primaryStage);  // Call Main to switch to Signup page
        });

        Hyperlink forgotPasswordLink = new Hyperlink("Forgot password?");
        forgotPasswordLink.setStyle("-fx-text-fill: white;");
        forgotPasswordLink.setOnAction(e -> {
            Main.getInstance().showRecoveryPage(primaryStage);  // Call Main to switch to Recovery page
        });

        HBox linksBox = new HBox(30, signupLink, forgotPasswordLink);
        linksBox.setAlignment(Pos.CENTER);
        Button loginButton = new Button("SIGN IN - FIND YOUR BOOK");

        // Inner layout (Login Form)
        layout = new VBox(30, titleLabel, subtitleLabel, cartIcon, usernameField, passwordField, roleBox, loginButton, linksBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #8b0000;");
        layout.setMaxWidth(450);
        layout.setMaxHeight(650);

        // Login Button
        loginButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold;");
        loginButton.setPrefWidth(300);
        loginButton.setOnAction(e -> {
            String email = usernameField.getText();
            String password = passwordField.getText();
            Toggle selectedToggle = roleGroup.getSelectedToggle();
        
            // Remove previous message
            layout.getChildren().removeIf(node -> node instanceof Label && node.getStyle().contains("red"));
        
            if (email.equals("admin") && password.equals("admin")) {
                // Open main page if credentials are correct
                Main.getInstance().showAdminPage(primaryStage);
            }

            if (selectedToggle == null) {
                Label errorLabel = new Label("Please select a role (SELLER or BUYER).");
                errorLabel.setStyle("-fx-text-fill: red;");
                layout.getChildren().add(errorLabel); 
                return;
            }
        
            String role = ((RadioButton) selectedToggle).getText(); // 선택된 역할 가져오기

            try {
                List<String> lines = Files.readAllLines(Paths.get("database.txt"));
                boolean isAuthenticated = false;

                for (String line : lines) {
                    String[] parts = line.split(", ");
                    String fileEmail = parts[3].split(": ")[1]; // Email
                    String filePassword = parts[4].split(": ")[1]; // Password
                    String fileRole = parts[6].split(": ")[1]; // Role

                    if (fileEmail.equals(email) && filePassword.equals(password) && fileRole.equals(role)) {
                        isAuthenticated = true;
                        break;
                    }
                }

                if (isAuthenticated) {
                    Main.getInstance().showMainPage(primaryStage); // If verifying the id pass to main.
                } else {
                    Label errorLabel = new Label("Check the email or password");
                    errorLabel.setStyle("-fx-text-fill: red;");
                    layout.getChildren().add(errorLabel); // Make an error
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


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

    public static void main(String[] args) {
        launch(args);
    }
}
