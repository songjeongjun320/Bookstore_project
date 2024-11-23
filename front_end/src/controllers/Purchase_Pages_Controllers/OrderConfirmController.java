package controllers.Purchase_Pages_Controllers;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import controllers.Main;

public class OrderConfirmController extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Root layout with dark red background
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #800000;");

        // Main content grid for layout
        GridPane mainContent = new GridPane();
        mainContent.setHgap(20);
        mainContent.setVgap(20);
        mainContent.setPadding(new Insets(20));

        // Set column and row constraints for flexible resizing
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50); // Left column takes 50% width
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50); // Right column takes 50% width

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50); // Top row takes 50% height
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(50); // Bottom row takes 50% height

        mainContent.getColumnConstraints().addAll(col1, col2);
        mainContent.getRowConstraints().addAll(row1, row2);

        // Panels
        VBox leftTopPanel = createShippingInfo();
        VBox leftBottomPanel = createReviewItems();
        VBox rightTopPanel = createPaymentInfo();
        VBox rightBottomPanel = createOtherItems();

        // Apply styles to panels
        leftTopPanel.setStyle("-fx-background-color: #E8E8E8; -fx-padding: 20px; -fx-border-radius: 10px;");
        leftBottomPanel.setStyle("-fx-background-color: #E8E8E8; -fx-padding: 20px; -fx-border-radius: 10px;");
        rightTopPanel.setStyle("-fx-background-color: #E8E8E8; -fx-padding: 20px; -fx-border-radius: 10px;");
        rightBottomPanel.setStyle("-fx-background-color: #E8E8E8; -fx-padding: 20px; -fx-border-radius: 10px;");

        // Add panels to the grid
        mainContent.add(leftTopPanel, 0, 0); // Top left
        mainContent.add(rightTopPanel, 1, 0); // Top right
        mainContent.add(leftBottomPanel, 0, 1); // Bottom left
        mainContent.add(rightBottomPanel, 1, 1); // Bottom right

        // Button Panel (Confirm and Cancel buttons)
        HBox buttonPanel = new HBox(10);
        buttonPanel.setAlignment(Pos.CENTER_RIGHT);
        buttonPanel.setPadding(new Insets(10));

        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: white; -fx-font-size: 14px; -fx-padding: 10 20;");
        cancelButton.setOnAction(e -> Main.getInstance().showInformationPage(primaryStage)); // Go back to Information Page

        Button confirmButton = new Button("Order Confirmation");
        confirmButton.setStyle("-fx-background-color: yellow; -fx-font-size: 14px; -fx-padding: 10 20;");
        confirmButton.setOnAction(e -> Main.getInstance().showOverviewPage(primaryStage)); // Go to Overview Page

        buttonPanel.getChildren().addAll(cancelButton, confirmButton);

        // Add grid and buttons to the root layout
        root.setCenter(mainContent);
        root.setBottom(buttonPanel);
        BorderPane.setAlignment(buttonPanel, Pos.CENTER_RIGHT);

        // Home Button
        Button homeButton = new Button();
        ImageView homeIcon = new ImageView(new Image("file:path/to/home-icon.png"));
        homeIcon.setFitWidth(30);
        homeIcon.setFitHeight(30);
        homeButton.setGraphic(homeIcon);
        homeButton.setStyle("-fx-background-color: transparent;");
        homeButton.setOnAction(e -> Main.getInstance().showMainPage(primaryStage));

        root.setLeft(homeButton);
        BorderPane.setAlignment(homeButton, Pos.BOTTOM_LEFT);

        // Scene setup
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Order Confirmation");
        primaryStage.setMaximized(true); // Launch in full screen
        primaryStage.show();
    }

    private VBox createShippingInfo() {
        VBox shippingInfo = new VBox(10);
        Text title = new Text("1. Shipping address");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        Text details = new Text("Jun Song\n1234 E IraFulton Rd, ECG 130\nTempe, AZ 85281");
        Button changeButton = new Button("Change");
        changeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: blue; -fx-underline: true;");
        shippingInfo.getChildren().addAll(title, details, changeButton);
        return shippingInfo;
    }

    private VBox createPaymentInfo() {
        VBox paymentInfo = new VBox(10);
        Text title = new Text("2. Payment method");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        Text details = new Text("Paying with Visa 4856\nBilling address: Same as shipping address");
        Button changeButton = new Button("Change");
        changeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: blue; -fx-underline: true;");
        paymentInfo.getChildren().addAll(title, details, changeButton);
        return paymentInfo;
    }

    private VBox createReviewItems() {
        VBox reviewItems = new VBox(15);
        Text title = new Text("Review Items and Shipping");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        HBox items = new HBox(10);
        items.setAlignment(Pos.CENTER);
        items.getChildren().addAll(
            createBookImage("nexus.jpg", 120, 160),
            createBookImage("engineers.jpg", 120, 160),
            createBookImage("rocket.jpg", 120, 160)
        );
        reviewItems.getChildren().addAll(title, items);
        return reviewItems;
    }

    private VBox createOtherItems() {
        VBox otherItems = new VBox(15);
        Text title = new Text("Other Items?");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        HBox items = new HBox(10);
        items.setAlignment(Pos.CENTER);
        items.getChildren().addAll(
            createBookImage("file:front_end/db/ELON MUSK_ASHLEE VANCE_ASH_NEW_01222023_SCIENCE_$5.99.png", 120, 160),
            createBookImage("dance_with_obsession.jpg", 120, 160)
        );
        otherItems.getChildren().addAll(title, items);
        return otherItems;
    }

    private ImageView createBookImage(String imagePath, double width, double height) {
        Image image = new Image("file:path/to/" + imagePath, width, height, true, true);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
