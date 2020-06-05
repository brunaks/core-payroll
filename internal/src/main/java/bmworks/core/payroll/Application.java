package bmworks.core.payroll;

import bmworks.core.payroll.driver.PayrollExecutor;
import bmworks.core.payroll.masterdata.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void onApplicationStarted(ApplicationStartedEvent event) {
        PayrollExecutor bean = event.getApplicationContext().getBean(PayrollExecutor.class);
        bean.execute(new Employee("Jane", "Doe", "Developer", "4000.00"));
    }
}
