package controllers.Account_Pages_Controllers;

import controllers.Seller_Pages_Controllers.Buyer_view.SellerAccountView;
import controllers.Seller_Pages_Controllers.Seller_view.OtherUserAccountView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageAccountsView {

    private final Stage primaryStage;

    public ManageAccountsView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #7E1416;");

        Label title = new Label("DEVIL'S READS ACCOUNTS");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        HBox accountFilterButtons = new HBox(20);
        accountFilterButtons.setAlignment(Pos.CENTER);

        Button activeAccountsButton = new Button("ACTIVE ACCOUNTS");
        activeAccountsButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");

        Button restrictedAccountsButton = new Button("RESTRICTED ACCOUNTS");
        restrictedAccountsButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");

        accountFilterButtons.getChildren().addAll(activeAccountsButton, restrictedAccountsButton);

        VBox sellersBox = new VBox(10);
        sellersBox.setAlignment(Pos.CENTER_LEFT);

        Label sellersLabel = new Label("SELLERS");
        sellersLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");

        HBox sellerAccount = new HBox(20);
        sellerAccount.setStyle("-fx-background-color: #D3D3D3; -fx-padding: 10px;");
        sellerAccount.setAlignment(Pos.CENTER_LEFT);

        Label sellerDetails = new Label("USERNAME: @junsong\nNAME: Jun Song\nACCOUNT TYPE: SELLER");
        sellerDetails.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");

        Button viewSellerButton = new Button("VIEW ACCOUNT");
        viewSellerButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        viewSellerButton.setOnAction(e -> new SellerAccountView(primaryStage).show());

        sellerAccount.getChildren().addAll(sellerDetails, viewSellerButton);
        sellersBox.getChildren().addAll(sellersLabel, sellerAccount);

        VBox buyersBox = new VBox(10);
        buyersBox.setAlignment(Pos.CENTER_LEFT);

        Label buyersLabel = new Label("BUYERS");
        buyersLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");

        HBox buyerAccount = new HBox(20);
        buyerAccount.setStyle("-fx-background-color: #D3D3D3; -fx-padding: 10px;");
        buyerAccount.setAlignment(Pos.CENTER_LEFT);

        Label buyerDetails = new Label("USERNAME: @tuhina.aa\nNAME: Tuhina Singh\nACCOUNT TYPE: BUYER");
        buyerDetails.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");

        Button viewBuyerButton = new Button("VIEW ACCOUNT");
        viewBuyerButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        viewBuyerButton.setOnAction(e -> new OtherUserAccountView(primaryStage).show());

        buyerAccount.getChildren().addAll(buyerDetails, viewBuyerButton);
        buyersBox.getChildren().addAll(buyersLabel, buyerAccount);

        Button backButton = new Button("BACK");
        backButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        backButton.setOnAction(e -> AdminPageController.getInstance(primaryStage).show());

        root.getChildren().addAll(title, accountFilterButtons, sellersBox, buyersBox, backButton);

        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.setTitle("Manage Accounts");
        primaryStage.show();
    }
}
