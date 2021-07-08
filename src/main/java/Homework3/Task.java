package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task {
    @Test
    public void test3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

     driver.get("https://www.saucedemo.com");

       WebElement user_name = driver.findElement(By.id("user-name"));
       user_name.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();


        WebElement button = driver.findElement(By.id("react-burger-menu-btn"));
        button.click();

        Thread.sleep(1000);
        WebElement logout_button= driver.findElement(By.id("logout_sidebar_link"));
        logout_button.click();

        driver.navigate().back();

         String expected_url="https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expected_url);


    }

}
