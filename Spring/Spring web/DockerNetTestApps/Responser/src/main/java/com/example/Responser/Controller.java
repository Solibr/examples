package com.example.Responser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Controller {

    Random rnd = new Random();

    @GetMapping( "/")
    public String getString() {
        return "Hello from responser. Random value: " + rnd.nextInt(100);
    }

}
