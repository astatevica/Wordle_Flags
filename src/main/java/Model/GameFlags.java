package Model;

import java.util.ArrayList;

public class GameFlags extends Game{
    //1.mainīgie
    private ArrayList<String> allAnswers = new ArrayList<String>();

    //2.getteri
    public ArrayList<String> getAllAnswers() {
        return allAnswers;
    }

    //3.setteri nevajag, jo arraylists tiks automātiski ģenerēts no jau dotiem nosaukumiem

    //4.Konstruktori, neūs defaultais konstruktors
    public GameFlags(int inputGuessesCount, ArrayList<String> inputAllGuesses, boolean inputWinOrNot,Player inputPlayer, ArrayList<String> inputAllAnswers){
        super(inputGuessesCount,inputAllGuesses,inputWinOrNot, inputPlayer);
        allAnswers = inputAllAnswers;
    }

    //5.toString
    public String toString(){
        String result = "Players ==> " + super.getPlayer().getName() + " All guesses ==> "+ super.getAllGuesses()
                + " All answers ==> "+ allAnswers.toString();
        return result;
    }
}
