package queens;
import java.util.Scanner;

/** class Utility, used to take input of numbers of queens
 *  and call the methoda nQuuen,
 * and return the Harray which showing where queen is placed */

public class Utility {

    public void execute(){
        Operation operation = new Operation();
        Scanner scanner = new Scanner(System.in);

        try{
            int numQueens;
            System.out.println("Enter the numbers of queens");
            numQueens = scanner.nextInt();
            if( numQueens <= 0 ){
                throw new AssertionError("NUmber of queens cannot be less than 1");
            } else if(numQueens == 2 || numQueens == 3){
                throw new AssertionError("Not possible to place queens, in this case");
            }

            
            int[][] ans = new int[numQueens][numQueens];
            ans = operation.nQueen(numQueens);

            // print the resulted array
            for(int index = 0; index < numQueens; index++){
                for(int j = 0; j < numQueens; j++){
                    System.out.print(ans[index][j] + " ");
                }
                System.out.println("\n");
            }
        }catch(AssertionError e){
            System.out.println("Not possible to place queens, in this case");
        }catch(Exception e){
            System.out.println("Unwanted Exception" + e.getMessage());
        }finally{
            scanner.close();
        }

    }   
}
