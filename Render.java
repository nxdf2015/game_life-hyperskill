package life;

import java.io.IOException;

public class Render {
    public void clear(){

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {

            System.out.println(e.getMessage());
        }

    }

    public void wait( int  second )  {
        try {
            Thread.sleep(second  );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print(Grid grid) {
        System.out.println(grid);
    }
}
