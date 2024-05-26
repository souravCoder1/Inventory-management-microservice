package kafkasvc.Producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value( "${test.topic.name}")
    private String topicName;

    public void sendMessage(String message) {
        log.info("MSG Produced................");
        kafkaTemplate.send(topicName, message);
    }

}
