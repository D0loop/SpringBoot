package pe.example.auth;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import pe.example.auth.dto.UserDto;
import pe.example.auth.entity.UserEntity;
import pe.example.auth.entity.UserRepository;

/**
 * @author D0Loop
 * @since 2022-03-17 [2022.3월.17]
 */

@Controller
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("login")
    public String login() {
        return "login-form";
    }

    @GetMapping("signup")
    public String signUp() {
        return "signup-form";
    }

    @PostMapping("signup")
    public String signUpPost(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("password_check") String passwordCheck) {

        if(!password.equals(passwordCheck)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(passwordEncoder.encode(password));
        userRepository.save(userEntity);

        return "redirect:/home";
    }
}
