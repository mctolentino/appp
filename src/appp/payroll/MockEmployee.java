package appp.payroll;

import java.math.BigDecimal;

public class MockEmployee implements Employee{
    @Override
    public BigDecimal calculatePay() {
        return null;
    }

    @Override
    public void postPayment() {

    }
}
