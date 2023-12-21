package example;

import java.util.ArrayList;
import java.util.List;

public class SortBubble {

    public static List<Integer> sort(List<Integer> list) {

        List<Integer> sortingList = new ArrayList<>(list);

        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = 0; j < list.size() - 1 - i; j++) {
                //System.out.println("Compairing: " + j + " and " + (j + 1));\
                int a = sortingList.get(j);
                int b = sortingList.get(j + 1);
                if (a > b) {
                    sortingList.set(j, b);
                    sortingList.set(j + 1, a);
                }

            }

        }
        return sortingList;

    }



}
