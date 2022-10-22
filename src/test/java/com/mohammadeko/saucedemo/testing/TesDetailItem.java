package com.mohammadeko.saucedemo.testing;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import com.mohammadeko.saucedemo.testing.pageobject.pages.DetailItem;
import com.mohammadeko.saucedemo.testing.pageobject.pages.Login;
import com.mohammadeko.saucedemo.testing.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TesDetailItem {
    public static WebDriver driver;
    private Login login;

    private DetailItem detailItem;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void pageObject() {
        login = new Login();
        detailItem = new DetailItem();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testDetailItem() {
        delay(Constants.DETIK);
        // PRE-CONDITION
        login.login("standard_user","secret_sauce");
        detailItem.btnClickItemBackpack();
        Assert.assertEquals(detailItem.getTxtItemBackpack(), "Sauce Labs Backpack");
        System.out.println("Test case detail item");
    }

    static void delay(int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
