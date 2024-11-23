package controllers.Account_Pages_Controllers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ReviewReportView {

    private final Stage primaryStage;

    public ReviewReportView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("REPORT LOGS");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        HBox reportBox = new HBox(20);
        reportBox.setAlignment(Pos.CENTER);
        reportBox.setStyle("-fx-background-color: #D3D3D3; -fx-padding: 10px;");

        VBox detailsBox = new VBox(5);
        detailsBox.setAlignment(Pos.CENTER_LEFT);

        Label usernameLabel = new Label("USERNAME: @tuhina.aa");
        usernameLabel.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");

        Label nameLabel = new Label("NAME: Tuhina Singh");
        nameLabel.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");

        Label accountTypeLabel = new Label("ACCOUNT TYPE: BUYER");
        accountTypeLabel.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");

        Label dateLabel = new Label("DATE: " + LocalDate.now());
        dateLabel.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");

        Label reportingLabel = new Label("REPORTING: @junsong");
        reportingLabel.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");

        detailsBox.getChildren().addAll(usernameLabel, nameLabel, accountTypeLabel, dateLabel, reportingLabel);

        Button reviewButton = new Button("REVIEW REPORT");
        reviewButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        reviewButton.setOnAction(e -> {
            new AdminReportDetailView(primaryStage).show();
        });

        reportBox.getChildren().addAll(detailsBox, reviewButton);

        Button backButton = new Button("BACK");
        backButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        backButton.setOnAction(e -> AdminPageController.getInstance(primaryStage).show());


        root.getChildren().addAll(title, reportBox, backButton);

        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.setTitle("Review Reports");
        primaryStage.show();
    }
}
