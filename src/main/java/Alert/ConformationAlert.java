package Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConformationAlert {

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
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement second_button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        second_button.click();
        driver.switchTo().alert().dismiss();//you clicked cancel
        WebElement thirdAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        thirdAlert.click();
        driver.switchTo().alert().sendKeys("Hello Techtorial");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

//        driver.get("https://sweetalert.js.org/");
//        WebElement button = driver.findElement(By.xpath("//div[@class='swal-modal-example']"));
//        button.click();
//        driver.switchTo().alert().accept();


    }
}