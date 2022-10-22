package com.mohammadeko.saucedemo.testing;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import com.mohammadeko.saucedemo.testing.pageobject.pages.AddToCart;
import com.mohammadeko.saucedemo.testing.pageobject.pages.CheckoutCart;
import com.mohammadeko.saucedemo.testing.pageobject.pages.Login;
import com.mohammadeko.saucedemo.testing.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCheckoutCart {
    public static WebDriver driver;
    private Login login;
    private AddToCart addToCart;

    private CheckoutCart checkoutCart;

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
        checkoutCart = new CheckoutCart();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @AfterMethod
    public void refreshBrowser() {
        driver.navigate().back();
    }

    @Test(priority = 5)
    public void testCheckout() {
        delay(Constants.DETIK);
        checkoutCart.checkoutCart("tes", "aja", "90908");
        Assert.assertEquals(checkoutCart.getTxtThanksForOrder(), "THANK YOU FOR YOUR ORDER");
        System.out.println("Test case checkout product");
    }

    @Test(priority = 1)
    public void testCheckoutFirstnameRequired() {
        delay(Constants.DETIK);
        // PRE-CONDITION
        login.login("standard_user","secret_sauce");
        addToCart.addItemToCart();
        checkoutCart.invalidCheckoutCart("", "aja", "90908");
        Assert.assertEquals(checkoutCart.getTxtRequired(), "Error: First Name is required");
        System.out.println("Test case firstname required");
    }

    @Test(priority = 2)
    public void testCheckoutLastnameRequired() {
        delay(Constants.DETIK);
        checkoutCart.invalidCheckoutCart("tes", "", "90908");
        Assert.assertEquals(checkoutCart.getTxtRequired(), "Error: Last Name is required");
        System.out.println("Test case lastname required");
    }

    @Test(priority = 3)
    public void testCheckoutPostalCodeRequired() {
        delay(Constants.DETIK);
        checkoutCart.invalidCheckoutCart("tes", "aja", "");
        Assert.assertEquals(checkoutCart.getTxtRequired(), "Error: Postal Code is required");
        System.out.println("Test case postalcode required");
    }

    @Test(priority = 4)
    public void testCheckoutAllInformationRequired() {
        delay(Constants.DETIK);
        checkoutCart.invalidCheckoutCart("", "", "");
        Assert.assertTrue(checkoutCart.getTxtRequired().contains("required"));
        System.out.println("Test case all required");
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
