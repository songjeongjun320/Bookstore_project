package controllers.Seller_Pages_Controllers.Seller_view;

import controllers.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReportView {

    private final Stage primaryStage;

    public ReportView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("Reporting: Tuhina Singh");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        TextArea reportBox = new TextArea();
        reportBox.setPromptText("Explain:");
        reportBox.setPrefHeight(300);
        reportBox.setPrefWidth(300);

        Button reportButton = new Button("REPORT");
        reportButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        reportButton.setOnAction(e -> {
            reportBox.clear();
            new ReportConfirmationView(primaryStage).show();
        });

        Button mainPageButton = new Button("MAIN PAGE");
        mainPageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        mainPageButton.setOnAction(e -> Main.getInstance().showMainPage(primaryStage));

        root.getChildren().addAll(title, reportBox, reportButton, mainPageButton);

        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.setTitle("Report User");
        primaryStage.show();
    }
}