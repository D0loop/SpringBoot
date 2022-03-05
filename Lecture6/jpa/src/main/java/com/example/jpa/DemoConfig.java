package com.example.jpa;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-03-05 [2022.3월.05]
 */

@Configuration
public class DemoConfig {

    public static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    @Value("${custom.property.single}")
    private String customProperty;

    @Value("${custom.property.comlist}")
    private List<String> customCommaList;

    @Value("${custom.property.default:default-property}")
    private String propertyDefault;

    @PostConstruct
    public void init() {
        logger.info("customProperty: {}", customProperty);
        logger.info("customCommaList.toString(): {}", customCommaList.toString());
        logger.info("propertyDefault: {}", propertyDefault);
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }


}
