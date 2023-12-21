package org.example;

import org.springframework.stereotype.Component;

@Component
public class Module1 implements Module {
    @Override
    public String getName() {
        return "module 1";
    }

}
