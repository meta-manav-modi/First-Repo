package sparse;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * class Utility, used to perform the main menu and perform the several
 * operations like,
 * Transpose, addition, multiplication and isSymmetric on sparseMatrix
 */
public class Utility {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {

            // Enter no of rows and columns
            System.out.println("Enter the number of rows and columns");
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            if (rows <= 0 || cols <= 0) {
                throw new AssertionError("Size cannot be zero");
            }

            System.out.println("Enter the number of non-zero values");
            int numOfNonZeroValues = scanner.nextInt();
            ArrayList<Matrix> nonZeroElements = new ArrayList<>();
            if (numOfNonZeroValues < 0) {
                throw new AssertionError("Size cannot be zero");
            }

            // Enter the non-zero elements
            for (int index = 0; index < numOfNonZeroValues; index++) {
                System.out.println("Enter the row, col and value");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                int value = scanner.nextInt();
                Matrix matrix = new Matrix(row, col, value);
                nonZeroElements.add(matrix);
            }

            SparseMatrix sparseMatrix = new SparseMatrix(rows, cols, nonZeroElements);

            System.out.println("Original Matrix : ");
            sparseMatrix.printMatrix();

            boolean run = true;
            int choice;
            int row1;
            int col1;
            int numOfNonZeroValuesInSecondMatrix;

            // Main Menu
            while (run) {
                System.out.println("1. Transpose of Matrix");
                System.out.println("2. Check symmetricity of Matrix");
                System.out.println("3. Addition of Matrix");
                System.out.println("4. Product of Matrix");
                System.err.println("5. Exit");
                System.out.println("Enter your choice");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:        //Transpose of Matrix
                        System.out.println("Transposed Matrix is");
                        SparseMatrix transposedMatrix = sparseMatrix.transpose();
                        transposedMatrix.printMatrix();
                        break;

                    case 2:        // Check matrix is symmetric or not
                        System.out.println("Symmetric is:" + sparseMatrix.isSymmetric());
                        break;

                    case 3:        // add two matrix
                        System.out.println("Enter the number of rows and columns");
                        row1 = scanner.nextInt();
                        col1 = scanner.nextInt();
                        if (row1 <= 0 || col1 <= 0) {
                            throw new AssertionError("Size cannot be zero");
                        }
                        System.out.println("Enter the number of non-zero values in second matrix");
                        numOfNonZeroValuesInSecondMatrix = scanner.nextInt();
                        ArrayList<Matrix> nonZeroElementsInSecndMatrix = new ArrayList<>();


                        //Enter non-zero elements
                        for (int index = 0; index < numOfNonZeroValuesInSecondMatrix; index++) {
                            System.out.println("Enter the row, col and value");
                            int row = scanner.nextInt();
                            int col = scanner.nextInt();
                            int value = scanner.nextInt();
                            Matrix matrix = new Matrix(row, col, value);
                            nonZeroElementsInSecndMatrix.add(matrix);
                        }
                        SparseMatrix sparseMatrix1 = new SparseMatrix(row1, col1,
                                nonZeroElementsInSecndMatrix);
                        SparseMatrix additionOfMatrix = sparseMatrix.addMatrix(sparseMatrix1);
                        additionOfMatrix.printMatrix();
                        break;

                    case 4:          // Product of two matrix
                        System.out.println("Enter the number of rows and columns");
                        row1 = scanner.nextInt();
                        col1 = scanner.nextInt();
                        if (row1 <= 0 || col1 <= 0) {
                            throw new AssertionError("Size cannot be zero");
                        }
                        System.out.println("Enter the number of non-zero values in second matrix");
                        numOfNonZeroValuesInSecondMatrix = scanner.nextInt();
                        ArrayList<Matrix> nonZeroElementsInSecndMatrix1 = new ArrayList<>();

                        // Enter non-zero elements
                        for (int index = 0; index < numOfNonZeroValuesInSecondMatrix; index++) {
                            System.out.println("Enter the row, col and value");
                            int row = scanner.nextInt();
                            int col = scanner.nextInt();
                            int value = scanner.nextInt();
                            Matrix matrix = new Matrix(row, col, value);
                            nonZeroElementsInSecndMatrix1.add(matrix);
                        }
                        SparseMatrix sparseMatrix2 = new SparseMatrix(row1, col1,
                                nonZeroElementsInSecndMatrix1);
                        SparseMatrix multiplyOfMatrix = sparseMatrix.multiplyMatrix(sparseMatrix2);
                        multiplyOfMatrix.printMatrix();
                        break;
                    case 5:
                        run = false;
                        break;

                    default:
                        break;
                }
            }
        } catch (AssertionError e) {
            System.out.println("AssertionError" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unwanted Exception " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
