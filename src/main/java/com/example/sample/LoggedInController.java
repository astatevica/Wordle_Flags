package com.example.sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button button_logout;

    @FXML
    private Label lable_welcome;

    @FXML
    private Button button_wordle;

    @FXML
    private  Button button_flags;

    @FXML
    private ImageView im_wordle;

    @FXML
    private ImageView im_flags;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Pārslēdz skatu no logged-in to sample
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Daļa koda nāk no DBUtils
                DBUtils.changeScene(event,"log-in.fxml","Log in!", null);
            }
        });

        //Pārslēdz skatu no logged-in to flags
        button_flags.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "flags.fxml", "Flag game!", null);
            }
        });

        loadPicture("flag_game",im_flags);
        loadPicture("wordle_game",im_wordle);

        lable_welcome.setText("Choose game!");

        button_wordle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "LevelSelector.fxml", "Wordle", null);
            }
        });
    }

    //parādīs kas ir ielogojies
    public void setUserInformation(String username){
        lable_welcome.setText("Welcome " + username + "!");
    }

    public void loadPicture(String inputName, ImageView imageViewName) {
        try {
            String fileName = inputName + ".jpg";
            String filePath = "/other_images/" + fileName;

            // Check if the file exists
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            if (inputStream == null) {
                System.out.println("Error: Image file not found - " + fileName);
                // Handle the error as needed
            } else {
                Image imageForIm_flag = new Image(inputStream);
                imageViewName.setImage(imageForIm_flag);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

}
