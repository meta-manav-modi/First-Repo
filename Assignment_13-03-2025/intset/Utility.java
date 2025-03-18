package intset;

import java.util.Scanner;

/**
 * class Utility to perform main menu and find the resuts for all the operation
 * like union, intersection, difference, size, subset etc.
 */
public class Utility {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of values in set A");
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int index = 0; index < num; index++) {
            arr[index] = scanner.nextInt();
        }
        IntSet operation = new IntSet(arr);
        boolean run = true;
        try {
            // Main menu
            int size;
            while (run) {

                System.out.println("1. union of A and B");
                System.out.println("2. Intersection of A and B");
                System.out.println("3. isSize of A and B");
                System.out.println("4. isSubset of A and B");
                System.out.println("5. Difference of A and B");
                System.out.println("6. isMember of A and B");
                System.out.println("7. Complementon of A and B");
                System.out.println("8. Exit");
                System.out.println(" Enter your choice");
                int caseChoice = scanner.nextInt();

                switch (caseChoice) {
                    case 1: // union
                        System.out.println("Enter number of values in set B");
                        size = scanner.nextInt();
                        int[] arrInput = new int[size];
                        for (int index = 0; index < size; index++) {
                            arrInput[index] = scanner.nextInt();
                        }
                        IntSet resUnion = operation.union(new IntSet(arrInput));
                        System.out.println("Union of A and B :" + resUnion);
                        break;

                    case 2: // Intersection
                        System.out.println("Enter number of values in set B");
                        size = scanner.nextInt();
                        int[] arrInput1 = new int[size];
                        for (int index = 0; index < size; index++) {
                            arrInput1[index] = scanner.nextInt();
                        }
                        IntSet resIntersection = operation.intersection(new IntSet(arrInput1));
                        System.out.println("Union of A and B :" + resIntersection);
                        break;

                    case 3: // size
                        System.out.println("Size is : " + operation.size());
                        break;

                    case 4: // subset
                        System.out.println("Enter number of values in set B");
                        int size1 = scanner.nextInt();
                        int[] arr2 = new int[size1];
                        for (int index = 0; index < size1; index++) {
                            arr2[index] = scanner.nextInt();
                        }

                        System.out.println("Is B is subset of A :" + operation.isSubset(new IntSet(arr2)));
                        break;
                    case 5:
                        System.out.println("Enter number of values in set B");
                        size = scanner.nextInt();
                        int[] arrInput2 = new int[size];
                        for (int index = 0; index < size; index++) {
                            arrInput2[index] = scanner.nextInt();
                        }
                        IntSet resDifference = operation.difference(new IntSet(arrInput2));
                        System.out.println("Difference of A and B :" + resDifference);
                        break;
                    case 6:
                        System.out.println("Enter the target value");
                        int target = scanner.nextInt();
                        System.out.println("Value is member : " + operation.isMemeber(target));
                        break;

                    case 7:
                        IntSet resComplement = operation.getComplement();
                        System.out.println("Complement is : " + resComplement);
                        break;

                    case 8:
                        run = false;
                        break;
                }
            }
        } catch (AssertionError e) {
            System.out.println("AssertionError : " + e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
