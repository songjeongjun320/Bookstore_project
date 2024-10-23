package controllers;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // SigninController의 start 메서드를 호출하여 로그인 페이지 표시
        SigninController signinController = new SigninController();
        signinController.start(primaryStage);  // 로그인 페이지를 처음에 실행
    }

    public static void main(String[] args) {
        launch(args);  // JavaFX 애플리케이션 시작
    }
}
