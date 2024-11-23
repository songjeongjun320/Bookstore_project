package controllers.Seller_Pages_Controllers.Seller_view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OtherUserAccountView {
    int i =2;

    private final Stage primaryStage;
    private final String username;
    private final String fullName;

    public OtherUserAccountView(Stage primaryStage, String username, String fullName) {
        this.primaryStage = primaryStage;
        this.username = username;
        this.fullName = fullName;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("Tuhina Singh's Account");
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font("Arial", 24));

        Circle profilePicture = new Circle(75);
        profilePicture.setFill(Color.LIGHTPINK); 

        Label userNameLabel = new Label("@tuhina.aas");
        userNameLabel.setTextFill(Color.WHITE);
        userNameLabel.setFont(Font.font("Arial", 20));

        Label fullNameLabel = new Label(fullName);
        fullNameLabel.setTextFill(Color.WHITE);
        fullNameLabel.setFont(Font.font("Arial", 16));

        Button messageButton = new Button("MESSAGE");
        messageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        messageButton.setOnAction(e -> {
            new MessageView(primaryStage, username).show();
        });

        Button reportButton = new Button("REPORT");
        reportButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        reportButton.setOnAction(e -> {
            new ReportView(primaryStage, username, fullName).show();
        });

        root.getChildren().addAll(title, profilePicture, userNameLabel, fullNameLabel, messageButton, reportButton);

        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.setTitle("User Account");
        primaryStage.show();
    }
}