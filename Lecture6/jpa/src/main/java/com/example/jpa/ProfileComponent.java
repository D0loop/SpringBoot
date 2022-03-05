package com.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author D0Loop
 * @since 2022-03-05 [2022.3월.05]
 */

@Component
@Profile("local")
public class ProfileComponent {
    public static final Logger logger = LoggerFactory.getLogger(ProfileComponent.class);

    public ProfileComponent() {
        logger.info("profile component profile: local");
    }
}
