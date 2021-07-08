package com.test.etsy.test;

import Utils.BrowserUtils;
import com.test.TestBase;
import com.test.etsy.page.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends TestBase {

    HomePage homePage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();

    }


    @AfterMethod
    public void tearDown(ITestResult result){

        if (!result.isSuccess()){
            BrowserUtils.takeScreenShot(driver);
        }

    }
    @DataProvider(name ="searchInfo" )
    public Object [][] getSearchData(){
        return new  Object[][]{
                {"java programming mug","java","programming","mug"},
                {"father day gift","father","day","gift"},
                {"iphone max case","iphone","max","case"},
                {"cold weather clothes","cold","weather","clothes"}

        };
    }

  //  @Parameters("searchValue")
  //  @Test
//    public void validateSearch(String name) {
//        driver.get("https://www.etsy.com");
//        homePage.SetSearchButton(name);
//        List<String> result = homePage.getSearchList();
//        for (String results : result) {
//            softAssert.assertTrue(results.contains("mug") || results.contains("java") ||
//                    results.contains("programming"));
//        }
//
//        softAssert.assertAll();


 //   }
    @Test (dataProvider ="searchInfo" )
    public void validateSearchData(String value,String con1,String con2,String con3){
        driver.get("https://www.etsy.com");
        homePage.searchValue(value);
        List<String> result = homePage.getSearchList();
        for (String results : result) {
            softAssert.assertTrue(results.contains(con1) || results.contains(con2) ||
                    results.contains(con3));
        }

        softAssert.assertAll();
    }
}