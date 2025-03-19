package graphics;

/** class Square, used to implement all methods like
 * getArea, getPerimeter, isPossible and many more
*/
public class Square implements Shape {
    private final double side;
    private final long timestamp;
    private Point origin;

    public Square(Point origin, double side) {
        this.side = side;
        this.origin = origin;
        this.timestamp = System.nanoTime();
    }

    //Definations of abstract methods
    public double getArea() {
        return Math.round(side * side);
    }

    public double getPerimeter() {
        return Math.round(4 * side);
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointClosed(Point p) {
        return ((p.getX() >= origin.getX() && p.getX() <= origin.getX() + side)
                && (p.getY() >= origin.getY() && p.getY() <= origin.getY() + side));
    }

    //Getters
    public ShapeType getType() {
        return ShapeType.Square;
    }

    public long getTimestamp(){
        return timestamp;
    }

    public double getDistance(Point p){
        double res = origin.distanceFromOrigin(p);
        return res;
    }

}
