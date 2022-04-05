package pe.example.gateway.filter;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

/**
 * @author D0Loop
 * @since 2022-04-05 [2022.4월.05]
 */

@Component
public class LoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

    private static final Logger logger = LoggerFactory.getLogger(LoggingGatewayFilterFactory.class);

    public LoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public String name() {
        return "LogExecution";
    }

    @Override
    public GatewayFilter apply(LoggingGatewayFilterFactory.Config config) {
        return (((exchange, chain) -> {
            logger.trace(config.toString());
            String uid = config.simpleUid ? UUID.randomUUID().toString().split("-")[0] : UUID.randomUUID().toString();

            final long timeStart = Instant.now().toEpochMilli();

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                long timeDiff = Instant.now().toEpochMilli() - timeStart;
                if(config.inSeconds) timeDiff /= 1000;

                logger.trace("Execution Time id: {}, timediff: ({}): {}",
                        uid,
                        config.inSeconds ? "s" : "ms",
                        timeDiff);

            }));
        }));
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Config {
        private boolean simpleUid;
        private boolean inSeconds;
    }
}
