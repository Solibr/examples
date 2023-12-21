package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DefaultController {

    @ResponseBody
    @GetMapping("hello")
    public Object hello() {
        return new Object() {
            String message = "Hello world";
            String shit = "shit";
        };
    }
}
