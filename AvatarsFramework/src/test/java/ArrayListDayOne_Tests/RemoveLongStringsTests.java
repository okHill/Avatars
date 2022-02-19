package ArrayListDayOne_Tests;

import ArrayList.ArrayListDayOne;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RemoveLongStringsTests {


    private ArrayListDayOne test = new ArrayListDayOne();

    @Test
    public void emptyList() {

        ArrayList <String> input = new ArrayList<>();

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual  = test.removeLongStrings(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void allFour() {

        ArrayList <String> input = ArrayListUtils.arrayToArrayList("four", "word", "hats", "jump", "duck", "bowl");

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual  = test.removeLongStrings(input);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void halfFour() {

        ArrayList <String> input = ArrayListUtils.arrayToArrayList("four", "hat", "house", "jumping", "sing", "beach", "", "verb", "kings");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("hat", "");
        ArrayList<String> actual  = test.removeLongStrings(input);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void halfFour2() {

        ArrayList <String> input = ArrayListUtils.arrayToArrayList("pro", "kevin", "fan", "pencil", "bottle", "cat", "mother");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("pro", "fan", "cat");
        ArrayList<String> actual  = test.removeLongStrings(input);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void halfFour3() {

        ArrayList <String> input = ArrayListUtils.arrayToArrayList("slime", "blanket", "water", "yawning", "yes", "mother");

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList(new String [] {"yes"});
        ArrayList<String> actual  = test.removeLongStrings(input);

        Assert.assertEquals(expected, actual);

    }




}
