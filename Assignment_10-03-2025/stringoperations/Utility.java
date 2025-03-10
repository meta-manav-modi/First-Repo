package stringoperations;
import java.util.Scanner;

/** class Utility have main menu to perform all operation or methods like,
 * compare, reverse, change casing, maximum word length
 */

public class Utility{
    public void execute(){
        Scanner sc = new Scanner(System.in);

        Operations operation = new Operations();
        boolean run = true;
        String firstString="";
        String secondString="";

        // Main Menu
        while(run){
            
            // Have all choices and print the output acc to choice
            System.out.println("1. Compare two strings ");
            System.out.println("2. Reverse a string");
            System.out.println("3. Change Casing of string ");
            System.out.println("4. Maximum length word ");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:     // Compare two strings
                    System.out.println("Enter second value"); 
                    firstString = sc.nextLine();
                    System.out.println("Enter second value"); 
                    secondString = sc.nextLine();
                    if(operation.toCompare(firstString, secondString)){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;

                case 2:     // Reverse a string
                    System.out.println("Enter value"); 
                    firstString = sc.nextLine();
                    System.out.println("Reverse string is:" + operation.reverse(firstString));
                    break;

                case 3:     // Change Casing of string
                    System.out.println("Enter value"); 
                    firstString = sc.nextLine();
                    System.out.println("String after casing change:" + operation.changeCasing(firstString));
                    break;

                case 4:     // Maximum length word
                    System.out.println("Enter value"); 
                    firstString = sc.nextLine();
                    System.out.println("Max length word is:" + operation.maxWord(firstString));
                    break;

                case 5:     // Exit
                    run = false;
                    break;
            }
        }
        sc.close();
    }
}