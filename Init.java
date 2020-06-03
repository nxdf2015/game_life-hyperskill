package life;

public enum Init {

    RANDOM(0),
    DEFAULT(0),
    SEED(0);

    private long value;

    Init(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
