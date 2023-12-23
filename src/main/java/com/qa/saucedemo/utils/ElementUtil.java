package com.qa.saucedemo.utils;

import com.qa.saucedemo.exception.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtil {

    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public By getBy(String locatorType, String locatorValue) {
        By by = null;

        switch (locatorType.toLowerCase().trim()) {
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "class":
                by = By.className(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "linktext":
                by = By.linkText(locatorValue);
                break;
            case "partiallinktext":
                by = By.partialLinkText(locatorValue);
                break;
            case "tag":
                by = By.tagName(locatorValue);
                break;

            default:
                System.out.println("wrong locator type is passed..." + locatorType);
                throw new FrameworkException("WRONG LOCATOR TYPE");
        }

        return by;

    }

    public WebElement waitForVisibilityOfElement(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public WebElement waitForVisibilityOfElement(By locator, int timeOut, int intervalTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public WebElement getElement(String locatorType, String locatorValue) {
        return driver.findElement(getBy(locatorType, locatorValue));
    }
    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public void doClick(String locatorType, String locatorValue) {
        getElement(locatorType, locatorValue).click();
    }

}
