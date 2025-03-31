package polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** class Utility, used to take input of the polynomial with multivariables */
public class Utility {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Polynomial poly = new Polynomial();

        System.out.println("Enter the no of terms");
        int numTerms = scanner.nextInt();

        // take cofficient input and create nested list to take input of variables for a specific term
        for(int index = 0; index < numTerms; index++){
            System.out.println("Enter cofficient");
            int cofficient = scanner.nextInt();

            List<List<Object>> polynomial = new ArrayList<>();
            System.out.println("Enter number of variables for term " + (index + 1));
            int numVars = scanner.nextInt();

            // Enter variable and its exponent value 
            for(int j = 0; j < numVars; j++){
                System.out.println("Enter the variable");
                String varName = scanner.next();
                System.out.println("Enter exponent value");
                int exponent = scanner.nextInt();

                if(exponent != 0){
                    polynomial.add(Arrays.asList(varName, exponent));
                }
            }
            poly.addTerm(cofficient, polynomial);
        }
        System.out.println("Polynomial is :" + poly);
        System.out.println("Degree of the polynomail : " + poly.getDegree());
        scanner.close();
    }
}
