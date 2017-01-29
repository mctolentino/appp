package java.appp.payroll;

public class MockCheckWriter implements CheckWriter{

    @Override
    public void writeCheck() {

    }

    @Override
    public boolean checksWereWrittenCorrectly() {
        return true;
    }
}
