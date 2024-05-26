/*
package order;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
@Deprecated
public class CartConfigOld {

    @Autowired
    private DiscoveryClient client;
    private final RestTemplate restTemplate;

    public CartConfig(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCartResponse() {
        List<ServiceInstance> instances= client.getInstances("CART");
        ServiceInstance si = instances.get(0);
        URI uri = si.getUri();
        String url = uri + "/cart/info";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
*/
