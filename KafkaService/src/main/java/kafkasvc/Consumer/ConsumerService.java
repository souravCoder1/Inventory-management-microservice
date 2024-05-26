package kafkasvc.Consumer;

import kafkasvc.Entity.MessageStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerService {

    @Autowired
    private MessageStore messageStore;

//    @Value( "${test.topic.name}")
//    private String topicName;

    @KafkaListener(topics = "${test.topic.name}", groupId = "myGroup")
    public void readMessage(String message) {
        log.info("MSG Consumer: {}", message);
        messageStore.add(message);
    }

}
