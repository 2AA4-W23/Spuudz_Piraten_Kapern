package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;
import java.util.ArrayList;

public class Game {
    private static final Logger logger = LogManager.getLogger(Game.class);
    public ArrayList<String> deck = new ArrayList<String>();
    public String card = "";

    public void setDeck(){
        for(int i = 0; i < 6; i++){
            deck.add("Sea Battle");
        }
        for(int j = 0; j < 29; j++){
            deck.add("nop");
        }
    }

    public String getCard(){
        return card;
    }


    public void turn(Strategy p1, Strategy p2){
        setDeck();
        p1.setScore(0);
        p2.setScore(0);
        String card = "";

        while(p1.getScore() < 6000 && p2.getScore() < 6000){
            logger.info("P1 Turn: \n");
            card = drawCard();
            p1.setCard(card);
            if(card.equals("Sea Battle"))
                logger.info("Sea Battle Drawn!");
            p1.initialRoll();
            p1.strategyReroll();
            logger.info("P2 Turn: \n");
            card = drawCard();
            p2.setCard(card);
            if(card.equals("Sea Battle"))
                logger.info("Sea Battle Drawn!");
            p2.initialRoll();
            p2.strategyReroll();
        }
        while(p1.getScore() == p2.getScore()){
            logger.info("P1 Turn: \n");
            card = drawCard();
            p1.setCard(card);
            if(card.equals("Sea Battle"))
                logger.info("Sea Battle Drawn!");
            p1.initialRoll();
            p1.strategyReroll();
            logger.info("P2 Turn: \n");
            card = drawCard();
            p2.setCard(card);
            if(card.equals("Sea Battle"))
                logger.info("Sea Battle Drawn!");
            p2.initialRoll();
            p2.strategyReroll();
        }
        if(p1.getScore() > p2.getScore()){ 
            logger.info("P1 wins!!");
            p1.increaseWins();;
        }
        else{
            logger.info("P2 wins!!");
            p2.increaseWins();
        }
    }

    public double calcPercent(Player player){
         return (player.numWins/42.0)*100.0; 
    }

    public String drawCard(){
        Random rand = new Random();
        int cardNum = rand.nextInt(35);

        return deck.get(cardNum);
    }

}