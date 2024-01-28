package com.example.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MemoryController extends Thread{
    
    @FXML
    Button doneButton, forfeitButton;
    @FXML
    Label turnLabel;
    @FXML
    Button memoryButton1, memoryButton2, memoryButton3, memoryButton4, memoryButton5, memoryButton6, memoryButton7, memoryButton8, memoryButton9, memoryButton10,
    memoryButton11, memoryButton12, memoryButton13, memoryButton14, memoryButton15, memoryButton16, memoryButton17, memoryButton18, memoryButton19, memoryButton20,
    memoryButton21, memoryButton22, memoryButton23, memoryButton24, memoryButton25, memoryButton26, memoryButton27, memoryButton28, memoryButton29, memoryButton30,
    memoryButton31, memoryButton32, memoryButton33, memoryButton34, memoryButton35, memoryButton36, memoryButton37, memoryButton38, memoryButton39, memoryButton40,
    memoryButton41, memoryButton42, memoryButton43, memoryButton44, memoryButton45, memoryButton46, memoryButton47, memoryButton48, memoryButton49, memoryButton50,
    memoryButton51, memoryButton52, memoryButton53, memoryButton54, memoryButton55, memoryButton56, memoryButton57, memoryButton58, memoryButton59, memoryButton60,
    memoryButton61, memoryButton62, memoryButton63, memoryButton64, memoryButton65, memoryButton66, memoryButton67, memoryButton68, memoryButton69, memoryButton70;

    @FXML
    ImageView imageViewBttn1, imageViewBttn2, imageViewBttn3, imageViewBttn4, imageViewBttn5, imageViewBttn6, imageViewBttn7, imageViewBttn8, imageViewBttn9, imageViewBttn10,
    imageViewBttn11, imageViewBttn12, imageViewBttn13, imageViewBttn14, imageViewBttn15, imageViewBttn16, imageViewBttn17, imageViewBttn18, imageViewBttn19, imageViewBttn20,
    imageViewBttn21, imageViewBttn22, imageViewBttn23, imageViewBttn24, imageViewBttn25, imageViewBttn26, imageViewBttn27, imageViewBttn28, imageViewBttn29, imageViewBttn30,
    imageViewBttn31, imageViewBttn32, imageViewBttn33, imageViewBttn34, imageViewBttn35, imageViewBttn36, imageViewBttn37, imageViewBttn38, imageViewBttn39, imageViewBttn40,
    imageViewBttn41, imageViewBttn42, imageViewBttn43, imageViewBttn44, imageViewBttn45, imageViewBttn46, imageViewBttn47, imageViewBttn48, imageViewBttn49, imageViewBttn50,
    imageViewBttn51, imageViewBttn52, imageViewBttn53, imageViewBttn54, imageViewBttn55, imageViewBttn56, imageViewBttn57, imageViewBttn58, imageViewBttn59, imageViewBttn60,
    imageViewBttn61, imageViewBttn62, imageViewBttn63, imageViewBttn64, imageViewBttn65, imageViewBttn66, imageViewBttn67, imageViewBttn68, imageViewBttn69, imageViewBttn70;

    ArrayList<ImageView> imageViewButtons = new ArrayList<ImageView>();
    ArrayList<Button> allButtons = new ArrayList<Button>();
    Dictionary<String, ArrayList<Button>> buttonPairDict = new Hashtable<>();
    
    ArrayList<Integer> clickedOnButtonsInt = new ArrayList<Integer>();
    ArrayList<Button> clickedOnButtonsBttn = new ArrayList<Button>();            
    //ArrayBlockingQueue<Button> clickedOnButtonsBttn = new ArrayBlockingQueue(5);                      
    ArrayBlockingQueue<Integer> clickedOnButtonsLocationInAllButtons = new ArrayBlockingQueue(5); 
    ArrayList<Button> disabledButtons = new ArrayList<Button>();

    float turns = 0;
    int pairsLeft = 35;
    private Timeline timeline = new Timeline();


    public void initialize(){
        doneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "logged-in.fxml","Welcome!",null);
            }
        });
    	timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), event -> {
			
            clickedOnButtonsBttn.get(0).setDisable(false);
            clickedOnButtonsBttn.get(1).setDisable(false);

			imageViewButtons.get(clickedOnButtonsLocationInAllButtons.poll()).imageProperty().set(null);
			imageViewButtons.get(clickedOnButtonsLocationInAllButtons.poll()).imageProperty().set(null);
            

            clickedOnButtonsInt.remove(0);
            clickedOnButtonsInt.remove(0);
            clickedOnButtonsBttn.remove(0);
            clickedOnButtonsBttn.remove(0);
            clickedOnButtonsLocationInAllButtons.clear();

            //TODO Enable all buttons
            for (int i = 0; i < allButtons.size(); i++){
                allButtons.get(i).setDisable(false);
            }
            for (int i = 0; i < disabledButtons.size(); i++){
                disabledButtons.get(i).setDisable(true);
            }
        }));
    	
        Random rand = new Random();

        Collections.addAll(allButtons, memoryButton1, memoryButton2, memoryButton3, memoryButton4, memoryButton5, memoryButton6, memoryButton7, memoryButton8, memoryButton9, memoryButton10,
        memoryButton11, memoryButton12, memoryButton13, memoryButton14, memoryButton15, memoryButton16, memoryButton17, memoryButton18, memoryButton19, memoryButton20,
        memoryButton21, memoryButton22, memoryButton23, memoryButton24, memoryButton25, memoryButton26, memoryButton27, memoryButton28, memoryButton29, memoryButton30,
        memoryButton31, memoryButton32, memoryButton33, memoryButton34, memoryButton35, memoryButton36, memoryButton37, memoryButton38, memoryButton39, memoryButton40,
        memoryButton41, memoryButton42, memoryButton43, memoryButton44, memoryButton45, memoryButton46, memoryButton47, memoryButton48, memoryButton49, memoryButton50,
        memoryButton51, memoryButton52, memoryButton53, memoryButton54, memoryButton55, memoryButton56, memoryButton57, memoryButton58, memoryButton59, memoryButton60,
        memoryButton61, memoryButton62, memoryButton63, memoryButton64, memoryButton65, memoryButton66, memoryButton67, memoryButton68, memoryButton69, memoryButton70);

        ArrayList<String> dictKeys = new ArrayList<String>(Arrays.asList("1",
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
            "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35"));

        
        for(int i = 0; i < dictKeys.size(); i++){

            int one = 1000;
            int two = 100;

            if(allButtons.size() != 2){
                one = rand.nextInt(allButtons.size()-1);
                do{
                    two = rand.nextInt(allButtons.size()-1);
                }while(one == two);

            }else{
                one = 0;
                two = 1;
            }
           
            buttonPairDict.put(dictKeys.get(i), new ArrayList<Button>(Arrays.asList(allButtons.get(one), allButtons.get(two))));

            if(two >= one){
                allButtons.remove(two);
                allButtons.remove(one);
            }else{
                allButtons.remove(one);
                allButtons.remove(two);
            }
            
        }
        

        Collections.addAll(allButtons, memoryButton1, memoryButton2, memoryButton3, memoryButton4, memoryButton5, memoryButton6, memoryButton7, memoryButton8, memoryButton9, memoryButton10,
        memoryButton11, memoryButton12, memoryButton13, memoryButton14, memoryButton15, memoryButton16, memoryButton17, memoryButton18, memoryButton19, memoryButton20,
        memoryButton21, memoryButton22, memoryButton23, memoryButton24, memoryButton25, memoryButton26, memoryButton27, memoryButton28, memoryButton29, memoryButton30,
        memoryButton31, memoryButton32, memoryButton33, memoryButton34, memoryButton35, memoryButton36, memoryButton37, memoryButton38, memoryButton39, memoryButton40,
        memoryButton41, memoryButton42, memoryButton43, memoryButton44, memoryButton45, memoryButton46, memoryButton47, memoryButton48, memoryButton49, memoryButton50,
        memoryButton51, memoryButton52, memoryButton53, memoryButton54, memoryButton55, memoryButton56, memoryButton57, memoryButton58, memoryButton59, memoryButton60,
        memoryButton61, memoryButton62, memoryButton63, memoryButton64, memoryButton65, memoryButton66, memoryButton67, memoryButton68, memoryButton69, memoryButton70);

        Collections.addAll(imageViewButtons, imageViewBttn1, imageViewBttn2, imageViewBttn3, imageViewBttn4, imageViewBttn5, imageViewBttn6, imageViewBttn7, imageViewBttn8, imageViewBttn9, imageViewBttn10,
        imageViewBttn11, imageViewBttn12, imageViewBttn13, imageViewBttn14, imageViewBttn15, imageViewBttn16, imageViewBttn17, imageViewBttn18, imageViewBttn19, imageViewBttn20,
        imageViewBttn21, imageViewBttn22, imageViewBttn23, imageViewBttn24, imageViewBttn25, imageViewBttn26, imageViewBttn27, imageViewBttn28, imageViewBttn29, imageViewBttn30,
        imageViewBttn31, imageViewBttn32, imageViewBttn33, imageViewBttn34, imageViewBttn35, imageViewBttn36, imageViewBttn37, imageViewBttn38, imageViewBttn39, imageViewBttn40,
        imageViewBttn41, imageViewBttn42, imageViewBttn43, imageViewBttn44, imageViewBttn45, imageViewBttn46, imageViewBttn47, imageViewBttn48, imageViewBttn49, imageViewBttn50,
        imageViewBttn51, imageViewBttn52, imageViewBttn53, imageViewBttn54, imageViewBttn55, imageViewBttn56, imageViewBttn57, imageViewBttn58, imageViewBttn59, imageViewBttn60,
        imageViewBttn61, imageViewBttn62, imageViewBttn63, imageViewBttn64, imageViewBttn65, imageViewBttn66, imageViewBttn67, imageViewBttn68, imageViewBttn69, imageViewBttn70);


        doneButton.setDisable(true);



    }


    @FXML
    public void doneGame(ActionEvent event) throws IOException{
    }
    @FXML
    public void forfeitGame(ActionEvent event) throws IOException{
        doneButton.setDisable(false);
        forfeitButton.setDisable(true);

        for(int i = 0; i < allButtons.size(); i++){
            allButtons.get(i).setDisable(true);
        }
    }


    public void buttonClicked(ActionEvent event) throws IOException{


        turns += 0.5;
        turnLabel.setText("Turns: " + (int)turns);
        
        
        int location = 11111;
        for(int i = 0; i < allButtons.size(); i++){

            if(event.getSource().equals(allButtons.get(i))){
                clickedOnButtonsLocationInAllButtons.add(i);
                
                Enumeration<String> k = buttonPairDict.keys();
                for(int j = 0; j < buttonPairDict.size(); j++){
                    ArrayList<Button> a = buttonPairDict.get(k.nextElement());
                    if(event.getSource().equals(a.get(0))){
                        clickedOnButtonsBttn.add(a.get(0));
                        a.get(0).setDisable(true);
                        location = j;
                        break;
                    } else if (event.getSource().equals(a.get(1))){
                        a.get(1).setDisable(true);
                        clickedOnButtonsBttn.add(a.get(1));
                        location = j;
                        break;
                    }
                }
                
                location += 1;

                Image alphaImage = new Image(getClass().getResourceAsStream("/memoryPictures/Alpha" + location + ".png"));
                imageViewButtons.get(i).setImage(alphaImage);
                clickedOnButtonsInt.add(location);
                break;
            }

        }


        if(clickedOnButtonsInt.size() == 2){

            //TODO Disable all buttons
            for (int i = 0; i < allButtons.size(); i++){
                allButtons.get(i).setDisable(true);
            }


            if(clickedOnButtonsInt.get(0) == clickedOnButtonsInt.get(1)){
                
                disabledButtons.add(clickedOnButtonsBttn.get(0));
                disabledButtons.add(clickedOnButtonsBttn.get(1));

                clickedOnButtonsBttn.get(0).setDisable(true);
                clickedOnButtonsBttn.get(1).setDisable(true);
                
                pairsLeft--;

                if(pairsLeft == 0){
                    forfeitButton.setDisable(true);
                    doneButton.setDisable(false);
                }

                clickedOnButtonsInt.remove(0);
                clickedOnButtonsInt.remove(0);
                clickedOnButtonsBttn.remove(0);
                clickedOnButtonsBttn.remove(0);
                clickedOnButtonsLocationInAllButtons.clear();
                    
                for (int i = 0; i < allButtons.size(); i++){
                    allButtons.get(i).setDisable(false);
                }
                for (int i = 0; i < disabledButtons.size(); i++){
                    disabledButtons.get(i).setDisable(true);
                }
                
            }else{
            	timeline.play();
            }

        }


    }

}