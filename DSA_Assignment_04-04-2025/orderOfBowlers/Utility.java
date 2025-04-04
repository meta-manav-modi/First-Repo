package orderOfBowlers;

import java.util.Scanner;

/** class Utility, used to take inputs and call the method to calculate the order of bowlers */
public class Utility {
    public void execute() {
        Scanner sc = new Scanner(System.in);
        QueueOfBowlers bowler = new QueueOfBowlers();
        try {

            System.out.println("Enter the number of bowlers");
            int numBowlers = sc.nextInt();
            if (numBowlers <= 0) {
                throw new AssertionError("Virat wins the match, He is legend");
            }

            System.out.println("How many balls will virat play");
            int totalBalls = sc.nextInt();
            if (totalBalls <= 0) {
                throw new AssertionError("Virat should play atleast one ball");
            }
            
            
            int[] quotes = new int[numBowlers];
            System.out.println("Enter number of balls of each player");
            for (int index = 0; index < numBowlers; index++) {
                quotes[index] = sc.nextInt();
            }
            
            String order = bowler.orderOfBowlers(numBowlers, totalBalls, quotes);
            System.out.println(order);

        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unwanted Exception" + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
