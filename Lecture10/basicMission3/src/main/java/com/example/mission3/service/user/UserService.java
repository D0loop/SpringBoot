package com.example.mission3.service.user;

import com.example.mission3.web.dto.PostDto;
import com.example.mission3.web.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-03-08 [2022.3월.08]
 */

public interface UserService {
    void createUser(UserDto dto);
    List<UserDto> readUserAll();
    UserDto readUser(int id);
    void updateUser(int id, UserDto dto);
    void deleteUser(int id);
}
