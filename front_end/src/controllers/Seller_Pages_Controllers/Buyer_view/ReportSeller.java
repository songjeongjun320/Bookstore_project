package controllers.Seller_Pages_Controllers.Buyer_view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class ReportSeller {

    int i = 2;
    private final Stage primaryStage;
    private final String username;
    private final String name;
  

    public ReportSeller (Stage primaryStage, String username, String name) {
        this.primaryStage = primaryStage;
        this.name = name;
        this.username = username;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("Reporting: Jun Song");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        TextArea reportBox = new TextArea();
        reportBox.setPromptText("Explain:");
        reportBox.setPrefHeight(300);
        reportBox.setPrefWidth(300);

        Button reportButton = new Button("REPORT");
        reportButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        reportButton.setOnAction(e -> {
            reportBox.clear();
            new ReportConfirm(primaryStage).show(); 
        });

        root.getChildren().addAll(title, reportBox, reportButton);

        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.setTitle("Report User");
        primaryStage.show();
    }
}