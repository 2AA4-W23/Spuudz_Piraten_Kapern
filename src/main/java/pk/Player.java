package pk;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
    private static final Logger logger = LogManager.getLogger(Player.class);
    public int score;
    public int numSkull;
    public int numWins;
    public ArrayList<String> currentHand = new ArrayList<String>();
    public Dice myDice = new Dice();
    public String drawnCard;

    public Player(){
        score = 0;
        numSkull = 0;
        for(int i = 0; i < 8;i++){
            currentHand.add("PLACEHOLDER");
        }
    }

    public void setCard(String card){
        drawnCard = card;
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

    public void increaseWins(){
        numWins++;
    }

    public void initialRoll(){
        ArrayList<String> randomHand = new ArrayList<String>();
        numSkull = 0;
            for (int i = 0; i < 8; i++){
                String myRoll = myDice.roll().toString();
                randomHand.add(myRoll);
            }
        Collections.sort(randomHand);
        logger.debug("Initial Roll: " + randomHand);
        removeSkulls(randomHand);

        currentHand = randomHand;
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
            if(drawnCard.equals("Monkey Business")){
                if(currentHand.get(i).equals("PARROT")){
                    currentHand.set(i,"MONKEY");
                }
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
