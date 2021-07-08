package com.test.Sentrifugo.tests;

import com.test.Sentrifugo.pages.GenderPage;
import com.test.Sentrifugo.pages.LoginPage;
import com.test.Sentrifugo.pages.OnPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GenderTest {

    WebDriver driver;
    LoginPage loginPage;
    OnPage homePage;
    GenderPage genderPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        genderPage = new GenderPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new OnPage(driver);
        driver.get("http://demo.sentrifugo.com/index.php");
        loginPage.login("EM01", "sentrifugo");

    }

    @Test

    public void validateGenderSelector() {
        homePage.clickGender();
        String actualAtrubuteValue = homePage.getSelectedOption();
        String expectedAttrubuteValue = "side-menu-selected";
        Assert.assertEquals(actualAtrubuteValue, expectedAttrubuteValue);
    }

    @Test
    public void validateDelete() throws InterruptedException {

        homePage.clickGender();
        genderPage.clickDeleteButton();
        genderPage.clickOkayButton();
        Thread.sleep(2000);
        String actualSuccessMessage = genderPage.getsucessMassage();
        String expectedSuccessMassage = "Gender deleted successfully.";

        Assert.assertEquals(actualSuccessMessage, expectedSuccessMassage, "test didn't pass");


    }
}