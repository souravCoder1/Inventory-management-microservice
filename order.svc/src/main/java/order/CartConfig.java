package order;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class CartConfig {

    @Autowired
    private LoadBalancerClient client;
    private final RestTemplate restTemplate;

    public CartConfig(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCartResponse() {
        ServiceInstance si= client.choose("CART");
        URI uri = si.getUri();
        String url = uri + "/cart/info";
        System.out.println(url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
