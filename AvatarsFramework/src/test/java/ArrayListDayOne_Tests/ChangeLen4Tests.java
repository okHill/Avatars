package ArrayListDayOne_Tests;

import ArrayList.ArrayListDayOne;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ChangeLen4Tests {

    private ArrayListDayOne test = new ArrayListDayOne();

    @Test
    public void emptyList() {

        ArrayList<String> input = new ArrayList<>();

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual  = test.changeLen4(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allFour() {

        ArrayList <String> input = ArrayListUtils.arrayToArrayList("four", "word", "hats", "jump", "duck", "bowl");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("****", "****","****","****","****","****");
        ArrayList<String> actual  = test.changeLen4(input);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void halfFour() {

        ArrayList <String> input = ArrayListUtils.arrayToArrayList("four", "hat", "house", "jumping", "sing", "beach", "", "verb", "king");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("****", "hat", "house", "jumping", "****", "beach", "", "****", "****");
        ArrayList<String> actual  = test.changeLen4(input);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void noFour() {

        ArrayList <String> input = ArrayListUtils.arrayToArrayList("slime", "blanket", "water", "yawning", "yes", "mother");

        ArrayList<String> expected  = input;
        ArrayList<String> actual  = test.changeLen4(input);

        Assert.assertEquals(expected, actual);

    }


}
