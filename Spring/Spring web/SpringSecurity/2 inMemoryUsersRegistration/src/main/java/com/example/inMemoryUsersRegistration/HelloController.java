package com.example.inMemoryUsersRegistration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;
    private final PasswordEncoder passwordEncoder;


    public HelloController(UserDetailsService userDetailsService, PasswordEncoder encoder) {
        this.inMemoryUserDetailsManager = (InMemoryUserDetailsManager) userDetailsService;
        this.passwordEncoder = encoder;
    }

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationData data) {

        UserDetails newUser = User.builder().passwordEncoder(passwordEncoder::encode)
                .username(data.getUsername())
                .password(data.getPassword())
                .authorities("USER")
                .build();

        inMemoryUserDetailsManager.createUser(newUser);

        return "user registered";
    }

    @GetMapping("/")
    public String getMainPage() {
        return "Main page";
    }
}
