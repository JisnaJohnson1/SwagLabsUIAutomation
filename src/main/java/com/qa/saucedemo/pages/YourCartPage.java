package com.qa.saucedemo.pages;

import com.qa.saucedemo.utils.ElementUtil;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class YourCartPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private By checkoutBtn = By.id("checkout");

    private By CartItems = By.xpath("//div[@class='cart_item']");


    public YourCartPage(WebDriver driver) {

        this.driver = driver;
        eleUtil= new ElementUtil(this.driver);


    }



    public int VerifyCartCount(){

        int CartCount= driver.findElements(CartItems).size();

        return CartCount;
    }

    public List<String>  ValidateOrderItem(int CartCount){

        System.out.println("Fetching Cart Item Details");

        List<String> ItemNames = new ArrayList<String>();
        for (int i=1;i<=CartCount;i++){
            String Item=driver.findElement(By.xpath("(//div[@class='cart_item']//a/div)["+i+"]")).getText();
//            System.out.println("ItemName***"+Item );
            ItemNames.add(Item);

                }
        return ItemNames;


    }

    public CheckoutYourInfo clickCheckout(){

        eleUtil.doClick(checkoutBtn);
        return new CheckoutYourInfo(driver);


    }

}
