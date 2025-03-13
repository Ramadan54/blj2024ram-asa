public class CSLineSegment {
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
}