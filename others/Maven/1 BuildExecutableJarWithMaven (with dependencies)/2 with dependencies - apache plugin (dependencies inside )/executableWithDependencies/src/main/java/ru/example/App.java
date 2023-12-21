package ru.example;

import com.google.gson.Gson;

public class App 
{
    public static void main(String[] args) {

        Gson gson = new Gson();
        String catInJson = gson.toJson(new Cat("Tom", 56));
        System.out.println(catInJson);

    }

    public static class Cat {
        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String name;
        int age;
    }
}
