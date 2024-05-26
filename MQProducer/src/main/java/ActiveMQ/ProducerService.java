package ActiveMQ;

import jakarta.jms.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${destination}")
    private String destination;

    public void sendMessage(String msg) {
        jmsTemplate.send(destination, Session::createMessage);
        log.info("Message sent from producer");
    }
}
