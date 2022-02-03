package JsonPathAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class MyAPI {

    @Test
    public void getTeachersList() {

        // 1. Hit API
        // HTTP method, EndPoint, Body, Header
        // This is hardcoded path

        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/1807");

        System.out.println(response.statusCode());
        System.out.println(response.asString());

        JsonPath jp = response.jsonPath();

        String firstName = jp.get("teachers[0].firstName");
        System.out.println(firstName);

        Assert.assertTrue(firstName != null);

        // putting keywords into ArrayList is dynamic

        // jp.getList()
    }

    @Test

    public void allTeachersAttributeVerification() {

        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/all");

        Assert.assertEquals("API server down", 200, response.statusCode());

        System.out.println(response.asString());

        JsonPath jp = response.jsonPath();

        int size = jp.getList("teachers").size();
        System.out.println(size);

        // teachers[index_number here].firstName;

        for(int i = 0; i< size; i++) {
            /*String path = "teachers[" + i + "].firstName";
            String name = jp.get(path);
            System.out.println(name);*/

            String pathName = "teachers[" + i + "].firstName";
            String pathEmail = "teachers[" + i + "].emailAddress";
            String name = jp.get(pathName);
            String email = jp.get(pathEmail);
            System.out.println(pathName);
            System.out.println(pathEmail);

            Assert.assertTrue((name != null));
            Assert.assertTrue((email != null));
        }
    }
}
