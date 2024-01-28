package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("--TEST-PLAYER_CLASS-------------------------------");
        Player player1 = new Player("bigBen425", "bigBen425@gmail.com", "bigBen425");
        System.out.println(player1);

        Player player2 = new Player();
        System.out.println(player2);

        Player player3 = new Player("superDuper3234", "superDuper3234@gmail.com", "sup32dup34");
        System.out.println(player3);


        System.out.println("--TEST-GAME-CLASS-------------------------------");
        int guesses = 4;
        ArrayList<String> testGuesses = new ArrayList<>();
        testGuesses.add("BOOK");
        testGuesses.add("SOUP");
        testGuesses.add("CAMP");
        testGuesses.add("CAKE");
        Game game1 = new Game(testGuesses, true, player1);
        System.out.println(game1);


        System.out.println("--TEST-GAME-FLAGS-CLASS-------------------------------");
        ArrayList<String> testGuesses1 = new ArrayList<>();
        testGuesses1.add("Albania");
        testGuesses1.add("Andorra");
        testGuesses1.add("Armenia");
        testGuesses1.add("Austria");
        testGuesses1.add("Azerbaijan");
        testGuesses1.add("Belarus");
        testGuesses1.add("Belgium");
        testGuesses1.add("Bosnia");
        testGuesses1.add("Bulgaria");
        testGuesses1.add("Croatia");

        ArrayList<String> testAnswers1 = new ArrayList<>();
        testGuesses1.add("Albania");
        testGuesses1.add("Andorra");
        testGuesses1.add("Armenia");
        testGuesses1.add("Austria");
        testGuesses1.add("Azerbaijan");
        testGuesses1.add("Belarus");
        testGuesses1.add("Belgium");
        testGuesses1.add("Bosnia");
        testGuesses1.add("Latvia");
        testGuesses1.add("Estonia");
        GameFlags gameFlags1 = new GameFlags(testGuesses1,true,player2, testAnswers1, 8);
        System.out.println(gameFlags1);

        System.out.println("--TEST-GAME-FLAGS-FUNCTIONS-CLASS-------------------------------");
        GameFlagFunctions newFunctions = new GameFlagFunctions();
        System.out.println(newFunctions);

        System.out.println(newFunctions.giveOneCountry());
        System.out.println(newFunctions.giveOneRandomCountry());

        System.out.println("--TEST-GAME-WORDLE-CLASS-------------------------------");
        ArrayList<String> testGuesses2 = new ArrayList<>();
        testGuesses2.add("AGSHT");
        testGuesses2.add("GOOSE");
        testGuesses2.add("HIGHT");
        testGuesses2.add("LAKES");
        GameWordle gameWordle1 = new GameWordle(testGuesses2, false, player3, 1, "HOUSE", 4);
        System.out.println(gameWordle1);





    }
}
