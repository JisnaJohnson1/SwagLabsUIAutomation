package com.qa.saucedemo.pages;

import com.qa.saucedemo.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    public CheckoutOverviewPage(WebDriver driver){

        this.driver=driver;
        eleUtil= new ElementUtil(this.driver);
    }

    private By checkoutOverviewText = By.xpath("//span[text()='Checkout: Overview']");

    private By finish = By.name("finish");

    public CheckoutCompletePage clickFinish(){

        eleUtil.doClick(finish);
        System.out.println("User Clicked on Finish Button");
        return new CheckoutCompletePage(driver);

    }

    public boolean ValidateCheckoutOverviewScreen(){

        return driver.findElement(checkoutOverviewText).isDisplayed();


    }
}
