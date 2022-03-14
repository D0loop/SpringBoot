package com.example.posting.config;

import com.example.posting.interceptor.HeaderLoggingInterceptor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author D0Loop
 * @since 2022-03-05 [2022.3월.05]
 */

@Configuration
@RequiredArgsConstructor
public class DemoConfig implements WebMvcConfigurer {

    public static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);

//    @Value("${custom.property.single}")
//    private String customProperty;
//
//    @Value("${custom.property.comlist}")
//    private List<String> customCommaList;
//
//    @Value("${custom.property.default:default-property}")
//    private String propertyDefault;
//
//    @PostConstruct
//    public void init() {
//        logger.info("customProperty: {}", customProperty);
//        logger.info("customCommaList.toString(): {}", customCommaList.toString());
//        logger.info("propertyDefault: {}", propertyDefault);
//    }
//
//    @Bean
//    public Gson gson() {
//        return new Gson();
//    }

    private final HeaderLoggingInterceptor headerLoggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerLoggingInterceptor)
                .addPathPatterns("/post/**")
                .excludePathPatterns("/except/**");
    }
}
