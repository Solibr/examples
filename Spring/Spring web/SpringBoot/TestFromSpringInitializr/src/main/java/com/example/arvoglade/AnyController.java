package com.example.arvoglade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@Slf4j
@RestController
@RequestMapping("/any")
public class AnyController {

    @Value("${string.any-test2}")
    public String textForGet2Method;

    @GetMapping("/test")
    public String get() {
        return "That was GET";
    }

    @PostMapping("/test")
    public String post(@RequestBody Some some) {
        return "That was POST. Text: " + some.text + " Count: " + some.count;
    }

    @GetMapping("/test2")
    public Object get2() {
        ZonedDateTime timeNow = ZonedDateTime.now();
        log.info("AnyController.get2: time: {}", timeNow);
        log.info("AnyController.get2: timeAsString: {}", timeNow.toString());

        return new Object() {
            public ZonedDateTime time = timeNow;
            public String timeAsString = timeNow.toString();
        };
    }
}
