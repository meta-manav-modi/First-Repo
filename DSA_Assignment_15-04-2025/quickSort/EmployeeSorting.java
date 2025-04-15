package quickSort;

/**
 * class EmployeeSorting, used to find the sorting of the emloyees list acc to
 * ther salary
 */
public class EmployeeSorting {
    Node head = null;

    /**
     * It add an employee to the starting position of the linked list
     * 
     * @param name
     * @param age
     * @param salaray
     */
    public void addEmployee(String name, int age, double salaray) {
        Employee newEmployee = new Employee(name, salaray, age);
        Node newNode = new Node(newEmployee);
        newNode.next = head;
        head = newNode;
    }

    /**
     * It sort the linked list on basis of their salary and age
     * 
     * @return starting node of the sorted list
     */
    public void sortEmployees() {
        quickSort(head, getTail(head));
    }

    /**
     * method used to perform the quick sort
     * @param start
     * @param end
     */
    private void quickSort(Node start, Node end) {
        if (start == null || start == end || start == end.next)
            return;

        Node pivot = partition(start, end);
        Node temp = start;

        while(temp != null && temp.next != pivot){
            temp = temp.next;
        }
        if(temp != null){
            temp.next = null;
            quickSort(start, temp);
            temp.next = pivot;
        }
        quickSort(pivot.next, end);
    }

    /**
     * method is used to make partitions with help of pivot element
     * @param start
     * @param end
     * @return the current node
     */
    private Node partition(Node start, Node end) {
        Employee pivot = end.getEmp();
        Node curr = start;
        Node prev = start;

        while (prev != end) {
            if (compareEmployees(prev.getEmp(), pivot) > 0) {
                swap(curr, prev);
                curr = curr.next;
            }
            prev = prev.next;
        }
        swap(curr, end);
        return curr;
    }

    /**
     * method is used to print the list
     */
    public void printList(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getEmp());
            temp = temp.next;
        }
        System.out.println("null");
    }


    /**
     * method used to get the last node of list
     * @param node
     * @return last node of list
     */
    private Node getTail(Node node) {
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }


    /**
     * It is used to swap the employees
     * @param n1
     * @param n2
     */
    private void swap(Node n1, Node n2){
        Employee temp = n1.getEmp();
        n1.setEmp(n2.getEmp());
        n2.setEmp(temp);
    }

    /**
     * It compare two employees on basis of their salaray and If salary are equal
     * than on basis of their age
     * 
     * @param e1 object of employee class
     * @param e2 object of employee class
     * @return comaprision of both objects
     */
    private int compareEmployees(Employee e1, Employee e2) {
        if (e1.getSalaray() != e2.getSalaray()) {
            return Double.compare(e1.getSalaray(), e2.getSalaray());
        } else {
            return Integer.compare(e2.getAge(), e1.getAge());
        }
    }

}