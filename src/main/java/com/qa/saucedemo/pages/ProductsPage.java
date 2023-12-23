package com.qa.saucedemo.pages;

import com.qa.saucedemo.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    private YourCartPage yourCartPage;

//    private By AddToCart = By.xpath("//div[contains(text(),'Backpack')]//ancestor::div[@class='inventory_item_label']//following-sibling::div//button");

    private By yourCart =By.xpath("//a[@class='shopping_cart_link']//span");
    private By ProductsHeadingTitle = By.xpath("//span[@class='title']");
    public ProductsPage(WebDriver driver){

        this.driver=driver;
        eleUtil= new ElementUtil(this.driver);

    }

    public String ProductsHeading(){
        return eleUtil.waitForVisibilityOfElement(ProductsHeadingTitle,5).getText();
    }

    public boolean VerifyItemName(String ItemName){
       return driver.findElement(By.xpath("//div[@class='inventory_item_label']//div[contains(text(),'"+ItemName+"')]")).isDisplayed();
    }
//    public boolean AddItemToCartButtonExists(){
//       return eleUtil.waitForVisibilityOfElement(AddToCart,5).isDisplayed();
//    }


    public void AddItemToCart(String ItemName){
//          eleUtil.waitForVisibilityOfElement(AddToCart,5).click();

        driver.findElement(By.xpath("//div[contains(text(),'"+ItemName+"')]//ancestor::div[@class='inventory_item_label']//following-sibling::div//button")).click();


//        driver.findElement(AddToCart).click();
    }

    public void clickShoppingCart(){
        eleUtil.doClick(yourCart);
    }

    public int getShoppingCartCount(){

        boolean flag =driver.findElement(By.xpath("//a[@class='shopping_cart_link']//span")).isDisplayed();

        if (flag==true){
            String Value= driver.findElement(By.xpath("//a[@class='shopping_cart_link']//span")).getText();
             return Integer.parseInt(Value);

        }
        else {
            return 0;
        }

    }
}
