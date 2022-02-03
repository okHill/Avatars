package mentorings.tuesday.amazon;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseExample {

    public static void main(String[] args) {

//      Create a UTILITY class and store CONNECTION, STATEMENT, RESULTSET [see DBUtility.java]

        // url: ec2-18-219-241-100.us-east-2.compute.amazonaws.com
        // port: 1521
        // SID: xe
        // username: hr
        // password: hr

//        String url = "jdbc:oracle:thin:@yoururl:1521:xe";

//      Single line connection syntax (url : port : SID)
//      Find this syntax in ORACLE documentation

        String url = "jdbc:oracle:thin:@ec2-3-135-231-80.us-east-2.compute.amazonaws.com:1521:xe";
        String username = "hr";
        String password = "hr";

//      IQ: How do you use JDBC?        --> Answer is in the following:

        // 3 CLASSES that we need for testing database

        // CONNECTION => create connection
        // STATEMENT => write query
        // ResultSET => result will be stored => new datatype

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select first_name, last_name, salary from employees");

//           we will get information of our Resultset, like how many columns and names of the columns and so on...

            ResultSetMetaData metaData = resultSet.getMetaData();

            // we get number of columns

            int numberOfColumns = metaData.getColumnCount();
            String columnName1 = metaData.getColumnName(1);
            String columnName2 = metaData.getColumnName(2);
            String columnName3 = metaData.getColumnName(3);

            System.out.println("Index 1 Column Name: " + columnName1);
            System.out.println("Index 2 Column Name: " + columnName2);

            System.out.println("Number of Columns: "+numberOfColumns);

            List <Map<Object, Object>> data = new ArrayList<>();

            int number = 1;


            while(resultSet.next()){

                Map<Object, Object> map = new HashMap<>();

                for(int i = 1; i <= numberOfColumns; i++ ){
                    map.put(metaData.getColumnName(i), resultSet.getObject(i));
                }
                data.add(map);
            }

            // print row 4, first and last name : expected : Alexander, Hunold

            System.out.println("Connection successful!");


            connection.close();
            statement.close();
            resultSet.close();

            for(Map<Object, Object> map: data){
                System.out.println(map);
            }

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Connection failed!");
        }


    }
}
