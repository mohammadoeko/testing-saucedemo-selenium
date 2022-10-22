package com.mohammadeko.saucedemo.testing;

import com.mohammadeko.saucedemo.testing.pageobject.drivers.DriverSingleton;
import com.mohammadeko.saucedemo.testing.pageobject.pages.Login;
import com.mohammadeko.saucedemo.testing.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogin {
    public static WebDriver driver;
    private Login login;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void pageObject() {
        login = new Login();
    }

    @AfterMethod
    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 6)
    public void testValidLogin() {
        delay(Constants.DETIK);
        login.login("standard_user","secret_sauce");
        Assert.assertEquals(login.getTxtProducts(), "PRODUCTS");
        System.out.println("Test case valid login");
    }

    @Test(priority = 1)
    public void testInvalidUsernameLogin() {
        delay(Constants.DETIK);
        login.login("standard_user1","secret_sauce");
        Assert.assertTrue(login.getTxtErrorUsernamePassword().contains("Username and password do not match"));
        System.out.println("Test case invalid username login");
    }

    @Test(priority = 2)
    public void testInvalidPasswordLogin() {
        delay(Constants.DETIK);
        login.login("standard_user","secret_sauce1");
        Assert.assertTrue(login.getTxtErrorUsernamePassword().contains("Username and password do not match"));
        System.out.println("Test case invalid password login");
    }

    @Test(priority = 3)
    public void testUsernameRequiredLogin() {
        delay(Constants.DETIK);
        login.login("","secret_sauce");
        Assert.assertEquals(login.getTxtUsernamePasswordRequired(), "Epic sadface: Username is required");
        System.out.println("Test case required username login");
    }

    @Test(priority = 4)
    public void testPasswordRequiredLogin() {
        delay(Constants.DETIK);
        login.login("standard_user","");
        Assert.assertEquals(login.getTxtUsernamePasswordRequired(), "Epic sadface: Password is required");
        System.out.println("Test case required password login");
    }

    @Test(priority = 5)
    public void testUsernamePasswordRequiredLogin() {
        delay(Constants.DETIK);
        login.login("","");
        Assert.assertTrue(login.getTxtUsernamePasswordRequired().contains("required"));
        System.out.println("Test case required password login");
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
