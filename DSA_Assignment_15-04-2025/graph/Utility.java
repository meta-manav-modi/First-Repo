package graph;

import java.util.Scanner;

/** class Utility used to call all the methods on teh graph and execute the main menu*/
public class Utility {
    public void execute() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the number of vertx");
            int numVertex = sc.nextInt();
            if (numVertex < 2) {
                throw new AssertionError("Number of nodes must be greater than 1");
            }
            Operations operation = new Operations(numVertex, sc);

            boolean run = true;
            while (run) {
                System.out.println("1. Graph is connected or not");
                System.out.println("2. Nodes reachable from source");
                System.out.println("3. Minimum spanning tree");
                System.out.println("4. Shorted distance between teo nodes");
                System.out.println("5. Exit");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Graph Connectivity : " + operation.isConnected());
                        break;
                    case 2:
                        System.out.println("Reachable vertices: " + operation.reachable(2));
                        break;
                    case 3:
                        System.out.println("MST value: " + operation.primsMST());
                        break;
                    case 4:
                        System.out.println("Shortest distance : " + operation.dijistra(0, 2));
                        break;
                    case 5:
                        run = false;
                        break;
                }
            }

        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("unwanted error : " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
