package order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CART")
public interface CartConfigFeign {
    @GetMapping("/cart/info")
    ResponseEntity<String> showMessage();

    @GetMapping("/cart/find/{id}")
    ResponseEntity<Cart> getCartById(@PathVariable("id") Integer id);

    @GetMapping("/cart/add")
    ResponseEntity<Cart> addToCart(@RequestBody Cart cart);
}
