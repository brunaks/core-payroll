package bmworks.core.payroll.masterdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeReader {

    private EmployeeRepository employeeRepository;

    public EmployeeReader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> readAll() {
        return employeeRepository.getAll();
    }
}
