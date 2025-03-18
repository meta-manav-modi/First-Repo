package organisation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
 
/** class EmployeeTest, used to run the test cases and print the salary slips of all employees */
public class EmployeeTest {

    @Test
    public void DeveloperTest() {
        Organisation org = new Organisation();
        Department dev = new Department("Dev");
        Department hr = new Department("Hr");
        
        Employee e1 = new Developer("one", 1500000);
        Employee e2 = new Developer("two", 1000000);
        Employee e3 = new HumanResouce("three", 1200000);
        Employee e4 = new HumanResouce("three", 1200000);

        assertTrue(dev.join(e1));
        assertTrue(dev.join(e2));
        assertTrue(dev.releive(e1));
        assertFalse(dev.releive(e4));
        assertTrue(hr.join(e3));
        assertTrue(org.addDepartment(dev));
        assertTrue(org.addDepartment(hr));

        assertEquals(2, org.getAllEmployees().size());
        
        Payroll.generatePayroll(org);

    }

}
