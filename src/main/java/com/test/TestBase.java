package com.test;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;



public class TestBase{
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void set() {
        driver = Driver.getDriver();
    }
}
