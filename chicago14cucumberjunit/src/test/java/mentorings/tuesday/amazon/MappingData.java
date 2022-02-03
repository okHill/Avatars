package mentorings.tuesday.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappingData {

    /**
     * | First_Name | Last_Name | Job_id |
     * | John       | Wick      | Fighter|      // Index 0
     * | Alica      | Smith     | Coder  |      // Index 1
     * | Nancy      | Johnson   | teacher|      // Index 2
     * */

    public static void main(String[] args) {

        Map<String, String> map1 = new HashMap<>();
        map1.put("First_Name", "John");
        map1.put("Last_Name", "Wick");
        map1.put("Job_id", "Fighter");

//        map1.get("First_Name"); // => john

        Map<String, String> map2 = new HashMap<>();
        map2.put("First_Name", "Alica");
        map2.put("Last_Name", "Smith");
        map2.put("Job_id", "Coder");



        Map<String, String> map3 = new HashMap<>();
        map3.put("First_Name", "Nancy");
        map3.put("Last_Name", "Johnson");
        map3.put("Job_id", "teacher");

        List<Map<String, String>> data = new ArrayList<>();
        data.add(map1);
        data.add(map2);
        data.add(map3);

        // data => all the data

        System.out.println(data.get(1).get("First_name"));
        System.out.println(data.get(1).get("Last_Name"));
        System.out.println(data.get(1).get("Job_id"));          // Row: index 1, Column: job_id --> coder
//        data.get(1).get("Job_id");

        System.out.println(data.get(1));

    }

}
