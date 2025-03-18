package lcmhcf;
import java.util.Scanner;

/** class Utility, used to take input of numbers x and y
 *  and call the methoda findLcm and findHcf,
 * and return the HCF and LCM of numbers */

public class Utility {
    public void execute(){
        Scanner sc = new Scanner(System.in);
        Operation operation = new Operation();
        
        try{
            int x;
            int y;
            while(true){
                System.out.println("Enter the numbers x and y");
                x = sc.nextInt();
                y = sc.nextInt();

                if( x <= 0 || y <= 0){
                    throw new AssertionError(("Numbers cannot be less than 0"));
                } else{
                    break;
                }
            }
            System.out.println("LCM of numbers is : " + operation.findLcm(x, y, Math.max(x, y)));
            System.out.println("HCF of numbers is : " + operation.findHcf(x, y));
        }catch(AssertionError e){
            System.out.println("AssertionError" + e.getMessage());
        }catch(Exception e){
            System.out.println("Unwanted Exception" + e.getMessage());
        }finally{
            sc.close();
        }

    }
    
}
