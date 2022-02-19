package ArrayListAndStringDayThree_Tests;

import ArrayList.ArrayListAndStringDayThree;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CamelCaseTests {

    private ArrayListAndStringDayThree test = new ArrayListAndStringDayThree();

    @Test
    public void emptyList() {

        ArrayList<String> input = new ArrayList<>();

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual = test.camelCase(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allLower() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("camel case", "java is fun", "maple trees grow here");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("camelCase", "javaIsFun", "mapleTreesGrowHere");
        ArrayList<String> actual = test.camelCase(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allUpper() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("IT IS RAINING TODAY", "THE BATCH IS ALMOST DONE", "I CAN HELP YOU");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("itIsRainingToday", "theBatchIsAlmostDone", "iCanHelpYou");
        ArrayList<String> actual = test.camelCase(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("JaMes BOnd MovIE", "", "charge", "lAPTOP FOR saLE");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("jamesBondMovie", "", "charge", "laptopForSale");
        ArrayList<String> actual = test.camelCase(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed2() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("empty", "upDAtE NOw", "How MAny CAts do yOU haVe", "the SOund bAr is LOUD");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("empty", "updateNow", "howManyCatsDoYouHave", "theSoundBarIsLoud");
        ArrayList<String> actual = test.camelCase(input);

        Assert.assertEquals(expected,actual);

    }
}
