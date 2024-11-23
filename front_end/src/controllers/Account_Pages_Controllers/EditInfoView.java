package controllers.Account_Pages_Controllers;
import controllers.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditInfoView {

    private final User user;
    private final Stage primaryStage;
    private final UserProfileView parentView;

    public EditInfoView(Stage primaryStage, User user, UserProfileView parentView) {
        this.primaryStage = primaryStage;
        this.user = user;
        this.parentView = parentView;
    }

    public void show() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #5e0505;");

        TextField usernameField = new TextField(user.getUsername());
        TextField firstNameField = new TextField(user.getFirstName());
        TextField lastNameField = new TextField(user.getLastName());

        Button saveButton = new Button("SAVE");
        saveButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        saveButton.setOnAction(e -> {
            user.setUsername(usernameField.getText());
            user.setFirstName(firstNameField.getText());
            user.setLastName(lastNameField.getText());
            parentView.show();
        });

        Button mainPageButton = new Button("MAIN PAGE");
        mainPageButton.setStyle("-fx-background-color: #FFCC00; -fx-text-fill: black; -fx-font-size: 14px;");
        mainPageButton.setOnAction(e -> Main.getInstance().showMainPage(primaryStage));

        root.getChildren().addAll(usernameField, firstNameField, lastNameField, saveButton, mainPageButton);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Edit Info");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}