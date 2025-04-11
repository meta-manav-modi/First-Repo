package employee;

/** class Employee, used to store the data values for an employee */
public class Employee {
    private String name;
    private double salaray;
    private int age;
    Employee next;

    public Employee(String name, double salaray, int age) {
        this.name = name;
        this.salaray = salaray;
        this.age = age;
        this.next = null;
    }

    // Getters of Employee class
    public String getName() {
        return name;
    }

    public double getSalaray() {
        return salaray;
    }

    public int getAge() {
        return age;
    }
}
