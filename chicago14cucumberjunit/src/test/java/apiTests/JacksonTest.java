package apiTests;

import apiModels.ResponseBody;
import apiModels.Subject;
import apiModels.Teacher;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class JacksonTest {

    @Test
    public void jackson() throws Exception {

        Teacher teacher = new Teacher();

        teacher.setFirstName("Jenn");
//        teacher.setLastName("Law");
        teacher.setEmailAddress("jlw@email.com");
        teacher.setJoinDate("03/15/2020");
        teacher.setSalary(10000);

        Subject subject = new Subject();

        subject.setBatch(14);
        subject.setName("Automation");
        subject.setYear(2020);

//        teacher.setSubject(subject);
//      * This is not in JSON format right now:
//      * We need to CONVERT it so that it can work through API
//      * Jackson Library is needed for conversion
        ObjectMapper objectMapper = new ObjectMapper();

//      * Now, convert teacher into JSON

        String teacherInJSONFormat = objectMapper.writeValueAsString(teacher);
//      * Code writeValueAsString() complains; throw Exception

        System.out.println(teacherInJSONFormat);

    }




}
