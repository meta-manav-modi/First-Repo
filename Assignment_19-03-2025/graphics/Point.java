package graphics;
/** class Point used to have the coordinates control */
public class Point {
    private final int XMax = 101;
    private final int YMax = 101;
    private final double x;
    private final double y;


    public Point(double x, double y){
        this.x = x;
        this.y = y;
        if(x > XMax || y > YMax) throw new AssertionError("Out of the screen");
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    /** Method distance calculator from origin
     * @ param object of point class
     */
    public double distanceFromOrigin(Point p){
        double distanceX = this.x - p.x;
        double distanceY = this.y - p.y;

        return Math.round(Math.sqrt((distanceX * distanceX) + (distanceY * distanceY)));
    }
}
