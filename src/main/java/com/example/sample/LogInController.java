package com.example.sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    @FXML
    private Button button_login;
    @FXML
    private Button button_sign_up;

    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_password;

    @FXML
    private ImageView im_console;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUtils.registerHistory(tf_username.getText());

    //set button on action
        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.logInUser(event,tf_username.getText(),tf_password.getText());

            }
        });

        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "sign-up.fxml","Sign up!", null);
            }
        });

    }



}