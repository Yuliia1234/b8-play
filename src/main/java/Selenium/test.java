package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {

    @Test
    public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("jwgfwio@jwdg.com");

        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("132126");
    }

    }
