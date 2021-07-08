package OurProdject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task3 {
    @Test
    public void test1() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement login_button = driver.findElement(By.id("ctl00_MainContent_login_button"));
        login_button.click();

        List<WebElement> all_links =driver.findElements(By.xpath("//ul[@id='ctl00_menu'] //a"));
        String[] hrefs = {"Default.aspx", "Products.aspx", "Process.aspx"};


        for (int i=0; i<all_links.size(); i++){
            System.out.println(all_links.get(i).getAttribute("href"));
            Assert.assertTrue(all_links.get(i).getAttribute("href").endsWith(hrefs[i]));
        }







    }
}
