package step_definitions.cybertekTraining_steps;

import apiModels.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.it.Ma;
import org.apache.poi.util.IntegerField;
import org.junit.Assert;
import pages.cybertekTraining_pages.CBTHomePage;
import utilities.APIUtil;
import utilities.Config;

import java.util.List;
import java.util.Map;

public class StudentsListAPI {

    CBTHomePage cbtHomePage = new CBTHomePage();

    @Given("user get student at {string}")
    public void user_get_student_at(String resource) {

        APIUtil.hitGET(resource);

    }

    @Given("user validates data from response bu {string}")
    public void user_validates_data_from_response_bu(String batchID) {

        for (Student student : APIUtil.getResponseBody().getStudents()) {

//            batchID number comes as a String
            String batchIDActual = student.getBatch() + "";
            Assert.assertEquals("Student batchID failed", batchID, batchIDActual);
        }
    }


    @Given("user deletes student with {string}")
    public void user_deletes_student_with(String resource) {
        APIUtil.hitDelete(resource);

    }

    @Then("user searches for student with {string}")
    public void user_searches_for_student_with(String studentID) throws InterruptedException {
        cbtHomePage.studentsDropdown.click();
        cbtHomePage.allStudentsLink.click();
        Thread.sleep(500);
        cbtHomePage.searchStudentbyID.sendKeys(studentID);
        cbtHomePage.searchBtn.click();
    }

    @Then("user verifies that no result is shown")
    public void user_verifies_that_no_result_is_shown() {

        Assert.assertEquals("Deleting student failed", 0,
                cbtHomePage.searchResultsName.size());

    }


    @Given("user creates student with the following data {string}")
    public void user_creates_student_with_the_following_data(String resource, io.cucumber.
            datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        RequestBody student = new RequestBody();

        student.setFirstName(data.get("firstName"));
        student.setLastName(data.get("lastName"));
        student.setMajor(data.get("major"));
        student.setSubject(data.get("subject"));
        student.setAdmissionNo(data.get("admissionNo"));
        student.setBatch(Integer.parseInt(data.get("batch")));
        student.setGender(data.get("gender"));
        student.setBirthDate(data.get("birthDate"));
        student.setJoinDate(data.get("joinDate"));
        student.setPassword(data.get("password"));
        student.setSection(data.get("section"));

        Contact contact = new Contact();
        contact.setPhone("phone");
        contact.setEmailAddress(data.get("emailAddress"));
        contact.setPremanentAddress(data.get("premanentAddress"));

        Company company = new Company();
        company.setCompanyName(data.get("companyName"));
        company.setStartDate("startDate");
        company.setTitle("title");

        Address address = new Address();
        address.setStreet(data.get("street"));
        address.setCity(data.get("city"));
        address.setState(data.get("state"));
        address.setZipCode(Integer.parseInt(data.get("zipCode")));

        company.setAddress(address);

        student.setContact(contact);
        student.setCompany(company);


        APIUtil.hitPost(resource, student);

    }


    @Then("user searches for student with newly created student ID")
    public void user_searches_for_student_with_newly_created_student_ID() throws InterruptedException {
        cbtHomePage.studentsDropdown.click();
        cbtHomePage.allStudentsLink.click();
        Thread.sleep(500);
        String studentID = APIUtil.getResponseBody().getStudentID() + "";
        cbtHomePage.searchStudentbyID.sendKeys(studentID);
        cbtHomePage.searchBtn.click();
    }

    @Then("user verifies that student created")
    public void user_verifies_that_student_created() {
        Assert.assertEquals("Student creation failed!", 1,
                cbtHomePage.searchResultsName.size());
        String name = cbtHomePage.searchResultsName.get(0).getText();
        System.out.println(name);
    }


}
