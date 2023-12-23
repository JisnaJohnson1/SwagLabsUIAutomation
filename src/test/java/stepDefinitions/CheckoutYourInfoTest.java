package stepDefinitions;

import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.CheckoutYourInfo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutYourInfoTest {
    private CheckoutYourInfo checkoutYourInfo= new CheckoutYourInfo(DriverFactory.getDriver());


    @Then("Verify the Checkout: Your Information screen is displayed")
    public void verify_the_checkout_your_information_screen_is_displayed() {

       Assert.assertTrue(checkoutYourInfo.verifyYourInformationHeader());
    }

    @Then("Verify that the user is able to enter customer details")
    public void verify_that_the_user_is_able_to_enter_customer_details() {
        checkoutYourInfo.EnterCustInfoforCheckout();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {

        checkoutYourInfo.clickContinueButton();

    }
}
