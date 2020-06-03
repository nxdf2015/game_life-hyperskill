package life;

public class Generation implements IGeneration {

    private Grid nextState;
    private Grid current;
    private int size;

    public void setGrid(Grid grid){
        this.current = grid;
        this.size = grid.getSize();
    }

    public Grid next(Grid grid) {

        this.current = grid;
          size = current.getSize();
        nextState = new Grid(size,Init.DEFAULT);// init empty grid


        int  countAlive = 0; // count alive when update nextState

        for(int row = 0 ; row < size ; row++ ){
            for(int col = 0 ; col < size ; col++ ){
                int countNeightboors = neighboor(row,col);
                //all cell nextState already dead
                if (current.isAlive(row,col) && (countNeightboors == 2 || countNeightboors == 3)){
                        countAlive++;
                        nextState.setAlive(row,col);
                }
                else if (countNeightboors == 3){
                        countAlive++;
                        nextState.setAlive(row,col);
                    }
            }
            nextState.setCountAlive(countAlive); //
        }
        return nextState;
    }

    public int neighboor(int row, int col) {
        int[]  d = { 1,0,-1};
        int count = 0 ;

        for (int drow : d ){
            for(int dcol : d){
                if (dcol == 0 && drow == 0 ){
                    continue;
                }

                int new_row = (size + row + drow ) % size;
                int new_col = (size + col + dcol) % size;
                count += current.isAlive(new_row,new_col) ? 1 : 0;

            }

        }

        return count;
    }
}
