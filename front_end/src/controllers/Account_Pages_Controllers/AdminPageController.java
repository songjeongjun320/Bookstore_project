package controllers.Account_Pages_Controllers;

import controllers.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminPageController {

    private static AdminPageController instance; 
    private final Stage primaryStage;

    private AdminPageController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public static AdminPageController getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new AdminPageController(primaryStage);
        }
        return instance;
    }

    public void show() {
        VBox root = new VBox(30);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label welcomeLabel = new Label("WELCOME, ADMIN");
        welcomeLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");

        Label adminNameLabel = new Label("JOHN");
        adminNameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");

        Label usernameLabel = new Label("@JOHNDOE");
        usernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");

        HBox buttonRow1 = new HBox(20);
        buttonRow1.setAlignment(Pos.CENTER);

        Button reviewReportsButton = new Button("REVIEW REPORTS");
        reviewReportsButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        reviewReportsButton.setOnAction(e -> new ReviewReportView(primaryStage).show());

        Button transactionsButton = new Button("TRANSACTIONS");
        transactionsButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        transactionsButton.setOnAction(e -> new TransactionLogsView(primaryStage).show());

        Button manageAccountsButton = new Button("MANAGE ACCOUNTS");
        manageAccountsButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        manageAccountsButton.setOnAction(e -> new ManageAccountsView(primaryStage).show());

        buttonRow1.getChildren().addAll(reviewReportsButton, transactionsButton, manageAccountsButton);

        Button listingsButton = new Button("LISTINGS");
        listingsButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        listingsButton.setOnAction(e -> new ListingApplicationLogsView(primaryStage).show());

        Button homeButton = new Button("");
        homeButton.setStyle("-fx-background-color: transparent; -fx-background-image: url('home-icon.png');");
        homeButton.setOnAction(e -> Main.getInstance().showMainPage(primaryStage));

        root.getChildren().addAll(homeButton, welcomeLabel, adminNameLabel, usernameLabel, buttonRow1, listingsButton);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin Page");
        primaryStage.show();
    }
}

