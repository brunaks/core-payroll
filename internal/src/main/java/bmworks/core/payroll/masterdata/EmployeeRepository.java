package bmworks.core.payroll.masterdata;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAll();
    void save(Employee fromInfo);
}
