package clump;
import java.util.Scanner;

/** class Utility, used to take input of array and call the method numClump,
 * and count number of clumps */
public class Utility {

    public void execute(){
        Scanner sc = new Scanner(System.in);
        Operation operation = new Operation();
        
        try{
            System.out.println("Enter number of values");
            int numValues = sc.nextInt();

            if( numValues <= 0){
                System.out.println("Size must be greater than 0");
            }
            
            int arr[] = new int[numValues];
            // Loop to take input and add value to array
            for(int index = 0; index < numValues; index++){
                arr[index] = sc.nextInt();
                if(arr[index] <= 0){
                    System.out.println("Only positive values are allowed");
                    return;
                }
            }
            System.out.println("Number of clumps is :" + operation.numClump(arr));
        }catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException" + e.getMessage());
        }catch(Exception e){
            System.out.println("Unexpected Exception" + e.getMessage());
        }finally{
            sc.close();
        }
    }
}
