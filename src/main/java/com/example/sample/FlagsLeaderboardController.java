package com.example.sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
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
        setScoreLable(lb_scoresFromDB);

    }

    //papildus funkcijas
    public void setLableScore(int inputScore){
        lb_score.setText("Your score: " + inputScore + "/10");
    }

    public void setScoreLable(Label inputScoreLabel){
        Connection connection = null;

        try{
            //izveido savienojumu ar datu bāzi
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordle_2023","root","edann130822");
            //izņemu username datus no DB
            Statement dbGet = connection.createStatement();
            ResultSet getUsername = dbGet.executeQuery("SELECT username from history order by RegTime desc limit 1");
            while (getUsername.next()) {
                String username = getUsername.getString("username");
                System.out.println(username);
                //izņemu pēdējos 5 spēļu rezultātu datus no DB
                Statement dbGetScores = connection.createStatement();
                ResultSet last5Scores = dbGetScores.executeQuery("SELECT score from flag_leaderboard\n" +
                        "where username = \""+username+"\" \n" +
                        "order by time desc \n" +
                        "limit 5");
                while (last5Scores.next()){
                    String scores = last5Scores.getString("score").trim();
                    System.out.println(scores);
                    inputScoreLabel.setText(scores);
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
