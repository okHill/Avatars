package ArrayListAndStringDayTwo_Tests;

import ArrayList.*;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RemoveDuplicatesTests {

    private ArrayListAndStringDayTwo test = new ArrayListAndStringDayTwo();

    @Test
    public void emptyList() {

        ArrayList<Integer> input = new ArrayList<>();

        ArrayList<Integer> expected  = new ArrayList<>();
        ArrayList<Integer> actual  = test.removeDuplicates(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void noDuplicate() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(9,-3,-4,6,8,10);

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(9,-3,-4,6,8,10);
        ArrayList<Integer> actual  = test.removeDuplicates(input);

        Collections.sort(expected);
        Collections.sort(actual);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void someDuplicate() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(-1,1,4,-3,4, 8, 19, 10, 1);

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(-1,1,4,-3,8,19,10);
        ArrayList<Integer> actual  = test.removeDuplicates(input);

        Collections.sort(expected);
        Collections.sort(actual);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void someDuplicate2() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(-3, 12, 9, 19, 12, 10, -3, 230, 10, 29, 29);

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(-3,12,9,19,10,230,29);
        ArrayList<Integer> actual  = test.removeDuplicates(input);

        Collections.sort(expected);
        Collections.sort(actual);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void someDuplicate3() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(10,30,12,10,-12,12,10,72);

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(10,30,12,-12,72);
        ArrayList<Integer> actual  = test.removeDuplicates(input);

        Collections.sort(expected);
        Collections.sort(actual);

        Assert.assertEquals(expected,actual);

    }




}
