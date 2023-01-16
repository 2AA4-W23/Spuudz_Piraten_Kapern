package pk;
import java.util.ArrayList;

public class Player {
    public int score;
    public int numSkull;
    public ArrayList<String> currentHand = new ArrayList<String>();

    public Player(){
        score = 0;
        numSkull = 0;
    }
    public int getScore(){
        return score;
    }
    public ArrayList<String> getHand(){
        return currentHand;
    }


    public void rollEight(){
        ArrayList<String> randomHand = new ArrayList<String>();
        Dice myDice = new Dice();
        for (int i = 0; i < 8; i++){
            String myRoll = myDice.roll().toString();
            randomHand.add(myRoll);
        }
        currentHand = randomHand;
        updateScore();
    }

    public void updateScore(){
        int count = 0;
        for(int i = 0; i < currentHand.size(); i++){
            if (currentHand.get(i) == "DIAMOND" || currentHand.get(i) == "GOLD"){
                count++;
            }
        }
        score+=(count*100);
    }


}
