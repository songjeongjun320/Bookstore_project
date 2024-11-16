package controllers.Account_Pages_Controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class BuyerProfileView {

    private final User user;
    private final ImageView profilePicture;

    public BuyerProfileView(User user) {
        this.user = user;
        this.profilePicture = new ImageView(new Image("default.png", 150, 150, false, false));
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setStyle("-fx-alignment: center; -fx-background-color: #8b0000; -fx-padding: 20;");

        profilePicture.setOnMouseClicked(e -> uploadProfilePicture(primaryStage));

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
        editButton.setOnAction(e -> openEditInfoView(primaryStage));

        root.getChildren().addAll(profilePicture, usernameLabel, nameLabel, emailLabel, phoneLabel, editButton);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void uploadProfilePicture(Stage primaryStage) {
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

    private void openEditInfoView(Stage primaryStage) {
        EditInfoView editInfoView = new EditInfoView(primaryStage, user, this);
        editInfoView.start(primaryStage);
    }
}
