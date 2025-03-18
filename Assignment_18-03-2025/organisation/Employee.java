package organisation;

/** class Employee, is an abstract class having abstract methods
 * like getBasicSalary, getBonus, getCompensation
 */
public abstract class Employee {
    protected String Id;

    public Employee(String Id){
        this.Id = Id;
    }

    // Getter of Id
    public String getId(){
        return Id;
    }

    // Abstract methods
    public abstract double getBasicSalary();

    public abstract double getBonus();

    public abstract double getCompensation();
}

