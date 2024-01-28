package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game{
    //Mainigie
    private boolean winOrNot;
    private LocalDateTime date;
    private ArrayList<String> allGuesses;
    private Player player;

    //test Array list for default constructor
    public ArrayList<String> testArrayList = new ArrayList<>();

    //Getters
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

    public void setAllGuesses(ArrayList<String> inputAllGuesses){
        //šeit nepārbudam, jo piemēra spēlē "Memory" nebūs minējumu
        allGuesses = inputAllGuesses;
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
        setAllGuesses(testArrayList);
        setWinOrNot(true);
        setLocalDateTime();
        setPlayer(new Player());
    }

    public Game(ArrayList<String> inputAllGuesses, boolean inputWinOrNot, Player inputPlayer){
        setAllGuesses(inputAllGuesses);
        setWinOrNot(inputWinOrNot);
        setLocalDateTime();
        setPlayer(inputPlayer);
    }

    //toString
    public String toString(){
        String result = " Game result ==> Player: " + player.getName() + " All Guesses: " +
                allGuesses + " Round is won: " + winOrNot + " Date: " + date;
        return result;
    }
}
