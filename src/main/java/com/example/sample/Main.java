package com.example.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    // #8328CC violets
    // #FFFFFF white

    @Override
    public void start(Stage stage) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         stage.setTitle("Log in!");
         stage.setScene(scene);
         stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}