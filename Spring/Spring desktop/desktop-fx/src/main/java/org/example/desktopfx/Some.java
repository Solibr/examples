package org.example.desktopfx;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Some {

    //@Autowired
    @Lazy
    private Runner runner;

    public void foo() {
        System.out.println("+++");

    }

    @Autowired
    @Lazy
    public void init(Runner runner) {

        //System.out.println(runner);
    }

}
