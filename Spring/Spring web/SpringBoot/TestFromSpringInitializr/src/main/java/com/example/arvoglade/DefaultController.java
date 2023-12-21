package com.example.arvoglade;

import com.example.arvoglade.test3.Test3Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequiredArgsConstructor
public class DefaultController {

    private final Service service;
    private final Test3Service test3Service;

    @GetMapping("/hello")
    public String get() {
        return service.test1();
    }

    @GetMapping("/hello2")
    public String get2() {
        return service.test2();
    }

    @GetMapping("/hello3")
    public String get3() {
        return test3Service.test3();
    }



    @GetMapping("/err")
    public String err() {
        throw new RuntimeException("Some message about the error");
    }

    @GetMapping("/test")
    public Object test() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ZonedDateTime time = ZonedDateTime.now();
        //return mapper.writeValueAsString(time);
        return new Object() {
            public ZonedDateTime time = ZonedDateTime.now();
        };
    }


}
