package utilities;

import java.util.HashMap;
import java.util.Map;

public class TempStorage {

            // this is our db, kind of

    private static Map<String,String> data = new HashMap<>();

            // then, we neeD two methods: add and get
            // public bec. we don't want to create an object,
            // also, we want to access it from anywhere

    public static void addData(String key, String value) { data.put(key,value); }

    public static String getData(String key){ return data.get(key); }

            // you can add clear method if needed

    public static void clear(){ data.clear();}

    // now, go back to step-defs page and use the utility class

    // Question: don't the keys got confused if we assign them in different places for different values?
/*
        If you use keys for one scenario, you don't confuse it.
        But for more than one scenarios,
        it is possible to confuse them. So, then,
        Clear the Map.
        Scenarios run through HOOKS.
        Hooks is a concept where you can put pre and post conditions
        for each scenario. It is like before() and after() methods.
        But it is before and after scenarios.
        So, HOOKS clear each scenario before executing the next one.

        It is like:
            public class Hooks {
            @Before
            TempStorage.clear();
            }
*/

}
