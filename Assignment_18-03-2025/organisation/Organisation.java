package organisation;

import java.util.ArrayList;
import java.util.List;

/** class Organisation, used to maintain list of all departments , having methods like
 * addDepartment and getAllEmployees list
 */
public class Organisation {
    List<Department> departments = new ArrayList<>();

    /** Mathod addDepartment, return boolean value if department is successfully added
     * @ param object of department class
     */
    boolean addDepartment(Department d) {
        if (departments.contains(d))
            return false;
        else {
            departments.add(d);
        }
        return true;
    }

    /** Mathod getAllEmployees, return arraylist of all employees from all departments
     */
    public List<Employee> getAllEmployees(){
        List<Employee> allEmployeeList = new ArrayList<>();
        for(Department d : departments){
            allEmployeeList.addAll(d.employeeList);
        }
        return allEmployeeList;
    }

}
