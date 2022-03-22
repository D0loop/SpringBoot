package pe.example.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.example.auth.infra.NaverOauth2Service;

/**
 * @author D0Loop
 * @since 2022-03-17 [2022.3월.17]
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final NaverOauth2Service naverOauth2Service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication() // 메모리상에서 유저 검증, 스프링부트에 내장되어서 구현되있는 객체중 하나를 유저관리를 위해 사용하게됨.
//                .withUser("user1")
//                .password(passwordEncoder().encode("user1pass"))
//                .roles("USER")
//            .and()
//                .withUser("admin1")
//                .password(passwordEncoder().encode("admin1pass"))
//                .roles("ADMIN")
//        ;
        auth.userDetailsService(this.userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // url 기반의 권한 확인을 하기 위한 객체 반환
//                .anyRequest()
                .antMatchers("/home/**", "/user/signup/**") // url을 기준으로 어떤것을 허용 할 것인가
                .anonymous()
                .anyRequest()
                .authenticated()
            .and()
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/home")
                .permitAll() // permitAll을 붙임으로써 and이후의 요구사항들이 우선 순위를 가지게 되어 antMatchers의 "/user/**"를 지워도 된다.
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                    .userService(naverOauth2Service)
                .and()
                    .defaultSuccessUrl("/home")
            .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/home")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true) // 세션에 저장해놓은 데이터를 지움
                .permitAll() // 로그아웃을 위해 접근해야하는 페이지에 대한 권한을 풀어준다.
        ;
    }

}
