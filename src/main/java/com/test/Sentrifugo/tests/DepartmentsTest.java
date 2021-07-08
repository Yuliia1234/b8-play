package com.test.Sentrifugo.tests;

import com.test.Sentrifugo.pages.DepartmentPage;
import com.test.Sentrifugo.pages.LoginPage;
import com.test.Sentrifugo.pages.OnPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DepartmentsTest {
    WebDriver driver;
    LoginPage loginPage;
    OnPage homePage;
    DepartmentPage departmentPage;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        homePage=new OnPage(driver);
        departmentPage=new DepartmentPage(driver);
    }

    @Test
    public void validateNewDepartment(){
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM01","sentrifugo");
        homePage.clickDepartment();
        departmentPage.clickAddButton();
        departmentPage.sendDepartmentDetails("Techtorial","1234");
        departmentPage.clickSaveButton();
        String actualSuccessMessage= departmentPage.getSuccessMessage();
        String expectedSuccessMessage="Department added successfully.";
        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);

    }
}
