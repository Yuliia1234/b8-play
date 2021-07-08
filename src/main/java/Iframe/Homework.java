package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Homework {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com");

        WebElement frame = driver.findElement(By.xpath("//a[.='Frames']"));
        frame.click();

        WebElement next_page = driver.findElement(By.xpath("//a[.='Nested Frames']"));
        next_page.click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement middle = driver.findElement(By.id("content"));
        System.out.println(middle.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement Bottom = driver.findElement(By.xpath("//html//body[contains(text(),'BOTTOM')]"));
        System.out.println(Bottom.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement left = driver.findElement(By.xpath("//html//body[contains(text(),'LEFT')]"));
        System.out.println(left.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        WebElement Bottom1 = driver.findElement(By.xpath("//html//body[contains(text(),'BOTTOM')]"));
        System.out.println(Bottom1.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        WebElement right = driver.findElement(By.xpath("//html//body[contains(text(),'RIGHT')]"));
        System.out.println(right.getText());




    }
}
