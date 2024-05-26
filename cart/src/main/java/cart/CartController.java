package cart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RefreshScope
public class CartController {
    @Value("${server.port}")
    private String port;
//
//    @Value("${my.key}")
//    private String property;

    @GetMapping("/info")
    public ResponseEntity<String> showMessage(@RequestHeader("Token") String token) {
        return ResponseEntity.ok("Cart Service" + port + ":" + ":" + token);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") Integer id) {
        Cart cart = Cart.builder()
                .cartId(id)
                .cartCost(11D)
                .cartCode(String.valueOf(111))
                .build();
        return ResponseEntity.ok(cart);
    }
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cart);
    }
}
