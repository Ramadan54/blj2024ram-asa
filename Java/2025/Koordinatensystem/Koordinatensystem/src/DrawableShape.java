import java.awt.Graphics2D;

public interface DrawableShape {
    void draw(Graphics2D g2d, int fieldScale, int pointSize, int size);
}
