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
    private Label lb_score1, lb_score2, lb_score3,lb_score4, lb_score5;

    @FXML
    private Label lb_time1, lb_time2, lb_time3, lb_time4, lb_time5;

    String time1, time2, time3, time4, time5;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
                //label1
                Statement dbGetTimes1 = connection.createStatement();
                ResultSet lastTime1 = dbGetTimes1.executeQuery("SELECT time from flag_leaderboard\n" +
                        "where username = \""+username+"\" \n" +
                        "order by time desc \n" +
                        "limit 1");
                while (lastTime1.next()){
                    time1 = lastTime1.getString("time").trim();
                    System.out.println(time1);
                    if(time1 != null) {
                        lb_time1.setText(time1);

                        //score1
                        Statement dbGetScore1 = connection.createStatement();
                        ResultSet lastScores1 = dbGetScore1.executeQuery("SELECT score from flag_leaderboard\n" +
                                "where username = \"" + username + "\" \n" +
                                "order by time desc \n" +
                                "limit 1");
                        while (lastScores1.next()) {
                            String score1 = lastScores1.getString("score").trim();
                            System.out.println(score1);
                            lb_score1.setText(score1 + "/10");
                        }
                    }else{
                        lb_time1.setText("");
                        lb_score1.setText("");
                    }
                }

                //label2
                Statement dbGetTimes2 = connection.createStatement();
                ResultSet lastTime2 = dbGetTimes2.executeQuery("SELECT time from flag_leaderboard\n" +
                        "where username = \""+username+"\" \n" +
                        "order by time desc \n" +
                        "limit 2");
                while (lastTime2.next()){
                    time2 = lastTime2.getString("time").trim();
                    System.out.println(time2);

                    if(!(time2.equals(time1))) {
                        lb_time2.setText(time2);

                        Statement dbGetScore2 = connection.createStatement();
                        ResultSet lastScores2 = dbGetScore2.executeQuery("SELECT score from flag_leaderboard\n" +
                                "where username = \"" + username + "\" \n" +
                                "order by time desc \n" +
                                "limit 2");
                        while (lastScores2.next()) {
                            String score2 = lastScores2.getString("score").trim();
                            System.out.println(score2);
                            lb_score2.setText(score2 + "/10");
                        }
                    }else{
                        lb_time2.setText("");
                        lb_score2.setText("");
                    }
                }

                //label3
                Statement dbGetTimes3 = connection.createStatement();
                ResultSet lastTime3 = dbGetTimes3.executeQuery("SELECT time from flag_leaderboard\n" +
                        "where username = \""+username+"\" \n" +
                        "order by time desc \n" +
                        "limit 3");
                while (lastTime3.next()){
                    time3 = lastTime3.getString("time").trim();
                    System.out.println(time3);
                    if(!(time3.equals(time2))) {
                        lb_time3.setText(time3);

                        Statement dbGetScore3 = connection.createStatement();
                        ResultSet lastScores3 = dbGetScore3.executeQuery("SELECT score from flag_leaderboard\n" +
                                "where username = \"" + username + "\" \n" +
                                "order by time desc \n" +
                                "limit 3");
                        while (lastScores3.next()) {
                            String score3 = lastScores3.getString("score").trim();
                            System.out.println(score3);
                            lb_score3.setText(score3 + "/10");
                        }
                    }else{
                        lb_time3.setText("");
                        lb_score3.setText("");
                    }
                }

                //label4
                Statement dbGetTimes4 = connection.createStatement();
                ResultSet lastTime4 = dbGetTimes4.executeQuery("SELECT time from flag_leaderboard\n" +
                        "where username = \""+username+"\" \n" +
                        "order by time desc \n" +
                        "limit 4");
                while (lastTime4.next()){
                    time4 = lastTime4.getString("time").trim();
                    System.out.println(time4);
                    if(!time4.equals(time3)) {
                        lb_time4.setText(time4);

                        Statement dbGetScore4 = connection.createStatement();
                        ResultSet lastScores4 = dbGetScore4.executeQuery("SELECT score from flag_leaderboard\n" +
                                "where username = \"" + username + "\" \n" +
                                "order by time desc \n" +
                                "limit 4");
                        while (lastScores4.next()) {
                            String score4 = lastScores4.getString("score").trim();
                            System.out.println(score4);
                            lb_score4.setText(score4 + "/10");
                        }
                    }else{
                        lb_time4.setText("");
                        lb_score4.setText("");
                    }
                }

                //label5
                Statement dbGetTimes5 = connection.createStatement();
                ResultSet lastTime5 = dbGetTimes5.executeQuery("SELECT time from flag_leaderboard\n" +
                        "where username = \""+username+"\" \n" +
                        "order by time desc \n" +
                        "limit 5");
                while (lastTime5.next()){
                    time5 = lastTime5.getString("time").trim();
                    System.out.println(time5);
                    if(!time4.equals(time3)) {
                        lb_time5.setText(time5);

                        Statement dbGetScore5 = connection.createStatement();
                        ResultSet lastScores5 = dbGetScore5.executeQuery("SELECT score from flag_leaderboard\n" +
                                "where username = \"" + username + "\" \n" +
                                "order by time desc \n" +
                                "limit 5");
                        while (lastScores5.next()) {
                            String score5 = lastScores5.getString("score").trim();
                            System.out.println(score5);
                            lb_score5.setText(score5 + "/10");
                        }
                    }else{
                        lb_time5.setText("");
                        lb_score5.setText("");
                    }
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

    //papildus funkcijas
    public void setLableScore(int inputScore){
        lb_score.setText("Your score: " + inputScore + "/10");
    }


}
