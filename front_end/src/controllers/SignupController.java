package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.json.JSONObject;

public class SignupController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField, confirmPasswordField;

    @FXML
    private RadioButton sellerOption, buyerOption;

    @FXML
    private Button signupButton;

    @FXML
    public void initialize() {
        signupButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> signup());
    }

    private void signup() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String role = sellerOption.isSelected() ? "seller" : "buyer";

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return;
        }

        // API 호출
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password", password);
        json.put("role", role);

        fetch("POST", "/signup", json.toString());
    }

    // fetch 메소드
    private void fetch(String method, String endpoint, String body) {
        // 비동기 호출 구현
        System.out.println("Request to: " + endpoint);
        System.out.println("Data: " + body);
        // 실제 구현 시 HttpURLConnection 또는 외부 라이브러리 사용 가능
    }
}
