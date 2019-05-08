package ThreePlayer.ThreeDimensionalDice;

import java.util.ArrayList;

public class DiceGame {


    Player[] players = new Player[3];

    Dice theDice = new Dice();

    public DiceGame(String player_one, String player_two, String player_three, int playerOneGuess, int playerTwoGuess, int playerThreeGuesss) {
        players[0] = new Player(player_one, playerOneGuess);
        players[1] = new Player(player_two, playerTwoGuess);
        players[2] = new Player(player_three, playerThreeGuesss);
    }

    public void start() {

        int diceRandomValue = theDice.getDiceOptions();

        ArrayList<Integer> ourList = new ArrayList<>();
        ourList.add(1);
        ourList.add(2);
        ourList.add(3);
        ourList.add(4);
        ourList.add(5);
        ourList.add(6);

        System.out.println("this is players guesses : " +
                players[0].getPlayerChoice() + "    " +
                players[1].getPlayerChoice() + "    " +
                players[2].getPlayerChoice() );


//        for (int x = 0; x < ourList.size(); x++) {
//            if ((x == players[0].getPlayerChoice()) || (x == players[1].getPlayerChoice()) || (x == players[2].getPlayerChoice())) {
//                ourList.remove(ourList.indexOf(x));
//
//            }
//        }

        int myPlayerOneChoice = players[0].getPlayerChoice();


        ourList.remove(ourList.indexOf(myPlayerOneChoice));
        ourList.remove(ourList.indexOf(players[1].getPlayerChoice()));
        ourList.remove(ourList.indexOf(players[2].getPlayerChoice()));

        System.out.println("this is arrayList after removing players guesses"+ ourList);


        if (diceRandomValue == players[0].getPlayerChoice()){
            System.out.println(" "+players[0].getName()+" won");

        } else if (diceRandomValue == players[1].getPlayerChoice()){
            System.out.println(" "+players[1].getName()+" won");


        } else if (diceRandomValue == players[2].getPlayerChoice()){
            System.out.println(""+players[2].getName()+"  won");


        } else if (diceRandomValue == ourList.get(0)){
            System.out.println("all players are looser !!!!");

        } else if (diceRandomValue == ourList.get(1)){
            System.out.println("all players are looser !!!!");


        } else if (diceRandomValue == ourList.get(2)){
            System.out.println("all players are looser !!!!");


        } else {
            System.out.println("this state wont happen");
        }
    }
}
