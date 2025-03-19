package graphics;

/** class Circle, used to implement all methods like
 * getArea, getPerimeter, isPossible and many more
*/
public class Circle implements Shape {
    private Point origin;
    private final double radius;
    private final long timestamp;

    public Circle(Point origin, double radius) {
        this.origin = origin;
        this.radius = radius;
        this.timestamp = System.nanoTime();
    }

    // Definations of abstract methods
    public double getArea() {
        return Math.round(Math.PI * radius * radius);
    }

    public double getPerimeter() {
        return Math.round(Math.PI * radius * 2);
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointClosed(Point p) {
        return ((p.getX() >= origin.getX() && p.getX() <= origin.getX() + radius)
        && (p.getY() >= origin.getY() && p.getY() <= origin.getY() + radius));
    }

    //Getters
    public ShapeType getType() {
        return ShapeType.Circle;
    }

    public long getTimestamp(){
        return timestamp;
    }
    public double getDistance(Point p){
        double res = origin.distanceFromOrigin(p);
        return res;
    }

}