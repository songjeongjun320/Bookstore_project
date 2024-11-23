package controllers.Seller_Pages_Controllers.Buyer_view;

import controllers.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SellerAccountView {

    private final Stage primaryStage;

    public SellerAccountView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("Jun's Seller Account");
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font("Arial", 24));

        Circle profilePicture = new Circle(75);
        profilePicture.setFill(Color.LIGHTPINK);

        Label usernameLabel = new Label("@junsong");
        usernameLabel.setTextFill(Color.WHITE);
        usernameLabel.setFont(Font.font("Arial", 18));

        Label fullNameLabel = new Label("Jun Song");
        fullNameLabel.setTextFill(Color.WHITE);
        fullNameLabel.setFont(Font.font("Arial", 16));

        Label ratingLabel = new Label("★★★★★ 5.0");
        ratingLabel.setTextFill(Color.YELLOW);
        ratingLabel.setFont(Font.font("Arial", 16));

        HBox buttonsBox = new HBox(20);
        buttonsBox.setAlignment(Pos.CENTER);

        Button messageButton = new Button("MESSAGE");
        messageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        messageButton.setOnAction(e -> {
            new SellerMessage(primaryStage).show(); // Matches your existing working code
        });

        Button reportButton = new Button("REPORT");
        reportButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        reportButton.setOnAction(e -> {
            new ReportSeller(primaryStage).show(); // Matches your existing working code
        });

        Button mainPageButton = new Button("MAIN PAGE");
        mainPageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        mainPageButton.setOnAction(e -> Main.getInstance().showMainPage(primaryStage));

        buttonsBox.getChildren().addAll(messageButton, reportButton);

        root.getChildren().addAll(title, profilePicture, usernameLabel, fullNameLabel, ratingLabel, buttonsBox, mainPageButton);

        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.setTitle("Seller Account");
        primaryStage.show();
    }
}