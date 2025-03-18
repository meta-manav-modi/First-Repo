package search;
import java.util.Arrays;
import java.util.Scanner;


/** class Utility, used to take input of array and call the method 
 * like findBinaySearch and findLinearSearch,
 * and print the index at which target is matched */
public class Utility {
    public void execute(){
        Scanner sc = new Scanner(System.in);
        Operation operation = new Operation();

        try{
            int numValues;
            while(true){
                try{
                    System.out.println("Enter the size of array");
                    numValues = sc.nextInt();

                    if(numValues <= 0){
                        System.out.println("Size cannot be less than 0");
                    } else{
                        break;
                    }
                } catch(Exception e) {
                    System.out.println("Unknown exception. Try again");
                    System.exit(0);
                }
            }
            int arr[] = new int[numValues];
            
            // Loop to take input and add value to array
            for(int index = 0; index < numValues; index++){
                try{
                    arr[index] = sc.nextInt();
                }catch(Exception e){
                    System.out.println("Wrong input" + e.getMessage());
                }
            }
            System.out.println("Enter target to seach in array");
            int target = sc.nextInt();
            System.out.println("Linear search result position is:" + operation.findLinearSearch(arr, 0, target));

            Arrays.sort(arr);
            System.out.println("Sorted array is");
            for(int index = 0; index < numValues; index++){
                System.out.print(arr[index] + " " );
            }
            System.out.println("\nBinary search result position is:" + operation.findBinarySearch(arr, numValues, target));
        }catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException" + e.getMessage());
        }catch(Exception e){
            System.out.println("Unexpected Exception" + e.getMessage());
        }finally{
            sc.close();
        }
    }
}
