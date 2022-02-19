package ArrayListDayOne_Tests;

import ArrayList.ArrayListDayOne;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class UpperOrLowerTests {

    private ArrayListDayOne test = new ArrayListDayOne();

    @Test
    public void emptyTrue() {
        String str = "";
        boolean bool = true;

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual  = test.getUpperOrLowerCase(str, bool);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void emptyFalse() {
        String str = "";
        boolean bool = false;

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual  = test.getUpperOrLowerCase(str, bool);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixedTrue() {
        String str = "tRyTHiseXAMplEfORtheTeSt";
        boolean bool = true;

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("RTHXAMEORTS");
        ArrayList<String> actual  = test.getUpperOrLowerCase(str, bool);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixedFalse() {
        String str = "tRyTHiseXAMplEfORtheTeSt";
        boolean bool = false;

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("tyiseplftheet");
        ArrayList<String> actual  = test.getUpperOrLowerCase(str, bool);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allUpTrue() {
        String str = "ALLUPPERCASE";
        boolean bool = true;

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList(str);
        ArrayList<String> actual  = test.getUpperOrLowerCase(str, bool);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allUpFalse() {
        String str = "ALLUPPERCASE";
        boolean bool = false;

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual  = test.getUpperOrLowerCase(str, bool);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allLowTrue() {
        String str = "alllowercase";
        boolean bool = true;

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual  = test.getUpperOrLowerCase(str, bool);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allLowFalse() {
        String str = "alllowercase";
        boolean bool = false;

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList(str);
        ArrayList<String> actual  = test.getUpperOrLowerCase(str, bool);

        Assert.assertEquals(expected,actual);

    }






}
