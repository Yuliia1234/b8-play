package JavaUploads;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Uploads {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softAssert = new SoftAssert();

    }

    @Test
    public void validateUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement choise = driver.findElement(By.id("file-upload"));
        choise.sendKeys("/Users/yuliiapopelniak/Desktop");

        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.submit();

        WebElement sucess_massage = driver.findElement(By.tagName("h3"));
        String expected_mes = sucess_massage.getText();
        String actual = "File Uploaded!";
        softAssert.assertEquals(expected_mes, actual);
        softAssert.assertAll();


    }

    @Test
    public void test2() {
        driver.get("http://demo.guru99.com/test/upload/");

        WebElement chose = driver.findElement(By.id("uploadfile_0"));
        String userID = System.getProperty("user.dir");
        chose.sendKeys( userID + "/src/main/resources/Picture/original.jpeg");

        WebElement terms = driver.findElement(By.id("terms"));
        terms.click();

        WebElement submit = driver.findElement(By.id("submitbutton"));
        submit.click();
        WebElement success = driver.findElement(By.tagName("h3"));

        String expected = "1 file\n" +
                "has been successfully uploaded.";
        String actual = success.getText();
        softAssert.assertEquals(expected, actual);
        softAssert.assertAll("Didn't pass");


    }
}
