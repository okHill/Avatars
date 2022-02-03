package step_definitions.cybertekTraining_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utilities.APIUtil;

public class TeacherDeleteService_stepDefs {


    @Given("user deletes teacher at {string}")
    public void user_deletes_teacher_at(String resource) {
        APIUtil.hitDelete(resource);
    }

    @Given("user gets teacher at {string}")
    public void user_gets_teacher_at(String resource) {
        APIUtil.hitGET(resource);
//        Assert.fail("On purpose"); for test to see if driver is launching and taking picture
    }

    @Then("user verifies response message with {string}")
    public void user_verifies_response_message_with(String expectedMessage) {
        String message = APIUtil.getResponseBody().getMessage();
        Assert.assertEquals("Delete teacher failed", expectedMessage, message);
    }

}
