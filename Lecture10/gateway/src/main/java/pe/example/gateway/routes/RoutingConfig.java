package pe.example.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 * @author D0Loop
 * @since 2022-04-05 [2022.4월.05]
 */

//@Configuration
public class RoutingConfig {

//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("community-user", predicateSpec -> predicateSpec
                        .path("/api/user/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec
                                .rewritePath("/api/(?<path>.*)",
                                        "/${path}"))
                        .uri("http://localhost:8081")
                ).build();
    }
}
