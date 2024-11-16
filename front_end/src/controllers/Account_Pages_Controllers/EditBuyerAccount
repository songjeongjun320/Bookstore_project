package controllers.Account_Pages_Controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditInfoView {

    private final Stage primaryStage;
    private final User user;
    private final ProfileView profileView;

    public EditInfoView(Stage stage, User user, ProfileView profileView) {
        this.primaryStage = stage;
        this.user = user;
        this.profileView = profileView;
    }

    public Scene createScene() {
        VBox root = new VBox(10);
        root.setStyle("-fx-alignment: center; -fx-background-color: #8b0000; -fx-padding: 20;");
        TextField nameField = new TextField(user.getFirstName() + " " + user.getLastName());
        nameField.setStyle("-fx-background-color: white; -fx-border-color: black;");
        TextField emailField = new TextField(user.getEmail());
        emailField.setStyle("-fx-background-color: white; -fx-border-color: black;");
        TextField phoneField = new TextField(user.getPhone());
        phoneField.setStyle("-fx-background-color: white; -fx-border-color: black;");
        Button saveButton = new Button("SAVE");
        saveButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black;");
        saveButton.setOnAction(e -> {
            String[] names = nameField.getText().split(" ", 2);
            user.setFirstName(names[0]);
            user.setLastName(names.length > 1 ? names[1] : "");
            user.setEmail(emailField.getText());
            user.setPhone(phoneField.getText());
            profileView.refresh();
        });
        VBox fieldsBox = new VBox(5, new Label("Name"), nameField, new Label("Email"), emailField, new Label("Phone"), phoneField, saveButton);
        fieldsBox.setStyle("-fx-background-color: #d3d3d3; -fx-padding: 10; -fx-border-color: black;");
        root.getChildren().add(fieldsBox);
        return new Scene(root, 600, 400);
    }
}
