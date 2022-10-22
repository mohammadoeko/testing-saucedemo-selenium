package com.mohammadeko.saucedemo.testing;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import com.mohammadeko.saucedemo.testing.pageobject.pages.AddToCart;
import com.mohammadeko.saucedemo.testing.pageobject.pages.Login;
import com.mohammadeko.saucedemo.testing.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAddToCart {
    public static WebDriver driver;
    private Login login;
    private AddToCart addToCart;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void pageObject() {
        login = new Login();
        addToCart = new AddToCart();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testItemCart() {
        delay(Constants.DETIK);
        // PRE-CONDITION
        login.login("standard_user","secret_sauce");
        addToCart.addItemToCart();
        Assert.assertEquals(addToCart.getTxtYourCart(), "YOUR CART");
        System.out.println("Test case add item to cart");
    }

    @Test(priority = 2)
    public void testRemoveItemCart() {
        delay(Constants.DETIK);
        addToCart.removeToCart();
        Assert.assertEquals(addToCart.getTxtYourCart(), "YOUR CART");
        System.out.println("Test case add item to cart");
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
