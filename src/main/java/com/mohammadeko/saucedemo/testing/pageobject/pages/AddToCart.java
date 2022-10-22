package com.mohammadeko.saucedemo.testing.pageobject.pages;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
    private WebDriver driver;

    public AddToCart() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement btnAddCartBackpack;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement btnAddCartTShirtRed;

    @FindBy(id = "shopping_cart_container")
    WebElement btnCart;

    @FindBy(xpath = "//span[@class='title']")
    WebElement txtYourCart;

    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    WebElement btnRemoveTShirtRed;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement btnRemoveBackpack;

    public void addItemToCart() {
        btnAddCartBackpack.click();
        btnAddCartTShirtRed.click();
        btnCart.click();
    }

    public void removeToCart() {
        btnRemoveTShirtRed.click();
        btnRemoveBackpack.click();
    }

    public String getTxtYourCart() {
        return txtYourCart.getText();
    }
}