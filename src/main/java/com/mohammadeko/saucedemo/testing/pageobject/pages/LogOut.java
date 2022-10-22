package com.mohammadeko.saucedemo.testing.pageobject.pages;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
    private WebDriver driver;

    public LogOut() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement btnMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement menuLogout;

    @FindBy(xpath = "//div[@class='login_wrapper']")
    WebElement displayLogin;

    public void logout() {
        btnMenu.click();
        menuLogout.click();
    }

    public boolean getdisplayLogin() {
        return displayLogin.isDisplayed();
    }
}
