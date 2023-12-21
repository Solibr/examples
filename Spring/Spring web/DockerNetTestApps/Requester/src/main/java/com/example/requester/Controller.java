package com.example.requester;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Requester requester;

    public Controller(Requester requester) {
        this.requester = requester;
    }

    @GetMapping("/")
    public String doFeign() {
        String fromFeign = requester.getString();
        return "Feign: " + fromFeign;
    }

}
