package stepDefinitions;

import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.LoginPage;
import com.qa.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class loginStep {

    private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
    private ProductsPage productsPage;


    @Given("The User navigates to Swag Labs website")
    public void the_user_navigates_to_swag_labs_website() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @When("The user is logged into the app with valid username {string} and password {string}")
    public void the_user_is_logged_into_the_app_with_valid_username_and_password(String un, String pwd) {
        productsPage= loginPage.douserLogin(un,pwd);
        System.out.println("Navigating Products Page");
    }



    @When("The user tries to log on to the app with Invalid username {string} and password {string}")
    public void the_user_tries_to_log_on_to_the_app_with_invalid_username_and_password(String un, String pwd) {

        productsPage= loginPage.douserLogin(un,pwd);
    }


    @Then("Error message is displayed with proper error message")
    public void error_message_is_displayed_with_proper_error_message() {

        Assert.assertTrue(loginPage.ValidateErrorMessage());
        System.out.println("Error message is displayed for invalid Login Credentials");

    }




}
