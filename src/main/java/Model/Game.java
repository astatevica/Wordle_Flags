package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {
    //Mainigie
    private Player player;
    private int guessesCount;
    private boolean winOrNot;
    private LocalDateTime date;
    private ArrayList<String> allGuesses;

    //test Array list for default constructor
    public ArrayList<String> testArrayList = new ArrayList<>();

    //Getters
    public Player getPlayer() {
        return player;
    }

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

    //Setteri
    public void setPlayer(Player inputPlayer){
        if(inputPlayer != null){
            player = inputPlayer;
        }else{
            player = new Player();
        }
    }

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

    public void setLocalDateTime(LocalDateTime inputDate){
        if(inputDate.isAfter(LocalDateTime.of(2023,10,20,12,30))){
            date = inputDate;
        }else{
            date = inputDate.of(2023,10,20,12,30);
        }
    }

    //Konstruktori
    public Game(){
        setPlayer(new Player());
        setGuessesCount(0);
        setAllGuesses(testArrayList);
        setWinOrNot(true);
        setLocalDateTime(LocalDateTime.of(2023,11,20,11,43));
    }

    public Game(Player inputPlayer, int inputGuessesCount, ArrayList<String> inputAllGuesses, boolean inputWinOrNot, LocalDateTime inputDate){
        setPlayer(inputPlayer);
        setGuessesCount(inputGuessesCount);
        setAllGuesses(inputAllGuesses);
        setWinOrNot(inputWinOrNot);
        setLocalDateTime(inputDate);
    }

    //toString
    public String toString(){
        String result = " Game result==> Player: " + player.getName() + " Guesses count: " + guessesCount + " All Guesses: " +
                allGuesses + " Round is won: " + winOrNot + " Date: " + date;
        return result;
    }
}
