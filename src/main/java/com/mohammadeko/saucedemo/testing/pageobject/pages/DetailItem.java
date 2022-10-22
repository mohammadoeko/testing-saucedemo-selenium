package com.mohammadeko.saucedemo.testing.pageobject.pages;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailItem {

    private WebDriver driver;

    public DetailItem() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "item_4_title_link")
    WebElement btnClickItemBackpack;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement txtItemBackpack;

    public void btnClickItemBackpack() {
        btnClickItemBackpack.click();
        System.out.println("button click item backpack");
    }

    public String getTxtItemBackpack() {
        return txtItemBackpack.getText();
    }
}
