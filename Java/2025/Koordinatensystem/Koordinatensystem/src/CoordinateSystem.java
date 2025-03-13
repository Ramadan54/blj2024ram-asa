import java.util.ArrayList;
import java.util.List;

public class CoordinateSystem {
    private final int size;
    private final List<CSPoint> points;
    private final List<CSLineSegment> lineSegments;

    public CoordinateSystem(int size) {
        if (size <= 0 || size % 20 != 0) {
            throw new IllegalArgumentException("Size must be positive and divisible by 20");
        }
        this.size = size;
        this.points = new ArrayList<>();
        this.lineSegments = new ArrayList<>();
    }

    public int getCoordinateSystemSize() {
        return size;
    }

    public CSPoint[] getAllPoints() {
        return points.toArray(new CSPoint[0]);
    }

    public CSLineSegment[] getAllLineSegments() {
        return lineSegments.toArray(new CSLineSegment[0]);
    }

    public void addPoint(CSPoint point) {
        points.add(point);
    }

    public void addLineSegment(CSLineSegment lineSegment) {
        lineSegments.add(lineSegment);
    }
}