package controllers.Seller_Pages_Controllers.Buyer_view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import controllers.Account_Pages_Controllers.Users;

import java.io.File;

public class ProfileView {

    private final Stage primaryStage;
    private final Users user;
    private final ImageView profilePicture;

    public ProfileView(Stage stage, Users user) {
        this.primaryStage = stage;
        this.user = user;
        profilePicture = new ImageView(new Image("default.png", 150, 150, false, false));
    }

    public Scene createScene() {
        VBox root = new VBox(10);
        root.setStyle("-fx-alignment: center; -fx-background-color: #5e0505; -fx-padding: 20;");
        profilePicture.setOnMouseClicked(e -> uploadProfilePicture());
        Label usernameLabel = new Label("@" + user.getUsername());
        usernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20;");
        Label nameLabel = new Label(user.getFirstName() + " " + user.getLastName());
        nameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16;");
        Label emailLabel = new Label("Email: " + user.getEmail());
        emailLabel.setStyle("-fx-text-fill: white;");
        Label phoneLabel = new Label("Phone: " + user.getPhone());
        phoneLabel.setStyle("-fx-text-fill: white;");
        Button editButton = new Button("EDIT INFO");
        editButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black;");
        editButton.setOnAction(e -> openEditInfoView());
        root.getChildren().addAll(profilePicture, usernameLabel, nameLabel, emailLabel, phoneLabel, editButton);
        return new Scene(root, 600, 400);
    }

    private void uploadProfilePicture() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Profile Picture");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            profilePicture.setImage(new Image(file.toURI().toString(), 150, 150, false, false));
        }
    }

    private void openEditInfoView() {
        EditInfoView editInfo = new EditInfoView(primaryStage, user, this);
        primaryStage.setScene(editInfo.createScene());
    }

    public void refresh() {
        primaryStage.setScene(this.createScene());
    }
}
