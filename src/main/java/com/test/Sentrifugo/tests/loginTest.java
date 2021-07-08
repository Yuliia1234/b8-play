package com.test.Sentrifugo.tests;

import com.test.Sentrifugo.TestData.LoginCredentials;
import com.test.Sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class loginTest {

    WebDriver driver;
   LoginPage loginPage ;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
    }
    @DataProvider(name="credentials")
    public Object[][] getCredentials(){
        return new Object[][]{
                {"EM01", "test"},
                {"test","sentrifugo"},
                {"test","test"}
        };
    }

       // @Test(priority = 1)
    public void validateNegativeLoginTest1() {
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM01","test");
        String actualErrMessage=loginPage.getErrorMessage();
        String expectedErrMessage="The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrMessage, expectedErrMessage);
    }
    @Test(dataProvider = "credentials",dataProviderClass = LoginCredentials.class,priority = 1)
    public void validateNegativeLoginTest1(String username, String password) {
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        loginPage.login(username,password);
        String actualErrMessage=loginPage.getErrorMessage();
        String expectedErrMessage="The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrMessage, expectedErrMessage);
    }


   //   @Test(priority = 2)
    public void validateNegativeLoginTest2() {
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        loginPage.login("test","sentrifugo");
        String actualErrMessage=loginPage.getErrorMessage();
        String expectedErrMessage="The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrMessage, expectedErrMessage);
    }
   // @Test(priority = 3)
    public void validateNegativeLoginTest3() {
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        loginPage.login("test", "test");
        String actualErrMessage = loginPage.getErrorMessage();
        String expectedErrMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrMessage, expectedErrMessage);

    }
    @Test(priority = 4)
    public void validatePositiveLoginTest() {

        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM01", "sentrifugo");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}