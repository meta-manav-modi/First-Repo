package subList;

import java.util.Scanner;

/** class Utility, used to take input in linked list and call the function to rotate the substring */
public class Utility {
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        SubListWithRotate subList = new SubListWithRotate();
        int size;
        int startIndex;
        int endIndex;
        int numOfRotations;

        // Enter size of the liked list
        while(true){
            System.out.println("Enter the number of values in linked list");
            size = scanner.nextInt();
            if(size <= 0){
                System.out.println("Size cannot be leass than 1");
            }else{
                break;
            }
        }

        try{
            System.out.println("Enter the values in linked list");
            for(int index = 0; index < size; index++){
                int value = scanner.nextInt();
                subList.insert(value);
            }

            System.out.println("Original List");
            System.out.println(subList.display());
            System.out.println("Enter the starting and end index, with number of rotations");
            startIndex = scanner.nextInt();
            endIndex = scanner.nextInt();
            numOfRotations = scanner.nextInt();
            subList.rotateSubList(startIndex,endIndex, numOfRotations);
            System.out.println("Modified List");
            System.out.println(subList.display());

        }catch(AssertionError e){
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            scanner.close();
        }
    }
}
