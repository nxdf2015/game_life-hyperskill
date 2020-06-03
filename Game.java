package life;

import java.util.Random;

public class Game {

    private final Universe universe;
    private final int numberGeneration;
    private int size;
    private Render render;

    public Game(int size,int numberGeneration) {
        this.size = size;

        this.universe = new Universe(size,numberGeneration);
        universe.setGeneration(new GenerationRenderer(new Generation()));
        this.numberGeneration = numberGeneration;

    }

    public void startGame(){
                 universe.generate() ;
    }
}
