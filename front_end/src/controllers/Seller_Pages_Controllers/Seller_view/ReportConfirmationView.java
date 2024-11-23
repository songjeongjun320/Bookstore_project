package controllers.Seller_Pages_Controllers.Seller_view;



import controllers.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import controllers.Main;

public class ReportConfirmationView {
    int i =2;

    private final Stage primaryStage;

    public ReportConfirmationView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label thankYouLabel = new Label("THANK YOU");
        thankYouLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        Button mainPageButton = new Button("MAIN PAGE");
        mainPageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        mainPageButton.setOnAction(e -> Main.getInstance().showMainPage(primaryStage));
        

        root.getChildren().addAll(thankYouLabel, mainPageButton);

        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.setTitle("Report Confirmation");
        primaryStage.show();
    }
}