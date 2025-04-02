package queueQ2;

import java.util.Scanner;

/** class Utility, perform the main menu and call all methods like
 * enqueue, isFull, isEmpty, dequeue
 */
public class Utility {
    public void execute() {
        int maxSize;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the size of queue");
            maxSize = scanner.nextInt();
            if (maxSize <= 0) {
                throw new AssertionError("Size cannot be less than 0");
            }
            CircularQueue<Integer> cq = new CircularQueue<>(maxSize);
            boolean run = true;
            while (run) {
                System.out.println("1. Insert element into queue");
                System.out.println("2. Delete an element from queue");
                System.out.println("3. Check queue is empty");
                System.out.println("4. Check queue is full");
                System.out.println("5. Display the queue");
                System.out.println("6. Exit");
                System.out.println("Enter your choice");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the value to insert");
                        int value = scanner.nextInt();
                        cq.enQueue(value);
                        break;
                    case 2:
                        int element = cq.deQueue();
                        System.out.println("Deleted value : " + element);
                        break;
                    case 3:
                        System.out.println(cq.isEmpty());
                        break;
                    case 4:
                        System.out.println(cq.isFull());
                        break;
                    case 5:
                        cq.display();
                        break;
                    case 6:
                        run = false;
                        break;
                }
            }
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unwanted Exception : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

}
