package com.example.securingweb;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // оригинальный код взятый из какой-то статьи. "Собранный" стиль
    @Bean
    @Profile("original")
    public SecurityFilterChain originalSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/home").permitAll().anyRequest().authenticated())
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

    // то же самое, но стиль "размазанный"
    @Bean
    @Profile("test1")
    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                    .requestMatchers("/home", "/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and();
        return http.build();
    }



    // оставляем стандартную страницу входа
    @Bean
    @Profile("default-login-page")
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                    .requestMatchers("/home", "/").permitAll()
                    .requestMatchers("/admin").hasRole("ADMIN")
                    //.anyRequest().authenticated()
                    .requestMatchers("/hello").hasRole("USER")
                    .and()
                .formLogin()
                    .and()
                .logout()
                    .permitAll()
                    .and();
        return http.build();
    }

    // всё по максимуму дефолтное
    @Bean
    @Profile("all-default")
    public SecurityFilterChain allDefaultFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .and()
                .logout()
                    .permitAll()
                    .and();
        return http.build();
    }

    // добавляем немного ролей
    @Bean
    @Profile("test2")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/home", "/").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                //.anyRequest().authenticated()
                .requestMatchers("/hello").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and();
        return http.build();
    }

    // добавим два бина как разные FilterChain. Один для админа, другой для остального. У админа будет кастомная страница входа
    // пока не работает
    @Bean
    @Profile("test3")
    public SecurityFilterChain securityFilterChainAdmin(HttpSecurity http) throws Exception {

        // securityMatcher - не факт, что его нужно использовать. Не понимаю что он делает
        http.securityMatcher("/admin")
                .authorizeHttpRequests()
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and();
        return http.build();
    }

    @Bean
    @Profile("test3")
    public SecurityFilterChain securityFilterChainOther(HttpSecurity http) throws Exception {
        http.securityMatcher("/")
                .authorizeHttpRequests()
                    .requestMatchers("/home", "/").permitAll()
                    .requestMatchers("/hello").hasRole("USER")
                    .and()
                .formLogin()
                    .and()
                .logout()
                    .permitAll()
                    .and();
        return http.build();
    }

    // правильная логика определения доступа к частично схожим ресурсам
    // (работает логика последовательного сопоставления)
    // плюс определил матчер для logout вручную - теперь можно разлогиниться с GET и любым другим методом на /logout, а раньше требовался метод POST
    @Bean
    @Profile("test4")
    public SecurityFilterChain securityFilterChain4(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                    .requestMatchers("/home", "/").permitAll()

                // речь о последующих двух строчках. Если поменять местами, будет неожидаемое поведение.
                .requestMatchers("/some/shit").permitAll()
                .requestMatchers("/some/**").authenticated()

                .requestMatchers("/register").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    //.logoutUrl("/logout")
                    .logoutRequestMatcher(new RequestMatcher() {
                        @Override
                        public boolean matches(HttpServletRequest request) {
                            return request.getRequestURI().equals("/logout");
                        }
                    })
                    .permitAll()
                    .and();
        return http.build();
    }
	
	// httpBasic
    @Bean
    @Profile("test5")
    public SecurityFilterChain basicSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/home").permitAll().anyRequest().authenticated())
                
				// Базовое окошко авторизации. В этом случае будет работать авторизация через url (		http://user:pass@localhost:8080/some/resource	)
				.httpBasic()
		;
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        ArrayList<UserDetails> users = new ArrayList<>();

        users.add(User.withDefaultPasswordEncoder()
                .username("user")
                .password("pass")
                .roles("USER")
                .build());

        users.add(User.withDefaultPasswordEncoder()
                .username("admin")
                .password("pass")
                .roles("ADMIN", "USER")
                .build());

        return new InMemoryUserDetailsManager(users);
    }
}
