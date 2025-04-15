package quickSort;

/** class Node used to create a node */
public class Node {
    private Employee emp;
    Node next;

    public Node(Employee emp) {
        this.emp = emp;
        this.next = null;
    }

    public Employee getEmp() {
        return emp;
    }

    public Node getNext() {
        return next;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
}