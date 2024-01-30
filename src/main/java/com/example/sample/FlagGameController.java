package com.example.sample;

import Model.Country;
import Model.GameFlagFunctions;
import Model.GameWordle;
import Model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class FlagGameController implements Initializable {

    @FXML
    private ImageView image_flag;

    @FXML
    private Label label_score;

    @FXML
    private Button button_1, button_2, button_3, button_return, button_play;


    //Nepieciešamie mainīgie
    int score = 0;
    int rounds = 0;
    ArrayList<String> allGuesses = new ArrayList<String>();
    ArrayList<String> allAnswers = new ArrayList<String>();


    @Override
    public void initialize(URL url, ResourceBundle resourcesBundle) {

        //Pārslēdz skatu no flag-game to logged-in
        button_return.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"logged-in.fxml","Welcome!", null);
            }
        });

        //Iestatu skata sākumu
        setBeginingOfScene();

    }

    public void startGame(){

        //Atlieku defoltajās vietās un krāsās pogas
        button_play.setLayoutX(219);
        button_play.setLayoutY(355);
        button_play.setPrefHeight(31);
        button_play.setPrefWidth(133);

        button_1.setStyle("-fx-background-color: #8328CC;");
        button_2.setStyle("-fx-background-color: #8328CC;");
        button_3.setStyle("-fx-background-color: #8328CC;");
        label_score.setText("Score: "+score);

        //ļauju spēlēt spēli 10 reizes
        if(rounds<10) {

            //Izveidoju visas valstis
            GameFlagFunctions allCountries = new GameFlagFunctions();
            System.out.println(allCountries);

            //Paprasu, lai iedod spēles mainīgos
            Country answer = allCountries.giveOneCountry();
            Country extra1 = allCountries.giveOneRandomCountry();
            Country extra2 = allCountries.giveOneRandomCountry();

            //Pievienoju atbildi atbilšu ArrayListam
            allAnswers.add(answer.toString());

            System.out.println("Atbilde ==> " + answer);
            System.out.println("1. atbilžu variants ==> " +extra1);
            System.out.println("2. atbilžu variants ==> " +extra2);

            //izveidoju karoga bildi;
            Image imageForIm_flag = new Image(getClass().getResourceAsStream("/flag_images/" + answer.toString() +".png"));
            image_flag.setImage(imageForIm_flag);

            //izveidoju atbilžu variantu array listu, lai to pēc tam sajauktu
            ArrayList<String> all_choices = new ArrayList<String>();
            all_choices.add(answer.toString());
            all_choices.add(extra1.toString());
            all_choices.add(extra2.toString());

            //samaisu atbildes
            shuffleAnswers(all_choices);
            //System.out.println(all_choices);

            //pogās ielieku tekstu
            button_1.setText(all_choices.get(0));
            button_2.setText(all_choices.get(1));
            button_3.setText(all_choices.get(2));

            //Izveidoju pogām funkcionalitāti
            button_1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setScoreFromAnswers(button_1,answer);
                }
            });
            button_2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setScoreFromAnswers(button_2,answer);
                }
            });
            button_3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setScoreFromAnswers(button_3,answer);
                }
            });

        //Parādu rezultātu
        }else{
            //Izveido objektus
            SignUpController.makeGameObject(allGuesses,true);
            SignUpController.makeGameFlagObject(allGuesses,true,allAnswers, score);

            //nomainīt skatu un ielādēt visu
            Parent root = null;
            try{
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource("flags-leaderboard.fxml"));
                //ielādē objektus no fxml faila
                root = loader.load();
                FlagsLeaderboardController flagsLeaderboardController = loader.getController();
                flagsLeaderboardController.setLableScore(score);
            }catch (IOException e){
                e.printStackTrace();
            }

            //ievietoju iegūto score DB
            String inputScore = String.valueOf(score);
            DBUtils.saveFlagGameResultsInDB(inputScore);

            //atjaunoju mainīgo lielumus
            score = 0;
            rounds = 0;

            //atjaunoju sākuma skatu spēlei
            setBeginingOfScene();

            //Atveru jaunu logu, kur parādīsies FlagsLeaderboards
            Stage stage = new Stage();
            stage.setTitle("Flags Leaderboard!");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();

        }

    }

    //papildfunkcijas
    public void shuffleAnswers(ArrayList<String> list){
        //Izveidoju Random objektu
        Random myRandom = new Random();

        //izveidoju ciklu, kas strādās 50 reizes
        for(int i = 0; i <500; i++){
            int answerNo = myRandom.nextInt(list.size());
            String removedAnswer = list.get(answerNo);
            list.remove(answerNo);
            list.add(removedAnswer);

        }
    }

    public void setBeginingOfScene(){
        //Man netiek lādēta bilde pēc vienkāršās metodes
        try {
            // Assuming "answer" is a valid value
            String fileName = "Play" + ".png";
            String filePath = "/flag_images/" + fileName;

            // Check if the file exists
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            if (inputStream == null) {
                System.out.println("Error: Image file not found - " + fileName);
                // Handle the error as needed
            } else {
                Image imageForIm_flag = new Image(inputStream);
                image_flag.setImage(imageForIm_flag);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }

        //Settoju to kas man ir kā default un paslēpju pogas
        label_score.setText("");
        button_1.setStyle("-fx-background-color: white;");
        button_2.setStyle("-fx-background-color: white;");
        button_3.setStyle("-fx-background-color: white;");

        //Sākt spēli un Play pogu centrēju
        button_play.setLayoutX(190);
        button_play.setLayoutY(120);
        button_play.setPrefHeight(40);
        button_play.setPrefWidth(190);
        button_play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startGame();
            }
        });
    }

    public void setScoreFromAnswers(Button inputButton, Country inputAnswer){
        if (inputButton.getText().equals(inputAnswer.toString())) {
            score++;
            label_score.setText("Score: " + score);
        }
        System.out.println("Spēlētāja atbilde ==> " + inputButton.getText());
        rounds++;
        allGuesses.add(button_1.getText());
        startGame();
    }



}
