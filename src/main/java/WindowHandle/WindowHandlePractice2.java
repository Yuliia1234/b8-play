package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlePractice2 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void Validate() {
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

        WebElement follow_all = driver.findElement(By.id("followall"));
        follow_all.click();

        String mainWindow = driver.getWindowHandle();

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            String url = driver.getCurrentUrl();
            if (!url.contains("twitter")) {
                driver.switchTo().window(id);
            }
        }
        String actualTitle = driver.getTitle();
        String expectedTitle = "Selenium Easy (@seleniumeasy) / Twitter";
        Assert.assertEquals(actualTitle, expectedTitle,"Title Validation");
    }

}
