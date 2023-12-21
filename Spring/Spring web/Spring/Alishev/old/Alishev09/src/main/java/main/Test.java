package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Long> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Random rnd = new Random();

        for (int i = 0; i < 1000; i++) {
            set.add(Math.round(Math.floor(Math.random() * 3)));

            set2.add(rnd.nextInt(3));
        }
        System.out.println(set);
        System.out.println(set2);

    }
}
