import pk.Player;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("This is one turn!");
        Player p1 = new Player();
        Player p2 = new Player();
        int game = 0;
        int p1Win = 0;
        int p2Win = 0;

        while(game < 42){
            p1.setScore(0);
            p2.setScore(0);
            while(p1.getScore() < 6000 && p2.getScore() < 6000){
                System.out.println("P1 Turn: \n");
                p1.rollEight();
                if(p1.getScore() < 6000){
                    System.out.println("P2 Turn: \n");
                    p2.rollEight();
                }
            }
            if(p1.getScore() >= 6000){ 
                System.out.println("P1 wins!!");
                p1Win++;
            }
            else{
                System.out.println("P2 wins!!");
                p2Win++;
            }
            game++;
        }
        double p1Percent = (p1Win/42.0)*100.0;
        double p2Percent = (p2Win/42.0)*100.0;

        System.out.println("P1: " + p1Percent + " P2 " + p2Percent);

        System.out.println("That's all folks!");
        
    }
    
}
