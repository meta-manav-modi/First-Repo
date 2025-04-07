package employee;

import java.util.Objects;

/** class Employee used to store the employee details */
public class Employee {
    private int empId;
    private String name;
    private String address;

    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    // Getters of employrr class
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return empId + " : " + name + " : " + address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (empId != other.empId)
            return false;
        return true;
    }

    

}
