package controllers.Account_Controllers;

import controllers.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmailverificationController extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title label
        Label titleLabel = new Label("Welcome SunDevil!");
        titleLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: white;");

        // Subtitle label
        Label subtitleLabel = new Label("We sent the verification code");
        subtitleLabel.setStyle("-fx-font-size: 28px; -fx-text-fill: white; -fx-font-style: italic;");

        // Instruction label
        Label instructionLabel = new Label("Please check your inbox and enter the verification code below to verify your email address.");
        instructionLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

        // Create 6 text fields for the verification code input
        HBox codeBox = new HBox(10);  // Space between boxes
        codeBox.setAlignment(Pos.CENTER);
        for (int i = 0; i < 6; i++) {
            TextField codeField = new TextField();
            codeField.setPrefWidth(40);  // Width of each field
            codeField.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: white; -fx-border-width: 1px;");
            codeBox.getChildren().add(codeField);
        }

        // Verify button
        Button verifyButton = new Button("VERIFY");
        verifyButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold;");
        verifyButton.setPrefWidth(300);
        verifyButton.setOnAction(e -> {
            Main.getInstance().showNewPasswordPage(primaryStage);  // Call Main to switch back to Signin page
        });

        // Main layout (VBox for vertical alignment)
        VBox layout = new VBox(30, titleLabel, subtitleLabel, instructionLabel, codeBox, verifyButton);
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
        primaryStage.setTitle("Devil's Reads - Email Verification");

        primaryStage.setMaximized(true);  // Full-screen
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Launch the application
    }
}
