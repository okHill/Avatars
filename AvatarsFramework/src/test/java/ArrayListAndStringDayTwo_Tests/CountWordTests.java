package ArrayListAndStringDayTwo_Tests;

import ArrayList.ArrayListAndStringDayTwo;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CountWordTests {

    private ArrayListAndStringDayTwo test = new ArrayListAndStringDayTwo();

    @Test
    public void emptyList() {

        ArrayList<String> input = new ArrayList<>();
        String target = "";

        int expected  = 0;
        int actual  = test.countWord(input, target);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void targetWord() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("garden", "home", "door", "bed", "home", "mat", "bathroom", "home", "tv");
        String target = "home";

        int expected  = 3;
        int actual  = test.countWord(input, target);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void targetWord2() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("lemon", "lime", "onion", "lemon", "garlic", "food", "apple");
        String target = "lemon";

        int expected  = 2;
        int actual  = test.countWord(input, target);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void emptyTarget() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("garden", "", "door", "bed", "", "home", "mat", "", "home", "tv", "");
        String target = "";

        int expected  = 4;
        int actual  = test.countWord(input, target);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void noTarget() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("lemon", "lime", "onion", "lemon", "garlic", "food", "apple");
        String target = "juice";

        int expected  = 0;
        int actual  = test.countWord(input, target);

        Assert.assertEquals(expected,actual);

    }


}
