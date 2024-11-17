package controllers.Purchase_Pages_Controllers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import controllers.Main;

public class BuyingController extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Main layout with red background (set entire background to red)
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #800000;");

        // Main Panel for the shopping cart items
        VBox mainPanel = new VBox(10);  // VBox for vertical layout
        mainPanel.setStyle("-fx-padding: 20px;");

        // Book item details with variables (can be dynamic from DB later)
        // Book 1 details
        String book1Title = "Nexus: A Brief History of Information Networks from the Stone Age to AI";
        String book1Author = "Yuval Noah Harari";
        String book1Price = "$8.00";
        String book1OriginalPrice = "$12.00";
        String book1Seller = "Jun Song";
        String book1Condition = "Normal Used";
        String book1Image = "nexus_image.jpg";  // Placeholder for image

        // Book 2 details
        String book2Title = "Engineer's Practical Database: A Technical Reference Guide for Students and Prof";
        String book2Author = "Jay Smith";
        String book2Price = "$10.00";
        String book2OriginalPrice = "$16.23";
        String book2Seller = "Sparky";
        String book2Condition = "New";
        String book2Image = "engineer_image.jpg";  // Placeholder for image

        // Book 3 details
        String book3Title = "Rocket Propulsion Elements";
        String book3Author = "George P. Sutton";
        String book3Price = "$50.00";
        String book3OriginalPrice = "$106.16";
        String book3Seller = "Devil";
        String book3Condition = "Normal Used";
        String book3Image = "rocket_image.jpg";  // Placeholder for image

        // Book item panels with variables (these will be dynamic when DB is integrated)
        HBox itemPanel1 = createCartItem(book1Title, book1Author, book1Price, book1Seller, book1Condition, book1OriginalPrice, book1Image);
        HBox itemPanel2 = createCartItem(book2Title, book2Author, book2Price, book2Seller, book2Condition, book2OriginalPrice, book2Image);
        HBox itemPanel3 = createCartItem(book3Title, book3Author, book3Price, book3Seller, book3Condition, book3OriginalPrice, book3Image);

        // Add items to the main panel
        mainPanel.getChildren().addAll(itemPanel1, itemPanel2, itemPanel3);

        // Calculate totals dynamically (also variable handling)
        double totalPrice = 8.00 + 10.00 + 50.00;
        double shipping = 7.99;
        double serviceFee = 19.19;
        double tax = 6.66;
        double sum = totalPrice + shipping + serviceFee + tax;

        // Summary section (shipping, service fees, etc.)
        VBox summaryPanel = new VBox(5);
        summaryPanel.setStyle("-fx-background-color: #800000; -fx-padding: 15px;");  // Maroon background for price section
        
        // Create HBoxes for each row to allow for right alignment
        HBox totalBox = new HBox();
        totalBox.getChildren().addAll(new Text("Total: $"), new Text(String.format("%.2f", totalPrice)));
        totalBox.setStyle("-fx-alignment: CENTER_RIGHT;"); // Align to the right
        
        HBox shippingBox = new HBox();
        shippingBox.getChildren().addAll(new Text("Shipping: $"), new Text(String.format("%.2f", shipping)));
        shippingBox.setStyle("-fx-alignment: CENTER_RIGHT;"); // Align to the right
        
        HBox serviceFeeBox = new HBox();
        serviceFeeBox.getChildren().addAll(new Text("Service Fee: $"), new Text(String.format("%.2f", serviceFee)));
        serviceFeeBox.setStyle("-fx-alignment: CENTER_RIGHT;"); // Align to the right
        
        HBox taxBox = new HBox();
        taxBox.getChildren().addAll(new Text("Tax: $"), new Text(String.format("%.2f", tax)));
        taxBox.setStyle("-fx-alignment: CENTER_RIGHT;"); // Align to the right
        
        HBox sumBox = new HBox();
        sumBox.getChildren().addAll(new Text("Sum: $"), new Text(String.format("%.2f", sum)));
        sumBox.setStyle("-fx-alignment: CENTER_RIGHT;"); // Align to the right
        
        // Add all HBoxes to the VBox
        summaryPanel.getChildren().addAll(totalBox, shippingBox, serviceFeeBox, taxBox, sumBox);
        
        // Modify text to be white and make it bold
        for (javafx.scene.Node node : summaryPanel.getChildren()) {
            if (node instanceof HBox) {
                HBox box = (HBox) node;
                for (javafx.scene.Node child : box.getChildren()) {
                    if (child instanceof Text) {
                        Text text = (Text) child;
                        text.setStyle("-fx-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");
                    }
                }
            }
        }
        
        // Buttons Panel (Cancel & Buy)
        HBox buttonPanel = new HBox(10);  // HBox for horizontal layout
        Button cancelButton = new Button("Cancel");
        Button buyButton = new Button("Buy");
        buttonPanel.getChildren().addAll(cancelButton, buyButton);
        buttonPanel.setStyle("-fx-alignment: center; -fx-padding: 10px;");

        // Button Styling
        cancelButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px;");
        buyButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-font-size: 14px;");
        
        // Wrap the summaryPanel and buttonPanel in a VBox to avoid overlap
        VBox bottomPanel = new VBox(10);  // VBox to contain summary and buttons
        bottomPanel.getChildren().addAll(summaryPanel, buttonPanel);

        // Create Home button (Left Bottom)
        Button homeButton = new Button("Home");
        homeButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px;");
        homeButton.setOnAction(e -> {
            Main.getInstance().showMainPage(primaryStage);  // Navigate to main page
        });

        // Place everything into the BorderPane root layout
        root.setCenter(mainPanel);
        root.setBottom(bottomPanel);  // Set VBox containing summary and buttons at the bottom
        root.setLeft(homeButton);  // Add home button to the left side

        // Event handlers for buttons
        cancelButton.setOnAction(e -> {
            Main.getInstance().showMainPage(primaryStage);
        });

        buyButton.setOnAction(e -> {
            Main.getInstance().showInformationPage(primaryStage); // Pass to InformationController.java page
        });

        // Create and set the scene
        Scene scene = new Scene(root, 1280, 800);  // Set full screen width and height
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shopping Cart");
        primaryStage.setMaximized(true);  // Make the window fullscreen
        primaryStage.show();
    }

    // Helper method to create each cart item panel with variables
    private HBox createCartItem(String title, String author, String price, String seller, String condition, String originalPrice, String imageFile) {
        HBox panel = new HBox(10);
        panel.setStyle("-fx-background-color: #999999; -fx-padding: 10px;");

        // Load the image for each item (Image placeholder here)
        Image image = new Image("file:/path/to/your/images/" + imageFile);  // Replace with correct image path
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);  // Set image width
        imageView.setFitHeight(150);  // Set image height

        // Set all texts in a new style to align and set spacing
        Text titleLabel = new Text(title);
        titleLabel.setWrappingWidth(250);
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Text authorLabel = new Text("Author: " + author);
        Text sellerLabel = new Text("Seller: " + seller);
        Text conditionLabel = new Text("Condition: " + condition);
        Text priceLabel = new Text(price);
        priceLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        Text originalPriceLabel = new Text(originalPrice);
        originalPriceLabel.setStyle("-fx-text-fill: grey; -fx-strikethrough: true;");

        // Add all texts to a panel
        VBox textPanel = new VBox(5);
        textPanel.getChildren().addAll(titleLabel, authorLabel, sellerLabel, conditionLabel, priceLabel, originalPriceLabel);

        // Add the image and text to the panel
        panel.getChildren().addAll(imageView, textPanel);
        return panel;
    }

    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
}
