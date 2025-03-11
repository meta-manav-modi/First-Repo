package mirrorArray;
import java.util.Scanner;

/** class Utility, used to take input of array and call the method maxMirror,
 * and print maximum length of mirror image of an array 
*/

public class Utility {
    public void execute(){
        Scanner sc= new Scanner(System.in);
        Operation operation = new Operation();
        int numValues;

        try{
            while (true) {
                System.out.print("Enter numbver of values: ");
    
                try{
                    numValues = sc.nextInt();
    
                    if (numValues > 0) {
                        break;
                    } else {
                        System.out.println("Size cannot be less than zero.");
                    }
                } catch(Exception e) {
                    System.out.println("Unknown exception. Try again");
                    System.exit(0);
                }
            }

            int arr[] = new int[numValues];
            // Loop to take input and add value to array
            for(int index = 0; index < numValues; index++){
                    arr[index] = sc.nextInt();
                    if(arr[index] < 0){
                        System.out.println("Only positive values are allowed");
                        System.exit(0);
                    }
            }
            System.out.println("Maximum mirror length of array is :" + operation.maxMirror(arr));
            
        }catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException" + e.getMessage());
        }catch(Exception e){
            System.out.println("Unexpected Exception" + e.getMessage());
        }finally{
            sc.close();
        }
    }

}
