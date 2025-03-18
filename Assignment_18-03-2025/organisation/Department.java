package organisation;
import java.util.ArrayList;
import java.util.List;

/** class Department, used to create an arrayList of all employees in a department
 * , performing methods like join, releive and List<Employee> getEmployees
 */
public class Department {
    public String name;
    List<Employee> employeeList = new ArrayList<>();

    public Department(String name){
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    /** Method join, add an employee details to employee list , return the boolean value
     * @ param object of Employee class
    */
    public boolean join(Employee e){
        if(employeeList.contains(e)) return false;
        else{
            employeeList.add(e);
        }
        return true;
    }

    /** Method releive, remove an employee details to employee list , return the boolean value
     * @ param object of Employee class
    */
    public boolean releive(Employee e){
        if(employeeList.contains(e)){
            employeeList.remove(e);
            return true;
        }
        return false;
    }

    /** Method getEmployee, return the complete employeeList
    */
    List<Employee> getEmployees(){
        return employeeList;
    }
}
