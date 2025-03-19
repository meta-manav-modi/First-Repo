package graphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Screen class, provide an interface to user to add any shape or delete also
 * have methods like addShape, deleteShape, deleteALllShape of specific type
 * and sort all shapes acc to distance , timestamp, area or perimeter
 */
public class Screen {

    private List<Shape> shapes = new ArrayList<Shape>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public boolean deleteShape(Shape shape) {
        return shapes.remove(shape);
    }

    public void deleteAllShapes(Shape.ShapeType type) {
        for (Shape shape : shapes) {
            if (type.equals(shape.getType())) {
                shapes.remove(shape);
                break;
            }
        }
    }

    /** This method sort shapes acc to area, perimeter and timestamp and print the sorted values */
    public void sortShapes(){
        //Sorting on basis of area
        List<Double> sortedListByArea = new ArrayList<>();
        for( Shape shape : shapes){
            sortedListByArea.add(shape.getArea());
        }
        System.out.println("Sorting on basis of area");
        Collections.sort(sortedListByArea);
        for(int index = 0; index < sortedListByArea.size(); index++){
            System.out.print(sortedListByArea.get(index) + " ");
        }

        //Sorting on basis of perimeter
        List<Double> sortedListByPerimeter = new ArrayList<>();
        for( Shape shape : shapes){
            sortedListByPerimeter.add(shape.getPerimeter());
        }
        System.out.println("\nSorting on basis of perimeter");
        Collections.sort(sortedListByPerimeter);
        for(int index = 0; index < sortedListByPerimeter.size(); index++){
            System.out.print(sortedListByPerimeter.get(index) + " ");
        }

        //Sorting on basis of timestamp
        List<Long> sortedListByTimestamp = new ArrayList<>();
        for( Shape shape : shapes){
            sortedListByTimestamp.add(shape.getTimestamp());
        }
        System.out.println("\nSorting on basis of timestamp");
        Collections.sort(sortedListByTimestamp);
        for(int index = 0; index < sortedListByTimestamp.size(); index++){
            System.out.print(sortedListByTimestamp.get(index) + " ");
        }
    }
    public void sortByDistance(Point p){
        List<Double> sortedListByDistance = new ArrayList<>();
        for( Shape shape : shapes){
            sortedListByDistance.add(shape.getOrigin().distanceFromOrigin(p));
        }
        System.out.println("\nSorting on basis of Distance from origin");
        Collections.sort(sortedListByDistance);
        for(int index = 0; index < sortedListByDistance.size(); index++){
            System.out.print(sortedListByDistance.get(index) + " ");
        }
    }

    public List<Shape> pointEnclosedShape(Point p) {
        List<Shape> listOfShapesEnclosedInPoint = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.isPointClosed(p)) {
                listOfShapesEnclosedInPoint.add(shape);
            }
        }
        return listOfShapesEnclosedInPoint;
    }

}
