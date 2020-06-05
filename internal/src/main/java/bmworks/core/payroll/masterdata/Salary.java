package bmworks.core.payroll.masterdata;

import java.math.BigDecimal;

public class Salary {

    private BigDecimal grossSalary;

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public void setMonthlyGrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
    }
}
