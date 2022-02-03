package mentorings.tuesday.amazon;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseExample2 {

    public static void main(String[] args) {


        String url = "jdbc:oracle:thin:@ec2-3-135-231-80.us-east-2.compute.amazonaws.com:1521:xe";
//        put URL in properties file - see Database Utility Class DBUtility
        String username = "hr";
        String password = "hr";

        // CONNECTION
        // STATEMENT
        // ResultSET

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
/*          ResultSet resultSet = statement.executeQuery("select * from employees");

            resultSet.next();  // moves the cursor to the row 1
            resultSet.next();  // moves the cursor to the next row, 2
            resultSet.next();  // moves the cursor to the next row, 3
            resultSet.next();  // moves the cursor to the next row, 4

            // print row 4, first and last name : expected : Alexander, Hunold

            System.out.println("Index 4, Column 2: " + resultSet.getObject(2));  // Alexander
            System.out.println("Index 4, Column 3: " + resultSet.getObject(3));  // Hunold
*/
//          Instead, loop through with WHILE LOOP

            ResultSet resultSet = statement.executeQuery("select first_name, last_name, salary from employees");

//          Getting extra data

            ResultSetMetaData metaData = resultSet.getMetaData();

            int numOfColumns = metaData.getColumnCount();
            System.out.println("Number of columns: " + numOfColumns );

            String columnName1 = metaData.getColumnName(1);
            String columnName2 = metaData.getColumnName(2);
            String columnName3 = metaData.getColumnName(3);

            System.out.println("Index 1 Column Name: " + columnName1);
            System.out.println("Index 2 Column Name: " + columnName2);
            System.out.println("Number of columns : " + numOfColumns);

//            System.out.println(columnName1 + " | " + columnName2 + " | " + columnName3);

//          Now, lets store them in maps

            List<Map<Object, Object>> data = new ArrayList<>();

            int number = 1;

            while (resultSet.next()) {

//                Map<Object, Object> map = new HashMap<>();

//                System.out.println(number + " - First name: " + resultSet.getObject(1) + " - " +
//                        " Last name: " + resultSet.getObject(2));

//          Make them objects

/*              String value1 = (String)resultSet.getObject(1);     // 03/01/2020: 1:52
                String value2 = (String)resultSet.getObject(2);
                System.out.println(number + " - First name: " +  value1 + " - Last name: " +
                        value2);
                        number++;
*/
//          Once we get number of Columns, we can get rows and columns dynamically

                for (int i = 1; i <= numOfColumns; i++) {

//                    map.put(metaData.getColumnName(i), resultSet.getObject(i));


                    System.out.print(metaData.getColumnName(i)+": " + resultSet.getObject(i)+" ");
                }

//                data.add(map);
                System.out.println();

            }

            System.out.println("Connection successful!");


            connection.close();
            statement.close();
            resultSet.close();

            for (Map<Object, Object> map : data) {
                System.out.println(map);
            }

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Connection failed!");
        }


    }
}
