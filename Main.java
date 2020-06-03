package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        String[]  line = scanner.nextLine().split(" ");

        int size = Integer.parseInt(line[0]);

//        int seed =  Integer.parseInt(line[1]);
//        int numberGeneration = Integer.parseInt(line[2]);
//
//        Random random = new  Random(seed);
//
//        Universe universe = new Universe(size,seed,numberGeneration);
//
//        Grid grid = universe.generate();
//        grid.show();

        Game game = new Game(size,5);
        game.startGame();
    }
}
