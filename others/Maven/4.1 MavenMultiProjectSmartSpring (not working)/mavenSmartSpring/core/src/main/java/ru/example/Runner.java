package ru.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {

    private final Map<String, Module> map;

    public Runner(List<Module> moduleList) {
        this.map = moduleList.stream().collect(Collectors.toMap(Module::getName, module -> module));
        System.out.println("List size: " + moduleList.size());
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Hello World from Runner!" );
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(new Cat("Sam", 3)));

        System.out.println("Map size: " + map.size());
        printAllModules();
    }

    private void printAllModules() {
        for (Map.Entry<String, Module> entry : map.entrySet()) {
            System.out.println("\t" + entry.getKey());
        }
    }

}
