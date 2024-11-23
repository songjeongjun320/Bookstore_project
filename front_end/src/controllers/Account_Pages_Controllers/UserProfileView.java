package controllers.Account_Pages_Controllers;

import controllers.Main;
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

    private final Stage primaryStage;

    public UserProfileView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        // Title
        Text title = new Text("Tuhina's Account");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Arial", 30));

        // Profile Circle Placeholder
        Circle profileCircle = new Circle(75);
        profileCircle.setFill(Color.LIGHTPINK);
        profileCircle.setStroke(Color.WHITE);
        profileCircle.setStrokeWidth(3);

        // Username and Full Name
        Label usernameLabel = new Label("@tuhina.aa");
        usernameLabel.setTextFill(Color.WHITE);
        usernameLabel.setFont(Font.font("Arial", 20));

        Label fullNameLabel = new Label("Tuhina Singh");
        fullNameLabel.setTextFill(Color.WHITE);
        fullNameLabel.setFont(Font.font("Arial", 16));

        // Buttons
        Button editInfoButton = new Button("EDIT INFO");
        editInfoButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        editInfoButton.setOnAction(e -> {
            EditInfoView editInfoView = new EditInfoView(primaryStage, new User("tuhina.aa", "Tuhina", "Singh"), this);
            editInfoView.show();
        });

        Button mainPageButton = new Button("MAIN PAGE");
        mainPageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        mainPageButton.setOnAction(e -> Main.getInstance().showMainPage(primaryStage));

        // Add Components to Layout
        root.getChildren().addAll(title, profileCircle, usernameLabel, fullNameLabel, editInfoButton, mainPageButton);

        // Create and Set Scene
        Scene scene = new Scene(root, 600, 800);
        primaryStage.setTitle("User Profile");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
