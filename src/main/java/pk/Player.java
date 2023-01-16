package pk;
import pk.Dice;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    public int score;
    public int numSkull;
    public ArrayList<String> currentHand = new ArrayList<String>();

    public Player(){
        score = 0;
        numSkull = 0;
    }

    public void rollEight(){
        ArrayList<String> randomHand = new ArrayList<String>();
        Dice myDice = new Dice();
        for (int i = 0; i < 8; i++){
            String myRoll = myDice.roll().toString();
            randomHand.add(myRoll);
        }
        currentHand = randomHand;
    }


}
