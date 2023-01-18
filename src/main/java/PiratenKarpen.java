import pk.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PiratenKarpen {
    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("Simulating 42 games!");
        Player p1 = new Player();
        Player p2 = new Player();
        int game = 0;
        int p1Win = 0;
        int p2Win = 0;

        while(game < 42){
            p1.setScore(0);
            p2.setScore(0);
            while(p1.getScore() < 6000 && p2.getScore() < 6000){
                logger.info("P1 Turn: \n");
                p1.rollEight();
                logger.info("P2 Turn: \n");
                p2.rollEight();
            }
            while(p1.getScore() == p2.getScore()){
                logger.info("P1 Turn: \n");
                p1.rollEight();
                logger.info("P2 Turn: \n");
                p2.rollEight();
            }
            if(p1.getScore() > p2.getScore()){ 
                logger.info("P1 wins!!");
                p1Win++;
            }
            else{
                logger.info("P2 wins!!");
                p2Win++;
            }
            game++;
        }
        double p1Percent = (p1Win/42.0)*100.0;
        double p2Percent = (p2Win/42.0)*100.0;

        System.out.println("Win Percents:");
        System.out.println("P1: " + p1Percent + " P2 " + p2Percent);

        System.out.println("That's all folks!");

        
    }
    
}
