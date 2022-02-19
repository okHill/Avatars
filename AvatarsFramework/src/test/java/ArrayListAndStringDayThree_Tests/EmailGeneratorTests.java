package ArrayListAndStringDayThree_Tests;

import ArrayList.ArrayListAndStringDayThree;
import Objects.Person;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class EmailGeneratorTests {

    private ArrayListAndStringDayThree test = new ArrayListAndStringDayThree();

    @Test
    public void emptyList() {

        ArrayList<Person> input = new ArrayList<>();

        ArrayList<String> expected  = new ArrayList<>();
        ArrayList<String> actual = test.emailGenerator(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed() {

        ArrayList<Person> input = ArrayListUtils.arrayToArrayList(new Person("James","Bond", 30), new Person("Adam", "Justice", 25), new Person("Jamie", "Sanders", 19));

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("JBond30@abc.com", "AJust25@abc.com", "JSand19@abc.com");
        ArrayList<String> actual = test.emailGenerator(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed2() {

        ArrayList<Person> input = ArrayListUtils.arrayToArrayList(new Person("Ben","Joe", 24), new Person("Eli", "Perez", 25), new Person("Ricky", "Lampson", 8));

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("BJoe24@abc.com", "EPere25@abc.com", "RLamp8@abc.com");
        ArrayList<String> actual = test.emailGenerator(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed3() {

        ArrayList<Person> input = ArrayListUtils.arrayToArrayList(new Person("Andrew","Kevins", 25), new Person("Ryan", "Monroe", 27), new Person("Sam", "Meleki", 35));

        ArrayList<String> expected  = ArrayListUtils.arrayToArrayList("AKevi25@abc.com", "RMone27@abc.com", "SMele35@abc.com");
        ArrayList<String> actual = test.emailGenerator(input);

        Assert.assertEquals(expected,actual);

    }


}
