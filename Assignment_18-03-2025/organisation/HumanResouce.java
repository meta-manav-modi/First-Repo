package organisation;

/** class HumanResouce , used to define abstract methods of employee class */
public class HumanResouce extends Employee{
    private double salary;
    
    public HumanResouce(String Id,double salary ){
        super(Id);
        this.salary = salary;
    }


     // Defination of abstract methods of employee class
    public double getBasicSalary(){
        return (75 * salary) / 100;   //base salary is 75%
    }
    public double getBonus(){
        return (15 * salary) / 100 ;  // bonus id 15%
    }
    public double getCompensation(){
        return (10 * salary) / 100;    // compensation is 10%
    }
}

