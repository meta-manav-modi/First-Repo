package convertor;
import java.util.Scanner;

/** Execution class provides function executeMenu to implement the Menu on screen
 * support operations like addition, subtraction, multiplication, division
 * and check comparity like greater, less and equal to
 * convert hexan to deci and vice-vers
 */
public class Execution{
    public void executeMenu(){
        Scanner sc = new Scanner(System.in);
        String firstNumber;
        String secondNumber;
        boolean run = true;
        int answer;
        Calculator calc = new Calculator();
        while(run){
            
            // Main Menu 
            System.out.println("1. Add function:");
            System.out.println("2. Subtract function:");
            System.out.println("3. Multiplication functiony:");
            System.out.println("4. Division function:");
            System.out.println("5. Equal to function:");
            System.out.println("6. Greater than function:");
            System.out.println("7. Less than function:");
            System.out.println("8. Hexadecimal to decimal:");
            System.out.println("9. Decimal to Hexadecimal:");
            System.out.println("10. Exit:");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
        switch(choice){
            case 1:
                // Add Function
                try{
                firstNumber = sc.next();
                secondNumber = sc.next();
                answer = calc.hexaToDeci(firstNumber) + calc.hexaToDeci(secondNumber);
                System.out.println("Output of Addition is  :" + calc.deciToHeca(answer));
                } catch(NumberFormatException e){
                     throw new IllegalArgumentException("Invalid hexadecimal numbers");
                }
                break;

            case 2:
                //Subtract Function
                try{
                firstNumber = sc.next();
                secondNumber = sc.next();
                answer = calc.hexaToDeci(firstNumber) - calc.hexaToDeci(secondNumber);
                System.out.println("Output of Subtraction is  :" + calc.deciToHeca(answer));
                } catch(NumberFormatException e){
                     throw new IllegalArgumentException("Invalid hexadecimal numbers");
                }
                break;

            case 3:
                // Multiply Function
                try{
                firstNumber = sc.next();
                secondNumber = sc.next();
                answer = calc.hexaToDeci(firstNumber) * calc.hexaToDeci(secondNumber);
                System.out.println("Output of Multiplication is  :" + calc.deciToHeca(answer));
                } catch(NumberFormatException e){
                     throw new IllegalArgumentException("Invalid hexadecimal numbers");
                }
                break;

            case 4:
                //Divide Function
                try{
                firstNumber = sc.next();
                secondNumber = sc.next();
                answer = calc.hexaToDeci(firstNumber) / calc.hexaToDeci(secondNumber);
                System.out.println("Output of Division is  :" +  calc.deciToHeca(answer));
                } catch(NumberFormatException e){
                     throw new IllegalArgumentException("Invalid hexadecimal numbers");
                }
                break;

            case 5:
                // Equal to numbers ==
                try{
                firstNumber = sc.next();
                secondNumber = sc.next();
                System.out.println(calc.equalTo(firstNumber, secondNumber));
                } catch(NumberFormatException e){
                     throw new IllegalArgumentException("Invalid hexadecimal numbers");
                }
                break;

            case 6:
                // Greater than > numbers
                try{
                firstNumber = sc.next();
                secondNumber = sc.next();
                System.out.println(calc.greaterTo(firstNumber, secondNumber));
                } catch(NumberFormatException e){
                     throw new IllegalArgumentException("Invalid hexadecimal numbers");
                }
                break;

            case 7:
                // Less than < numbers
                try{
                firstNumber = sc.next();
                secondNumber = sc.next();
                System.out.println(calc.lessTo(firstNumber, secondNumber));
                } catch(NumberFormatException e){
                     throw new IllegalArgumentException("Invalid hexadecimal numbers");
                }
                break;

            case 8:
                // Convert Hexadecimal to Decimal
                System.out.println("Enter the hexadecimal value:");
                try{
                firstNumber = sc.next();
                System.out.println("Decimal is : " + calc.hexaToDeci(firstNumber));
                } catch(NumberFormatException e){
                     throw new IllegalArgumentException("Invalid hexadecimal numbers");
                }
                break;

            case 9:
                // Conert Decimal to Hexadecimal
                System.out.println("Enter the decimal value:");
                try{
                int number = sc.nextInt();
                System.out.println("Hexadecimal is : " + calc.deciToHeca(number));
                } catch(NumberFormatException e){
                     System.out.println("Your input is invalid, please try again");
                }
                break;

            case 10:
                // Exit
                run = false;
                break;

            default:
                System.out.println("Not appropriate choice input");
                break;
        }
        }
        sc.close();
    }
}