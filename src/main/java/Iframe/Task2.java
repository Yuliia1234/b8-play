package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task2 {
    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        WebElement frame = driver.findElement(By.xpath("//a[.='Frames']"));
        frame.click();

        WebElement next_page = driver.findElement(By.xpath("//a[.='Nested Frames']"));
        next_page.click();

        driver.switchTo().frame("frame-right");
        driver.switchTo().defaultContent();//will take you to the first parent
        driver.switchTo().frame("frame-bottom");



        WebElement middle = driver.findElement(By.name("frame-bottom"));
        System.out.println( middle.getText());

    }
}
