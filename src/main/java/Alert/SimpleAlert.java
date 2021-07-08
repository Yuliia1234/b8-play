package Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleAlert {
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

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alert.click();
        driver.switchTo().alert().accept();



    }
    }
