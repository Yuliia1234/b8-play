package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IframeByWeElement {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement abc = driver.findElement(By.xpath("//iframe[@class='tox-edit-area__iframe']"));

        driver.switchTo().frame(abc);
        WebElement text = driver.findElement(By.id("tinymce"));
        text.clear();


    }
}
