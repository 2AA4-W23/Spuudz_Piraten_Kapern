import pk.Player;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("This is one turn!");
        Player p1 = new Player();


        while(p1.score < 6000){
            p1.rollEight();
        }

        System.out.println("That's all folks!");
    }
    
}
