package com.qa.saucedemo.pages;

import com.qa.saucedemo.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    public CheckoutCompletePage(WebDriver driver){

        this.driver=driver;
        eleUtil= new ElementUtil(this.driver);
    }

    private By OrderConfirmationmsg = By.xpath("//h2[text()='Thank you for your order!']");

    public boolean VerifyOrderConfirmation(){

      return driver.findElement(OrderConfirmationmsg).isDisplayed();



    }
}
