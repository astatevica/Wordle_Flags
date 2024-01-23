package com.example.sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LevelSelectorController{
    

    private Stage primaryStage;
    private Scene scene;
    private Parent root;
    private AnchorPane levelSelectorPane;

    @FXML
    private Button buttonLVL1, buttonLVL2, buttonLVL3, backLevelSelectorButton;


    @FXML
    public void openLevel1(ActionEvent event) throws IOException {
        
        String level = "Level 1";

        // root = FXMLLoader.load(getClass().getResource("Level1.fxml"));
        // primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // primaryStage.setScene(scene);
        // primaryStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Level1.fxml"));
        root = loader.load();

        LevelController levelController = loader.getController();
        levelController.initialize(level);

        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    public void openLevel2(ActionEvent event) throws IOException{

        String level = "Level 2";
        
        // root = FXMLLoader.load(getClass().getResource("Level2.fxml"));
        // primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // primaryStage.setScene(scene);
        // primaryStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Level2.fxml"));
        root = loader.load();

        LevelController levelController = loader.getController();
        levelController.initialize(level);

        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void openLevel3(ActionEvent event) throws IOException{
        
         String level = "Level 3";
        
        // root = FXMLLoader.load(getClass().getResource("Level2.fxml"));
        // primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // primaryStage.setScene(scene);
        // primaryStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Level3.fxml"));
        root = loader.load();

        LevelController levelController = loader.getController();
        levelController.initialize(level);

        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void backLevelSelector(ActionEvent event) {
        DBUtils.changeScene(event,"logged-in.fxml", "Welcome!", null);
    }






}
