package organisation;

/** class Payroll, used to print the complete payslip for all employees */
public class Payroll {

    /** Method generatePayroll, call the printSalarySlip method
     * @ param object of organization class
     */
    public static void generatePayroll(Organisation org){
        for (Employee employee : org.getAllEmployees()){
            printSalarySlip(employee);
        }
    }

    /** Method printSalarySlip, print all type salaries like, basic, bonus and compensation
     * call the taxOnSalary method
     * @ param object of employee class
     */
    public static void printSalarySlip(Employee e) {
       System.out.println("Slip of employee :" + e.getId());
       System.out.println("Basic Salary is:" + e.getBasicSalary());
       System.out.println("Bonus is:" + e.getBonus());
       System.out.println("Compensation is:" + e.getCompensation());
       double salary = e.getBasicSalary() + e.getBonus() + e.getCompensation();
       taxOnSalary(salary);
    }

    /** Method taxOnSalary, print tax on salary and net salary
     * @ param salary
     */
    public static void taxOnSalary(double salary) {
        if (salary <= 1200000) {
            System.out.println("Tax on salary less than" + 1200000 + " is " + 0);
        } else if (salary > 1200000 && salary <= 1500000) {
            double tax = (20 * salary) / 100;
            System.out.println("Tax on salary of" + salary + " is: " + tax);
            System.out.println("Net salary is:" + (salary - tax));
        } else if (salary > 1500000) {
            double tax = (30 * salary) / 100;
            System.out.println("Tax on salary of" + salary + " is: " + tax);
            System.out.println("Net salary is:" + (salary - tax));
        }
    }
}
