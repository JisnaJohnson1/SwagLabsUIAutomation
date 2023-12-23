package stepDefinitions;

import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.pages.LoginPage;
import com.qa.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class productsPageTest {

    private ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

    @Then("The User is launched in Products Page")
    public void the_user_is_launched_in_products_page() {
        Assert.assertEquals(productsPage.ProductsHeading(),"Products");
    }

    @Then("Verify the product {string} are listing in the productsPage")
    public void verify_the_product_are_listing_in_the_products_page(String ProdName) {
        Assert.assertEquals(productsPage.VerifyItemName(ProdName),true);
    }

    @When("User Adds item {string} to the Cart")
    public void user_adds_item_to_the_cart(String ItemName) {
        productsPage.AddItemToCart(ItemName);
    }

    @When("User clicks on the Shopping Cart")
    public void user_clicks_on_the_shopping_cart() {
        productsPage.clickShoppingCart();
    }

//    @Then("Verify the user is able to Add the Item to the Cart")
//    public void verify_the_user_is_able_to_add_the_item_to_the_cart() {
//
//        productsPage.AddItemToCart();
//    }

//    @When("User clicks on AddtoCart")
//    public void user_clicks_on_addto_cart() {
//
//        productsPage.AddItemToCart(ItemName);
//        int CartCount= productsPage.getShoppingCartCount();
//        System.out.println("No:of Items in the Cart "+ CartCount);
//
//    }

}
