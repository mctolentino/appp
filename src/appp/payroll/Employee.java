package appp.payroll;

import java.math.BigDecimal;

public interface Employee {
    BigDecimal calculatePay();
    void postPayment();
}
