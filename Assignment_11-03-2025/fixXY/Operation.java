package fixXY;

/** class Operation, used to perform the method changedArray
 * and return the array after changeing acc to positions of X and Y
 */
public class Operation {

    /** Method changedArray, return the array after changing positions acc to X and Y
     * @ param array of ineteger type, variable X and Y of int type
     */

    public int[] changedArray(int[] arr, int X, int Y)throws AssertionError, IllegalArgumentException{
        
        if(arr == null){
            throw new IllegalArgumentException("Array cannot be null");
        }
        if(arr.length == 0){
            throw new AssertionError("Array cannot be empty");
        }

        int countX = 0;
        int countY = 0;

        // habdelling all the required condition 
        for(int index = 0; index < arr.length; index++){
            if(arr[arr.length - 1] == X){
                throw new AssertionError("Last element is X");
            }
            if(arr[index] == X && arr[index + 1] == X){
                throw new AssertionError("Two consecutive X are there");
            }
            if(arr[index] == X){
                countX++;
            }
            else if(arr[index] == Y){
                countY++;
            }
        }
        if(countX != countY){
            throw new AssertionError("X and Y are not equal in number");
        }

        // visited array to have status of each index
        int[] result =  new int[arr.length];
        boolean[] visited = new boolean[arr.length];    
        
        if(arr[0] != X && arr[0] != Y){
            result[0] = arr[0];
            visited[0] = true;
        }
        for(int index = 0; index < arr.length; index++){

            // if X is at correct position
            if( arr[index] == X){
                result[index] = X;
                visited[index] = true;
                
                // If Y is at correct position
                if(arr[index + 1] == Y){
                    result[index + 1] = Y;
                    visited[index + 1] = true;
                }else if( arr[index + 1] != Y){
                    int currValue = arr[index + 1];

                    for(int index1 = 0; index1 < arr.length; index1++){
                        if(arr[index1] == Y && !visited[index1]){
                            result[index + 1] = Y;
                            result[index1] = currValue;
                            visited[index + 1] = true;
                            visited[index1] = true;
                            index++;
                            break;
                        }
                    }
                }
            }
        }
        return result; 
    }
}
