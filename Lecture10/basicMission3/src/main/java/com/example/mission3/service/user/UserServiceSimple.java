package com.example.mission3.service.user;

import com.example.mission3.domain.user.UserEntity;
import com.example.mission3.domain.user.UserRepository;
import com.example.mission3.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-03-08 [2022.3월.08]
 */

@Service
@RequiredArgsConstructor
public class UserServiceSimple implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceSimple.class);

    private final UserRepository userRepository;

    @Override
    public void createUser(UserDto dto) {
        this.userRepository.save(dto.toEntity());
    }

    @Override
    public List<UserDto> readUserAll() {
        Iterator<UserEntity> iterator = userRepository.findAll().iterator();
        List<UserDto> result = new ArrayList<>();

        while (iterator.hasNext()) {
            UserEntity userEntity = iterator.next();
            result.add(UserDto.builder()
                    .id(Math.toIntExact(userEntity.getId()))
                    .name(userEntity.getName())
                    .age(Math.toIntExact(userEntity.getAge()))
                    .build());

        }
        return result;
    }

    @Override
    public UserDto readUser(int id) {
        return this.userRepository.findById((long) id)
                .map(UserDto::new)
                .orElseThrow(() -> new IllegalArgumentException("No user has id = " + id));
    }

    @Override
    public void updateUser(int id, UserDto dto) {

        UserEntity targetEntity = this.userRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        targetEntity.setName(dto.getName() == null ? targetEntity.getName() : dto.getName());
        targetEntity.setAge(dto.getAge() == targetEntity.getAge() ? targetEntity.getAge() : dto.getAge());

        this.userRepository.save(targetEntity);
    }

    @Override
    public void deleteUser(int id) {

        UserEntity targetEntity = this.userRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("No user has id = " + id));

        this.userRepository.delete(targetEntity);

    }
}
