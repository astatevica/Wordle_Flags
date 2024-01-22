package com.example.sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FlagsLeaderboardController implements Initializable{

    @FXML
    private Label lb_score;

    @FXML
    private Label lb_scoresFromDB;

    @FXML
    private Label lb_timesFromDB;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //papildus funkcijas
    public void setLableScore(int inputScore){
        lb_score.setText("Your score: " + inputScore + "/10");
    }
}
