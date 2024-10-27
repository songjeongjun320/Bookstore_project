package controllers.Main_Pages_Controllers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CategoryController extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // "This is main page"
        Label messageLabel = new Label("This is gonna be category controller");
        messageLabel.setStyle("-fx-text-fill: white;"); // Text colors
        
        StackPane layout = new StackPane(messageLabel);
        layout.setStyle("-fx-background-color: #8b0000;"); // Wallpaper color
        
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
