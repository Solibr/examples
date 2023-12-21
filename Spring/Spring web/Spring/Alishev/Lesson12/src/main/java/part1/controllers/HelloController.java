package part1.controllers;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    //  #new - использование HttpServletRequest. Если нужного параметра нет - null
    @GetMapping("/hello1")
    public String hello1(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("Name: " + name);

        return "/hello";
    }

    // #new - использование @RequestParam. Если нужного параметра нет - Error
    @GetMapping("/hello2")
    public String hello2(@RequestParam("name") String name) {
        System.out.println("Name: " + name);
        return "/hello";
    }

    // #new - использование @RequestParam. Если нужного параметра нет - null
    @GetMapping("/hello3")
    public String hello3(@RequestParam(value = "name", required = false) String name) {
        System.out.println("Name: " + name);
        return "/hello";
    }

}
