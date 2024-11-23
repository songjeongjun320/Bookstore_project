package controllers.Account_Pages_Controllers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TransactionStatsView {

    private final Stage primaryStage;

    public TransactionStatsView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("TRANSACTION STATS");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        Label booksBoughtLabel = new Label("BOOKS BOUGHT THIS MONTH: ");
        Label booksListedLabel = new Label("BOOKS LISTED THIS MONTH: ");
        Label totalBooksBoughtLabel = new Label("TOTAL BOOKS BOUGHT: ");
        Label booksStillListedLabel = new Label("BOOKS STILL LISTED: ");
        Label percentageBoughtLabel = new Label("PERCENTAGE OF BOOKS LISTED THAT HAVE BEEN BOUGHT: ");

        booksBoughtLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        booksListedLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        totalBooksBoughtLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        booksStillListedLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        percentageBoughtLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");

        Button backButton = new Button("BACK");
        backButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        backButton.setOnAction(e -> AdminPageController.getInstance(primaryStage).show());

        root.getChildren().addAll(title, booksBoughtLabel, booksListedLabel, totalBooksBoughtLabel, booksStillListedLabel, percentageBoughtLabel, backButton);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Transaction Stats");
        primaryStage.show();
    }
}
