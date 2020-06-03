package life;

public class Universe {


    private final int numberGeneration;
    private Grid grid;
    public Universe(int size, int seed,int numberGeneration) {
        this.numberGeneration = numberGeneration;
        grid = new Grid(size,seed);
    }

    public Grid generate(){

        Generation generation = new Generation();
        for(int i = 0 ; i < numberGeneration  ; i++ ){
            grid = generation.next(grid);
        }
        return grid;

    }




}