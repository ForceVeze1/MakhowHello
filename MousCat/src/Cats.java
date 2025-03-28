import java.util.ArrayList;

public class Cats {
    private String name;
    private int speed;
    private int weight;
    private ArrayList<Mouse> caughtMice;
    private static final int MAX_MICE = 100;

    public Cats(String name, int speed, int weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.caughtMice = new ArrayList<>(MAX_MICE);
    }
}



