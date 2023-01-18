package pk;
import java.util.ArrayList;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
    private static final Logger logger = LogManager.getLogger(Player.class);
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
            logger.debug("Initial Roll: " + randomHand);
            removeSkulls(randomHand);
            while(numSkull<3){
                logger.debug("Reroll!");
                reroll(randomHand,myDice,numSkull);
                logger.debug(randomHand);
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
        logger.debug(numSkull + " skull(s) found overall.\n");
    }
    public void reroll(ArrayList<String> randomHand, Dice myDice,int numSkull){
        if(numSkull < 3){
            Random rand = new Random();
            int changeRoll = rand.nextInt(randomHand.size()+1);

            for(int j = 0; j < changeRoll;j++){
                randomHand.set(j,myDice.roll().toString());
            }
        }
    }

    public void updateScore(){
        logger.debug("Previous score: " + score);
        ArrayList<Integer> combo = new ArrayList<Integer>(); 
        int count = 0;
        int stack = 0;
        int temp = 0;
        int max = 0;

        for(int i = 0; i < currentHand.size(); i++){
            temp=0;
            if (currentHand.get(i) == "DIAMOND" || currentHand.get(i) == "GOLD"){
                count++;
            }
            for(int j = i; j < currentHand.size(); j++){
                if (currentHand.get(i) == currentHand.get(j))
                    temp++;
            }
            if(temp > max)
                max = temp;
            combo.add(temp);
        }

        for(int k = 0; k < combo.size(); k++){
            if(combo.get(k) == max)
                stack++;
        }

        for(int a = 0; a < stack; a++){
            if (max==3)
                score+=100;
            else if(max==4)
                score+=200;
            else if(max==5)
                score+=500;
            else if(max==6)
                score+=1000;
            else if(max==7)
                score+=2000;
            else if(max==8)
                score+=4000;
        }

        score+=(count*100); 
        logger.debug(max + ":combo | stack:" + stack);
        logger.debug(score);
        logger.debug("------------------");
    }


}
