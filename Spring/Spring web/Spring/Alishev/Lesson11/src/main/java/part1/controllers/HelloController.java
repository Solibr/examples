package part1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first") // определяет префикс к url, чтобы обратиться к методам этого контроллера
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "/first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "/first/goodbye";
    }

}
