package ArrayList;

import Objects.Person;

import java.util.ArrayList;

public class ArrayListAndStringDayThree {

    /**
     *  reverseAll
     *
     *  This method will take an ArrayList of Strings and
     *  reverse each element and return an ArrayList of
     *  all reversed words
     *
     * @param words - Given ArrayList of Strings
     * @return - ArrayList of Strings
     *
     */

    public ArrayList<String> reverseAll(ArrayList<String> words) {



        return null;
    }

    /*
    ---------------------------------------------------------------------------------------
     */

    /**
     *  secondBiggestNumber
     *
     *  This method takes an ArrayList of numbers and will find the
     *  second biggest number and return that number. The biggest and
     *  the second biggest number should not be the same.
     *
     *  If you are unable to give a valid number return 0
     *
     * @param nums - Given ArrayList of numbers
     * @return - Second biggest number
     *
     */


    public int secondBiggestNumber (ArrayList <Integer> nums) {



        return 0;
    }



    /*
    ---------------------------------------------------------------------------------------
     */

    /**
     *  sumAllNumbers
     *
     *  This method will give an ArrayList of numbers given in the format of a whole String.
     *  Take each character in the String elements as single digit numbers and add the numbers
     *  from each element and put store them into an ArrayList of numbers.
     *
     *  Ex: input: {"123,"421"};
     *
     *      output: {6, 7}
     *
     * @param numbers - Given ArrayList of numbers as Strings
     * @return - ArrayList of each element sum values
     *
     */


    public ArrayList<Integer> sumAllNumbers (ArrayList<String> numbers) {




        return null;
    }


    /*
    ---------------------------------------------------------------------------------------
     */

    /**
     *  camelCase
     *
     *  This method will accept an ArrayList of words. Each element may
     *  be multiple words (while will be separated by a space, if that
     *  is the case make sure the element is altered to follow camel case
     *  rules. The camel case words should be added to a new ArrayList.
     *  Each character in your word should be lowercase except the
     *  first letter of each new word after the first word.
     *
     * @param words - Given ArrayList of words
     * @return - ArrayList of all camel case words
     *
     */

    public ArrayList<String> camelCase(ArrayList<String> words ) {




        return null;
    }



    /*
    ---------------------------------------------------------------------------------------
     */

    /**
     *  calculateTax
     *
     *  This method will calculate tax amounts needed to be paid for each item.
     *  Return an ArrayList with all the tax amounts for each given prices based
     *  on the given rate
     *
     *      Income / Rates
     *
     *  |   <= 1000    |  10  |
     *  | 1001 - 2000  |  20  |
     *  | 2001 - 3000  |  30  |
     *  | >= 3001      |  40  |
     *
     *  To calculate tax: price * rate
     *
     *  Note: Rates are given as whole numbers. Example: 10% -> 0.1
     *
     * @param income - Given ArrayList of prices
     * @return - ArrayList of tax amounts
     *
     */

    public ArrayList<Double> calculateTax (ArrayList<Double> income ){




        return null;
    }

    /*
    ---------------------------------------------------------------------------------------
     */

    /**
     *  emailGenerator
     *
     *  This method will go through each Person object and create an email for each
     *  given person. Add each email to an ArrayList and return all emails at the end.
     *  The emails will follow the following format:
     *      firstName - first character
     *      lastName - first four characters if present or existing characters
     *      age - given age
     *      '@abc.com'
     *
     *      Ex: Person [ firstname = "James" | lastName = "Bond" | Age = 25 ]
     *
     *         email = JBond25@abc.com
     *
     *
     * @param people - Given ArrayList of Person objects
     * @return - ArrayList of String emails
     *
     */


    public ArrayList<String> emailGenerator (ArrayList<Person> people) {




        return  null;
    }

    /*
    ---------------------------------------------------------------------------------------
     */






}
