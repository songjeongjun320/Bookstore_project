package controllers.Seller_Pages_Controllers.Seller_view;

import controllers.Main;
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

    private final Stage primaryStage;

    public OtherUserAccountView(Stage primaryStage) {
        this.primaryStage = primaryStage;
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

        Label userNameLabel = new Label("@tuhina.aa");
        userNameLabel.setTextFill(Color.WHITE);
        userNameLabel.setFont(Font.font("Arial", 20));

        Label fullNameLabel = new Label("Tuhina Singh");
        fullNameLabel.setTextFill(Color.WHITE);
        fullNameLabel.setFont(Font.font("Arial", 16));

        Button messageButton = new Button("MESSAGE");
        messageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        messageButton.setOnAction(e -> {
            new MessageView(primaryStage).show();
        });

        Button reportButton = new Button("REPORT");
        reportButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        reportButton.setOnAction(e -> {
            new ReportView(primaryStage).show();
        });

        Button mainPageButton = new Button("MAIN PAGE");
        mainPageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        mainPageButton.setOnAction(e -> Main.getInstance().showMainPage(primaryStage));

        root.getChildren().addAll(title, profilePicture, userNameLabel, fullNameLabel, messageButton, reportButton, mainPageButton);

        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.setTitle("User Account");
        primaryStage.show();
    }
}
