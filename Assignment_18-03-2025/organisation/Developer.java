package organisation;

/** class Developer , used to define abstract methods of employee class */
public class Developer extends Employee{
    private double salary;
    
    public Developer(String Id,double salary ){
        super(Id);
        this.salary = salary;
    }
    
    // Defination of abstract methods of employee class
    public double getBasicSalary(){
        return (75 * salary) / 100;   
    }
    public double getBonus(){
        return (15 * salary) / 100 ;  
    }
    public double getCompensation(){
        return (10 * salary) / 100;    
    }

}
