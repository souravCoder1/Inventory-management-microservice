package order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
//    private CartConfig config;
    private CartConfigFeign config;

    @GetMapping("/info")
    public ResponseEntity<String> placeOrder() {
//        String cartResponse = config.getCartResponse();
        String cartResponse = config.showMessage().getBody();
        return ResponseEntity.ok("Order Placed!!!! " + cartResponse);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<String> getOrder(@PathVariable("id")Integer id) {
        Cart cartResponse = config.getCartById(id).getBody();
        return ResponseEntity.ok("Order Placed!!!! " + cartResponse);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> newOrder(@RequestBody Cart cart) {
        Cart cartResponse = config.addToCart(cart).getBody();
        return ResponseEntity.ok("Order Placed!!!! " + cartResponse);
    }
}