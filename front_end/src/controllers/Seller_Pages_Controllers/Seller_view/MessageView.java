package controllers.Seller_Pages_Controllers.Seller_view;



import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class MessageView {
    int i =2;

    private final Stage primaryStage;
    private final String username;

    public MessageView(Stage primaryStage, String username) {
        this.primaryStage = primaryStage;
        this.username = username;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("Message Tuhina Singh");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        TextArea messageBox = new TextArea();
        messageBox.setPromptText("Enter...");
        messageBox.setPrefHeight(300);
        messageBox.setPrefWidth(300);

        Button sendButton = new Button("SEND");
        sendButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        Button mainPageButton = new Button("MAIN PAGE");
        mainPageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        sendButton.setOnAction(e -> {
            messageBox.clear(); 
        });
        

        root.getChildren().addAll(title, messageBox, sendButton, mainPageButton);

        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.setTitle("Message User");
        primaryStage.show();
    }
}