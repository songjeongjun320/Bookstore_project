package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.json.JSONObject;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton sellerOption, buyerOption;

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
        loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> login());
    }

    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = sellerOption.isSelected() ? "seller" : "buyer";

        // API 호출
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password", password);
        json.put("role", role);

        fetch("POST", "/login", json.toString());
    }

    // fetch 메소드
    private void fetch(String method, String endpoint, String body) {
        // 비동기 호출 구현
        // 여기서 endpoint는 "/login"이야
        System.out.println("Request to: " + endpoint);
        System.out.println("Data: " + body);
        // 실제 구현 시에는 HttpURLConnection을 사용해서 서버와 통신하거나 라이브러리 사용 가능
    }
}
