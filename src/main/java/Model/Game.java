package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game{
    //Mainigie
    private int guessesCount;
    private boolean winOrNot;
    private LocalDateTime date;
    private ArrayList<String> allGuesses;
    private Player player;

    //test Array list for default constructor
    public ArrayList<String> testArrayList = new ArrayList<>();

    //Getters
    public int getGuessesCount() {
        return guessesCount;
    }

    public boolean isWinOrNot() {
        return winOrNot;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public ArrayList<String> getAllGuesses() {
        return allGuesses;
    }

    public Player getPlayer(){
        return player;
    }

    //Setteri
    public void setGuessesCount(int inputGuessesCount){
        if(inputGuessesCount >= 1){
            guessesCount = inputGuessesCount;
        }else{
            guessesCount = 0;
        }
    }

    public void setAllGuesses(ArrayList<String> inputAllGuesses){
        if(inputAllGuesses != null){
            allGuesses = inputAllGuesses;
        }else{
            allGuesses.add("NULL");
        }
    }

    public void setWinOrNot(boolean inputWinOrNot){
        winOrNot = inputWinOrNot;
    }

    public void setLocalDateTime(){
        date = LocalDateTime.now();
    }

    public void setPlayer(Player inputPlayer){
        if(inputPlayer != null){
            player = inputPlayer;
        }else{
            player = new Player();
        }
    }

    //Konstruktori
    public Game(){
        setGuessesCount(0);
        setAllGuesses(testArrayList);
        setWinOrNot(true);
        setLocalDateTime();
        setPlayer(new Player());
    }

    public Game(int inputGuessesCount, ArrayList<String> inputAllGuesses, boolean inputWinOrNot, Player inputPlayer){
        setGuessesCount(inputGuessesCount);
        setAllGuesses(inputAllGuesses);
        setWinOrNot(inputWinOrNot);
        setLocalDateTime();
        setPlayer(inputPlayer);
    }

    //toString
    public String toString(){
        String result = " Game result==> Player: " + player.getName() + " Guesses count: " + guessesCount + " All Guesses: " +
                allGuesses + " Round is won: " + winOrNot + " Date: " + date;
        return result;
    }
}
