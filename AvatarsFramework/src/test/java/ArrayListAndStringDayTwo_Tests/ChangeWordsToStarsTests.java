package ArrayListAndStringDayTwo_Tests;

import ArrayList.ArrayListAndStringDayTwo;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ChangeWordsToStarsTests {

    private ArrayListAndStringDayTwo test = new ArrayListAndStringDayTwo();

    @Test
    public void emptyList() {

        ArrayList<String> input = new ArrayList<>();

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual  = test.changeWordsToStars(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("bats", "house", "fast", "I", "finish");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("****", "*****", "****", "*", "******");

        ArrayList<String> actual  = test.changeWordsToStars(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed2() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("stars", "fall", "from", "the", "sky");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("*****", "****", "****", "***", "***");

        ArrayList<String> actual  = test.changeWordsToStars(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed3() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("one", "sided", "", "", "event", "tonight", "example");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("***", "*****", "", "", "*****", "*******", "*******");

        ArrayList<String> actual  = test.changeWordsToStars(input);

        Assert.assertEquals(expected,actual);

    }


}
