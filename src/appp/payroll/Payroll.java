package appp.payroll;

public class Payroll {
    private final CheckWriter checkWriter;
    private final EmployeeDb employeeDb;

    Payroll(EmployeeDb employeeDb, CheckWriter checkWriter){
        this.employeeDb = employeeDb;
        this.checkWriter = checkWriter;
    }

    public void payEmployees() {
    }
}
