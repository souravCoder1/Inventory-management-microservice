package gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class MyRouteConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {

        return routeLocatorBuilder.routes()
                .route("cartRoutingId", r -> r.path("/cart/**")
                        .filters(
                                f -> f.addRequestHeader("Token", "Basic " + UUID.randomUUID())
                                        .addResponseHeader("EncodeType", "Active")
                        )
                        .uri("lb://CART"))
                .route("cartRoutingId", r -> r.path("/order/**").uri("lb://ORDER"))
                .build();
    }
}
