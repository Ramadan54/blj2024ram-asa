import java.awt.Color;
import java.awt.Graphics2D;

public class CSLineSegment implements DrawableShape {
    private final CSPoint startPoint;
    private final CSPoint endPoint;

    public CSLineSegment(CSPoint startPoint, CSPoint endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    public CSPoint getStartPoint() {
        return startPoint;
    }
    public CSPoint getEndPoint() {
        return endPoint;
    }
    @Override
    public void draw(Graphics2D g2d, int fieldScale, int pointSize, int size) {
        int x1 = startPoint.x * fieldScale + size / 2;
        int y1 = size / 2 - startPoint.y * fieldScale;
        int x2 = endPoint.x * fieldScale + size / 2;
        int y2 = size / 2 - endPoint.y * fieldScale;

        g2d.setColor(Color.GREEN);
        g2d.drawLine(x1, y1, x2, y2);
    }
}
