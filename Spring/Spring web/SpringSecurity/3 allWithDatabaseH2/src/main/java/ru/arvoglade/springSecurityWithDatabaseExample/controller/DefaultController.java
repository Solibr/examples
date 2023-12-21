package ru.arvoglade.springSecurityWithDatabaseExample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.arvoglade.springSecurityWithDatabaseExample.dto.RegisterUser;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.Authority;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.Role;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.User;
import ru.arvoglade.springSecurityWithDatabaseExample.repository.UserRepository;

import java.util.List;

@Controller
public class DefaultController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DefaultController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String getIndex() {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new Authority(Role.USER)))
            return "redirect:/home";
        return "index";
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        String roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().map(authority -> authority.getAuthority()).reduce((a, b) -> a + " " + b).get();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("username", username);
        model.addAttribute("roles", roles);
        return "home";
    }

    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute("user")RegisterUser registerUser) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") RegisterUser registerUser) {
        if (userRepository.findUserByUsername(registerUser.getUsername()).isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This username already taken");
        User newUser = new User(
                registerUser.getUsername(),
                passwordEncoder.encode(registerUser.getPassword()),
                List.of(new Authority(Role.USER)));
        userRepository.save(newUser);
        return "redirect:/home";
    }

}
