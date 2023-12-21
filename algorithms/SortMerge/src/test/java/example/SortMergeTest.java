package example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortMergeTest {

    @Test
    public void sort() {

        List<Integer> list = new ArrayList<>(List.of(4, 5, 1, 3, 2));

        //List<Integer> expectedSortedList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        //Integer[] expectedSortedArr = new Integer[5];

        Integer[] expectedSortedArr = {1, 2, 3, 4, 5};

        List<Integer> sortedList = SortMerge.sort(list);

        Integer[] sortedArr = new Integer[5];
        sortedArr = sortedList.toArray(sortedArr);

        Assert.assertArrayEquals( expectedSortedArr, sortedArr );

    }

}
