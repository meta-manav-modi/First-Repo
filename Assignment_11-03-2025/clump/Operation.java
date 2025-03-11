package clump;

/** class Operation is used to calculate the number of clumps present in array
 * return the number of clumps as integer type
 */
public class Operation{

    /** Method numClump calculate no of clumps, return countClump */
    public int numClump(int[] arr) throws AssertionError, IllegalArgumentException{
        
        if(arr == null){
            throw new IllegalArgumentException("Array cannot be null");
        }
        if(arr.length == 0){
            throw new AssertionError("Array cannot be empty");
        }
        int countClump = 0;
            for (int index = 0; index < arr.length - 1; index++) {
                if( arr[index] == arr[index + 1]){
                    countClump++;
                    while (index < arr.length - 1 && arr[index] == arr[index + 1]) {
                        index++;
                    }
                }
            }
        return countClump;  
    }
}