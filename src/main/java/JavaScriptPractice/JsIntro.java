package JavaScriptPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JsIntro {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }

    @Test
    public void ValidationJsIntro() {
        driver.get("https://www.techtorialacademy.com");

        System.out.println(driver.getTitle());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actuallTitle = js.executeScript("return document.title").toString();
        String expected = "Home Page - Techtorial";

        softAssert.assertEquals(actuallTitle, expected);

        WebElement browser = driver.findElement(By.xpath("//a[.='Browse Course']"));
        js.executeScript("arguments[0].click()", browser);
        String title = js.executeScript("return document.title").toString();
        String expectedTitle = "Programs - Techtorial";
        softAssert.assertEquals(title, expectedTitle);

        js.executeScript("alert(\"Techtorial Js Alert\")");

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();


        softAssert.assertAll();


    }
}
