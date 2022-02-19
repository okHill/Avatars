package ArrayListAndStringDayTwo_Tests;

import ArrayList.ArrayListAndStringDayTwo;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CountLettersTests {

    private ArrayListAndStringDayTwo test = new ArrayListAndStringDayTwo();

    @Test
    public void emptyList() {

        ArrayList<String> input = new ArrayList<>();
        char letter = 'a';

        int expected  = 0;
        int actual  = test.countLetters(input, letter);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void targetLetter() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("the", "king", "traveled", "through", "his", "land");
        char letter = 't';

        int expected  = 3;
        int actual  = test.countLetters(input, letter);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void targetLetter2() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("the", "new", "process", "has", "taken", "a" , "long", "time", "to", "change");
        char letter = 'a';

        int expected  = 4;
        int actual  = test.countLetters(input, letter);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void targetLetter3() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("the", "new", "process", "has", "taken", "a" , "long", "time", "to", "change");
        char letter = 'e';

        int expected  = 6;
        int actual  = test.countLetters(input, letter);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void noTarget() {

        ArrayList<String> input = ArrayListUtils.arrayToArrayList("the", "king", "traveled", "through", "his", "land");
        char letter = 'z';

        int expected  = 0;
        int actual  = test.countLetters(input, letter);

        Assert.assertEquals(expected,actual);

    }


}
