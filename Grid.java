package life;

import javax.swing.*;
import java.util.Random;
import java.util.function.Supplier;

import static life.Cell.ALIVE;
import static life.Cell.DEAD;

public class Grid {
    private   Supplier<Boolean> generator; // function use for initialize grid
    private  int size;// size of the grid
    private  Cell[][] grid;
    private int countAlive;// number cell alive



    public Grid(int size,Init init) {
        Random random;
        grid = new Cell[size][size];
        this.size = size;
        this.countAlive = 0;
        switch(init){
            case DEFAULT:
                this.generator = () -> false;
                break;
            case RANDOM:
                random = new Random();
                this.generator = () -> random.nextBoolean();
                break;
            case SEED:
                random = new Random(init.getValue());
                this.generator = () -> random.nextBoolean();
                break;
        }

        initialize();
    }

    /*
    initialize grid with generator selected in constructor
     */
    public void initialize(){
       countAlive = 0;
        for(int row = 0 ; row < grid.length ; row++ ){
            for (int col = 0 ; col < grid.length ; col++ ){

                Cell cell = getValue();
                countAlive += cell == ALIVE ? 1 : 0 ;
                grid[row][col] = cell;
            }
        }
        show();

    }

    /*
    @return string of the grid
     */
    public String  show(){
        String result = "";
        for(int i = 0 ; i < size ; i++ ){

            for(int j = 0 ; j < size ; j++ ){
                result += grid[i][j];

            }
            result  += System.lineSeparator();
        }
        return result;
    }

    @Override
    public String toString() {
        return show();
    }

    public boolean isAlive(int row, int col) {
        return grid[row][col] == ALIVE;
    }

    // setter and getter  of the grid
    public void setAlive(int row, int col) {
        grid[row][col] = ALIVE;
    }

    public void setDead(int row, int col) {
        grid[row][col] = DEAD;
    }


    public int getCountAlive() {
        return countAlive;
    }

    public void setCountAlive(int countAlive) {
        this.countAlive = countAlive;
    }


    private Cell getValue(){
        return  generator.get()? ALIVE : DEAD;
    }


    public int getSize() {
        return size;
    }

    // true if all cell not alive
    //@return boolean
    public boolean isEmpty() {
        return countAlive == 0;
    }
}
