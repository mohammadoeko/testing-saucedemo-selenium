package com.mohammadeko.saucedemo.testing.pageobject.pages;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    private WebDriver driver;

    public Login() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement btnLogin;

    @FindBy(xpath = "//span[@class='title']")
    WebElement txtProducts;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement txtErrorUsernamePassword;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    WebElement txtUsernamePasswordRequired;

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public String getTxtProducts() {
        return txtProducts.getText();
    }

    public String getTxtErrorUsernamePassword() {
        return txtErrorUsernamePassword.getText();
    }

    public String getTxtUsernamePasswordRequired() {
        return txtUsernamePasswordRequired.getText();
    }
}
