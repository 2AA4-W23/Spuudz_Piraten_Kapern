package pk;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
    private static final Logger logger = LogManager.getLogger(Player.class);
    public int score;
    public int numSkull;
    public ArrayList<String> currentHand = new ArrayList<String>();
    public String strategy;

    public Player(){
        score = 0;
        numSkull = 0;
        for(int i = 0; i < 8;i++){
            currentHand.add("PLACEHOLDER");
        }
    }
    public void setStrat(String strat){
        strategy = strat;
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
        Collections.sort(randomHand);
        logger.debug("Initial Roll: " + randomHand);
        removeSkulls(randomHand);

        if(strategy.equals("combo")){
            randomHand = comboStrat(myDice,randomHand);
        }
        else if (strategy.equals("random")){
            logger.debug("Reroll!");
            randomHand = reroll(randomHand,myDice,numSkull);
            Collections.sort(randomHand);
            logger.debug(randomHand);
            removeSkulls(randomHand);
        }

        currentHand = randomHand;
        if(numSkull < 3)
            score = updateScore(score,currentHand)[0];
    }

    public ArrayList<String> comboStrat(Dice myDice, ArrayList<String> randomHand){
        boolean endTurn = false;
        String comboCard = "";
        while(numSkull<3 && endTurn == false){
            int temp_score = 0;
            if(updateScore(temp_score,randomHand)[1] >= 4 || updateScore(temp_score,randomHand)[0] >= 400){
                endTurn = true;
            }
            else {
                logger.debug("Reroll!");
                comboCard = getHighestCombo(randomHand);
                logger.debug("Trying to roll for " + comboCard);
                randomHand = comboReroll(randomHand,myDice,numSkull,comboCard);
                Collections.sort(randomHand);
                logger.debug(randomHand);
                removeSkulls(randomHand);
            }
        }
        return randomHand;
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
    public ArrayList<String> reroll(ArrayList<String> randomHand, Dice myDice,int numSkull){
        if(numSkull < 3){
            Random rand = new Random();
            int changeRoll = rand.nextInt(randomHand.size()+1);

            for(int j = 0; j < changeRoll;j++){
                randomHand.set(j,myDice.roll().toString());
            }
        }
        return randomHand;
    }
    public ArrayList<String> comboReroll(ArrayList<String> randomHand, Dice myDice, int numSkull, String card){
        if(numSkull < 3){

            for(int j = 0; j < randomHand.size();j++){
                if(randomHand.get(j) != card)
                    randomHand.set(j,myDice.roll().toString());
            }
        }
        return randomHand;
    }

    public String getHighestCombo(ArrayList<String> randomHand){
        int temp = 0;
        int max = 0;
        String cardMax = "";
        for(int l = 0; l < randomHand.size();l++){
            temp = 0;
            for(int j = l; j < randomHand.size(); j++){
                if (randomHand.get(l) == randomHand.get(j) && randomHand.get(l) != "SKULL")
                    temp++;
            }
            if (temp > max || (temp == max && (randomHand.get(l).equals("DIAMOND") || randomHand.get(l).equals("GOLD")))){
                max = temp;
                cardMax = randomHand.get(l);
            }
            l+=temp-1;
        }
        return cardMax;
    }

    public int[] updateScore(int score, ArrayList<String> currentHand){
        logger.debug("Previous score: " + score);
        ArrayList<Integer> combo = new ArrayList<Integer>();
        int count = 0;
        int temp = 0;
        int max = 0;

        for(int i = 0; i < currentHand.size(); i++){
            if (currentHand.get(i) == "DIAMOND" || currentHand.get(i) == "GOLD"){
                count++;
            }
        }

        for(int l = 0; l < currentHand.size();l++){
            temp = 0;
            for(int j = l; j < currentHand.size(); j++){
                if (currentHand.get(l) == currentHand.get(j) && currentHand.get(l) != "SKULL")
                    temp++;
            }
            if (temp > max){
                max = temp;
            }
            l+=temp-1;
            combo.add(temp);
        }

        for(int k = 0; k < combo.size(); k++){
            if (combo.get(k)==3)
                score+=100;
            else if(combo.get(k)==4)
                score+=200;
            else if(combo.get(k)==5)
                score+=500;
            else if(combo.get(k)==6)
                score+=1000;
            else if(combo.get(k)==7)
                score+=2000;
            else if(combo.get(k)==8)
                score+=4000;
        }

        logger.debug(count);
        score+=(count*100); 
        logger.debug(combo);
        logger.debug(score);
        logger.debug("------------------");

        int[] arr = {score,max};

        return arr;
    }


}
