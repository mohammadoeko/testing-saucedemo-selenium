package com.mohammadeko.saucedemo.testing;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import com.mohammadeko.saucedemo.testing.pageobject.pages.AddToCart;
import com.mohammadeko.saucedemo.testing.pageobject.pages.Login;
import com.mohammadeko.saucedemo.testing.pageobject.pages.SortListProduct;
import com.mohammadeko.saucedemo.testing.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSortListProduct {
    public static WebDriver driver;
    private Login login;
    private SortListProduct sortListProduct;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void pageObject() {
        login = new Login();
        sortListProduct = new SortListProduct();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testSortList() {
        delay(Constants.DETIK);
        // PRE-CONDITION
        login.login("standard_user","secret_sauce");
        sortListProduct.sortPriceLowToHigh();
        Assert.assertEquals(sortListProduct.getTxtSortPriceLowToHigh(), "PRICE (LOW TO HIGH)");
        System.out.println("Test case Sort List Price Product Low To High");
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
