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

public class OverviewController extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout with red background
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #800000;");
        root.setPadding(new Insets(20)); // Add padding around the main layout

        // Top Section - Order Confirmation
        HBox topSection = new HBox(20);
        topSection.setAlignment(Pos.CENTER_LEFT);
        topSection.setStyle("-fx-background-color: #cccccc; -fx-padding: 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        // Order details
        VBox orderDetails = new VBox(10);
        orderDetails.setAlignment(Pos.TOP_LEFT);
        Text orderPlaced = new Text("✅ Order placed, thanks!");
        orderPlaced.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
        Text confirmationText = new Text("Confirmation will be sent to your email.");
        Text shippingInfo = new Text("Shipping to Jun Song,\n1234 E IraFulton, ECG 130, Tempe, AZ, 85281, United States");
        Text orderDate = new Text("Order confirmation date : Dec. 20");
        Text deliveryEstimate = new Text("Estimated delivery 5~7 business days : Dec. 26");

        orderDetails.getChildren().addAll(orderPlaced, confirmationText, shippingInfo, orderDate, deliveryEstimate);

        // Image section (Logo or Icon)
        VBox logoSection = new VBox();
        logoSection.setAlignment(Pos.TOP_RIGHT);
        ImageView logoImageView = createImageView("file:/path/to/devil_logo.png", 120, 120); // Replace with the correct image path
        logoSection.getChildren().add(logoImageView);

        topSection.getChildren().addAll(orderDetails, logoSection);
        HBox.setHgrow(orderDetails, Priority.ALWAYS);

        // Bottom Section - Order Summary
        VBox bottomSection = new VBox(10);
        bottomSection.setAlignment(Pos.TOP_LEFT);
        bottomSection.setStyle("-fx-background-color: #cccccc; -fx-padding: 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        Text itemsPrice = new Text("Items: $68");
        Text shippingPrice = new Text("Shipping & handling: $7.99");
        Text serviceFee = new Text("Service fee (20%): $19.19");
        Text totalBeforeTax = new Text("Total before tax: $95.18");
        Text tax = new Text("Estimated tax to be collected (7%): $6.66");
        Text orderTotal = new Text("Order total: $101.84");
        orderTotal.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        Text orderNumber = new Text("Order #: 12345678");
        orderNumber.setStyle("-fx-font-size: 14px; -fx-text-fill: grey;");

        bottomSection.getChildren().addAll(itemsPrice, shippingPrice, serviceFee, totalBeforeTax, tax, orderTotal, orderNumber);

        // Home Button
        Button homeButton = new Button("Home");
        homeButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px;");
        homeButton.setOnAction(e -> {
            Main.getInstance().showMainPage(primaryStage);
        });

        // Add home button to the left side (bottom-left)
        HBox homeButtonBox = new HBox();
        homeButtonBox.setAlignment(Pos.BOTTOM_LEFT);
        homeButtonBox.setPadding(new Insets(10, 0, 0, 0));
        homeButtonBox.getChildren().add(homeButton);

        // Layout setup
        root.setTop(topSection);
        root.setBottom(new VBox(bottomSection, homeButtonBox)); // Add the bottom section and the Home button container
        BorderPane.setMargin(topSection, new Insets(20, 20, 10, 20));
        BorderPane.setMargin(bottomSection, new Insets(10, 20, 20, 20));

        // Scene setup
        Scene scene = new Scene(root, 1280, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Order Overview");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    // Helper method to create an ImageView
    private ImageView createImageView(String imagePath, double width, double height) {
        Image image = new Image(imagePath); // Replace with actual image path
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
