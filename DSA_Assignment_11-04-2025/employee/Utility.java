package employee;

import java.util.Scanner;

/** class Utility, used t take input from user and call the sorting function to sort the list of employees */
public class Utility {
    public void execute() {
        Scanner sc = new Scanner(System.in);
        EmployeeSorting emp = new EmployeeSorting();

        try {
            
            System.out.println("Enter the number of Employees");
            int numEmployees = sc.nextInt();
            sc.nextLine();
            if (numEmployees <= 0) {
                throw new AssertionError("Size cannot be less than 1");
            }

            // Take input from user and add to the list
            for (int index = 0; index < numEmployees; index++) {
                System.out.println("Enter the name, age and salary and age of employee in order");
                String name = sc.nextLine();
                int age = sc.nextInt();
                double salaray = sc.nextDouble();
                sc.nextLine();
                if (age < 18) {
                    throw new AssertionError("Not eligible to do work");
                }
                emp.addEmployee(name, age, salaray);
            }


            // Call the sorting function to sort the employees list
            Employee sorted = emp.sortEmployees();
            while (sorted != null) {
                System.out.println(sorted.getName() + " : " + sorted.getAge() + " : " + sorted.getSalaray());
                sorted = sorted.next;
            }

        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unwanted error" + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
