package bmworks.core.payroll.masterdata;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HireEmployeeTests {

    EmployeeRepository employeeRepository;
    EmployeeReader employeeReader;
    EmployeeHiring employeeHiring;

    @BeforeEach
    public void setup() {
        employeeRepository = new InMemoryEmployeeRepository();
        employeeReader = new EmployeeReader(employeeRepository);
        employeeHiring = new EmployeeHiring(employeeRepository);
    }

    @Test
    public void hireNewEmployee() {
        assertEquals(employeeReader.readAll().size(), 0);
        employeeHiring.execute(createEmployee());
        var employees = employeeReader.readAll();
        assertEquals(employees.size(), 1);
        assertEmployeeInfo(employees.get(0));
    }

    private EmployeeInfo createEmployee() {
        var employeeInfo = new EmployeeInfo();
        employeeInfo.firstName          = "Name";
        employeeInfo.lastName           = "Surname";
        employeeInfo.contractName       = "Developer";
        employeeInfo.monthlyGrossSalary = "5000.00";
        return employeeInfo;
    }

    private void assertEmployeeInfo(Employee employee) {
        assertEquals("Name Surname", employee.getFullName());
        assertEquals("Developer", employee.getContractName());
        assertEquals("5000.00", employee.getMonthlyGrossSalary().toString());
    }
}
