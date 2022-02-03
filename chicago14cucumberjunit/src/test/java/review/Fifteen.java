package review;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fifteen {

    public static void main(String[] args) {

        Map<String, Integer> maps = new HashMap<>();

        // .put() method
        maps.put("Age", 25);
        maps.put("Houses", 2);
        maps.put("Kids", 4);

        // .get() method
        System.out.println(maps.get("Kids"));

        // .remove() method
        //System.out.println(maps.remove("Houses"));
       // System.out.println(maps.get("Houses"));

        // .keySet() method: It returns multiple keys
        System.out.println();
        System.out.println("This is KEYSET");
        System.out.println("Print every single key and value");

        Set<String> keys = maps.keySet();

        for(String map : keys) {

            System.out.println(map);            // print every key
            System.out.println(maps.get(map));  // print every value

        }

    }
}
