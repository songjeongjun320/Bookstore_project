package controllers.Main_Pages_Controllers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SearchBookController extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // "This is main page"
        Label messageLabel = new Label("This is main page");
        
        StackPane layout = new StackPane(messageLabel);
        
        // Scene
        Scene scene = new Scene(layout, 800, 600); // 800x600
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        primaryStage.show(); // Stage
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}