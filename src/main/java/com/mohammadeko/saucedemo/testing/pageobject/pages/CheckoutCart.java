package com.mohammadeko.saucedemo.testing.pageobject.pages;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCart {

    private WebDriver driver;

    public CheckoutCart() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    WebElement btnCheckout;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement btnContinue;

    @FindBy(id = "finish")
    WebElement btnFinish;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement txtThanksForOrder;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement txtRequired;

    public void checkoutCart(String firstName, String lastName, String postalCode) {
        btnCheckout.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
        btnContinue.click();
        btnFinish.click();
    }

    public void invalidCheckoutCart(String firstName, String lastName, String postalCode) {
        btnCheckout.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
        btnContinue.click();
    }

    public String getTxtThanksForOrder() {
        return txtThanksForOrder.getText();
    }

    public String getTxtRequired() {
        return txtRequired.getText();
    }
}