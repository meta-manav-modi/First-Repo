import java.util.List;

import graphics.*;

/** Main class have main function to perform all concept */
public class MainClass {
    public static void main(String[] args){

        Screen screen = new Screen();
        try{
        FactoryShape factoryMethod = new FactoryShape();
        Shape circle = factoryMethod.createShape(Shape.ShapeType.Circle, new Point(3, 3), List.of(3.0));
        Shape square = factoryMethod.createShape(Shape.ShapeType.Square, new Point(1, 6), List.of(4.0));
        Shape square1 = factoryMethod.createShape(Shape.ShapeType.Square, new Point(6, 4), List.of(2.4));
        Shape circle1 = factoryMethod.createShape(Shape.ShapeType.Circle, new Point(3, 9), List.of(5.3));
        Shape rectangle = factoryMethod.createShape(Shape.ShapeType.Rectangle, new Point(3, 2), List.of(3.6, 9.3));
        
        screen.addShape(circle);
        screen.addShape(square);
        screen.addShape(square1);
        screen.addShape(circle1);
        screen.addShape(rectangle);
        screen.deleteShape(square);
        screen.deleteAllShapes(Shape.ShapeType.Circle);
        screen.sortShapes();

        screen.sortByDistance(new Point(5, 5));
        }catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException" + e.getMessage());
        }catch(Exception e){
            System.out.println("Unwanted Exception" + e.getMessage());
        }

    }
}
