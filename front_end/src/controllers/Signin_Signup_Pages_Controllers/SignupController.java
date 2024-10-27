package controllers.Signin_Signup_Pages_Controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import controllers.Main;
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
        
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("LEGAL LAST NAME");
        lastNameField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");
        
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("LEGAL FIRST NAME");
        firstNameField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");
        
        TextField emailField = new TextField();
        emailField.setPromptText("EMAIL");
        emailField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("PASSWORD");
        passwordField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");

        PasswordField confirm_passwordField = new PasswordField();
        confirm_passwordField.setPromptText("CONFIRM THE PASSWORD");
        confirm_passwordField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");

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
        signupButton.setMaxWidth(Double.MAX_VALUE);  // Set maximum width
        signupButton.setOnAction(e -> {
            Main.getInstance().showSigninPage(primaryStage);  // Call Main to switch back to Signin page
                String username = usernameField.getText();
                String lastName = lastNameField.getText();
                String firstName = firstNameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirm_passwordField.getText();
                String role = sellerOption.isSelected() ? "SELLER" : "BUYER";

                // Check the password avaiability
                if (!password.equals(confirmPassword)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords do not match.");
                    alert.showAndWait();
                    return;
                }

                // Store the data
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt", true))) {
                    writer.write(String.format("Username: %s, Last Name: %s, First Name: %s, Email: %s, Password: %s, Phone: %s, Role: %s%n",
                            username, lastName, firstName, email, password, phone, role));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Error saving data.");
                    alert.showAndWait();
                    return;
                }

        });

        // Inner layout (Signup Form)
        VBox layout = new VBox(20, titleLabel, subtitleLabel, cartIcon, usernameField, passwordField, confirm_passwordField, lastNameField, firstNameField, emailField, phoneField, roleBox, signupButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #8b0000;");
        layout.setMaxWidth(450);  // Set maximum width
        layout.setFillWidth(true);  // Internal elements expand to fill the layout

        // Outer layout to center the inner layout
        StackPane outerLayout = new StackPane(layout);
        outerLayout.setStyle("-fx-background-color: #8b0000;");
        outerLayout.setPadding(new Insets(50)); // Padding for centering

        Scene Signupscene = new Scene(outerLayout, 1200, 800);  // Revise Scene size
        primaryStage.setScene(Signupscene);
        primaryStage.setTitle("Devil's Reads - Sign Up");

        primaryStage.setMaximized(true);  // Full-screen
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
