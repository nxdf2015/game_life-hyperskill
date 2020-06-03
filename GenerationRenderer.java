package life;

public class GenerationRenderer  implements IGeneration{

    private final Render render;
    private IGeneration generation;
    private int count;
    public GenerationRenderer(IGeneration generation) {
        this.generation = generation;
        render  = new Render();
        count = 1;
    }

    @Override
    public Grid next(Grid grid) {
        System.out.println("Generation #"+(count++));
        System.out.println("Alive "+ grid.getCountAlive());
        render.print(grid);
        Grid nextGrid = generation.next(grid);


        render.wait(500);
        render.clear();
        return nextGrid;
    }
}
