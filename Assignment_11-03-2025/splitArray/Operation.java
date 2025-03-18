package splitArray;

/** class Operation, used to define method toSplitArray and 
 * split array such that sum is equal on both sides
 */

public class Operation {

    /** Method toSplitArray, return index from where we split array
     * @ param array of integer type 
     */
    public int toSplitArray(int[] arr){
        if( arr == null || arr.length == 0){
            throw new AssertionError("Array cannot be empty and null");
        }

        //create left and right array to cal sum at each index
        int[] leftSum = new int[arr.length];
        int[] rightSum = new int[arr.length];
        
        leftSum[0] = arr[0];
        for(int index = 1; index < arr.length; index++){
            leftSum[index] = leftSum[index - 1] + arr[index];
        }

        rightSum[arr.length - 1] = 0;
        for(int index = arr.length - 2;index >= 0; index--){
            rightSum[index] = rightSum[index + 1] + arr[index + 1];
        }

        // checking condition
        for(int index = 0; index < arr.length; index++){
            if(rightSum[index] == leftSum[index]){
                return index + 1;
            }
        }
        return -1;
    }
}
