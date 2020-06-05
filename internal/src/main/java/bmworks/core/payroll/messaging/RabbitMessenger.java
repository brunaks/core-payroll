package bmworks.core.payroll.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessenger {

    private RabbitTemplate rabbitTemplate;

    public RabbitMessenger(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage() {
        rabbitTemplate.convertAndSend("amq.topic", "ExecutePayrollRunStep", "Test");
    }
}
