package controllers;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Call the start method of SigninController to display the login page
        SigninController signinController = new SigninController();
        signinController.start(primaryStage);  // Execute the login page initially
    }

    public static void main(String[] args) {
        launch(args);  // Start the JavaFX application
    }
}
