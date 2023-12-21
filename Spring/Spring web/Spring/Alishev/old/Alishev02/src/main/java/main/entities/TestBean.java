package main.entities;

import org.springframework.stereotype.Component;

//@Component("testBean")
public class TestBean {
    public String name;

    public TestBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
