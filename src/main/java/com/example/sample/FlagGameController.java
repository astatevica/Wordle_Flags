package com.example.sample;

import Model.Country;
import Model.GameFlagFunctions;
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
    private Button button_1;

    @FXML
    private Button button_2;

    @FXML
    private Button button_3;

    @FXML
    private Button button_return;

    @FXML
    private Button button_play;


    //Nepieciešamie mainīgie
    int score = 0;
    int rounds = 0;


    @Override
    public void initialize(URL url, ResourceBundle resourcesBundle) {

        //Pārslēdz skatu no flag-game to logged-in
        button_return.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"logged-in.fxml","Log in!", null);
            }
        });

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

            System.out.println(answer);
            System.out.println(extra1);
            System.out.println(extra2);

            //izveidoju karoga bildi;
            try {
                // Assuming "answer" is a valid value
                String fileName = answer.toString() + ".png";
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

            //izveidoju atbilžu variantu array listu
            ArrayList<String> all_choices = new ArrayList<String>();
            System.out.println(all_choices);
            all_choices.add(answer.toString());
            all_choices.add(extra1.toString());
            all_choices.add(extra2.toString());

            //samaisu atbildes
            shuffleAnswers(all_choices);
            System.out.println(all_choices);

            //pogās ielieku tekstu
            button_1.setText(all_choices.get(0));
            button_2.setText(all_choices.get(1));
            button_3.setText(all_choices.get(2));

            //Izveidoju pogām funkcionalitāti
            button_1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (button_1.getText().equals(answer.toString())) {
                        score++;
                        label_score.setText("Score: " + score);
                    }
                    rounds++;
                    startGame();
                }
            });
            button_2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (button_2.getText().equals(answer.toString())) {
                        score++;
                        label_score.setText("Score: " + score);
                    }
                    rounds++;
                    startGame();
                }
            });
            button_3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (button_3.getText().equals(answer.toString())) {
                        score++;
                        label_score.setText("Score: " + score);
                    }
                    rounds++;
                    startGame();
                }
            });

        //Parādu rezultātu
        }else{
            //TODO nepieciešams pabeigt
            //saveResultsInDB(score);


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

            //ievieroju iegūto score DB
            String inputScore = String.valueOf(score);
            DBUtils.saveFlagGameResultsInDB(inputScore);

            score = 0;
            rounds = 0;
            setBeginingOfScene();
            //Stage can give multiple scenes
            // (events ir klikšķis --> iegūst avotu) --> iegūst skatu un atver logu
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



}
