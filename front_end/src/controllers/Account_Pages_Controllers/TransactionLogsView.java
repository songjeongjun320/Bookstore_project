package controllers.Account_Pages_Controllers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TransactionLogsView {

    private final Stage primaryStage;

    public TransactionLogsView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("TRANSACTION LOGS");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        Label emptyLabel = new Label("No transactions have been made yet.");
        emptyLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");

        Button backButton = new Button("BACK");
        backButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        backButton.setOnAction(e -> AdminPageController.getInstance(primaryStage).show());


        root.getChildren().addAll(title, emptyLabel, backButton);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Transaction Logs");
        primaryStage.show();
    }
}
