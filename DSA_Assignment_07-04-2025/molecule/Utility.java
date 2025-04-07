package molecule;

import java.util.Scanner;

/** class Utility, used to take input of formula and call method to calculate mass */
public class Utility {
    public void execute() {
        MoleculeMass mass = new MoleculeMass();
        Scanner scanner = new Scanner(System.in);   
        try {
            System.out.println("Enter the formula");
            String str = scanner.next();
            System.out.println("Total mass is : " + mass.getTotalmass(str));
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unwanted error" + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}