package controllers.Account_Controllers;

import controllers.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewPasswordController extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title label
        Label titleLabel = new Label("Welcome SunDevil!");
        titleLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: white;");

        // New password input field
        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setPromptText("NEW PASSWORD");
        newPasswordField.setPrefWidth(300);
        newPasswordField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");

        // Confirm new password input field
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("CONFIRM NEW PASSWORD");
        confirmPasswordField.setPrefWidth(300);
        confirmPasswordField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");

        // Update password button
        Button updatePasswordButton = new Button("UPDATE PASSWORD");
        updatePasswordButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold;");
        updatePasswordButton.setPrefWidth(300);
        updatePasswordButton.setOnAction(e -> {
            Main.getInstance().showSigninPage(primaryStage);  // Call Main to switch back to Signin page
        });

        // Main layout (VBox for vertical alignment)
        VBox layout = new VBox(30, titleLabel, newPasswordField, confirmPasswordField, updatePasswordButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #8b0000;");  // Background color
        layout.setMaxWidth(450);
        layout.setMaxHeight(650);

        // Outer layout to center the inner layout
        StackPane outerLayout = new StackPane(layout); // Use StackPane to center
        outerLayout.setStyle("-fx-background-color: #8b0000;"); // Background color
        outerLayout.setPadding(new Insets(50)); // Padding for centering

        // Create the scene
        Scene scene = new Scene(outerLayout, 1200, 800); // Larger scene size
        primaryStage.setScene(scene);
        primaryStage.setTitle("Devil's Reads - Update Password");

        primaryStage.setMaximized(true);  // Full-screen
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Launch the application
    }
}
