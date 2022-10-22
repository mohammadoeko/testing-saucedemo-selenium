package com.mohammadeko.saucedemo.testing.pageobject.pages;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class About {

    private WebDriver driver;

    public About() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement btnMenu;

    @FindBy(id = "about_sidebar_link")
    WebElement btnAbout;

    @FindBy(xpath = "//*[@id=\"entry-3qDFahnypj1KkiORyU1Zyh\"]/div/div/div/div[1]/div/h1")
    WebElement txtDevelopWithConfidence;

    public void about() {
        btnMenu.click();
        btnAbout.click();
    }

    public String getTxtDevelopWithConfidence() {
        return txtDevelopWithConfidence.getText();
    }
}
