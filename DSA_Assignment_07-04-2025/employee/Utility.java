package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * class Utility to get inputs from user and perform all types of comparisons
 * like sortById, sortByName, remove duplicate values
 */
public class Utility {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number of employees");
            int numEmployee = Integer.parseInt(scanner.nextLine());
            if (numEmployee <= 0) {
                throw new AssertionError("Size cannot be less than 0");
            }

            List<Employee> collectionOfEmployees = new ArrayList<>();
            for (int index = 0; index < numEmployee; index++) {
                System.out.println("Enter the id, name and address of employee");
                int empId = Integer.parseInt(scanner.nextLine());
                String name = scanner.nextLine();
                String address = scanner.nextLine();
                collectionOfEmployees.add(new Employee(empId, name, address));
            }

            while (true) {
                System.out.println("1. Natiral order sorting ");
                System.out.println("2. Sorting by name ");
                System.out.println("3. Avoid duplicate employee");
                System.out.println("4. Exit");
                System.out.println("Enter your choice");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Comparator<Employee> naturalComparator = new sortById();
                        Collections.sort(collectionOfEmployees, naturalComparator);
                        for (Employee emp : collectionOfEmployees) {
                            System.err.println(emp);
                        }
                        break;
                    case 2:
                        Comparator<Employee> comparatorNmae = new sortByName();
                        Collections.sort(collectionOfEmployees, comparatorNmae);
                        for (Employee emp : collectionOfEmployees) {
                            System.err.println(emp);
                        }
                        break;
                    case 3:
                        HashSet<Employee> employeeSet = new HashSet<>();
                        employeeSet.addAll(collectionOfEmployees);
                        for (Employee emp : employeeSet) {
                            System.err.println(emp);
                        }
                        break;
                    case 4:
                        return;
                    default:
                        break;
                }
            }

        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unwanted error" + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
// Generating the custom comparator to sort by id
class sortById implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getEmpId() - e2.getEmpId();
    }
}

// Generating the custom comparator to sort by id
class sortByName implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
