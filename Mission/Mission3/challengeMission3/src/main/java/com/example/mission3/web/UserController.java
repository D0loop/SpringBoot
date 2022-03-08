package com.example.mission3.web;

import com.example.mission3.service.user.UserService;
import com.example.mission3.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-03-08 [2022.3월.08]
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserDto userDto, HttpServletRequest httpServletRequest) {
        logger.info(userDto.toString());
        logger.info(httpServletRequest.getHeader("content-type"));
        this.userService.createUser(userDto);
    }

    @GetMapping()
    public List<UserDto> readUserAll() {
        logger.info("in read all");
        return this.userService.readUserAll();
    }

    @GetMapping("{id}")
    public UserDto readUserOne(@PathVariable("id") int id) {
        logger.info("in read one");
        return this.userService.readUser(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@PathVariable("id") int id,
                            @Valid @RequestBody UserDto userDto) {

        this.userService.updateUser(id, userDto);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") int id) {
        this.userService.deleteUser(id);
    }
}
