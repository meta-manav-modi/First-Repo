package area;
import java.util.Scanner;

/** class Utility have the main menu to perform operations like,
 * Area of triangle, circle, square, rectangle,
 * Having main menu to oerform operations
 */

public class Utility{
    public void execute(){
        Scanner sc = new Scanner(System.in);
        Operations operation = new Operations();
        boolean run = true;
         
        // declare variables
        double height;
        double width;
        double radius;

        // Main menu
        while(run){
            System.out.println("1. Area of Triangle");
            System.out.println("2. Area of Rectangle");
            System.out.println("3. Area of Square");
            System.out.println("4. Area of Circle");
            System.out.println("5. Exit");
            int choice = sc.nextInt();

            // Switch Case
            switch(choice){
                case 1:    //Area of Triangle
                    try{
                        System.out.println("Enter height");
                        height = sc.nextDouble();
                        System.out.println("Enter width");
                        width = sc.nextDouble();
                        System.out.println("Area of Triangle :" + operation.areaTriangle(height, width));
                    }catch(ArithmeticException e){
                        System.out.println ("Width & height must be greater than 0"); 
                    }
                    break;
                    
                case 2:    //Area of Rectangle
                try{
                        System.out.println("Enter height");
                        height = sc.nextDouble();
                        System.out.println("Enter width");
                        width = sc.nextDouble();
                        System.out.println("Area of Rectangle :" + operation.areaRectangle(height, width));
                }catch(ArithmeticException e){
                    System.out.println ("Width & height must be greater than 0"); 
                }
                    break;
                case 3:    //Area of Square
                    try{
                        System.out.println("Enter width");
                        width = sc.nextDouble();
                        System.out.println("Area of Square :" + operation.areaSquare(width));
                    }catch(ArithmeticException e){
                        System.out.println ("Width must be greater than 0"); 
                    }
                    break; 

                case 4:    //Area of Circle
                    try{
                        System.out.println("Enter radius");
                        radius = sc.nextDouble();
                        System.out.println("Area of Circle" + operation.areaCircle(radius));
                    }catch(ArithmeticException e){
                        System.out.println ("Radius must be greater than 0"); 
                    }
                    break;

                case 5:    //Exit
                    run = false;
                    break;
            }
        }
        sc.close();
    }
}