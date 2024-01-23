package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class GameGuessNumbers extends  Game{

    //1.variables
    private String number;
    private int digits;

    //2.getters
    public String getNumber() {
        return number;
    }

    public int getDigits() {
        return digits;
    }

    //3.set - nevajag, jo neko neievadīs neviens
    public void setDigits(int digits) {
        this.digits = digits;
    }

    //4.konstruktori
    public GameGuessNumbers(){
        super();
        digits = 4;
        number = "1234";
    }

    public GameGuessNumbers(Player inputPlayer, int inputGuessesCount, ArrayList<String> inputAllGuesses, boolean inputWinOrNot, LocalDateTime inputDate, int inputDigits){
        super(inputPlayer,inputGuessesCount,inputAllGuesses,inputWinOrNot,inputDate);
        digits = inputDigits;
        number = ganerateNumber(digits);
    }

    //5.toString
    public String toString(){
        String result =  String.valueOf(number);
        return  result;
    }

    //6.Papildus funkicjas
    public static String ganerateNumber(int inputDigits){
        Random myRandom = new Random();
        int generatorNumber = 10^(inputDigits-1) + 1;
        String format = "%0"+inputDigits+"d";
        String randomNumber = String.format(format, myRandom.nextInt(generatorNumber));
        System.out.println(randomNumber);
        return  randomNumber;
    }

    public static int numbersInCorrectPosition(String ComputerNumber, String Guess){
        int length = ComputerNumber.length();
        int correctPosition = 0;
        for (int i = 0; i < length; i++ ){
            if (ComputerNumber.charAt(i) == Guess.charAt(i)){
                correctPosition++;
            }
        }
        return correctPosition;
    }

    public static int correctDigits(String ComputerNumber, String Guess){
        int length = ComputerNumber.length();
        int correctDigits = 0;
        for (int i = 0; i < length; i++ ){
            for (int j = 0; j < length; j++)
                if (ComputerNumber.charAt(i) == Guess.charAt(j)){
                    correctDigits++;
            }
        }
        return correctDigits;
    }
}
