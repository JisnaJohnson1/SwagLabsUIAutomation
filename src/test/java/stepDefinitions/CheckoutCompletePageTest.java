package stepDefinitions;


import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.CheckoutCompletePage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckoutCompletePageTest {
 ;
    private CheckoutCompletePage checkoutCompletePage= new CheckoutCompletePage(DriverFactory.getDriver());


    @Then("Verify the Order is displayed.")
    public void verify_the_order_is_displayed() {
        Assert.assertTrue(checkoutCompletePage.VerifyOrderConfirmation());
    }
}
