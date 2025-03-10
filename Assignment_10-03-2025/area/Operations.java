package area;
import java.lang.Math;

/** class Operations, have all methods to perform like
 * area of triangle, circle, square, rectangle
 */
public class Operations{

    /**Method areaTrianle, return area of triangle
     * @ param height and width
     */
    public double areaTriangle(double height, double width){
        if( height <= 0 || width <= 0){
            throw new ArithmeticException("Width & height must be greater than 0");
        }
        double triangle = (height * width) / 2;
        return triangle;
    }

    /**Method areaRectangle, return area of rectangle 
     *  @ param height and width
    */
    public double areaRectangle(double height, double width){
        if( height <= 0 || width <= 0){
            throw new ArithmeticException("Width & height must be greater than 0");
        }
        double rectangle = height * width;
        return rectangle;
    }
    
    /**Method areaSquare, return area of square 
     * @ param width
    */
    public double areaSquare(double width){
        if( width <= 0){
            throw new ArithmeticException("Width must be greater than 0");
        }
        double square = width * width;
        return square;
    }
    
    /**Method areaCircle, return area of circle
     * @ param radius 
     */
    public double areaCircle(double radius){
        if( radius <= 0){
            throw new ArithmeticException("Radius must be greater than 0");
        }
        double circle = Math.PI * radius * radius;
        return circle;
    }
}