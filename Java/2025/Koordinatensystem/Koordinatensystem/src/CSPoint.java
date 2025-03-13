import java.awt.*;

public class CSPoint extends Point {
    private static int nextId = 1;
    private final int id;

    public CSPoint(int x, int y) {
        super(x, y);
        this.id = nextId++;
    }

    public CSPoint() {
        this(0, 0);
    }
}