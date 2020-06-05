package bmworks.core.payroll.masterdata;

public class EmployeeHiring {

    private EmployeeRepository employeeRepository;

    public EmployeeHiring(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void execute(EmployeeInfo employeeInfo) {
        employeeRepository.save(Employee.fromInfo(employeeInfo));
    }
}
