package com.qa.saucedemo.factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser) {
        System.out.println("BrowserName*** " + browser);

        if (browser.equals("chrome")){
            tlDriver.set(new ChromeDriver());
        }

        else  if (browser.equals("edge")){
            tlDriver.set(new EdgeDriver());
        }
        else  if (browser.equals("safari")){

            tlDriver.set(new SafariDriver());
        }
        else {
            System.out.println("Please pass the correct browser Value");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /* This is used to get the driver with ThreadLocal
     * @return
     * */
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();

    }
}
