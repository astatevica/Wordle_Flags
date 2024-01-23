package com.example.sample;

import Model.GameGuessNumbers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NumbersController implements Initializable {
    @FXML
    private Label lb_choice;

    @FXML
    private TextField tf_digits;

    @FXML
    private Button button_submit;

    @FXML
    private Label lb_guess1, lb_guess2, lb_guess3, lb_guess4, lb_guess5, lb_guess6;

    @FXML
    private Label lb_digits1, lb_digits2, lb_digits3, lb_digits4, lb_digits5, lb_digits6;

    @FXML
    private Label lb_position1, lb_position2, lb_position3, lb_position4, lb_position5, lb_position6;

    @FXML
    private Label lb_results;

    private int digits = 0;
    private String numberToGuess;
    int rounds = 1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tf_digits.setPromptText("Choose numbers from 4-8!");
        String chosenDigits = tf_digits.getText().trim();


        switch (chosenDigits) {
            case "4" -> digits = 4;
            case "5" -> digits = 5;
            case "6" -> digits = 6;
            case "7" -> digits = 7;
            case "8" -> digits = 8;
        }

        numberToGuess = GameGuessNumbers.ganerateNumber(digits);

        button_submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startGame();
            }
        });


    }

    public void startGame() {
        tf_digits.setPromptText("Type some numbers!");
        lb_choice.setText(tf_digits.getText() + " digits");

        button_submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (rounds != 7 && !tf_digits.getText().equals(numberToGuess)) {
                    lb_guess1.setText(tf_digits.getText().trim());
                    lb_digits1.setText(String.valueOf(GameGuessNumbers.correctDigits(numberToGuess, tf_digits.getText().trim())));
                    lb_position1.setText(String.valueOf(GameGuessNumbers.numbersInCorrectPosition(numberToGuess, tf_digits.getText().trim())));
                    rounds++;
                } else {
                    lb_results.setText("Completed! " + rounds + " Guesses");
                }
            }
        });



    }
}



