package com.mohammadeko.saucedemo.testing.pageobject.pages;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SortListProduct {
    private WebDriver driver;

    public SortListProduct() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
    WebElement sortPriceLowToHigh;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/span")
    WebElement txtSortPriceLowToHigh;

    public void sortPriceLowToHigh() {
        Select selectSortProduct = new Select(sortPriceLowToHigh);
        selectSortProduct.selectByValue("lohi");
    }

    public String getTxtSortPriceLowToHigh() {
        return txtSortPriceLowToHigh.getText();
    }
}
