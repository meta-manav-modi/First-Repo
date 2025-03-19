package graphics;

/** class Rectangle, used to implemnet methods like
 * getArea, getPerimeter and many more
 */
public class Rectangle implements Shape {
    private final double length;
    private final double breadth;
    private final long timestamp;
    private Point origin;

    public Rectangle(Point origin, double length, double breadth) {
        this.origin = origin;
        this.length = length;
        this.breadth = breadth;
        this.timestamp = System.nanoTime();
    }

    //Definations of abstract methods
    public double getArea() {
        return Math.round(length * breadth);
    }

    public double getPerimeter() {
        return Math.round(2 * (length + breadth));
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointClosed(Point p) {
        return ((p.getX() >= origin.getX() && p.getX() <= origin.getX() + length)
                && (p.getY() >= origin.getY() && p.getY() <= origin.getY() + breadth));
    }

    //Getters
    public ShapeType getType() {
        return ShapeType.Rectangle;
    }

    public long getTimestamp(){
        return timestamp;
    }
    public double getDistance(Point p){
        double res = origin.distanceFromOrigin(p);
        return res;
    }

}
