package com.qa.saucedemo.pages;

import com.qa.saucedemo.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInfo {
    private WebDriver driver;
    private ElementUtil eleUtil;
    public CheckoutYourInfo(WebDriver driver){

        this.driver=driver;
        eleUtil= new ElementUtil(this.driver);
    }

    private  By firstName = By.id("first-name");
    private  By lastName = By.id("last-name");
    private  By zip = By.id("postal-code");
    private  By continuebtn = By.id("continue");
    private By YourInfoHeader=By.xpath("//span[text()='Checkout: Your Information']");

    public boolean verifyYourInformationHeader(){

        return driver.findElement(YourInfoHeader).isDisplayed();

    }

    public void EnterCustInfoforCheckout(){

        eleUtil.doSendKeys(firstName,"abc");
        eleUtil.doSendKeys(lastName,"weer");
        eleUtil.doSendKeys(zip,"NN2 9TG");


    }

    public CheckoutOverviewPage clickContinueButton(){

        eleUtil.doClick(continuebtn);
        return new CheckoutOverviewPage(driver);

    }

}
