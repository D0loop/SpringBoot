package dev.example.community.controller;

import dev.example.community.controller.dto.UserDto;
import dev.example.community.infra.AuthenticationFacade;
import dev.example.community.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final AuthenticationFacade authenticationFacade;


    @GetMapping("login")
    public String login() {

        try {
            logger.info("At user connected user : {}", authenticationFacade.getAuthentication().getName());
        } catch (NullPointerException e) {
            logger.info("No user logged in");
        }

        return "login-form";
    }

    @GetMapping("signup")
    public String signUp() {
        return "signup-form";
    }

    @PostMapping("signup")
    public String signUpPost(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("password_check") String passwordCheck,
                             @RequestParam(value = "is_shop_owner", required = false) Boolean isShopOwner) {

        logger.info("isShopOwner : " + isShopOwner);
        userService.signUpPost(username, password, passwordCheck, isShopOwner);

        return "redirect:/home";
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(this.userService.createUser(userDto));
    }

    @GetMapping("{id}")
    public @ResponseBody ResponseEntity<UserDto> readUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.readUser(id));
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Collection<UserDto>> readUserAll(){
        return ResponseEntity.ok(this.userService.readUserAll());
    }

    @PutMapping("{id}")
    public @ResponseBody ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        this.userService.updateUser(id, userDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public @ResponseBody ResponseEntity<?> DeleteUser(@PathVariable("id") Long id){
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
