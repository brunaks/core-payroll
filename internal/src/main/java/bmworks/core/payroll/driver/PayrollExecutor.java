package bmworks.core.payroll.driver;

import bmworks.core.payroll.masterdata.Employee;
import bmworks.core.payroll.messaging.RabbitMessenger;
import org.springframework.stereotype.Component;

@Component
public class PayrollExecutor {

    private RabbitMessenger rabbitMessenger;

    public PayrollExecutor(RabbitMessenger rabbitMessenger) {
        this.rabbitMessenger = rabbitMessenger;
    }

    public void execute(Employee employee) {
        System.out.println("Executing payroll for " + employee.getFullName());
        System.out.println("- Contract " + employee.getContractName());
        System.out.println("- Gross salary " + employee.getMonthlyGrossSalary());
        rabbitMessenger.sendMessage();
    }
}
