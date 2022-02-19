package ArrayListDayOne_Tests;

import ArrayList.ArrayListDayOne;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;


public class PosNumTests {

    private ArrayListDayOne test = new ArrayListDayOne();

    @Test
    public void onlyPosNum() {
        int [] arr = {2,5,6,12,45};

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(arr);
        ArrayList<Integer> actual  = test.getPositiveNumbers(arr);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void onlyNegNum() {
        int [] arr = {-1, -10, -4, -241, -8};

        ArrayList<Integer> expected  = new ArrayList<>();
        ArrayList<Integer> actual  = test.getPositiveNumbers(arr);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixedNum() {
        int [] arr = {90, -2, -29, 4, -12, 2};

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(90,4,2);
        ArrayList<Integer> actual  = test.getPositiveNumbers(arr);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void emptyArray() {
        int [] arr = new int [0];

        ArrayList<Integer> expected  = new ArrayList<>();
        ArrayList<Integer> actual  = test.getPositiveNumbers(arr);

        Assert.assertEquals(expected,actual);

    }







}
