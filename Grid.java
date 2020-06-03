package life;

import java.util.Random;
import java.util.function.Supplier;

import static life.Cell.ALIVE;
import static life.Cell.DEAD;

public class Grid {
    private   Supplier<Boolean> generator;
    private  int size;
    private  Cell[][] grid;

    public Grid(int size) {
        this.generator = () -> false;
        this.size= size;
        this.grid = new Cell[size][size];
        initialize();
    }


    public int getSize() {
        return size;
    }

    public Grid(int size,int seed) {
        this.size = size;
        grid = new Cell[size][size];
        Random random = new Random(seed);
        this.generator  = () -> random.nextBoolean();
        initialize();
    }



    public Cell getValue(){
        return generator.get() ? ALIVE : DEAD;
    }

    public void initialize(){
        for(int row = 0 ; row < grid.length ; row++ ){
            for (int col = 0 ; col < grid.length ; col++ ){
                grid[row][col] = getValue();
            }
        }
    }


    public void show(){
        String result = "";
        for(int i = 0 ; i < size ; i++ ){

            for(int j = 0 ; j < size ; j++ ){
                result += grid[i][j];

            }
            result  += System.lineSeparator();
        }
        System.out.println(result);
    }

    public boolean isAlive(int row, int col) {
        return grid[row][col] == ALIVE;
    }

    public void setAlive(int row, int col) {
        grid[row][col] = ALIVE;
    }

    public void setDead(int row, int col) {
        grid[row][col] = DEAD;
    }
}
