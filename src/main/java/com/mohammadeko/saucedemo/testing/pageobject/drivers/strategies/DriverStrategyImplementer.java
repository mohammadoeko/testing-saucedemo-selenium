package com.mohammadeko.saucedemo.testing.pageobject.drivers.strategies;

import com.mohammadeko.saucedemo.testing.pageobject.utils.Constants;

public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case Constants.CHROME:
                return new Chrome();

            case Constants.FIREFOX:
                return new Firefox();

            default:
                return null;
        }
    }
}
