package java.appp.payroll;

public interface EmployeeDb {
    Employee getEmployee();
    void putEmployee();

    boolean paymentsWerePostedCorrectly();
}
