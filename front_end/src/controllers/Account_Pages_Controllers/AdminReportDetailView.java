package controllers.Account_Pages_Controllers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminReportDetailView {

    private final Stage primaryStage;

    public AdminReportDetailView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("TUHINA'S REPORT");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        Label reportDetails = new Label("I AM REPORTING JUN FOR X, Y, AND Z.");
        reportDetails.setStyle("-fx-text-fill: black; -fx-font-size: 16px; -fx-background-color: #D3D3D3; -fx-padding: 10px;");
        reportDetails.setMaxWidth(500);
        reportDetails.setWrapText(true);

        Button backButton = new Button("BACK");
        backButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        backButton.setOnAction(e -> AdminPageController.getInstance(primaryStage).show());

        root.getChildren().addAll(title, reportDetails, backButton);

        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.setTitle("Admin Report Details");
        primaryStage.show();
    }
}
