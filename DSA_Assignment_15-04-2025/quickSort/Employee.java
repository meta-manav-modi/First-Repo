package quickSort;

/** class Employee, used to store the data values for an employee */
public class Employee {
    private String name;
    private double salaray;
    private int age;

    public Employee(String name, double salaray, int age) {
        this.name = name;
        this.salaray = salaray;
        this.age = age;
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

    @Override
    public String toString() {
        return "Employee [name=" + name + ", salaray=" + salaray + ", age=" + age + "]";
    }

    
}
