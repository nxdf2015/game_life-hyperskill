package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        String[]  line = scanner.nextLine().split(" ");
        int size = Integer.parseInt(line[0]);
        int seed =  Integer.parseInt(line[1]);
        Random random = new  Random(seed);
        
        String grid = "";
        for(int i = 0 ; i < size ; i++ ){
            for(int j = 0 ; j < size ; j++ ){
                grid +=  random.nextBoolean() ? "O" : " ";

            }
            grid += System.lineSeparator();
        }

        System.out.println(grid);

    }
}
