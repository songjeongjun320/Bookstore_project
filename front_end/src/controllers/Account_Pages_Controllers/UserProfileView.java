package controllers.Account_Pages_Controllers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserProfileView {

    private final User user; // Store user
    private final Stage primaryStage; 

    public UserProfileView(Stage primaryStage, User user) {
        this.primaryStage = primaryStage;
        this.user = user;
    }

    public void show() {
        // Layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #5e0505;");

        // Title text
        Text title = new Text("Your Account");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Arial", 30));

        // Profile circle as a placeholder
        Circle profileCircle = new Circle(75);
        profileCircle.setFill(Color.LIGHTPINK);
        profileCircle.setStroke(Color.WHITE);
        profileCircle.setStrokeWidth(3);

        // Username and full name labels
        Label usernameLabel = new Label("@tuhina.aa");
        usernameLabel.setTextFill(Color.WHITE);
        usernameLabel.setFont(Font.font("Arial", 20));

        Label fullNameLabel = new Label("Tuhina Singh");
        fullNameLabel.setTextFill(Color.WHITE);
        fullNameLabel.setFont(Font.font("Arial", 16));

        // Edit Info button
        Button editInfoButton = new Button("EDIT INFO");
        editInfoButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        editInfoButton.setOnAction(e -> {
            EditInfoView editInfoView = new EditInfoView(primaryStage, user, this);
            editInfoView.show();
        });

        // Add components to the layout
        root.getChildren().addAll(title, profileCircle, usernameLabel, fullNameLabel, editInfoButton);

        // Create and set the Scene
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setTitle("User Profile");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}