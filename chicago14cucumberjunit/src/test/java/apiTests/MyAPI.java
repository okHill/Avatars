package apiTests;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.junit.Assert;
import org.junit.Test;

public class MyAPI {

    @Test
    public void getTeachersList() {

        // Step 1. Hit API
        // HTTP method, Endpoint, Body, Header
        // RestAssured will return response
        // So, we need to catch it with Response
        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/all");

        // response will give us status code; print it out as a string:

        System.out.println(response.statusCode());
        //System.out.println(response.asString());

        // Step 2. make sure that attributes are there
        // Copy the response body from console
        // Read it with JSON viewer
        // there are two ways to select the data we want:
            // 1. JSON path
            // 2. POJO model

        JsonPath jp = response.jsonPath();
        String firstName = jp.get("teachers[0].firstName");
        System.out.println(firstName);


        Assert.assertTrue(firstName !=null);
    }

    // TASK: Automate all teachers and make sure that firstName and email
    // is coming in the response without failure.

    @Test

    public void allTeachersAttributeVerification() {

        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/all");

//      System.out.println(response.statusCode());
        Assert.assertEquals("API Server down", 200, response.statusCode());
        System.out.println(response.asString());

        JsonPath jp = response.jsonPath();

//      get the teachers list, and automate the changing part in attributes:
//      Like: x.teachers[2].firstName (index number is changing)
//      For this, we need to know the size of the list

        int size = jp.getList("teachers").size();

//        "teachers" is the name of the List in Json Response {"teachers" : [ {"teacherID": 5451, "firstName":....} ]}

        System.out.println(size);

        // teachers[0].firstName

        for(int i = 0; i < size; i++) {
            String pathName = "teachers[" + i + "].firstName";
            String pathEmail = "teachers[" + i + "].emailAddress";
            String name = jp.get(pathName);
            String email = jp.get(pathEmail);
//            System.out.println(name);
//            System.out.println(email);

        Assert.assertTrue(name != null);
        Assert.assertTrue(email != null);

//          	* If assertion fails, how to troubleshoot?
//      Print out the i. It will print the one that fails
        }
    }


}
