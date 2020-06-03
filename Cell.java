package life;

public enum Cell {
    ALIVE("O"),
    DEAD(" ");

    private final String value;

    private Cell(String value) {
       this.value = value;
    }

    @Override
    public String toString() {
        return  value;
    }
}
