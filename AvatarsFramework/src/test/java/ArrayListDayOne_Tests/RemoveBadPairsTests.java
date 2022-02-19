package ArrayListDayOne_Tests;

import ArrayList.ArrayListDayOne;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RemoveBadPairsTests {

    private ArrayListDayOne test = new ArrayListDayOne();

    @Test
    public void emptyList() {

        ArrayList<Integer> input = new ArrayList<>();

        ArrayList<Integer> expected  = new ArrayList<>();
        ArrayList<Integer> actual  = test.removeBadPairs(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void halfPairs() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(3,2, 4,7, 5,1, 3,3, 8,3, 9,7, 2,10);

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(4,7,3,3,2,10);
        ArrayList<Integer> actual  = test.removeBadPairs(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void noPairs() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(3,4, 5,20, 2,5, -12,-1, 32,33, 4,18) ;

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(3,4, 5,20, 2,5, -12,-1, 32,33, 4,18);
        ArrayList<Integer> actual  = test.removeBadPairs(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void somePairs() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(2,3, 5,9, -3,0, 12,8, 3,8, 34,50, 2,14, 42,33) ;

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(2,3, 5,9, -3,0, 3,8, 34,50,2,14);
        ArrayList<Integer> actual  = test.removeBadPairs(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void somePairs2() {

        ArrayList<Integer> input = ArrayListUtils.arrayToArrayList(20,12, -29,40, 9,10, -31,-19, -1, 10) ;

        ArrayList<Integer> expected  = ArrayListUtils.arrayToArrayList(-29,40, 9,10, -31,-19, -1, 10);
        ArrayList<Integer> actual  = test.removeBadPairs(input);

        Assert.assertEquals(expected,actual);

    }






}
