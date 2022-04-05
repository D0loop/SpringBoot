package dev.example.community.controller;

import dev.example.community.infra.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author D0Loop
 * @since 2022-03-17 [2022.3월.17]
 */

@Controller
@RequestMapping("home")
@RequiredArgsConstructor
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final AuthenticationFacade authenticationFacade;

    @GetMapping()
    public String home() {
        try {
            logger.info("At home connected user : {}", authenticationFacade.getAuthentication().getName());
        } catch (NullPointerException e) {
            logger.info("No user logged in");
        }
        return "index";
    }
}
