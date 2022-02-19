package ArrayListDayOne_Tests;

import ArrayList.ArrayListDayOne;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MergeArraysTests {

    private ArrayListDayOne test = new ArrayListDayOne();

    @Test
    public void sameSize() {
        int [] arrOne = {2,5,6,12,45};
        int [] arrTwo = {21,123,1,10,-1};

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(2,21,5,123,6,1,12,10,45,-1);
        ArrayList<Integer> actual  = test.mergeArrays(arrOne, arrTwo);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void arrayOneBigger() {
        int [] arrOne = {-10, -39, 30, 12, -4, 40, 0, 23};
        int [] arrTwo = {-6, 24, 72, -29};

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(-10,-6,-39,24,30,72,12,-29,-4,40,0,23);
        ArrayList<Integer> actual  = test.mergeArrays(arrOne, arrTwo);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void arrayTwoBigger() {
        int [] arrOne = {1,232,-23};
        int [] arrTwo = {80, 320, -54, -32, -32, -450};

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(1, 80, 232, 320, -23, -54, -32, -32, -450);
        ArrayList<Integer> actual  = test.mergeArrays(arrOne, arrTwo);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void bothEmpty() {
        int [] arrOne = new int [0];
        int [] arrTwo = new int[0];

        ArrayList<Integer> expected  = new ArrayList<>();
        ArrayList<Integer> actual  = test.mergeArrays(arrOne, arrTwo);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void arrayOneEmpty() {
        int [] arrOne = new int[0];
        int [] arrTwo = {31, -7, -3, 2, -10};

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(31, -7, -3, 2, -10);
        ArrayList<Integer> actual  = test.mergeArrays(arrOne, arrTwo);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void arrayTwoEmpty() {
        int [] arrOne = {4, 23, 6, -2, 8};
        int [] arrTwo = new int [0];

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(4, 23, 6, -2, 8);
        ArrayList<Integer> actual  = test.mergeArrays(arrOne, arrTwo);

        Assert.assertEquals(expected,actual);

    }





}
