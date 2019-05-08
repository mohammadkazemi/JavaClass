package ThreePlayer.ThreeDimensionalDice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {

    int diceOptions;


    Dice() {
        List<Integer> diceValue = new ArrayList<>();
        diceValue.add(1);
        diceValue.add(2);
        diceValue.add(3);
        diceValue.add(4);
        diceValue.add(5);
        diceValue.add(6);


         diceOptions = getRandomElement(diceValue);
        System.out.println("our dice random value is : "+ diceOptions );

    }

    private int getRandomElement(List<Integer> diceValue) {
        Random random = new Random();
        return diceValue.get(random.nextInt(diceValue.size()));
    }

    public int getDiceOptions() {
        return diceOptions;
    }
}
