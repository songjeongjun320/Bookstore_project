package controllers.Signin_Signup_Pages_Controllers;

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

public class RecoveryController extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label titleLabel = new Label("Welcome SunDevil!");
        titleLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label subtitleLabel = new Label("Account Recovery");
        subtitleLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: white;");

        // Instruction Label
        Label instructionLabel = new Label("Please put your email when you sign up for verification");
        instructionLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");

        // Email Field
        TextField emailField = new TextField();
        emailField.setPromptText("EMAIL");
        emailField.setPrefWidth(300);
        emailField.setStyle("-fx-background-color: #5e0505; -fx-prompt-text-fill: #ffffff; -fx-text-fill: #ffffff; -fx-border-color: white; -fx-border-width: 1px;");

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

        // Next Button
        Button nextButton = new Button("NEXT");
        nextButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold;");
        nextButton.setPrefWidth(300);
        nextButton.setOnAction(e -> {
            Main.getInstance().showEmailverificationPage(primaryStage);  // Call Main to switch back to email verification page
        });

        // Layout for the form
        VBox layout = new VBox(20, titleLabel, subtitleLabel, instructionLabel, emailField, roleBox, nextButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #8b0000;");
        layout.setMaxWidth(450);
        layout.setMaxHeight(650);

        // Outer layout to center the inner layout
        StackPane outerLayout = new StackPane(layout);
        outerLayout.setStyle("-fx-background-color: #8b0000;");
        outerLayout.setPadding(new Insets(50));

        Scene scene = new Scene(outerLayout, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Devil's Reads - Account Recovery");
        primaryStage.setMaximized(true);  // Full-screen
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
