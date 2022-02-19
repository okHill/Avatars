package ArrayListAndStringDayThree_Tests;

import ArrayList.ArrayListAndStringDayThree;
import Utilities.ArrayListUtils;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class CalculateTaxTests {

    private ArrayListAndStringDayThree test = new ArrayListAndStringDayThree();

    @Test
    public void emptyList() {

        ArrayList<Double> input = new ArrayList<>();

        ArrayList<Double> expected  = new ArrayList<>();
        ArrayList<Double> actual = test.calculateTax(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed() {

        ArrayList<Double> input = ArrayListUtils.arrayToArrayList(300.0, 5000.0, 1500, 20);

        ArrayList<Double> expected  = ArrayListUtils.arrayToArrayList(30.0, 2000.0, 300.0, 2.0);
        ArrayList<Double> actual = test.calculateTax(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed2() {

        ArrayList<Double> input = ArrayListUtils.arrayToArrayList(1000.0, 1301.0, 12893.0, 139.0);

        ArrayList<Double> expected  = ArrayListUtils.arrayToArrayList(100.0, 260.2, 5157.2, 13.9);
        ArrayList<Double> actual = test.calculateTax(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void mixed3() {

        ArrayList<Double> input = ArrayListUtils.arrayToArrayList(3109.3, 912.5, 9193.0, 1421.4, 319.4);

        ArrayList<Double> expected  = ArrayListUtils.arrayToArrayList(1243.72, 91.25, 3677.2, 284.28, 31.94);
        ArrayList<Double> actual = test.calculateTax(input);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void bounds() {

        ArrayList<Double> input = ArrayListUtils.arrayToArrayList(999.0, 1880.0, 2900.3, 3130.0);

        ArrayList<Double> expected  = ArrayListUtils.arrayToArrayList(99.9, 376.0, 870.09, 1252.0);
        ArrayList<Double> actual = test.calculateTax(input);

        Assert.assertEquals(expected,actual);

    }


}
