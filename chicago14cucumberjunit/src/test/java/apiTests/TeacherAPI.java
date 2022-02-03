package apiTests;

import apiModels.ResponseBody;
import apiModels.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import utilities.Config;

/*@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)*/

public class TeacherAPI {

    @Test
    public void departmentNameVerification() {

        // 03-15-2020; 20:50 -> TeacherAPI.class
        // GET API

        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/department/Computer");

        System.out.println(response.statusCode());

        Assert.assertEquals("Server is down", 200, response.statusCode());

        System.out.println(response.asString());

        JsonPath jp  = response.jsonPath();

        int size = jp.getList("teachers").size();

//        "teachers" is the name of the List in Json Response {"teachers" : [ {"teacherID": 5451, "firstName":....} ]}


        System.out.println(size);

        for(int i = 0; i < size; i++) {

            String pathDepartment = "teachers[" + i + "].department";
            String department = jp.getString(pathDepartment);
//          System.out.println(department);
            Assert.assertEquals("Department failed at: " + i, "Computer", department);
//          Assert.assertTrue(department.equalsIgnoreCase("Computer"));

//          *** From QA perspective, how to we know that all the teachers in the Computer department are listed?
//          *** This approach is not bad for small scale testing; yet, it's not scalable for big projects
//              * Hard-coded parts do not allow it to be scalable
//          *** Use POJO instead
        }
    }

    @Test
    public void emailValidationTeacherAPI() throws Exception {

// GET API

//      path: base URL + Resources

        Response response = RestAssured.get(Config.getProperty("baseURL") + "/teacher/all");


        System.out.println(response.statusCode());
        System.out.println(response.asString());

        Assert.assertEquals("List of teachers API has failed!", 200, response.statusCode());
//      Attribute verification. This scenario is about data (value) validation,

        ObjectMapper objectMapper = new ObjectMapper();

        ResponseBody rb = objectMapper.readValue(response.asString(), ResponseBody.class);

        System.out.println(rb.getTeachers().size());
        int count = 0;
        for(int i = 0; i < rb.getTeachers().size(); i++) {

            String email = rb.getTeachers().get(i).getEmailAddress();
            if(email.contains("@") && email.contains(".")) {
                continue;
            }
            count++;
            System.out.println(count + ": (" + i + ") " + email);
        }

    }

    @Test
    public void createTeacherTest() throws Exception {

        // POST API
        Teacher teacher = new Teacher();

        teacher.setPremanentAddress("123 Main St");
        teacher.setSection("whatever");
        teacher.setSubject("Swimming");
        teacher.setPhone("8009000000");
        teacher.setBatch(14);
        teacher.setBirthDate("01/01/1990");
        teacher.setDepartment("Maths");
        teacher.setGender("Male");
        teacher.setPassword("JbJb2020");
        teacher.setFirstName("Rahul");
        teacher.setLastName("Bond");
        teacher.setEmailAddress("jb2020@gmail.com");
        teacher.setJoinDate("01/01/2020");
        teacher.setSalary(5000);

        int teacherId;


        ObjectMapper objectMapper = new ObjectMapper();
        String teacherJSON = objectMapper.writeValueAsString(teacher);
        System.out.println(teacherJSON);

        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(teacherJSON).when().post("http://api.cybertektraining.com/teacher/create");

        System.out.println(response.statusCode());
        System.out.println(response.asString());

    }

    @Test
    public void updateTeacherTest() throws Exception {

        // POST API

        Teacher teacher = new Teacher();

        teacher.setEmailAddress("jb2020@gmail.com");
        teacher.setFirstName("Pele");
        teacher.setLastName("theKing");
        teacher.setPhone("8009000000");
        teacher.setGender("M");
        teacher.setJoinDate("01/01/2020");
        teacher.setSalary(5000);
        teacher.setBatch(14);
        teacher.setSection("whatever");
        teacher.setSubject("Swimming");
        teacher.setDepartment("Sports");
        teacher.setBirthDate("01/01/1990");
        teacher.setPassword("JbJb2020");
        teacher.setPremanentAddress("123 Main St");

        teacher.setTeacherId(5742);

        ObjectMapper objectMapper = new ObjectMapper();
        String teacherJSON = objectMapper.writeValueAsString(teacher);
        System.out.println(teacherJSON);

        Response response = RestAssured.given().contentType(ContentType.JSON).body(teacherJSON).
                put(Config.getProperty("baseURL") + "/teacher/update");

        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test

    public void teachersEmailValidation () throws JsonProcessingException {

        Response response = RestAssured.get(Config.getProperty("baseURL") + "/teacher/all");

        System.out.println(response.statusCode());
        System.out.println(response.asString());

//        We have response now as JSON
//        We want to convert it and map it into JAVA OBJECT
//        that I created before: ResponseBody.java


        ObjectMapper objectMapper = new ObjectMapper();

        ResponseBody responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);

        int size = responseBody.getTeachers().size();
        System.out.println("Total emails : " + size);
        int count = 0;

            for (int i = 0; i < size; i++) {

                String email = responseBody.getTeachers().get(i).getEmailAddress();
                if (email.contains("@") && email.contains(".")) {

                    continue;
                }
                count++;

                String firstName = responseBody.getTeachers().get(i).getFirstName();
                System.out.println(count + "/" + i + " Name: " + firstName + " - " + email);
            }
        System.out.println("Invalid emails : " + count);

    }

    @Test

    public void weatherTest() throws JsonProcessingException {

        String path = "https://weather.com/swagger-docs/sun/v2/turboCurrentsonDemand";

        Response response = RestAssured.get(path);

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(response.statusCode());

        ResponseBody responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);

        String weather = response.getHeaders().getValue("swagger");
        System.out.println(weather);
    }
}
