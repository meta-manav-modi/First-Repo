package organisation;

import java.util.ArrayList;
import java.util.List;

/**
 * class Department, used to create an arrayList of all employees in a
 * department
 * , performing methods like join, releive and List<Employee> getEmployees
 */
public class Department {
    private List<Employee> employeeList = new ArrayList<>();
    private String Id;

    public Department(String Id) {
        this.Id = Id;
        this.employeeList = new ArrayList<>();
    }

    /**
     * Method join, add an employee details to employee list , return the boolean
     * value
     * @ param object of Employee class
     */
    public boolean join(Employee e) {
        for (Employee emp : employeeList) {
            if (emp.getId() == e.getId()) {
                return false;
            }
        }
        return employeeList.add(e);
    }

    /**
     * Method releive, remove an employee details to employee list , return the
     * boolean value
     * @ param object of Employee class
     */
    public boolean releive(Employee e) {
        for (Employee emp : employeeList) {
            if (emp.getId() == e.getId()) {
                employeeList.remove(e);
                return true;
            }
        }
        return false;
    }

    /**
     * Method getEmployee, return the complete employeeList
     */
    public List<Employee> getEmployees() {
        return employeeList;
    }

    public String getId(){
        return Id;
    }
}
