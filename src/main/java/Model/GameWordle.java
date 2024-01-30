package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GameWordle extends Game{
    //variable
    private int level;
    private String secretWord;
    private int guessesCount;

    //getters
    public int getLevel() {
        return level;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public int getGuessesCount() {
        return guessesCount;
    }

    //setters
    public void setLevel(int inputLevel){
        if(inputLevel>0 && inputLevel<=3){
            level = inputLevel;
        }else{
            level = 1;
        }
    }

    public void setSecretWord(String inputSecretWord){
        if(inputSecretWord != null){
            secretWord = inputSecretWord;
        }else{
            secretWord = "APPLE";
        }
    }

    public void setGuessesCount(int inputGuessesCount){
        guessesCount = inputGuessesCount;
    }

    //constructors
    public GameWordle(){
        super();
        setLevel(1);
        setSecretWord("APPLE");
        guessesCount = 0;
    }

    public GameWordle(ArrayList<String> inputAllGuesses,boolean inputWinOrNot, Player inputPlayer,
                      int inputLevel, String inputSecretWord, int inputGuessesCount){
        super(inputAllGuesses,inputWinOrNot,inputPlayer);
        setLevel(inputLevel);
        setSecretWord(inputSecretWord);
        setGuessesCount(inputGuessesCount);
    }

    //toString
    public String toString(){
        System.out.println("------------------------------------------------------------");
        String result = "WORDLE: Level: " + level + " Secret word: " + secretWord + " Guesses count: " + guessesCount
                + super.toString();
        return result;
    }
}
