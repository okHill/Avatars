package JsonPathAPI;

import apiModels.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class AttributeVerification {

    @Test


    public void checkAllTeachersDepartmentValue() {

        String path = "http://www.api.cybertektraining.com/teacher/department/Computer";

        Response response = RestAssured.get(path);

        System.out.println("Status code: " + response.statusCode());

        Assert.assertEquals("Server is down", 200, response.statusCode());
        System.out.println(response.asString());
        JsonPath jsonPath = response.jsonPath();

        int size = jsonPath.getList("teachers").size();

//        "teachers" is the name of the List in Json Response {"teachers" : [ {"teacherID": 5451, "firstName":....} ]}

        System.out.println(size);

        for (int i = 0; i < size; i++) {

            String departmentPath = "teachers[" + i + "].department";
            String firstNamePath = "teachers[" + i + "].firstName";
            String departmentName = jsonPath.getString(departmentPath);
            String firstName = jsonPath.getString(firstNamePath);
            System.out.println(i + " - " + firstName + " - " + departmentName);

            Assert.assertEquals("Department not Computer", "Computer", departmentName);

//            Assert.assertEquals("Department failed at: " + i, "Computer", departmentName);
        }
    }

}
