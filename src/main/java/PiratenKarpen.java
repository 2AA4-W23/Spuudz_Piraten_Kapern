import pk.*;
public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("Simulating 42 games!");
        int game = 0;

        Game piratenGame = new Game();
        Strategy p1 = new Strategy();
        p1.setStrat(args[0]);
        Strategy p2 = new Strategy();
        p2.setStrat(args[1]);

        while(game < 42){
            piratenGame.turn(p1,p2);
            game++;
        }
        System.out.println("Player1 win percent: " + piratenGame.calcPercent(p1) + "%");
        System.out.println("Player2 win percent: " + piratenGame.calcPercent(p2) + "%");

        System.out.println("That's all folks!");
    }
}
