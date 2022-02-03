package apiTests;

import apiModels.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class StudentTest {

    @Test

    public void student() throws Exception {

        Company company = new Company();

        company.setCompanyName("Cybertek");
        company.setStartDate("01/01/2020");
        company.setTitle("SDET");
        Address address = new Address();
        address.setCity("Chicago");
        address.setStreet("123 Main St");
        address.setZipCode(9900990);
        company.setAddress(address);

        Contact contact = new Contact();
        contact.setEmailAddress("mjordan@email.com");
        contact.setPhone("8001234567");


        Student student = new Student();
        student.setFirstName("Michael");
        student.setLastName("Jordan");
        student.setBatch(14);
        student.setSection("QA");
        student.setContact(contact);
        student.setCompany(company);

        ObjectMapper objectMapper = new ObjectMapper();
        String studentInJsonFormat = objectMapper.writeValueAsString(student);

        System.out.println(studentInJsonFormat);

    }

    @Test

    public void jobFoundTest() throws Exception {

        Response response = RestAssured.get("http://api.cybertektraining.com/student/all");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);

        int counter = 0;

        for (Student student : responseBody.getStudents()) {
//              find students who joined in 2020
            if (student.getCompany().getStartDate().endsWith("2020")){
                System.out.println(student.getFirstName());
                counter++;
            }

        }
        System.out.println("\nCount: " + counter);
    }

    @Test
    public void studentGet() throws Exception {
//      1. get() returns a response OBJECT

        Response response = RestAssured.get("http://api.cybertektraining.com/student/20201");
        Response responseAll = RestAssured.get("http://api.cybertektraining.com/student/all");
//      2. we catch it as String

        System.out.println(response.asString());
        System.out.println(responseAll.asString());

//      3. and convert it into any other data type using POJO

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody rb = objectMapper.readValue(response.asString(), ResponseBody.class);
        ResponseBody rbAll = objectMapper.readValue(responseAll.asString(), ResponseBody.class);

//      4. we are now able to extract data from what we received

        String fName = rb.getStudents().get(0).getFirstName();
        String firstName = rbAll.getStudents().get(1).getFirstName();
        System.out.println(fName);
        System.out.println(firstName);

    }

    @Test
    public void studentGetAll() throws Exception {
//      1. get() returns a response OBJECT

        Response responseAll = RestAssured.get("http://api.cybertektraining.com/student/all");

//      2. we catch it as String

        System.out.println(responseAll.asString());

//      3. and convert it into any other data type using POJO

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody rbAll = objectMapper.readValue(responseAll.asString(), ResponseBody.class);

//      4. we are now able to extract data from what we received

        int numberOfStudents = rbAll.getStudents().size();
        System.out.println("Number of Students: " + numberOfStudents);
        String firstName = rbAll.getStudents().get(numberOfStudents-1).getFirstName();
        int studentId = rbAll.getStudents().get(numberOfStudents-1).getStudentId();
        System.out.println("First name of the Student " + studentId + " is " + firstName);

    }
}
