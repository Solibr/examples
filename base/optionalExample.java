package main.toReplaceToOptionalExample;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

public class optionalExample {

    @Data
    @AllArgsConstructor
    public static class Cat {
        String name;
        int age;
    }

    public static Optional<Cat> findCat(String dummyName) {
        if (Math.random() < 0.5) {
            return Optional.empty();
        }
        return Optional.of(new Cat(dummyName, 4));
    }

    public static void main(String[] args) {

        // For example, we want just to print cat's age
        Optional<Cat> optionalCat = findCat("some name");
        if (optionalCat.isPresent()) {
            System.out.println(optionalCat.get().getAge());
        } else {
            System.out.println(0);
        }

        // here we must get Cat object just to later print age
        Cat cat = findCat("some name").orElse(new Cat("Unknown", 0));
        System.out.println(cat.getAge());

        // More concise way to print age
        System.out.println(findCat("some name").map(Cat::getAge).orElse(0));
    }
}
