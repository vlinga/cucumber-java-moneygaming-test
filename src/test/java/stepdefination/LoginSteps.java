package stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.Login;

public class LoginSteps extends Base {

    Login loginPage;


    @Given("^I open moneygaming site$")
    public void i_open_moneygaming_site() {
        Base.initialization();
        loginPage = new Login();
        loginPage.launchwebsite();
    }


    @When("^User click on JoinNow$")
    public void user_click_on_joinnow() {
        loginPage.joinNow();
    }

    @Then("^User Selected Title as (.*)$")
    public void user_selected_title_as_something(String option) {
        loginPage.selectTitle(option);
    }

    @And("^User Enter Firstname as (.*)$")
    public void user_enter_firstname(String firstname) {
        loginPage.enterFirstname(firstname);
    }

    @And("^User Enter Surname as (.*)$")
    public void user_enter_surname(String surname) {
        loginPage.surName(surname);
    }

    @And("^User selected I accept the Terms and Conditions and certify that I am overthe age of 18$")
    public void user_selected_i_accept_the_terms_and_conditions_and_certify_that_i_am_overthe_age_of_18() {
        loginPage.selectCheckbox();
    }

    @Then("^User click on JoinNowReg$")
    public void user_click_on_joinnowreg() {
        loginPage.joinNowReg();
    }


    @And("^Verify system is displaying error message\"([^\"]*)\"$")
    public void verify_system_is_displaying_error_messagesomething(String errormsg) {
        loginPage.validateMessage(errormsg);
    }


}