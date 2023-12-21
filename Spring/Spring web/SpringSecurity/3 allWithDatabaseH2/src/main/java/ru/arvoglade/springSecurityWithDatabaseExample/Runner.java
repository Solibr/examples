package ru.arvoglade.springSecurityWithDatabaseExample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.Authority;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.Role;
import ru.arvoglade.springSecurityWithDatabaseExample.entities.User;
import ru.arvoglade.springSecurityWithDatabaseExample.repository.AuthorityRepositiory;
import ru.arvoglade.springSecurityWithDatabaseExample.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final AuthorityRepositiory authorityRepositiory;
    private final PasswordEncoder passwordEncoder;

    public Runner(UserRepository userRepository, AuthorityRepositiory authorityRepositiory, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepositiory = authorityRepositiory;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        checkRolesInDatabase();
        //addUsers();
    }

    private String encode(String password) {
        return passwordEncoder.encode(password);
    }

    private void checkRolesInDatabase() {
        Set<String> allRoles = Arrays.stream(Role.values())
                .map(role -> role.toString()).collect(Collectors.toSet());

        Set<String> persistedRoles = new HashSet<>();
        authorityRepositiory.findAll().forEach(authority -> persistedRoles.add(authority.toString()));

        allRoles.removeAll(persistedRoles);
        Set<Authority> notPersistedAuthorities = new HashSet<>();

        allRoles.forEach(role -> notPersistedAuthorities
                .add(new Authority(Role.valueOf(role))));

        authorityRepositiory.saveAll(notPersistedAuthorities);
    }

    private void addTestUsers() {
        System.out.println("Before");
        userRepository.findAll().forEach(System.out::println);

        User admin = new User("Sam", encode("pass"), List.of(new Authority(Role.USER), new Authority(Role.ADMIN)));
        userRepository.save(admin);

        User user = new User("John", encode("pass"), List.of(new Authority(Role.USER)));
        userRepository.save(user);

        User adminAdmin = new User("Tom", encode("pass"), List.of(new Authority(Role.ADMIN)));
        userRepository.save(adminAdmin);

        System.out.println("After");
        userRepository.findAll().forEach(System.out::println);
    }
}
