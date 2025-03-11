package mirrorArray;

/** class Operation, used to perform the method maxMirror */
public class Operation {
    
    /** Method maxMirror, return the maximum mirror length in array
     * @ param array of integer type
     */

    public int maxMirror(int[] arr) {

        if(arr.length == 0 || arr == null){
            throw new AssertionError("Array cannot be empty");
        }
        int maxCount = 1;
        boolean flag = false;
        
        for(int index = 0; index < arr.length; index++)
        {
           int tempCount = 1;
           int count = index;
      
           for(int j = arr.length - 1; j >=0 && (count < arr.length ); j--)
           {
              if((arr[count] == arr[j]) && !(flag))
              {
                flag = true;
                count++;
                continue;
              }
              if((arr[count] == arr[j]) && (flag))
              {
                tempCount++;
                count++;
                maxCount = (tempCount > maxCount) ? tempCount : maxCount;
                continue;
              }
              if(!(arr[index] == arr[j]) && (flag))
              {
                flag = false;
                count = index;
                tempCount = 1;
                continue;
              }
              if((j == count) || (j - count) == 1)
              {
                flag = false;
                break;
                }
            }
        }    
        return maxCount;    
      
      }
    
}
