package java.appp.payroll;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PayrollTest {
    Employee employee;
    CheckWriter checkWriter;
    EmployeeDb employeeDb;

    @Before
    public void setup() {
        employee = new MockEmployee();
        checkWriter = new MockCheckWriter();
        employeeDb = new MockEmployeeDb();
    }

    @Test
    public void testPayroll(){
        Payroll p = new Payroll(employeeDb, checkWriter);
        p.payEmployees();
        assertTrue(checkWriter.checksWereWrittenCorrectly());
        assertTrue(employeeDb.paymentsWerePostedCorrectly());
    }


}
