package apiTests;

import apiModels.RequestBody;
import apiModels.ResponseBody;
import apiModels.Student;
import apiModels.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.APIUtil;
import utilities.Config;

public class UtilTesting {

    // Get one teacher and make attribute testing
    // resource is /teacher/id

    @Test
    public void teacherTesting() {

        String resource = "/teacher/{id}"; // this part will probably come from Scenario outline

//      You can use for all get methods
//      String resource = "/teacher/all";

        APIUtil.hitGET(resource);

        System.out.println(APIUtil.getResponseBody().getTeachers().get(0).getFirstName());

            // by Assertion, we can make actual testing here
    }

    @Test
    public void allTeachersTest() {

        APIUtil.hitGET("/teacher/all");

        for(Teacher t : APIUtil.getResponseBody().getTeachers()) {
            if(t.getGender().equalsIgnoreCase("female")) {
                System.out.println(t.getFirstName());
            }
        }
    }

    @Test
    public void studentBatchTest() {
        APIUtil.hitGET("/teacher/9804");

        int index = 0;
        for(Student s : APIUtil.getResponseBody().getStudents()){
            if(s.getBatch() >= 7 && s.getBatch() <=14) {
                index++;
                continue;
            }
//            System.out.println(s.getFirstName() + " : " + s.getBatch());

//          It failed. There were batches other than specified here
//          So, use assertion and counter to report

            Assert.fail("Student Batch Test failed at: " + index);

        }
    }

    @Test

    public void postTesting() {
/*
        Teacher teacher = new Teacher();
        teacher.setDepartment("Sports");
*/
//  We cannot use these classes for request.
//  It should be dynamic. Use a generic class instead

//        RequestBody requestBody = new RequestBody();

//        Change the name to teacher from requestBody.

//        This class is empty. Nothing happens yet when wew say requestBody.set
//        It does not all instance variables yet.
//        Copy-paste instance variables from Teacher model class.

        RequestBody teacher = new RequestBody();

//      Now, set all the information in the requirements

        teacher.setPremanentAddress("123 Main St");
        teacher.setSection("whatever");
        teacher.setSubject("Swimming");
        teacher.setPhone("8009000000");
        teacher.setBatch(14);
        teacher.setBirthDate("01/01/1990");
        teacher.setDepartment("Sports");
        teacher.setGender("Male");
        teacher.setPassword("JbJb2020");
        teacher.setFirstName("Laurel");
        teacher.setLastName("Hardy");
        teacher.setEmailAddress("jb2020@gmail.com");
        teacher.setJoinDate("01/01/2020");
        teacher.setSalary(5000);
        int teacherId;

        APIUtil.hitPost("/teacher/create", teacher);

    }

    @Test

    public void deleteTesting() {

        String resource = "/teacher/delete/10661";

        APIUtil.hitDelete(resource);
        APIUtil.responseBodies[0].getTeachers();

    }

    @Test

    public void updateTesting() {

        String resource = "/teacher/update";

        RequestBody requestBody = new RequestBody();

        requestBody.setTeacherId(10661);
        requestBody.setEmailAddress("new@gmail.com");
        requestBody.setFirstName("Tim");
        requestBody.setLastName("Ronaldo");
        requestBody.setJoinDate("01/02/2003");
        requestBody.setSalary(50000);
        requestBody.setBatch(14);
        requestBody.setBirthDate("01/01/1980");
        requestBody.setGender("Male");
        requestBody.setPassword("jd1234");
        requestBody.setPhone("1235790101");
        requestBody.setPremanentAddress("123 Main St.");
        requestBody.setSection("Science");
        requestBody.setDepartment("Sports");
        requestBody.setSubject("Coding");

        APIUtil.hitPUT(resource, requestBody);

    }

    @Test

    public void authentification() {

//        Basic authentication
//        username: cbt1; pass: admin2020

        Response response = RestAssured.given().header("cbt1", "admin2020").get("http://api.cybertektraining.com/teachers/all");
        System.out.println(response.asString());
    }

    @Test

    public void teacherDeleteAndGetTEst() {

            String resourceForDelete = "/teacher/delete/10664";

            APIUtil.hitDelete(resourceForDelete);

            String resourceForGet = "/teacher/10664";
            APIUtil.hitGET(resourceForGet);

//            I commented out Assertion in the hitGet() API in APIUtil.

            String message = APIUtil.getResponseBody().getMessage();
            System.out.println(message);

    }

    @Test

    public void hitDeletNegative() {

        String resource = "/teacher/delete/9999";
        APIUtil.hitDelete(resource);

        String message = APIUtil.getResponseBody().getMessage();
        System.out.println(message);

        String expectedMessage = "Teacher with id = 9999 NOT FOUND!";
        Assert.assertEquals("Delete teacher Negative scenario failed", expectedMessage, message);
    }
}
