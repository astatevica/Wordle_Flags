package Model;

import java.util.ArrayList;

public class GameMemory extends Game{
    //variable
    private int turns;

    //getters
    public int getTurns() {
        return turns;
    }

    //setters
    public void setTurns(int inputTurns) {
        if (inputTurns >= 0){
            turns = inputTurns;
        }else{
            turns = 0;
        }
    }

    //constructors
    public GameMemory(){
        setTurns(0);
    }

    public GameMemory(int inputGuessesCount, ArrayList<String> inputAllGuesses,
                      boolean inputWinOrNot, Player inputPlayer, int inputTurns){
        super(inputGuessesCount,inputAllGuesses,inputWinOrNot,inputPlayer);
        setTurns(inputTurns);
    }

    //toString
    public String toString(){
        String result = "Turns: " + turns + super.toString();
        return result;
    }
}
