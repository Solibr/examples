package com.example.arvoglade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {
    public String test1() {
        Map<String, Object> map = getMap();
        ObjectMapper mapper = new ObjectMapper();

        Person person = mapper.convertValue(map, Person.class);

        System.out.println(person);
        return person.toString();
    }

    public String test2() {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person();
        person.setName("Peter");
        person.setAge(45);
        person.setLastname("Yu");

        Map<String, Object> map  = mapper.convertValue(person, HashMap.class);

        System.out.println("Name" + map.get("name") + "\t Class: " + map.get("name").getClass().getName());
        System.out.println("Lastname" + map.get("lastname") + "\t Class: " + map.get("lastname").getClass().getName());
        System.out.println("Age" + map.get("age") + "\t Class: " + map.get("age").getClass().getName());

        return map.toString();
    }


    public static Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Alex");
        map.put("age", 27);
        map.put("lastname", "Simpson");
        return map;
    }
}
