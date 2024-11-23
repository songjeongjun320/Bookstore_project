package controllers.Purchase_Pages_Controllers;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import controllers.Main;

public class InformationController extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout with red background
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #800000;");

        // Form layout with dynamic resizing
        GridPane formLayout = new GridPane();
        formLayout.setPadding(new Insets(20));
        formLayout.setHgap(20);
        formLayout.setVgap(20);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100); // Full width column
        formLayout.getColumnConstraints().add(col1);

        // Card details section
        VBox cardSection = new VBox(10);
        cardSection.setStyle("-fx-background-color: #cccccc; -fx-padding: 15px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        Text cardTitle = new Text("Card Details");
        TextField cardNumber = new TextField();
        cardNumber.setPromptText("Card Number");
        TextField nameOnCard = new TextField();
        nameOnCard.setPromptText("Name on Card");
        HBox expirationAndCVV = new HBox(10);
        TextField expirationDate = new TextField();
        expirationDate.setPromptText("Expiration Date (MM/YY)");
        TextField cvv = new TextField();
        cvv.setPromptText("CVV");
        expirationAndCVV.getChildren().addAll(expirationDate, cvv);
        expirationAndCVV.setMaxWidth(Double.MAX_VALUE);

        cardSection.getChildren().addAll(cardTitle, cardNumber, nameOnCard, expirationAndCVV);

        // Shipping Address section
        VBox shippingSection = new VBox(10);
        shippingSection.setStyle("-fx-background-color: #cccccc; -fx-padding: 15px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        Text shippingTitle = new Text("Shipping Address");
        TextField shippingName = new TextField();
        shippingName.setPromptText("Full Name");
        TextField shippingAddress = new TextField();
        shippingAddress.setPromptText("Street Address");
        HBox cityStateZip = new HBox(10);
        TextField city = new TextField();
        city.setPromptText("City");
        TextField state = new TextField();
        state.setPromptText("State");
        TextField zip = new TextField();
        zip.setPromptText("ZIP Code");
        cityStateZip.getChildren().addAll(city, state, zip);
        cityStateZip.setMaxWidth(Double.MAX_VALUE);
        CheckBox sameAsBilling = new CheckBox("Billing address is the same as shipping");

        shippingSection.getChildren().addAll(shippingTitle, shippingName, shippingAddress, cityStateZip, sameAsBilling);

        // Billing Address section
        VBox billingSection = new VBox(10);
        billingSection.setStyle("-fx-background-color: #cccccc; -fx-padding: 15px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        Text billingTitle = new Text("Billing Address");
        TextField billingName = new TextField();
        billingName.setPromptText("Full Name");
        TextField billingAddress = new TextField();
        billingAddress.setPromptText("Street Address");
        HBox billingCityStateZip = new HBox(10);
        TextField billingCity = new TextField();
        billingCity.setPromptText("City");
        TextField billingState = new TextField();
        billingState.setPromptText("State");
        TextField billingZip = new TextField();
        billingZip.setPromptText("ZIP Code");
        billingCityStateZip.getChildren().addAll(billingCity, billingState, billingZip);
        billingCityStateZip.setMaxWidth(Double.MAX_VALUE);

        billingSection.getChildren().addAll(billingTitle, billingName, billingAddress, billingCityStateZip);

        // Buttons (Cancel and Order)
        HBox buttonPanel = new HBox(20);
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setPadding(new Insets(10));
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px;");
        Button orderButton = new Button("Order");
        orderButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-font-size: 14px;");
        buttonPanel.getChildren().addAll(cancelButton, orderButton);

        // Button actions
        orderButton.setOnAction(e -> Main.getInstance().showOrderConfirmationPage(primaryStage));
        cancelButton.setOnAction(e -> Main.getInstance().showBuyingPage(primaryStage));

        // Add all sections to the form layout
        formLayout.add(cardSection, 0, 0);
        formLayout.add(shippingSection, 0, 1);
        formLayout.add(billingSection, 0, 2);
        formLayout.add(buttonPanel, 0, 3);

        // Set row constraints for dynamic resizing
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(25); // 25% height for card section
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(25); // 25% height for shipping section
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(25); // 25% height for billing section
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(25); // 25% height for button panel

        formLayout.getRowConstraints().addAll(row1, row2, row3, row4);

        // Add form layout to root
        root.setCenter(formLayout);

        // Scene setup
        Scene scene = new Scene(root, 1200, 800); // Fullscreen width and height
        primaryStage.setScene(scene);
        primaryStage.setTitle("Purchase Page");
        primaryStage.setMaximized(true); // Fullscreen mode
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
