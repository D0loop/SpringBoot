package pe.example.auth.infra;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pe.example.auth.entity.UserRepository;

import java.util.Collections;
import java.util.Map;

/**
 * @author D0Loop
 * @since 2022-03-22 [2022.3월.22]
 */

@Service
@RequiredArgsConstructor
public class NaverOauth2Service implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private static final Logger logger = LoggerFactory.getLogger(NaverOauth2Service.class);

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String nameAttributeKey = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        logger.info(nameAttributeKey);
        logger.info(oAuth2User.getAttributes().toString());

        Map<String, Object> attributeMap = oAuth2User.getAttributes();
        Map<String, Object> responseMap = (Map<String, Object>) attributeMap.get("response");
        DefaultOAuth2User defaultOAuth2User =new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                responseMap,
                "email"
        );

        return defaultOAuth2User;
    }
}
