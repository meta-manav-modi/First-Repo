package graphics;

/** rovides an interface to user, It is a Interface */
public interface Shape {

    public  double getArea();
    public  double getPerimeter();
    public  Point getOrigin();
    public  ShapeType getType();
    public  boolean isPointClosed(Point p);
    public  long getTimestamp();
    
    enum ShapeType {
        Circle,
        Rectangle,
        Square,
        Triangle,
        RegularPolygon
    }

   
}