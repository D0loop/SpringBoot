package pe.example.auth;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.example.auth.infra.AuthenticationFacade;

import java.security.Principal;

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
//    public String home(Principal principal) { //  방법 1
//    public String home(Authentication authentication) { // 방법 2
    public String home() { // 방법 3
        try {
//            logger.info("connected user : {}", principal.getName());
//            logger.info("connected user : {}", authentication.getName());
            logger.info("connected user : {}", authenticationFacade.getAuthentication().getName());
        } catch (NullPointerException e) {
            logger.info("No user logged in");
        }
        return "index";
    }
}
