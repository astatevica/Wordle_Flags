package Model;

import java.util.ArrayList;

public class GameFlags extends Game{
    //1.mainīgie
    private ArrayList<String> allAnswers = new ArrayList<String>();
    private int rightGuessesCount;

    //2.getteri
    public ArrayList<String> getAllAnswers() {
        return allAnswers;
    }

    public int getRightGuessesCount() {
        return rightGuessesCount;
    }

    //3.setteri nevajag
    public void setRightGuessesCount(int inputRightGuessesCount){
        rightGuessesCount = inputRightGuessesCount;
    }

    //4.Konstruktori, neūs defaultais konstruktors
    public GameFlags(ArrayList<String> inputAllGuesses, boolean inputWinOrNot,Player inputPlayer,
                     ArrayList<String> inputAllAnswers, int inputRightGuessesCount){
        super(inputAllGuesses,inputWinOrNot, inputPlayer);
        allAnswers = inputAllAnswers;
        rightGuessesCount = inputRightGuessesCount;
    }

    //5.toString
    public String toString(){
        System.out.println("------------------------------------------------------------");
        String result = "FLAGS: Players ==> " + super.getPlayer().getName() + "Correct answers ==> " + rightGuessesCount
                + " All guesses ==> "+ super.getAllGuesses()
                + " All answers ==> "+ allAnswers.toString();
        return result;
    }
}
