package OurProdject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {
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



        WebElement view_all_products = driver.findElement(By.xpath("//ul[@id='ctl00_menu']/li[2]/a"));
        view_all_products.click();
        // WebElement selected =driver.findElement(By.xpath("//ul[@id='ctl00_menu']/li[2]"));
       //selected.click();
        WebElement actual = driver.findElement(By.xpath("//ul[@id='ctl00_menu']/li[2]/a"));

        Assert.assertEquals(actual.getText(),"View all products");

        String header = driver.findElement(By.tagName("h2")).getText();

        Assert.assertEquals(header, "List of Products");

        String current_url = driver.getCurrentUrl();
        if (current_url.contains("Products")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test didn't pass");
        }



    }


}

