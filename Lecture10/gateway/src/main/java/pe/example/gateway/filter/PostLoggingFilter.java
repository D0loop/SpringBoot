package pe.example.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

/**
 * @author D0Loop
 * @since 2022-04-05 [2022.4월.05]
 */

//@Component
public class PostLoggingFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(PostLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {


        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            ServerHttpRequest serverHttpRequest = exchange.getRequest();
            String requestId = serverHttpRequest.getHeaders()
                    .getFirst("likelion-gateway-request-id");
            String requestTimeString = serverHttpRequest.getHeaders()
                    .getFirst("likelion-gateway-request-time");

            long timeEnd = Instant.now().toEpochMilli();
            long timeStart = requestTimeString == null ? timeEnd : Long.parseLong(requestTimeString);

            logger.trace("Executed Time id: {}, timediff(ms): {}", requestId, timeEnd - timeStart);

        }));
    }
}