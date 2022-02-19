package ArrayListAndStringDayThree_Tests;

import ArrayList.ArrayListAndStringDayThree;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ReverseAllTests {

    private ArrayListAndStringDayThree test = new ArrayListAndStringDayThree();

    @Test
    public void emptyList() {

        ArrayList<String> input = new ArrayList<>();

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual = test.reverseAll(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("sleep", "nice", "could", "want");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("peels", "ecin", "dluoc", "tnaw");
        ArrayList<String> actual = test.reverseAll(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed2() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("omega", "beta", "alpha", "theta");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("agemo", "ateb", "ahpla", "ateht");
        ArrayList<String> actual = test.reverseAll(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed3() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("fan", "picture", "bed", "cape", "request");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("naf", "erutcip", "deb", "epac", "tseuqer");
        ArrayList<String> actual = test.reverseAll(input);

        Assert.assertEquals(expected,actual);

    }




}
