package search;

/**class Operation , used to perform methods like linear and binary searches
 * and return the indexes of search find */

public class Operation {

    /** findLinearSearch, return the index at which search is find
     * @ param array, size and target to find in integer type
     */

    public int findLinearSearch(int[] arr, int size, int target){
        if( arr == null || arr.length == 0){
            throw new AssertionError("Array cannot be null or mepty");
        }

        if( size == arr.length){
            return -1;
        } else if( arr[size] == target ){
            return size + 1;
        }

        return findLinearSearch(arr, size + 1, target);
    }

     /** findBinarySearch, return the index at which search is find
     * @ param array, size and target to find in integer type
     */
    public int findBinarySearch(int[] arr, int size, int target){
        if( arr == null || arr.length == 0){
            throw new AssertionError("Array cannot be null or mepty");
        }
        int beg = 0;
        int end = size - 1;
        return toBinary(arr, target, beg, end);
    }

     /** toBinary, return the index at which search is find
      * performing the recursion here
     * @ param array, target, beginneing and ending index  to find in integer type
     */
    public int toBinary(int[] arr, int target, int beg, int end){
        
        if (beg > end){
            return -1;
        }
        int mid = beg + (end - beg) / 2;

        if( arr[mid] == target ){
            if( mid == 0 || arr[mid -1] != target){
                return mid + 1;
            } else{
                return toBinary(arr, target, beg, mid -1 );
            }
        }
        if(arr[mid] > target) {
            return toBinary(arr, target, beg, mid - 1);
        }
        if( arr[mid] < target ){ 
            return toBinary(arr, target, mid + 1, end);
        }
    return -1;
    }
}
