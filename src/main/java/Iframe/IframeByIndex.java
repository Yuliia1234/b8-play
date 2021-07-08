package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public  class  IframeByIndex {
    WebDriver driver ;

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


        String expected = "https://the-internet.herokuapp.com/iframe";
        driver.get(expected);
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(expected, actual);
        driver.switchTo().frame(0);

        WebElement textField = driver.findElement(By.id("tinymce"));
        textField.clear();
        textField.sendKeys("Good morning ");

    }
    @Test
    public void test2(){

        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(1);//switching by index
        WebElement Bottom = driver.findElement(By.xpath("//html//body[contains(text(),'BOTTOM')]"));
        System.out.println(Bottom.getText());





    }
}
