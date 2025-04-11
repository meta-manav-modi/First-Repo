package employee;


/** class EmployeeSorting, used to find the sorting of the emloyees list acc to ther salary */
public class EmployeeSorting {
    Employee head;

    /**
     * It add an employee to the starting position of the linked list
     * @param name
     * @param age
     * @param salaray
     */
    public void addEmployee(String name, int age, double salaray) {
        Employee newEmployee = new Employee(name, salaray, age);
        newEmployee.next = head;
        head = newEmployee;
    }

    /**
     * It sort the linked list on basis of their salary and age
     * @return starting node of the sorted list
     */
    public Employee sortEmployees() {
        Employee current = head;
        Employee sorted = null;
        while (current != null) {
            Employee currNext = current.next;
            sorted = insertionSort(sorted, current);
            current = currNext;
        }
        return sorted;
    }

    /**
     * It sort the list using insertion sort
     * @param sorted
     * @param current
     * @return head of the sorted list
     */
    private Employee insertionSort(Employee sorted, Employee current){
        
        // checks if starting node is null or greater than current node,if yes than add current node to starting
        if(sorted == null || compareEmployees(sorted, current) < 0){
            current.next = sorted;
            return current;
        }else{

            // Check until a greater value than current is find and than insert the current node at that location
            Employee temp = sorted;
            while( temp.next != null && compareEmployees(temp, current) > 0){
                temp = temp.next;
            }
            current.next = temp.next;
            temp.next = current;
        }
        return sorted;
    }

    /**
     * It compare two employees on basis of their salaray and If salary are equal than on basis of their age
     * @param e1 object of employee class
     * @param e2 object of employee class
     * @return comaprision of both objects
     */
    private int compareEmployees(Employee e1, Employee e2) {
        if (e1.getSalaray() != e2.getSalaray()) {
            return Double.compare(e1.getSalaray(), e2.getSalaray());
        } else {
            return Integer.compare(e2.getAge(), e2.getAge());
        }
    }

}