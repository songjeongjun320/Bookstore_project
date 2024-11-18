package controllers.Seller_Buyer_Pages_Controllers.Buyer_view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import controllers.Main;

public class BuyerPovController extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout with red background
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #800000;");

        // Profile Section (Center)
        VBox profileSection = new VBox(20);
        profileSection.setAlignment(Pos.CENTER);
        profileSection.setPadding(new Insets(50));

        // Profile Image
        ImageView profileImage = createImageView("file:C:/Users/frank/Desktop/Bookstore_project/front_end/Images/buyer.png", 200, 200); // Replace with correct image path
        Label buyerName = new Label("@JUNSONG\nJun Song");
        buyerName.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: white;");
        Label rating = new Label("⭐ ⭐ ⭐ ⭐ ⭐  5.0");
        rating.setStyle("-fx-font-size: 30px; -fx-text-fill: yellow;");

        Button editInfoButton = new Button("EDIT INFO");
        editInfoButton.setStyle("-fx-background-color: yellow; -fx-font-size: 20px; -fx-text-fill: black;");
        editInfoButton.setOnAction(event -> showEditPopup(buyerName));

        // Add profile components
        profileSection.getChildren().addAll(profileImage, buyerName, rating, editInfoButton);

        // Buttons Section (Bottom Center)
        HBox buttonsSection = new HBox(20);
        buttonsSection.setAlignment(Pos.CENTER);
        buttonsSection.setPadding(new Insets(20));

        // CART and MAIN buttons
        Button cartButton = new Button("CART");
        Button mainButton = new Button("MAIN");

        // Button styles
        cartButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;");
        mainButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;");

        cartButton.setOnAction(e->{
            Main.getInstance().showBuyingPage(primaryStage);
        });

        mainButton.setOnAction(e->{
            Main.getInstance().showMainPage(primaryStage);
        });
        // Add buttons to the HBox
        buttonsSection.getChildren().addAll(cartButton, mainButton);

        // Layout setup
        root.setCenter(profileSection);
        root.setBottom(buttonsSection);

        // Scene setup
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Buyer Page View");
        primaryStage.show();
    }

    // Helper method to show an edit popup
    private void showEditPopup(Label sellerName) {
        Stage popupStage = new Stage();
        popupStage.setTitle("Edit Seller Name");

        VBox popupLayout = new VBox(10);
        popupLayout.setPadding(new Insets(20));
        popupLayout.setAlignment(Pos.CENTER);

        Label instructionLabel = new Label("Enter new name:");
        instructionLabel.setStyle("-fx-font-size: 18px;");
        TextField nameInputField = new TextField();
        nameInputField.setPromptText("New name...");

        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: green; -fx-font-size: 16px; -fx-text-fill: white;");
        saveButton.setOnAction(e -> {
            String newName = nameInputField.getText().trim();
            if (!newName.isEmpty()) {
                sellerName.setText(newName);
                popupStage.close();
            }
        });

        popupLayout.getChildren().addAll(instructionLabel, nameInputField, saveButton);
        Scene popupScene = new Scene(popupLayout, 300, 200);
        popupStage.setScene(popupScene);
        popupStage.show();
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
