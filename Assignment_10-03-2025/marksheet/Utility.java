package marksheet;
import java.util.Scanner;
import java.util.HashMap;

/** class Utility have main menu to perform all operation or methods like,
 * average, minimum, maximum, passed percentage,
 */

public class Utility{
    public void execute(){
        Scanner sc = new Scanner(System.in);
        int numStudent;

        while (true) {
            System.out.print("Enter number of students: ");

            try{
                numStudent = sc.nextInt();

                if (numStudent > 0) {
                    break;
                } else {
                    System.out.println("Number of student cannot be below or equal to zero.");
                }
            } catch(Exception e) {
                System.out.println("Unknown exception. Try again");
                System.exit(0);
            }
        }

        Operations operation = new Operations();

        for(int index = 1; index <= numStudent; index++){
            System.out.println("Enter the key and grades od student" + index);
            String id = sc.next();
            double marks = sc.nextDouble();
            if(marks < 0 ){
                throw new ArithmeticException("Marks cannot be negative");
            }
            operation.addGrade(id, new Student(marks));
        }

        boolean run = true;

        // Main Menu
        while(run){
            
            // Have all choices and print the output acc to choice
            try{
            System.out.println("1. Average marks");
            System.out.println("2. Maximum grade");
            System.out.println("3. Minimum grade");
            System.out.println("4. Percenatge of student passed");
            System.out.println("5. Exit");
            int choice = sc.nextInt();

            switch(choice){
                case 1:     // Print average of all grades
                    System.out.println("Average marks are :" + operation.average());
                    break;
                case 2:     // Print maximum from all grades
                    System.out.println("Maximum grade is :" + operation.maximumGrade());
                    break;
                case 3:     // Print minimum from all grades
                    System.out.println("Minimun grade is :" + operation.minimumGrade());
                    break;
                case 4:     // Print percentage of student passed
                    System.out.println("Percentage of Student passed %:" + operation.passedStudent() * 100);
                    break;
                case 5:     // Exit
                    run = false;
                    break;
            }
            }catch(ArithmeticException e ){
                System.out.println( e.getMessage());
            } 
        }
        sc.close();
    }
}