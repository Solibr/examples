package com.example.securingweb;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/some")
    @ResponseBody
    public String getSome() {
        return "Some";
    }

    @GetMapping("/some/shit")
    @ResponseBody
    public String getSomeShit() {
        return "Shit";
    }

    @GetMapping("/register")
    @ResponseBody
    public String register(@RequestParam(required = false) String username, @RequestParam(required = false) String password) {



        return username + " " + password;
    }
}
