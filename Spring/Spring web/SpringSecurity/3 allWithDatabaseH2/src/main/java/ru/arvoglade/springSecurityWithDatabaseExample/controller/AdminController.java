package ru.arvoglade.springSecurityWithDatabaseExample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.Authority;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.Role;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.User;
import ru.arvoglade.springSecurityWithDatabaseExample.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getAdminPage() {
        return "admin";
    }

    @PostMapping("/add")
    public String addAdmin(@RequestParam("username") String username) {
        System.out.println("Username: " + username);
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        if (!user.getAuthorities().contains(new Authority(Role.ADMIN))) {
            user.addAuthority(Role.ADMIN);
            userRepository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already admin");
        }
        return "admin";
    }
}
