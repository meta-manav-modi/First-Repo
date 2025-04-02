package stackQ1;

import java.util.Scanner;

/** class Utility, take the input and call evaluation function 
 * and return the output of the expression
 */
public class Utility {
    public void execute(){
        Evaluate eva = new Evaluate();
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter your string expression");
            String expr = sc.nextLine();
            System.out.println( "Result is :" + eva.evaluate(expr));
        }catch(Exception e){
            System.out.println("Unwanted Error" + e.getMessage());
        }finally{
            sc.close();
        }

    }
}
