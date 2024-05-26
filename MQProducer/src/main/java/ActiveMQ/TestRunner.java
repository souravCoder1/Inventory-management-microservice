package ActiveMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private ProducerService producerService;
    @Override
    public void run(String... args) throws Exception {
        producerService.sendMessage("Hello");
    }
}
