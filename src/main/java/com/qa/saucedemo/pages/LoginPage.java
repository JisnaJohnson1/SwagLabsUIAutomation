package com.qa.saucedemo.pages;

import com.qa.saucedemo.factory.DriverFactory;
import com.qa.saucedemo.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

//    By Locators

    private By userName = By.id("user-name");
    private By pswd = By.id("password");
    private By login = By.id("login-button");

    private By ErrorMessage=By.xpath("//h3[contains(text(),'Username and password do not match any user')]");

    private By HeadingText=By.xpath("//div[text()='Swag Labs']");

    //    Page Constructor

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
    }
    //    Page Actions


    public String SwagLabsHeadingText(){

        return eleUtil.waitForVisibilityOfElement(HeadingText,5).getText();
    }
    public ProductsPage douserLogin(String un, String pwd){

        eleUtil.waitForVisibilityOfElement(userName,10).sendKeys(un);
        eleUtil.doSendKeys(pswd,pwd);
        eleUtil.doClick(login);
        System.out.println("User is logged In");

        return new ProductsPage(driver);

    }

    public boolean ValidateErrorMessage(){

      return eleUtil.waitForVisibilityOfElement(ErrorMessage,5).isDisplayed();

    }


}




