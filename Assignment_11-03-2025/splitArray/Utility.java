package splitArray;
import java.util.Scanner;

/** class Utility, used to take input of array and call the method toSplitArray,
 * and split the array at equal sum on both sides
 */

public class Utility {
    public void execute(){
        Scanner sc= new Scanner(System.in);
        Operation operation = new Operation();
        int numValues;

        try{
            while (true) {
                System.out.print("Enter numbver of values: ");
                    numValues = sc.nextInt();
    
                    if (numValues > 0) {
                        break;
                    } else {
                        System.out.println("Size cannot be less than zero.");
                    }
            }

            int arr[] = new int[numValues];
            // Loop to take input and add value to array
            for(int index = 0; index < numValues; index++){
                arr[index] = sc.nextInt();
            }

            System.out.println("Index to split array :" + operation.toSplitArray(arr));

        }catch(AssertionError e){
            System.out.println("AssertionError" + e.getMessage());
        }catch(Exception e){
            System.out.println("Unexpected Exception" + e.getMessage());
        }finally{
            sc.close();
        }
    }
}
