package ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderPractice2 {
    @Test
    public void moveElement(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/angular/");
        driver.manage().window().maximize();

        WebElement redcircle = driver.findElement(By.xpath("//div[contains(@class, 'vertical')]//a[@role='slider']"));
        WebElement ten = driver.findElement(By.xpath("//div[contains(@class, 'vertical')]//li[@title='10']"));
        WebElement zero = driver.findElement(By.xpath("//div[contains(@class, 'vertical')]//li[@title='0']"));
        Point tenL = ten.getLocation();
        Point zeroL =zero.getLocation();

        System.out.println(tenL.getY());
        System.out.println(zeroL.getY());
        System.out.println(tenL.getY()-zeroL.getY());

        Actions actions = new Actions(driver);

        actions.clickAndHold(redcircle).moveByOffset(0,-50).release().perform();
    }
}
