public class Main {
    public static void main(String[] args) {
        CoordinateSystem cs = new CoordinateSystem(500);
        CSPoint p1 = new CSPoint(-50, -50);
        CSPoint p2 = new CSPoint(50, 50);
        cs.addPoint(p1);
        cs.addPoint(p2);
        CSLineSegment l1 = new CSLineSegment(p1, p2);
        cs.addLineSegment(l1);
        CSRenderer csr = new CSRenderer(cs, 1, 5);
    }
}