package graphics;

import java.util.List;

/** class FactoryShape , used to create factory method to implement object creation */
public class FactoryShape {

    public Shape createShape(Shape.ShapeType type, Point origin, List<Double> values) {
        if (type.equals(Shape.ShapeType.Circle)) {
            return new Circle(origin, values.get(0));
        } else if (type.equals(Shape.ShapeType.Rectangle)) {
            return new Rectangle(origin, values.get(0), values.get(1));
        } else if (type.equals(Shape.ShapeType.Square)) {
            return new Square(origin, values.get(0));
        } else if (type.equals(Shape.ShapeType.Triangle)) {
            return new Triangle(origin, values.get(0), values.get(1));
        } else if (type.equals(Shape.ShapeType.RegularPolygon)) {
            return new RegularPolygon(origin, values.get(0), values.get(1), values.get(2));
        } else {
            throw new IllegalArgumentException("Unsupported Shape type");
        }
    }

}