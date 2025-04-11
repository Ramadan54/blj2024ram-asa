import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class CSPoint extends Point implements DrawableShape {
    private static int nextId = 1;
    private final int id;

    public CSPoint(int x, int y) {
        super(x, y);
        this.id = nextId++;
    }
    public CSPoint() {
        this(0, 0);
    }
    @Override
    public void draw(Graphics2D g2d, int fieldScale, int pointSize, int size) {
        int px = x * fieldScale + size / 2;
        int py = size / 2 - y * fieldScale;

        g2d.setColor(Color.BLUE);
        g2d.fillOval(px - pointSize / 2, py - pointSize / 2, pointSize, pointSize);
    }
}
