package graphics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/** class ShapeTest, used to perform junit test cases on methods */
public class ShapesTest {

    @Test
    public void deleteShapeTest(){
        Screen scr = new Screen();
        FactoryShape factoryMethod = new FactoryShape();
        Shape square = factoryMethod.createShape(Shape.ShapeType.Square, new Point(1, 6), List.of(4.0));
        Shape square1 = factoryMethod.createShape(Shape.ShapeType.Square, new Point(6, 4), List.of(2.4));
        scr.addShape(square1);
        assertFalse(scr.deleteShape(square));
        assertTrue(scr.deleteShape(square1));
    }

    @Test
    public void getValuesTest(){
        FactoryShape factoryMethod = new FactoryShape();
        Shape square = factoryMethod.createShape(Shape.ShapeType.Square, new Point(2, 3), List.of(4.0));
       assertEquals(16.0, square.getArea(), 0.001);
       assertEquals(16.0, square.getPerimeter(), 0.001);

       assertTrue(square.isPointClosed(new Point(3, 4)));
       assertFalse(square.isPointClosed(new Point(10, 10)));
    }
}
