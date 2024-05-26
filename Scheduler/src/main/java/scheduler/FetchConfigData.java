package scheduler;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;

@Component
public class FetchConfigData {

    @Scheduled(cron = "10 * * * * * ")
    public void fetch() {
        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
// Create HttpHeaders object to store custom headers
        HttpHeaders headers = new HttpHeaders();

// Add custom headers to HttpHeaders object
        headers.set("Authorization", "Bearer your_token");
        //headers.set("Content-Type", "application/json");
        headers.setContentType(MediaType.APPLICATION_JSON);
// Optionally, you can set other headers if needed

// Create HttpEntity with headers
        HttpEntity<String> requestEntity = new HttpEntity<>("{}", headers);
        String url = "http://localhost:8081/actuator/refresh";
        String output =
                restTemplate.postForEntity(url, requestEntity, String.class)
                        .getBody();
        System.out.println(output);
    }
}
