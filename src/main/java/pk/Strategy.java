package pk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Strategy extends Player{
    private static final Logger logger = LogManager.getLogger(Strategy.class);
    public String strategy;
    public int requiredSabers;

    public void setStrat(String strat){
        strategy = strat;
    }

    public void strategyReroll(){
        Random rand = new Random();

        if(drawnCard.equals("Sea Battle")){
            requiredSabers = rand.nextInt(2)+2;
            logger.debug("Sabers Required: " + requiredSabers);
        }

        if (strategy.equals("combo")){
            if(drawnCard.equals("Sea Battle")){
                saberStrat(myDice, currentHand);
            }
            else
                comboStrat(myDice,currentHand);
        }
        else{
            randomReroll(currentHand,myDice);
        }
        if(drawnCard.equals("Sea Battle") && numSkull < 3)
            seaBattleScore();
        else if(numSkull < 3)
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
                if(drawnCard.equals("Monkey Business"))
                    monkeyReroll(randomHand,myDice,numSkull,comboCard);
                else
                    randomHand = comboReroll(randomHand,myDice,numSkull,comboCard);
                Collections.sort(randomHand);
                logger.debug(randomHand);
                removeSkulls(randomHand);
            }
        }
        return randomHand;
    }

    public ArrayList<String> saberStrat(Dice myDice, ArrayList<String> randomHand){
        boolean endTurn = false;
        while(numSkull<3 && endTurn == false){
            int saberNum = 0;

            for(int i = 0; i < randomHand.size();i++){
                if(randomHand.get(i).equals("SABER"))
                    saberNum++;
            }

            if(saberNum > requiredSabers){
                endTurn = true;
            }
            else {
                logger.debug("Reroll!");
                logger.debug("Trying to roll for SABER");
                randomHand = comboReroll(randomHand,myDice,numSkull,"SABER");
                Collections.sort(randomHand);
                logger.debug(randomHand);
                removeSkulls(randomHand);
            }
        }
        return randomHand;
    }

    public ArrayList<String> randomReroll(ArrayList<String> randomHand, Dice myDice){
        if(numSkull < 3){
            logger.debug("Reroll!");
            Random rand = new Random();
            int changeRoll = rand.nextInt(randomHand.size()+1);

            for(int j = 0; j < changeRoll;j++){
                randomHand.set(j,myDice.roll().toString());
            }
            Collections.sort(randomHand);
            logger.debug(randomHand);
            removeSkulls(randomHand);
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

    public ArrayList<String> monkeyReroll(ArrayList<String> randomHand, Dice myDice, int numSkull, String card){
        if(numSkull < 3){
            if(card.equals("MONKEY") || card.equals("PARROT")){
                for(int j = 0; j < randomHand.size();j++){
                    if(!(randomHand.get(j).equals("MONKEY")) && !(randomHand.get(j).equals("PARROT")))
                        randomHand.set(j,myDice.roll().toString());
                }
            }
            else {
                for(int j = 0; j < randomHand.size();j++){
                    if(!(randomHand.get(j).equals(card)))
                        randomHand.set(j,myDice.roll().toString());
                }
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

    public void seaBattleScore(){
        int saberNum = 0;

        for(int i = 0; i < currentHand.size();i++){
            if(currentHand.get(i).equals("SABER"))
                saberNum++;
        }

        if(saberNum >= requiredSabers){
            logger.debug("Required num of sabers reached: score increased!");
            score+=500;
            logger.debug("New score: " + score);
            updateScore(score,currentHand);
        }
        else{
            logger.info("Required num of sabers not reached, no points");
        }
    }
}
