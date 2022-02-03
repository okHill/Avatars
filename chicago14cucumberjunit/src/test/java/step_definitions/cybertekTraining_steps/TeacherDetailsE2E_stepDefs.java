package step_definitions.cybertekTraining_steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.cybertekTraining_pages.CBTHomePage;
import utilities.APIUtil;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class TeacherDetailsE2E_stepDefs {

    CBTHomePage cbtHomePage = new CBTHomePage();

    @Given("User gets teacher at {string}")
    public void user_gets_teacher_at(String resource) {
        APIUtil.hitGET(resource);
    }

    @And("user goes to cybertek training application")
    public void user_goes_to_cybertek_training_application() {
        Driver.getDriver().get(Config.getProperty("cybertekTrainingURL"));

    }

    @Then("user opens teacher profile details page {string}")
    public void user_opens_teacher_profile_details_page(String teacherID) throws InterruptedException {
        cbtHomePage.teachersDropdown.click();
        cbtHomePage.allTeachersLink.click();
//        Thread.sleep(1000);
        cbtHomePage.teacherIDSearchInput.sendKeys(teacherID);
        cbtHomePage.searchBtn.click();
        cbtHomePage.avatar.click();
    }

    @And("user cross validates teacher details on API and UI")
    public void user_cross_validates_teacher_details_on_API_and_UI() {
        String apiFullName = APIUtil.getResponseBody().getTeachers().get(0).getFirstName()
                + " " + APIUtil.getResponseBody().getTeachers().get(0).getLastName();
        String uiFullName = cbtHomePage.fullName.getText();
        System.out.println("API Full Name: " + apiFullName);
        System.out.println("UI full Name: " + uiFullName);
        Assert.assertEquals("E2E Full Name verification failed!", apiFullName, uiFullName);
        Assert.assertEquals("E2E Phone Number verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getPhone().trim(), cbtHomePage.phoneNumber.getText().trim());
        Assert.assertEquals("E2E Email verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getEmailAddress().trim(), cbtHomePage.email.getText().trim());
        Assert.assertEquals("E2E Batch verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getBatch() +"".trim(), cbtHomePage.batch.getText().trim());
        Assert.assertEquals("E2E Birthday verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getBirthDate().trim(), cbtHomePage.birthday.getText().trim());
        Assert.assertEquals("E2E Join Date verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getJoinDate().trim(), cbtHomePage.joinDate.getText().trim());
        Assert.assertEquals("E2E Address verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getPremanentAddress().trim(), cbtHomePage.address.getText().trim());
        Assert.assertEquals("E2E Gender verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getGender().trim(), cbtHomePage.gender.getText().trim());
        Assert.assertEquals("E2E Salary verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getSalary()+"".trim(), cbtHomePage.salary.getText().trim());
        Assert.assertEquals("E2E Section verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getSection().trim(), cbtHomePage.section.getText().trim());
        Assert.assertEquals("E2E Subject verification failed!", APIUtil.getResponseBody().getTeachers().get(0).getSubject().trim(), cbtHomePage.subject.getText().trim());

    }


    @Then("user searches for teachers with name {string}")
    public void user_searches_for_teachers_with_name(String teacherName) throws Exception {

        cbtHomePage.teachersDropdown.click();
        cbtHomePage.allTeachersLink.click();
        Thread.sleep(500);
        cbtHomePage.teacherNameSearchInput.sendKeys(teacherName);
        cbtHomePage.searchBtn.click();

    }

    @Then("user cross validates teacher name result on API and on UI with {string}")
    public void user_cross_validates_teacher_name_result_on_API_and_on_UI_with(String teacherName) {

//        1. Number of resutls AI vs UI
//        2. Data validation on UI
//        3. Data validation on API
        int apiResult = APIUtil.getResponseBody().getTeachers().size();
        int uiResult = cbtHomePage.searchResultsName.size();

        System.out.println(apiResult);
        System.out.println(uiResult);

//

        Assert.assertEquals("Number of results failed: " + apiResult, uiResult);

//        Step #2
//        We will see what is on the UI

        List<WebElement> teachers = cbtHomePage.searchResultsName;
        for (WebElement teacher : teachers) {
            System.out.println(teacher.getText());
        }

    }


}
