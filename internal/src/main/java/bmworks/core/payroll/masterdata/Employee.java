package bmworks.core.payroll.masterdata;

import java.math.BigDecimal;

public class Employee {

    private Name name;
    private String contractName;
    private Salary salary;

    public Employee(String firstName, String lastName, String contractName, String monthlyGrossSalary) {
        this.name = new Name(firstName, lastName);
        this.contractName = contractName;
        this.salary = new Salary();
        this.salary.setMonthlyGrossSalary(new BigDecimal(monthlyGrossSalary));
    }

    public static Employee fromInfo(EmployeeInfo employeeInfo) {
        return new Employee(employeeInfo.firstName,
                            employeeInfo.lastName,
                            employeeInfo.contractName,
                            employeeInfo.monthlyGrossSalary);
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getContractName() {
        return contractName;
    }

    public BigDecimal getMonthlyGrossSalary() {
        return salary.getGrossSalary();
    }
}
