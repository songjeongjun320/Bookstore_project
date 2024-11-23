
package controllers.Account_Pages_Controllers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditInfoView {

    private final User user; // User object to store information
    private final Stage primaryStage; 
    private final UserProfileView parentView; 
    int i = 2;

    public EditInfoView(Stage primaryStage, User user, UserProfileView parentView) {
        this.primaryStage = primaryStage;
        this.user = user;
        this.parentView = parentView;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #5e0505;");

        // Input fields pre-filled with user's current data
        TextField usernameField = new TextField(user.getUsername());
        TextField firstNameField = new TextField(user.getFirstName());
        TextField lastNameField = new TextField(user.getLastName());

        // Save button to update user details and return to UserProfileView
        Button saveButton = new Button("SAVE");
        saveButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        saveButton.setOnAction(e -> {
            user.setUsername(usernameField.getText());
            user.setFirstName(firstNameField.getText());
            user.setLastName(lastNameField.getText());

            // Return to UserProfileView 
            parentView.show();
        });

        // Add to layout
        root.getChildren().addAll(usernameField, firstNameField, lastNameField, saveButton);

        // Create and set the Scene
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setTitle("Edit Info");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
