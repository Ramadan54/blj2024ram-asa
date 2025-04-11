import java.util.ArrayList;
import java.util.List;

public class CoordinateSystem {
    private final int size;
    private final List<DrawableShape> shapes;

    public CoordinateSystem(int size) {
        if (size <= 0 || size % 20 != 0) {
            throw new IllegalArgumentException("Size must be positive and divisible by 20");
        }
        this.size = size;
        this.shapes = new ArrayList<>();
    }
    public int getCoordinateSystemSize() {
        return size;
    }
    public List<DrawableShape> getAllShapes() {
        return shapes;
    }
    public void addShape(DrawableShape shape) {
        shapes.add(shape);
    }
}
