package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandlePractice3 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void Validate() {

        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html" );
        WebElement follow_all = driver.findElement(By.id("followall"));
        follow_all.click();

        String mainId=driver.getWindowHandle();
        String url ="https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2Fseleniumeasy";
        BrowserUtils.switchByURL(driver,url);
        System.out.println(driver.getCurrentUrl());//facebook

        String targettitle = "Selenium Easy (@seleniumeasy) / Twitter";
        BrowserUtils.switchByTitle(driver,targettitle);
        System.out.println(driver.getTitle());

        BrowserUtils.closeWindow(driver,mainId);
    }
}
