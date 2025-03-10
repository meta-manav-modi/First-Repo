package marksheet;
import java.util.Scanner;
import java.util.HashMap;

/** class Utility have main menu to perform all operation or methods like,
 * average, minimum, maximum, passed percentage, Hashmap is used
 * To store the grades acc to their key
 */

public class Utility{
    public void execute(){
        System.out.println("Enter number of students");
        Scanner sc = new Scanner(System.in);
        int numStudent = sc.nextInt();
        
        // HashMap to store the grades
        HashMap<String, Student> grade = new HashMap<>();

        for(int index = 1; index <= numStudent; index++){
            System.out.println("Enter the key and grades od student" + index);
            String id = sc.next();
            double marks = sc.nextDouble();
            grade.put(id, new Student(marks));
        }

        Operations operation = new Operations(grade);
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
                    System.out.println("Average marks are :" + operation.average(grade));
                    break;
                case 2:     // Print maximum from all grades
                    System.out.println("Maximum grade is :" + operation.maximumGrade(grade));
                    break;
                case 3:     // Print minimum from all grades
                    System.out.println("Minimun grade is :" + operation.minimumGrade(grade));
                    break;
                case 4:     // Print percentage of student passed
                    System.out.println("Percentage of Student passed %:" + operation.passedStudent(grade) * 100);
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