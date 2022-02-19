package ArrayListAndStringDayThree_Tests;

import ArrayList.ArrayListAndStringDayThree;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SecondBiggestNumberTests {

    private ArrayListAndStringDayThree test = new ArrayListAndStringDayThree();

    @Test
    public void emptyList() {

        ArrayList<Integer> input = new ArrayList<>();

        int expected  = 0;
        int actual = test.secondBiggestNumber(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(3,5,-2,-6,2,9);

        int expected  = 5;
        int actual = test.secondBiggestNumber(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed2() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(-3,-4,3,2,1,-1);

        int expected  = 2;
        int actual = test.secondBiggestNumber(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed3() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(10, -10, 32, 349, -239, 23, 230, -140);

        int expected  = 230;
        int actual = test.secondBiggestNumber(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allNegative() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(-113,-213,-134,-242,-422,-104);

        int expected  = -113;
        int actual = test.secondBiggestNumber(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allNegative2() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(-42, -10, -50, -32, -19);

        int expected  = -19;
        int actual = test.secondBiggestNumber(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allSame() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(5,5,5,5,5);

        int expected  = 0;
        int actual = test.secondBiggestNumber(input);

        Assert.assertEquals(expected,actual);

    }



}
