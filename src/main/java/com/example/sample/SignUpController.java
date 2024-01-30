package com.example.sample;

import Model.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private Button button_signup;

    @FXML
    private Button button_login;

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField pf_password;

    @FXML
    private PasswordField pf_confirm_password;

    @FXML
    private TextField tf_email;

    private static Player player;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //pievieno jauno lietotāju DB un veic pārbaudes
        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //parbauda vai username un password lauki ir aizpildīti
                if(!tf_username.getText().trim().isEmpty() && !pf_password.getText().trim().isEmpty()){
                    //pārbauda vai sakrīt paroles un reģistrē vēsturi un lietotāju
                    if((pf_password.getText().trim().equals(pf_confirm_password.getText().trim()))) {
                        DBUtils.signUpUser(event, tf_username.getText(), pf_password.getText(), tf_email.getText());
                        DBUtils.registerHistory(tf_username.getText());
                        //izveido player objektu
                        player = new Player(tf_username.getText(),tf_email.getText(),pf_password.getText());
                        System.out.println(player);
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

        //pārslēdzas uz log-in skatu
        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "log-in.fxml", "Log in!", null);
            }
        });

    }


    //Papildus funkcijas

    //Funkcija, lai varētu izveidot Game objektu
    public static void makeGameObject(ArrayList<String> inputAllGuesses, boolean inputWinOrNot){
        Game game = new Game(inputAllGuesses, inputWinOrNot, player);
        System.out.println(game);
    }

    //Funkcija, lai izveido GameFlags objektu
    public static void makeGameFlagObject(ArrayList<String> inputAllGuesses,
                                          boolean inputWinOrNot, ArrayList<String> inputAllAnswers, int inputGuessesCount){
        GameFlags gameFlags = new GameFlags(inputAllGuesses, inputWinOrNot, player,inputAllAnswers, inputGuessesCount);
        System.out.println(gameFlags);
    }

    //Funkcija, lai izveido GameWordle objektu
    public static void makeGameWordleObject(ArrayList<String> inputAllGuesses,boolean inputWinOrNot,
                                            int inputLevel, String inputSecretWord, int inputGuessesCount){
        GameWordle gameWordle = new GameWordle(inputAllGuesses,inputWinOrNot,player,
                inputLevel,inputSecretWord,inputGuessesCount);
        System.out.println(gameWordle);
    }

    //Funkcija, lai izveido GameMemory objektu
    public static void makeGameMemoryObject(ArrayList<String> inputAllGuesses,
                                            boolean inputWinOrNot, int inputTurns){
        GameMemory gameMemory = new GameMemory(inputAllGuesses, inputWinOrNot, player, inputTurns);
        System.out.println(gameMemory);
    }


}
