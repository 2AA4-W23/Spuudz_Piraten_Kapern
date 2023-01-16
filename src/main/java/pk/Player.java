package pk;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    public int score;
    public int numSkull;
    public ArrayList<String> currentHand = new ArrayList<String>();

    public Player(){
        score = 0;
        numSkull = 0;
        for(int i = 0; i < 8;i++){
            currentHand.add("PLACEHOLDER");
        }
    }
    public int getScore(){
        return score;
    }
    public ArrayList<String> getHand(){
        return currentHand;
    }


    public void rollEight(){
        ArrayList<String> randomHand = new ArrayList<String>();
        randomHand = currentHand;
        Dice myDice = new Dice();
        while(numSkull < 3){
            for (int i = 0; i < (8-numSkull); i++){
                String myRoll = myDice.roll().toString();
                randomHand.set(i,myRoll);
            }
            System.out.println(randomHand);
            removeSkulls(randomHand);
            System.out.println(randomHand);
            reroll(randomHand,myDice,numSkull);
            System.out.println(randomHand);
            removeSkulls(randomHand);
            System.out.println(randomHand);
            System.out.println("------------------");
        }
        currentHand = randomHand;
        updateScore();
    }
    public void removeSkulls(ArrayList<String> randomHand){
        for(int i = 0; i < randomHand.size(); i++){
            if(randomHand.get(i) == "SKULL"){
                randomHand.remove(String.valueOf("SKULL"));
                numSkull++;
                i--;
                System.out.println("DEBUG found a skull");
            }
        }
    }
    public void reroll(ArrayList<String> randomHand, Dice myDice,int numSkull){
        if(numSkull < 3){
            Random rand = new Random();

            for(int i = 0; i < randomHand.size();i++){
                int changeRoll = rand.nextInt(2);

                if(changeRoll == 1){
                    randomHand.set(i,myDice.roll().toString());
                }
            }
        }
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
