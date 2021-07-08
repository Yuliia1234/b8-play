package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultiplePractice {
    @Test
    public void validateMultipleSelection() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        WebElement multiSelect = driver.findElement(By.id("multi-select"));
        Select select = new Select(multiSelect);

        select.selectByVisibleText("Ohio");
        select.selectByVisibleText("Texas");
        select.selectByValue("Florida");

        select.deselectByVisibleText("Florida");
        select.deselectAll();
    }
}
