package controllers;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // LoginController의 start 메서드를 호출하여 로그인 페이지 표시
        SignupController loginController = new SignupController();
        loginController.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
