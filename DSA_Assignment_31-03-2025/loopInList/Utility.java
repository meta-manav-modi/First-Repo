package loopInList;
import java.util.Scanner;

/** class Utility, used to take input in linked list and call the function to rotate the substring */
public class Utility {
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        LoopInList loop = new LoopInList();
        int size;

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
                loop.insert(value);
            }

            loop.createLoop(2);
            System.out.println("Loop detected : " + loop.isLoopDetected());

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
