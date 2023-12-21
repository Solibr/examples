package example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        testBubbleSort();

    }

    private static void testMergeSort() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input size of list to sort");
            String line = scanner.nextLine();
            int count;
            try {
                count = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Closing the program");
                break;
            }
            List<Integer> list = getShuffledList(count);
            long startTime = System.currentTimeMillis();
            List<Integer> sortedList = SortMerge.sort(list);
            System.out.println("TIME: " + (System.currentTimeMillis() - startTime));
            //System.out.println(sortedList);
            //System.out.println(list);
        }
    }

    private static void testBubbleSort() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input size of list to sort");
            String line = scanner.nextLine();
            int count;
            try {
                count = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Closing the program");
                break;
            }
            List<Integer> list = getShuffledList(count);
            long startTime = System.currentTimeMillis();
            List<Integer> sortedList = SortBubble.sort(list);
            System.out.println("TIME: " + (System.currentTimeMillis() - startTime));
            //System.out.println(sortedList);
            //System.out.println(list);
        }
    }

    private static List<Integer> getShuffledList(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }
}