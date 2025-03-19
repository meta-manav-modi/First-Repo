package graphics;

/** class RegularPolygon, used to implement all methods like
 * getArea, getPerimeter, isPossible and many more
*/
public class RegularPolygon implements Shape{
    private final double length;
    private final double numOfSides;
    private final double apothem;
    private final long timestamp;
    private Point origin;

    public RegularPolygon(Point origin, double length, double apothem, double numOfSides) {
        this.origin = origin;
        this.length = length;
        this.apothem = apothem;
        this.numOfSides = numOfSides;
        this.timestamp = System.nanoTime();
    }

    //Definations of abstract methods
    public double getArea() {
        return Math.round(length * apothem * numOfSides) / 2;
    }

    public double getPerimeter() {
        return Math.round(length * numOfSides);
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointClosed(Point p) {
        return ((p.getX() >= origin.getX() && p.getX() <= origin.getX() + length)
                && (p.getY() >= origin.getY() && p.getY() <= origin.getY() + apothem));
    }

    //Getters
    public ShapeType getType() {
        return ShapeType.RegularPolygon;
    }

    public long getTimestamp(){
        return timestamp;
    }
    public double getDistance(Point p){
        double res = origin.distanceFromOrigin(p);
        return res;
    }

}
