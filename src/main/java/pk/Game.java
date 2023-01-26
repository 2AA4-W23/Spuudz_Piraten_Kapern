package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private static final Logger logger = LogManager.getLogger(Game.class);


    public void turn(Strategy p1, Strategy p2){
        p1.setScore(0);
        p2.setScore(0);

        while(p1.getScore() < 6000 && p2.getScore() < 6000){
            logger.info("P1 Turn: \n");
            p1.initialRoll();
            p1.strategyReroll();
            logger.info("P2 Turn: \n");
            p2.initialRoll();
            p2.strategyReroll();
        }
        while(p1.getScore() == p2.getScore()){
            logger.info("P1 Turn: \n");
            p1.initialRoll();
            p1.strategyReroll();
            logger.info("P2 Turn: \n");
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

}