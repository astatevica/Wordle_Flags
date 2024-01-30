package com.example.sample;

import Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.*;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

public class DBUtils {
    //brains of operation

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username){
        Parent root = null;


        if (username != null){
            //loader ielādē skatu jeb izveido to
            try{
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                //ielādē objektus no fxml faila
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.setUserInformation(username);
            }catch (IOException e){
                e.printStackTrace();
            }
        } else{
            try{
                root = FXMLLoader.load(Objects.requireNonNull(DBUtils.class.getResource(fxmlFile)));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //Stage can give multiple scenes
        // (events ir klikšķis --> iegūst avotu) --> iegūst skatu un atver logu
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void signUpUser(ActionEvent event, String username, String password, String email){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;



        try{
            //izveido savienojumu ar datu bāzi
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordle_2023","root","edann130822");
            //pārbuda vai tāds username jau nepastāv
            psCheckUserExists = connection.prepareStatement("SELECT * FROM user_information WHERE username = ?");
            psCheckUserExists.setString(1,username);
            resultSet = psCheckUserExists.executeQuery();

            if(resultSet.isBeforeFirst()){
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username.");
                alert.show();
            }else{
                psInsert = connection.prepareStatement("INSERT INTO user_information (username, password, email) VALUES(?, ?, ?)");
                psInsert.setString(1,username);
                psInsert.setString(2,password);
                psInsert.setString(3,email);
                psInsert.executeUpdate();//for updating database


                changeScene(event,"logged-in.fxml","Welcome!", username);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(psCheckUserExists != null){
                try {
                    psCheckUserExists.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(psInsert != null){
                try {
                   psInsert.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, String username, String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Player player = new Player(username,null,password);
        System.out.println(player);

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordle_2023","root","edann130822");
            preparedStatement = connection.prepareStatement("SELECT password, email FROM user_information WHERE username = ? ");
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                System.out.println("User not found in the database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect!");
                alert.show();
            }else{
                while(resultSet.next()){
                    String retrievedPassword = resultSet.getString("password");
                    String retrievedEmail = resultSet.getString("email");
                    if(retrievedPassword.equals(password)){
                        changeScene(event,"logged-in.fxml","Welcome!", username);
                    }else{
                        System.out.println("Passwords did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The provided credentials are incorrect");
                        alert.show();
                    }
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void registerHistory(String username){
        Connection connection = null;
        PreparedStatement psInsert = null;

        Timestamp time = Timestamp.valueOf(LocalDateTime.now());

        try{
            //izveido savienojumu ar datu bāzi
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordle_2023","root","edann130822");

            psInsert = connection.prepareStatement("INSERT INTO history (username, RegTime) VALUES(?, ?)");
            psInsert.setString(1,username);
            psInsert.setTimestamp(2,time);
            psInsert.executeUpdate();//for updating database

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(psInsert != null){
                try {
                    psInsert.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveFlagGameResultsInDB(String inputScore){
        Connection connection = null;
        PreparedStatement psInsert = null;

        Timestamp time = Timestamp.valueOf(LocalDateTime.now());

        try{
            //izveido savienojumu ar datu bāzi
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordle_2023","root","edann130822");
            //izņemu datus no DB
            Statement dbGet = connection.createStatement();
            ResultSet getUsername = dbGet.executeQuery("SELECT username from history order by RegTime desc limit 1");
            while (getUsername.next()) {
                String username = getUsername.getString("username");
                //System.out.println(username);
                //ievietoju datus DB
                psInsert = connection.prepareStatement("INSERT INTO flag_leaderboard (username, score, time) VALUES(?, ?, ?)");
                psInsert.setString(1,username);
                psInsert.setString(2,inputScore);
                psInsert.setTimestamp(3,time);
                psInsert.executeUpdate();//for updating database
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(psInsert != null){
                try {
                    psInsert.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
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


