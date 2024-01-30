package com.example.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LevelController {
    
    //TODO make less lives difficulty
    //TODO make time based difficulty
    //Many variables have 1 added to them because i was planning on making a controller for each level... but that was not necessary


    //"ARROW", "HUMAN", "HOUSE", "CLOTH", "CLOWN", "ENEMY", "POWER"

    //Variables for the game
    // private static ArrayList<String> fiveLetterWords = new ArrayList<String>(Arrays.asList("HOUSE"));
    // private static ArrayList<String> sixLetterWords = new ArrayList<String>(Arrays.asList("AXIOMS"));
    // private static ArrayList<String> sevenLetterWords = new ArrayList<String>(Arrays.asList("COURAGE"));
    private static String secretWord;
    private static int lives;
    private static ArrayList<Character> greenLetters;

    ArrayList<String> allGuesses;


    @FXML   
    private Label wordleLable1, levelLable1, enterWordLabel1, resultMessage1, resultMessage11;
    @FXML
    private TextField answerBox1;
    @FXML
    private Button doneGameButton1, submitButton1, forfeitButton1;
    @FXML
    private AnchorPane scenePane1;

    //Wordle letters
    @FXML
    private ImageView word1Letter1, word1Letter2, word1Letter3, word1Letter4, word1Letter5, word1Letter6, word1Letter7;
    @FXML
    private ImageView word2Letter1, word2Letter2, word2Letter3, word2Letter4, word2Letter5, word2Letter6, word2Letter7;
    @FXML
    private ImageView word3Letter1, word3Letter2, word3Letter3, word3Letter4, word3Letter5, word3Letter6, word3Letter7;
    @FXML
    private ImageView word4Letter1, word4Letter2, word4Letter3, word4Letter4, word4Letter5, word4Letter6, word4Letter7;
    @FXML
    private ImageView word5Letter1, word5Letter2, word5Letter3, word5Letter4, word5Letter5, word5Letter6, word5Letter7;
    @FXML
    private ImageView word6Letter1, word6Letter2, word6Letter3, word6Letter4, word6Letter5, word6Letter6, word6Letter7;

    //For coloring wordle letters
    ArrayList<ImageView> word1ArrayList = new ArrayList<ImageView>();
    ArrayList<ImageView> word2ArrayList = new ArrayList<ImageView>();
    ArrayList<ImageView> word3ArrayList = new ArrayList<ImageView>();
    ArrayList<ImageView> word4ArrayList = new ArrayList<ImageView>();
    ArrayList<ImageView> word5ArrayList = new ArrayList<ImageView>();
    ArrayList<ImageView> word6ArrayList = new ArrayList<ImageView>();

    //Top of screen letters
    @FXML
    private ImageView a1box, b1box, c1box, d1box, e1box, f1box, g1box, h1box, i1box, j1box, k1box, l1box, m1box;
    @FXML
    private ImageView n1box, o1box, p1box, q1box, r1box, s1box, t1box, u1box, v1box, w1box, x1box, y1box, z1box;


    //For colorKeyboard function AKA letters ath the top of screen
    ArrayList<ImageView> topLetters = new ArrayList<ImageView>();
    Dictionary<Character, ArrayList<String>> imageDict = new Hashtable<>();

    String userGuess;
    int levelForClass;
    boolean winOrNot;

    @FXML
    public void initialize(String level){
        allGuesses = new ArrayList<String>();
        winOrNot = false;
        levelForClass = Character.getNumericValue(level.charAt(6));

        Random rand = new Random();

        lives = 6;
        greenLetters = new ArrayList<Character>();

        // Gets a random word from the correct txt file
        if (level.equals("Level 1")){
            try {
                //Count how many words are in the list with code
                // BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\words\\5letterWords.txt"));

                // int lineCount = 0;
                // while(reader.readLine() != null){
                //     lineCount++;
                // }
                // reader.close();

                int lineCount = 5757;

                int secretWordLocation = rand.nextInt(1, lineCount);

                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/words/5letterWords.txt"));
                lineCount = 0;
                while(lineCount != secretWordLocation){
                    secretWord = reader.readLine().toUpperCase();
                    lineCount++;
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            //secretWord = getSecretWord1(fiveLetterWords).toUpperCase(); 

        }else if(level.equals("Level 2")){
            try {
                // BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\words\\6letterWords.txt"));

                // int lineCount = 0;
                // while(reader.readLine() != null){
                //     lineCount++;
                // }
                // reader.close();

                int lineCount = 141;

                int secretWordLocation = rand.nextInt(1, lineCount);

                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/words/6letterWords.txt"));
                lineCount = 0;
                while(lineCount != secretWordLocation){
                    secretWord = reader.readLine().toUpperCase();
                    lineCount++;
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            //secretWord = getSecretWord1(sixLetterWords).toUpperCase();

        }else if(level.equals("Level 3")){
            try {
                // BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\words\\7letterWords.txt"));

                // int lineCount = 0;
                // while(reader.readLine() != null){
                //     lineCount++;
                // }
                // reader.close();
                
                int lineCount = 501;

                int secretWordLocation = rand.nextInt(1, lineCount);

                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/words/7letterWords.txt"));
                lineCount = 0;
                while(lineCount != secretWordLocation){
                    secretWord = reader.readLine().toUpperCase();
                    lineCount++;
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            //secretWord = getSecretWord1(sevenLetterWords).toUpperCase();

        }
        
        ArrayList<Character> dictKeys = new ArrayList<Character>(Arrays.asList('A',
         'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        
        //Makes a dictionary to save a lot of lines of code for function colorKeyboard
        for(int i = 0; i < 26; i++){
            imageDict.put(dictKeys.get(i), new ArrayList<String>(Arrays.asList(dictKeys.get(i) + "_red", dictKeys.get(i) + "_orange", dictKeys.get(i) + "_green")));
        }


        //Need this for function displayColoredLetters
        Collections.addAll(word1ArrayList, word1Letter1, word1Letter2, word1Letter3, word1Letter4, word1Letter5, word1Letter6, word1Letter7);
        Collections.addAll(word2ArrayList, word2Letter1, word2Letter2, word2Letter3, word2Letter4, word2Letter5, word2Letter6, word2Letter7);
        Collections.addAll(word3ArrayList, word3Letter1, word3Letter2, word3Letter3, word3Letter4, word3Letter5, word3Letter6, word3Letter7);
        Collections.addAll(word4ArrayList, word4Letter1, word4Letter2, word4Letter3, word4Letter4, word4Letter5, word4Letter6, word4Letter7);
        Collections.addAll(word5ArrayList, word5Letter1, word5Letter2, word5Letter3, word5Letter4, word5Letter5, word5Letter6, word5Letter7);
        Collections.addAll(word6ArrayList, word6Letter1, word6Letter2, word6Letter3, word6Letter4, word6Letter5, word6Letter6, word6Letter7);


        //Need this for function colorKeyboard... Where depending on the index it changes the correct ImageView slot
        Collections.addAll(topLetters, z1box, y1box, x1box, w1box, v1box, u1box, t1box, s1box, r1box, q1box, p1box, o1box, n1box, m1box, l1box, k1box, j1box,
        i1box, h1box, g1box, f1box, e1box, d1box, c1box, b1box, a1box);
        

        //I dont want the player to be able to press done button without losing or winning the game
        doneGameButton1.setDisable(true);

    }


    //Submit answer button
    @FXML
    public void submitAnswer1(ActionEvent event) {
        userGuess = answerBox1.getText().toUpperCase();

        //Stops user from being able to use some buttons after winning
        if(userGuess.equals(secretWord)){
            allGuesses.add(userGuess);
            disableThings();
            displayResultLabels(userGuess);
            SignUpController.makeGameWordleObject(allGuesses,winOrNot,levelForClass,secretWord,(6-lives));
        }

        //If correct user input then go through to the letter check
        if (userGuess.length() == secretWord.length() && userGuess.matches("[a-zA-Z]{"+ secretWord.length() +"}")){
            allGuesses.add(userGuess);
            answerBox1.clear();
            checkGuess1(userGuess, secretWord);
            lives -= 1;
        }

        if (lives == 0){
            disableThings();
            displayResultLabels(userGuess);
            SignUpController.makeGameWordleObject(allGuesses,winOrNot,levelForClass,secretWord,(6-lives));
            System.out.println(allGuesses.toString());
        }

    }


    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    
    //Done button
    //Goes back to level selector
    @FXML
    public void doneGame1(ActionEvent event) throws IOException{
        // primaryStage = (Stage) scenePane1.getScene().getWindow();   
        // primaryStage.close();

        root = FXMLLoader.load(getClass().getResource("LevelSelector.fxml"));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //Forfeit the game button
    @FXML
    public void forfeit1(ActionEvent event){
        lives = 0;
        disableThings();
        displayResultLabels("XXXXX");
        SignUpController.makeGameWordleObject(allGuesses,winOrNot,levelForClass,secretWord,(6-lives));
    }


    // public static String getSecretWord1(ArrayList<String> listOfWords) {
	// 	Random rand = new Random();
	// 	String secretWord = listOfWords.get(rand.nextInt(listOfWords.size()));
	// 	return secretWord;
	// }


    //Function where userGuess gets compared to secretWord and then creates an ArrayList with Image names
    public void checkGuess1(String userGuess, String secretWord) {

		ArrayList<Character> redLetters = new ArrayList<Character>();
	    ArrayList<Character> orangeLetters = new ArrayList<Character>();

        ArrayList<String> lettersWithColors = new ArrayList<String>();
		for(int i = 0; i < secretWord.length(); i++) {
			lettersWithColors.add("?");
		}

    
        for(int i = 0; i < secretWord.length(); i++) {
                        
            if(userGuess.charAt(i) == secretWord.charAt(i)) {
                //Makes a list with correctly placed used letters
                greenLetters.add(userGuess.charAt(i));


                //Letter + Green (In secret word, with correct placement)
                lettersWithColors.set(i, userGuess.charAt(i) + "_green");

            }else{
                for(int j = 0; j < secretWord.length(); j++) {
                    //Makes a list with correct letters incorrectly placed
                    if(userGuess.charAt(i) == secretWord.charAt(j)) {
                        //Letter + Orange (In secret word, without correct placement)
                        lettersWithColors.set(i, userGuess.charAt(i) + "_orange");
                        
            
                        //Makes a list with letters in secret word, but incorrectly placed
                        if(!orangeLetters.contains(userGuess.charAt(i))){
                            orangeLetters.add(userGuess.charAt(i));
                        }
                    }
                }

                //Makes a list with letters not in the secret word
                if(!orangeLetters.contains(userGuess.charAt(i)) && !redLetters.contains(userGuess.charAt(i))) {
                    redLetters.add(userGuess.charAt(i));
                }


                //Letter + Gray (Not in secret word)
                if(redLetters.contains(userGuess.charAt(i))){
                    lettersWithColors.set(i, userGuess.charAt(i) + "_red");
                }
            }
        }

        displayColoredLetters1(lettersWithColors);
        colorKeyboard(lettersWithColors);

    } 


    //Wordle user guess letter coloring
    public void displayColoredLetters1(ArrayList<String> lettersWithColors){
        
        Image letterOne = new Image(getClass().getResourceAsStream("/PictureOfLetters/" + lettersWithColors.get(0) +".jpg"));
        Image letterTwo = new Image(getClass().getResourceAsStream("/PictureOfLetters/" + lettersWithColors.get(1) +".jpg"));
        Image letterThree = new Image(getClass().getResourceAsStream("/PictureOfLetters/" + lettersWithColors.get(2) +".jpg"));
        Image letterFour = new Image(getClass().getResourceAsStream("/PictureOfLetters/" + lettersWithColors.get(3) +".jpg"));
        Image letterFive = new Image(getClass().getResourceAsStream("/PictureOfLetters/" + lettersWithColors.get(4) +".jpg"));
        Image letterSix = new Image(getClass().getResourceAsStream("/PictureOfLetters/default.jpg"));
        Image letterSeven = new Image(getClass().getResourceAsStream("/PictureOfLetters/default.jpg"));

        if(secretWord.length() >= 6){
            letterSix = new Image(getClass().getResourceAsStream("/PictureOfLetters/" + lettersWithColors.get(5) +".jpg"));
        }
        if(secretWord.length() >= 7){
            letterSeven = new Image(getClass().getResourceAsStream("/PictureOfLetters/" + lettersWithColors.get(6) +".jpg"));
        }

        ArrayList <Image> gameLetterImageList = new ArrayList<Image>();
        Collections.addAll(gameLetterImageList, letterOne, letterTwo, letterThree, letterFour, letterFive, letterSix, letterSeven);


        for(int i = 0; i < secretWord.length(); i++){
            if (lives == 6){
                word1ArrayList.get(i).setImage(gameLetterImageList.get(i));
            } else if (lives == 5){
                word2ArrayList.get(i).setImage(gameLetterImageList.get(i));
            } else if (lives == 4){
                word3ArrayList.get(i).setImage(gameLetterImageList.get(i));
            } else if (lives == 3){
                word4ArrayList.get(i).setImage(gameLetterImageList.get(i));
            } else if (lives == 2){
                word5ArrayList.get(i).setImage(gameLetterImageList.get(i));
            } else if (lives == 1){
                word6ArrayList.get(i).setImage(gameLetterImageList.get(i));
            } 
        }

    }


    //Disables buttons when the game is over and enables the ability to quit the game
    public void disableThings(){
        submitButton1.setDisable(true);
        answerBox1.setDisable(true);
        forfeitButton1.setDisable(true);
        doneGameButton1.setDisable(false);
    }


    //There are 2 empty labels above the done button, that get filled out when the game is over
    public void displayResultLabels(String userGuess){
        if (userGuess.equals(secretWord)){
            resultMessage1.setText("You win");
            resultMessage11.setText("Word was: " + secretWord);
        } else if (lives == 0){
            resultMessage1.setText("You lose");
            resultMessage11.setText("Word was: " + secretWord);
        }
    }

    
    //This function colors the top letters of the game
    public void colorKeyboard(ArrayList<String> lettersWithColors){

        for(int i = 0; i < secretWord.length(); i++){
            Enumeration<Character> k = imageDict.keys();

            for(int j = 0; j < imageDict.size(); j++){
                ArrayList<String> a = imageDict.get(k.nextElement());

                if (lettersWithColors.get(i).charAt(0) == a.get(0).charAt(0)){
                    
                    if (lettersWithColors.get(i).equals(a.get(0)) || 
                    lettersWithColors.get(i).equals(a.get(1)) && !greenLetters.contains(lettersWithColors.get(i).charAt(0)) || 
                    lettersWithColors.get(i).equals(a.get(2))){

                        Image letter = new Image(getClass().getResourceAsStream("/PictureOfLetters/" + lettersWithColors.get(i) +".jpg"));
                        topLetters.get(j).setImage(letter);
                    }
                }
            }
        }
    }




}
