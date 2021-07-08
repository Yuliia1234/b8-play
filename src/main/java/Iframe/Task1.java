package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com");

        WebElement frame = driver.findElement(By.xpath("//a[.='Frames']"));
        frame.click();

        WebElement next_page = driver.findElement(By.xpath("//a[.='iFrame']"));
        next_page.click();

        String current_url = driver.getCurrentUrl();
        Assert.assertTrue(current_url.endsWith("iframe"), "Faild to verify the Iframe page");

        driver.switchTo().frame("mce_0_ifr");
        WebElement iframe = driver.findElement(By.xpath("//body[@id='tinymce']"));
        iframe.clear();
        iframe.sendKeys("Hello Techtorial");
        driver.switchTo().parentFrame();

        WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
        edit.click();
        WebElement drop_down = driver.findElement(By.xpath("//div[@title = 'Undo']//div[@class='tox-collection__item-label']"));
        drop_down.click();

        driver.switchTo().frame("mce_0_ifr");
        iframe = driver.findElement(By.xpath("//body[@id='tinymce']"));
        Assert.assertTrue(iframe.getText().trim().isEmpty());


    }
}
