package ArrayListAndStringDayTwo_Tests;

import ArrayList.ArrayListAndStringDayTwo;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SwitchPairsTests {

    private ArrayListAndStringDayTwo test = new ArrayListAndStringDayTwo();

    @Test
    public void emptyList() {

        ArrayList<String> input = new ArrayList<>();

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual  = test.switchPairs(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void pairs() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("house","is", "at","the", "end","of", "the","block");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("is","house", "the","at", "of","end", "block","the");
        ArrayList<String> actual  = test.switchPairs(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void pairs2() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("during","the", "last","sprint", "I","finished", "10", "test cases");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("the","during", "sprint","last", "finished","I", "test cases","10");
        ArrayList<String> actual  = test.switchPairs(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void pairs3() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("When","I", "go","down", "to","the", "beach","I", "like","sleeping");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("I","When", "down","go", "the","to", "I","beach", "sleeping","like");
        ArrayList<String> actual  = test.switchPairs(input);

        Assert.assertEquals(expected,actual);

    }




}
