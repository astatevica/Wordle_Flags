package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GameWordle extends  Game{
    //variable
    private int level;
    private String secretWord;

    //getters
    public int getLevel() {
        return level;
    }

    public String getSecretWord() {
        return secretWord;
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

    //constructors
    public GameWordle(){
        super();
        setLevel(1);
        setSecretWord("APPLE");
    }

    public GameWordle(Player inputPlayer, int inputGuessesCount, ArrayList<String> inputAllGuesses,
                      boolean inputWinOrNot, LocalDateTime inputDate, int inputLevel, String inputSecretWord){
        super(inputPlayer,inputGuessesCount,inputAllGuesses,inputWinOrNot,inputDate);
        setLevel(inputLevel);
        setSecretWord(inputSecretWord);
    }

    //toString
    public String toString(){
        String result = "Level: " + level + " Secret word: " + secretWord + super.toString();
        return result;
    }
}
