package poly;

import java.util.ArrayList;
import java.util.*;

/** class Utility, used to perform the main menu and to create the objects of polynomial ,
 * methods like addPoly, multiplyPoly, evaluate and degree
 */
public class Utility {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            // Input values of Polynomial 1
            System.out.println("Enter the size of first polynomial");
            int sizePoly1 = scanner.nextInt();
            if(sizePoly1 <= 0){
                throw new AssertionError("Size cannot be less than 0");
            }
            List<Term> coff1 = new ArrayList<>();
            System.out.println("Enter the cofficient and Exponent for polynomial 1");

            for (int index = 0; index < sizePoly1; index++) {
                int value = scanner.nextInt();
                int degree = scanner.nextInt();
                coff1.add(new Term(value, degree));
            }
            Polynomial poly1 = new Polynomial(coff1);

            // Input values for polynomial 2
            System.out.println("Enter the size of second polynomial");
            int sizePoly2 = scanner.nextInt();
            if(sizePoly2 <= 0){
                throw new AssertionError("Size cannot be less than 0");
            }
            ArrayList<Term> coff2 = new ArrayList<>();
            System.out.println("Enter the cofficient and Exponent for polynomial 2");
            for (int index = 0; index < sizePoly2; index++) {
                int value = scanner.nextInt();
                int degree = scanner.nextInt();
                coff2.add(new Term(value, degree));
            }
            Polynomial poly2 = new Polynomial(coff2);


            // Both the polynomials are:
            System.out.println("Polynomial 1 is: " + poly1);
            System.out.println("Polynomial 2 is: " + poly2);

            boolean run = true;
            while (run) {
                System.out.println("1. Calculate result for floating value");
                System.out.println("2. Add two polunomials");
                System.out.println("3. Multiply the two polynomials");
                System.out.println("4. Find the degree of polynomial");
                System.out.println("5. Exit");
                System.out.println("Enter your choice");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the value of x");
                        float x = scanner.nextFloat();
                        System.out.println("Enter polynomial to choose");
                        int choiceOfPolynomial = scanner.nextInt();
                        float res = (choiceOfPolynomial == 1) ? poly1.evaluate(x)
                                : poly2.evaluate(x);
                        System.out.println("The result is " + res);
                        break;

                    case 2:
                        Polynomial sum = Polynomial.addPoly(poly1, poly2);
                        System.out.println("Sum of two polynomials is: " + sum);

                        break;

                    case 3:
                        Polynomial product = Polynomial.multiplyPoly(poly1, poly2);
                        System.out.println("Product of two polynomials is: " + product);

                        break;

                    case 4:
                        System.out.println("Enter polynomial to choose");
                        int choiceOfPoly = scanner.nextInt();
                        float resDegree = (choiceOfPoly == 1) ? poly1.degree()
                                : poly2.degree();
                        System.out.println("The Degree is " + resDegree);

                    case 5:
                        run = false;
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
