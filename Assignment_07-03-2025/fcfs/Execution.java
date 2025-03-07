package fcfs;
import java.util.Scanner;

/** Execution class provides the menu to perform all operation 
 * operation like print completion, turnaround, waiting time of ach process
 * and print average and maximum waiting time
 */

public class Execution{
    // Scanner sc = new Scanner(System.in);
    // Calculation calc = new Calculation(); // b 
    // InputTime inputTime = new InputTime();
    public void executeMenu(Scanner sc, Calculation calc){
        boolean run = true;

        // Main menu to perform multiple operations
        while(run){
            System.out.println("1. Completion time of each process");
            System.out.println("2. waiting time of each process");
            System.out.println("3. turnaround time of each process");
            System.out.println("4. Average waiting time of processes");
            System.out.println("5  Maximum waiting time period for a process in queue.");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
            switch(choice){
                case 1:           // Completion time of each process
                    for(Integer key : calc.items.keySet() ){
                        System.out.println(key + ": " + calc.items.get(key).getCompletionTime());
                    }
                    break;
                case 2:           // waiting time of each process
                    for(int key : calc.items.keySet() ){
                        System.out.println(key + ": " + calc.items.get(key).getWaitingTime());
                    }
                    break;
                case 3:           // turnaround time of each process
                    for(int key : calc.items.keySet() ){
                        System.out.println(key + ": " + calc.items.get(key).getTurnaroundTime());
                    }
                    break;
                case 4:           //Average waiting time of processes
                    int result=0;
                    for(int key : calc.items.keySet() ){
                        result += calc.items.get(key).getWaitingTime();
                    }
                    System.out.println(" Average waiting time :" + ((float)result / (float)calc.items.size()));
                    break;
                case 5:           //Maximum waiting time period for a process in queue
                    int maximum = 0;
                    for(int key : calc.items.keySet() ){
                        maximum = Math.max(maximum, calc.items.get(key).getWaitingTime());
                    }
                    System.out.println("Maximum waiting time is:" + maximum);
                    break;
                case 6:           // exit
                    run = false;
                    break;
                default:
                    System.out.println("Enter wronng choice");
            }
        }
        sc.close();
    }
}