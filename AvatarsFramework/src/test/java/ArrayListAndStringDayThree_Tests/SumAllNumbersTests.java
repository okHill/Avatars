package ArrayListAndStringDayThree_Tests;

import ArrayList.ArrayListAndStringDayThree;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SumAllNumbersTests {

    private ArrayListAndStringDayThree test = new ArrayListAndStringDayThree();

    @Test
    public void emptyList() {

        ArrayList<String> input = new ArrayList<>();

        ArrayList<Integer> expected  = new ArrayList<>();
        ArrayList<Integer> actual = test.sumAllNumbers(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("123", "912", "2130", "12");

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(6, 12, 6, 3);
        ArrayList<Integer> actual = test.sumAllNumbers(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed2() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("318719", "3289","9038", "182", "314114");

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(29, 22, 20, 11, 14);
        ArrayList<Integer> actual = test.sumAllNumbers(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed3() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("9123","0330", "0121", "89248");

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(15, 6, 4, 31);
        ArrayList<Integer> actual = test.sumAllNumbers(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void zeros() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("000", "910", "0001", "0003", "000");

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(0, 10, 1, 3, 0);
        ArrayList<Integer> actual = test.sumAllNumbers(input);

        Assert.assertEquals(expected,actual);

    }


}
