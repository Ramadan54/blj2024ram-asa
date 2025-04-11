public class Main {
    public static void main(String[] args) {
        CoordinateSystem cs = new CoordinateSystem(500);
        CSPoint p1 = new CSPoint(-50, -50);
        CSPoint p2 = new CSPoint(50, 50);
        CSLineSegment l1 = new CSLineSegment(p1, p2);

        cs.addShape(p1);
        cs.addShape(p2);
        cs.addShape(l1);

        CSRenderer renderer = new CSRenderer(cs, 1, 5);
    }
}
