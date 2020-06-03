package life;

public class Universe {


    private final int numberGeneration;
    private Grid grid;
    private IGeneration generation;

    public Universe(int size, Init init,int numberGeneration) {
        this.numberGeneration = numberGeneration;
        this.grid = new Grid(size,init);
    }

    public Universe(int size, int numberGeneration) {
        this.numberGeneration = numberGeneration;
        this.grid = new Grid(size,Init.RANDOM);


    }

    public void setGeneration(IGeneration generation){
        this.generation = generation;
    }


    public Grid generate(){

         if (generation == null)
             generation = new Generation();
        for(int i = 0 ; i < numberGeneration  ; i++ ){
            grid = generation.next(grid);
            if (grid.isEmpty()) {
                break;
            }
        }
        return grid;
    }
}