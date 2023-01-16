import pk.Player;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        //System.out.println("I'm rolling a dice");
        Player p1 = new Player();
        p1.rollEight();
        System.out.println(p1.currentHand);

        System.out.println("That's all folks!");
    }
    
}
