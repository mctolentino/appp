package java.appp.payroll;

public class MockEmployeeDb implements EmployeeDb{

    @Override
    public Employee getEmployee() {
        return null;
    }

    @Override
    public void putEmployee() {

    }

    @Override
    public boolean paymentsWerePostedCorrectly() {
        return true;
    }
}
