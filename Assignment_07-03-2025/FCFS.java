package fcfs;
import java.util.Scanner;

/** FCFS class provides operations to get number of processes and 
 * take arrival and burst time from the user, than execute the menu
 */

public class FCFS{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int numProcess;        // Enter the number of processes

        System.out.println("Enter number of process");
        numProcess = sc.nextInt();
        int process[][] =new int[numProcess][2];
        
        // Getting input of arrival and burst time from user
        try{
            for( int index = 0; index < numProcess; index++ ){
                process[index][0] = sc.nextInt();
                process[index][1] = sc.nextInt();
            }
        } catch(Exception e){
            System.out.println(" Wronh input, please try again");
        }

        // calculate all the time values
        Calculation calc = new Calculation(process); // a 
        calc.calculationTimes();
        
        // execute the main menu
        Execution execute = new Execution();
        execute.executeMenu(sc, calc);
    }
}