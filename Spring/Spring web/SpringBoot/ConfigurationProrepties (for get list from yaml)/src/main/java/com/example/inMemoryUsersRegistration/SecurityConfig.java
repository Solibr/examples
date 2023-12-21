package com.example.inMemoryUsersRegistration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.PrivateKey;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PermittedUrls permittedUrls;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((c) -> c.ignoringRequestMatchers("/**"))
                .authorizeHttpRequests((request) -> request
                        //.requestMatchers("/" ,"/register").permitAll()
                        .requestMatchers(permittedUrls.list).permitAll()
                        .anyRequest().authenticated())
                .httpBasic()


                /*.formLogin((form) -> form
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout").permitAll())*/

        ;
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetailsService userDetailsService;
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails user = User.builder()
                .passwordEncoder(encoder::encode)
                .username("user")
                .password("pass")
                .authorities("USER")
                .build();

        UserDetails artem = User.builder()
                .passwordEncoder(encoder::encode)
                .username("artem")
                .password("pass")
                .authorities("USER")
                .build();

        userDetailsService = new InMemoryUserDetailsManager(user, artem);
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
