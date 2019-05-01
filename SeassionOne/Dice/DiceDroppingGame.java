package ThreePlayer.ThreeDimensionalDice;

import java.util.Scanner;

public class DiceDroppingGame {

    public static void main(String[] args){

         String groupAnswer;


        int playerOneGuess , playerTwoGuess, playerThreeGuesss;

        do {
            System.out.println("Do you want to play again ? ");
            Scanner playersGuess = new Scanner(System.in);
            Scanner playGameAgain = new Scanner(System.in);



            groupAnswer         = playGameAgain.nextLine();

            System.out.println("player one enter your choosen number : ");
            playerOneGuess      = playersGuess.nextInt();



            System.out.println("player two enter your choosen number : ");
            playerTwoGuess      = playersGuess.nextInt();


            System.out.println("player three enter your choosen number : ");
            playerThreeGuesss   = playersGuess.nextInt();





//        create a dice game with 3 player provided
            DiceGame diceGame =
                    new DiceGame("player one",
                            "player two",
                            "player three",
                            playerOneGuess,
                            playerTwoGuess,
                            playerThreeGuesss);
            diceGame.start();

        } while ((groupAnswer.startsWith("y")) || (groupAnswer.startsWith("Y")));
    }
}
