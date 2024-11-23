package controllers.Seller_Pages_Controllers.Buyer_view;

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

import java.util.List;

public class SellerAccountView {
    

    private final Stage primaryStage;
    private final String username;
    private final String fullName;
    private final double rating;
    private final List<String> listedBooks;
    private final List<String> soldBooks;

    public SellerAccountView(Stage primaryStage, String username, String fullName, double rating, List<String> listedBooks, List<String> soldBooks) {
        this.primaryStage = primaryStage;
        this.username = username;
        this.fullName = fullName;
        this.rating = rating;
        this.listedBooks = listedBooks;
        this.soldBooks = soldBooks;
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

        Label ratingLabel = new Label("★★★★★ " + rating);
        ratingLabel.setTextFill(Color.YELLOW);
        ratingLabel.setFont(Font.font("Arial", 16));

        Label listedBooksLabel = new Label("Listed Books:");
        listedBooksLabel.setTextFill(Color.WHITE);
        listedBooksLabel.setFont(Font.font("Arial", 16));

        VBox listedBooksBox = new VBox(5);
        listedBooksBox.setAlignment(Pos.CENTER_LEFT);
        for (String book : listedBooks) {
            Label bookLabel = new Label(book);
            bookLabel.setTextFill(Color.WHITE);
            bookLabel.setFont(Font.font("Arial", 14));
            listedBooksBox.getChildren().add(bookLabel);
        }

        Label soldBooksLabel = new Label("Sold Books:");
        soldBooksLabel.setTextFill(Color.WHITE);
        soldBooksLabel.setFont(Font.font("Arial", 16));

        VBox soldBooksBox = new VBox(5);
        soldBooksBox.setAlignment(Pos.CENTER_LEFT);
        for (String book : soldBooks) {
            Label bookLabel = new Label(book);
            bookLabel.setTextFill(Color.WHITE);
            bookLabel.setFont(Font.font("Arial", 14));
            soldBooksBox.getChildren().add(bookLabel);
        }

        HBox buttonsBox = new HBox(20);
        buttonsBox.setAlignment(Pos.CENTER);

        Button messageButton = new Button("MESSAGE");
        messageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        messageButton.setOnAction(e -> {
            new SellerMessage(primaryStage, username).show();
        });

        Button reportButton = new Button("REPORT");
        reportButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        reportButton.setOnAction(e -> {
            new ReportSeller(primaryStage, username, fullName).show();
        });

        buttonsBox.getChildren().addAll(messageButton, reportButton);

        root.getChildren().addAll(title, profilePicture, usernameLabel, fullNameLabel, ratingLabel,
                listedBooksLabel, listedBooksBox, soldBooksLabel, soldBooksBox, buttonsBox);

        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.setTitle("Seller Account");
        primaryStage.show();
    }
}