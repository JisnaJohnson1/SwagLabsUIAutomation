package stepDefinitions;

import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.YourCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class YourCartPageTest {

    private YourCartPage yourCartPage= new YourCartPage(DriverFactory.getDriver());;

    @Then("Verify the Item is added in yourCartScreen")
    public void verify_the_item_is_added_in_your_cart_screen() {
        int count= yourCartPage.VerifyCartCount();
        List<String> Names=  yourCartPage.ValidateOrderItem(count);
        System.out.println(Names);
        System.out.println("Cart Count "+ count);
        Assert.assertTrue(count>0,"Cart Count is zero");

    }

    @When("The user clicks on checkoutButton")
    public void the_user_clicks_on_checkout_button() {
        yourCartPage.clickCheckout();
    }
}
