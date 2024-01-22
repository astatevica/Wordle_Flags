package com.example.sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private Button button_signup;

    @FXML
    private Button button_login;

    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_confirm_password;

    @FXML
    private TextField tf_email;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //parbauda vai username un password lauki ir aizpildīti
                if(!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()){
                    //pārbauda vai sakrīt paroles
                    if((tf_password.getText().trim().equals(tf_confirm_password.getText().trim()))) {
                        DBUtils.registerHistory(tf_username.getText());
                        DBUtils.signUpUser(event, tf_username.getText(), tf_password.getText(), tf_email.getText());

                    }else{
                        System.out.println("Password does not match!");
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setContentText("Password does not match!");
                        alert1.show();
                    }
                }else{
                    System.out.println("Please fill in all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up!");
                    alert.show();
                }
            }
        });

        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "log-in.fxml", "Log in!", null);
            }
        });

    }




}
