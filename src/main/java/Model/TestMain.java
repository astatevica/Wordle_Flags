package Model;

import java.time.LocalDateTime;

public class TestMain {
    public static void main(String[] args) {
//        System.out.println("---------------------------------------------------");
//        System.out.println("-----LOG-IN-&&-SIGN-UP-----------------------------");
//        Scanner myScanner = new Scanner(System.in);
//        System.out.println("Log-In or Sign-Up");
//        String choice = myScanner.next();
//        //TODO visu šo smuki ielikt loopā
//        if(choice.matches("Log-In")){
//            //TODO šo vajadzētu sameklēt no DB un neprasīt lietotājam, kas ielogojas
//            System.out.println("Please input your username address: ");
//            String username = myScanner.next();
//            System.out.println("Please input your password address: ");
//            String password = myScanner.next();
//            //Te vajag funkciju, kas sameklēs personu
//            //TODO te pēc būtības nevajadzēs izveidot playery, bet atrast esošo un agaidām izprintēt
//        }else if (choice == "Sign-Up") {
//            System.out.println("Please input your e-mail address: ");
//            String email = myScanner.next();
//            System.out.println("Please input your username address: ");
//            String username = myScanner.next();
//            System.out.println("Please input your password address: ");
//            String password = myScanner.next();
//            System.out.println("Please confirm your password address: ");
//            String password1 = myScanner.next();
//            if(password == password1){
//                Player player = new Player(username, email, password);
//                System.out.println(player); //Te vajadzētu ievietot info DB
//            }else{
//                System.out.println("------your-password-do-not-match-----------");
//            }
//        }else{
//            System.out.println("------PLEASE-TRY-AGAIN--------------------------");
//        }


        System.out.println("---------------------------------------------------");
        System.out.println("--TEST-PLAYER_CLASS-------------------------------");
        Player player1 = new Player("bigBen425", "bigBen425@gmail.com", "bigBen425");
        System.out.println(player1);

        Player player2 = new Player();
        System.out.println(player2);

        Player player3 = new Player("superDuper3234", "superDuper3234@gmail.com", "sup32dup34");
        System.out.println(player3);


        System.out.println("--TEST-GAME_CLASS-------------------------------");

        System.out.println("--TEST-GAME_CLASS-addToAllGuesses-------------------------------");
//        ArrayList<String> testGuesses = new ArrayList<>();
//        testGuesses.add("BOOK");
//        testGuesses.add("SOUP");
//        testGuesses.add("CAMP");
//        testGuesses.add("CAKE");
//
//        Game game1 = new Game(player1, 4, testGuesses, true, LocalDateTime.of(2023, 11, 20, 12, 18));
//        System.out.println(game1);
//
//        Game game2 = new Game();
//        System.out.println(game2);
//
//        Game game3 = new Game(player3, 6, testGuesses, false, LocalDateTime.of(2023, 11, 20, 12, 23));
//        System.out.println(game3);
//
//        System.out.println("---TEST_LETTER_CLASS------------------------------------------");
//        PictureOfLetters letter1 = new PictureOfLetters("A", "green");
//        System.out.println(letter1);
//
//        PictureOfLetters letter2 = new PictureOfLetters("B", "orange");
//        System.out.println(letter2);
//
//        PictureOfLetters letter3 = new PictureOfLetters("N", "yellow");
//        System.out.println(letter3);
//
//        PictureOfLetters letter4 = new PictureOfLetters("S", "GrEy");
//        System.out.println(letter4);
//
//        PictureOfLetters letter5 = new PictureOfLetters("ņ", "GREEN");
//        System.out.println(letter5);
//
//
//        System.out.println("---TEST-GAME-WORDLE-CLASS------------------------------------------");
//        GameWordle gameWordle1 = new GameWordle(player1, 4, testGuesses, true, LocalDateTime.of(2023, 11, 20, 12, 18), 3, "SHOWS");
//        System.out.println(gameWordle1);
//
//        GameWordle gameWordle2 = new GameWordle();
//        System.out.println(gameWordle2);
    }
}
