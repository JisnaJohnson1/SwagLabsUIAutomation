package stepDefinitions;

import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.CheckoutOverviewPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutOverviewPageTest {

    private CheckoutOverviewPage checkoutOverviewPage= new CheckoutOverviewPage(DriverFactory.getDriver());


    @Then("Verify Checkout: Overview screen is displayed")
    public void verify_checkout_overview_screen_is_displayed() {
        Assert.assertTrue(checkoutOverviewPage.ValidateCheckoutOverviewScreen());
    }

    @When("User clicks on Finish button")
    public void user_clicks_on_finish_button() {
        checkoutOverviewPage.clickFinish();
    }

}
