package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        String[]  line = scanner.nextLine().split(" ");

        int size = Integer.parseInt(line[0]);

        Game game = new Game(size,5);
        game.startGame();
    }
}
