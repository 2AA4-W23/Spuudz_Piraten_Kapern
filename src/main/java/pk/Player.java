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
    public void setScore(int value){
        score = value;
    }
    public int getScore(){
        return score;
    }
    public ArrayList<String> getHand(){
        return currentHand;
    }


    public void rollEight(){
        ArrayList<String> randomHand = new ArrayList<String>();
        numSkull = 0;
        Dice myDice = new Dice();
            for (int i = 0; i < 8; i++){
                String myRoll = myDice.roll().toString();
                randomHand.add(myRoll);
            }
            System.out.println("Initial Roll: " + randomHand);
            removeSkulls(randomHand);
            while(numSkull<3){
                System.out.println("Reroll!");
                reroll(randomHand,myDice,numSkull);
                System.out.println(randomHand);
                removeSkulls(randomHand);
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
            }
        }
        System.out.println(numSkull + " skull(s) found overall.\n");
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
        System.out.println(score);
        System.out.println("------------------");
    }


}
