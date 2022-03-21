package dev.example.community.infra;

import dev.example.community.entity.UserEntity;
import dev.example.community.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author D0Loop
 * @since 2022-03-21 [2022.3월.21]
 */

@Service
//@RequiredArgsConstructor
public class CommunityUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CommunityUserDetailsService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CommunityUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        final UserEntity testUserEntity = new UserEntity();
        testUserEntity.setUsername("entity_user");
        testUserEntity.setPassword(this.passwordEncoder.encode("test1pass"));
        this.userRepository.save(testUserEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<UserEntity> userEntity = this.userRepository.findByUsername(username);

        logger.info("CommunityUserDetailsService userEntity : " + userEntity.toString());
        UserEntity user = userEntity.orElseThrow(() -> {
            logger.info("CommunityUserDetailsService userEntity orElseThrow 발생");
            throw new UsernameNotFoundException(username + "은 없는 유저입니다.");
        });

        return new User(username, user.getPassword(), new ArrayList<>());
    }

}
