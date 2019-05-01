package ThreePlayer.ThreeDimensionalDice;

public class Player {

    private String name = "";

    private int playerChoice = 0;


    Player(String newName, int choice){
        name = newName;
        playerChoice = choice;
    }


    public int getPlayerChoice() {
        return playerChoice;
    }




    public String getName() {
        return name;
    }




}
