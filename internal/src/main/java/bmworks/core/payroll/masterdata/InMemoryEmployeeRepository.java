package bmworks.core.payroll.masterdata;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEmployeeRepository implements EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }
}
