import pk.Player;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("This is one roll!");
        Player p1 = new Player();
        p1.rollEight();
        System.out.println(p1.getHand());
        System.out.println(p1.getScore());

        System.out.println("That's all folks!");
    }
    
}
