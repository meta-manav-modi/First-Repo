package graphics;

/** class Triangle, used to implement all methods like
 * getArea, getPerimeter, isPossible and many more
*/
public class Triangle implements Shape {
    private final double base;
    private final double height;
    private final long timestamp;
    private Point origin;

    public Triangle(Point origin, double base, double height) {
        this.origin = origin;
        this.base = base;
        this.height = height;
        this.timestamp = System.nanoTime();
    }

    //Definations of abstract methods
    public double getArea() {
        return Math.round((base * height ) / 2);
    }

    public double getPerimeter() {
        double hypotaneous = Math.sqrt(base * base + height * height);
        return Math.round(base + height + hypotaneous);
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointClosed(Point p) {
        return ((p.getX() >= origin.getX() && p.getX() <= origin.getX() + base)
                && (p.getY() >= origin.getY() && p.getY() <= origin.getY() + height));
    }

    //Getters
    public ShapeType getType() {
        return ShapeType.Triangle;
    }

    public long getTimestamp(){
        return timestamp;
    }
    public double getDistance(Point p){
        double res = origin.distanceFromOrigin(p);
        return res;
    }

}
