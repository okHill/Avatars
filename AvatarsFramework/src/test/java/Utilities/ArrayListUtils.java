package Utilities;

import Objects.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListUtils {

    public static ArrayList<Integer> arrayToArrayList (int ... arr) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int num: arr) {
            list.add(num);
        }

        return list;

    }

    public static ArrayList<Double> arrayToArrayList (double ... arr) {

        ArrayList<Double> list = new ArrayList<>();

        for(double num: arr) {
            list.add(num);
        }

        return list;

    }

    public static ArrayList<Person> arrayToArrayList (Person... arr) {

        ArrayList<Person> list = new ArrayList<>(Arrays.asList(arr));

        return list;

    }

    public static ArrayList<String> arrayToArrayList (String ... arr) {

        ArrayList<String> list = new ArrayList<>();

        for(String word: arr) {
            list.add(word);
        }

        return list;

    }

    public static ArrayList<String> arrayToArrayList (String str) {

        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i < str.length(); i++) {
            list.add(String.valueOf(str.charAt(i)));
        }

        return list;

    }





}
