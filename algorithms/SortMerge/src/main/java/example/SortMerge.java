package example;

import java.util.ArrayList;
import java.util.List;

public class SortMerge {

    public static List<Integer> sort(List<Integer> inputList) {

        return innerSort(inputList, 0, inputList.size());

        //return List.of(1, 2, 3, 4, 5);
    }

    private static List<Integer> innerSort(List<Integer> inputList, int begin, int end) {

        List<Integer> sortedList = new ArrayList<>();
        if (end - begin > 2) {
            int middle = (end - begin) / 2 + begin;
            List<Integer> aList = innerSort(inputList, begin, middle);
            List<Integer> bList = innerSort(inputList, middle, end);

            int aPointer = 0;
            int bPointer = 0;

            while (aPointer != aList.size() && bPointer != bList.size()) {
                if (aList.get(aPointer) < bList.get(bPointer)) {
                    sortedList.add(aList.get(aPointer));
                    aPointer++;
                } else {
                    sortedList.add(bList.get(bPointer));
                    bPointer++;
                }
            }
            if (aPointer == aList.size() && bPointer != bList.size()) {
                sortedList.addAll(bList.subList(bPointer, bList.size()));
            }
            if (bPointer == bList.size() && aPointer != aList.size()) {
                sortedList.addAll(aList.subList(aPointer, aList.size()));
            }

        }
        else if (end - begin == 1) {
            sortedList.add(inputList.get(begin));
        }
        else {
            Integer a = inputList.get(begin);
            Integer b = inputList.get(end - 1);
            if (a <= b) {
                sortedList.add(a);
                sortedList.add(b);
            } else {
                sortedList.add(b);
                sortedList.add(a);
            }

        }

        return sortedList;
    }
}
