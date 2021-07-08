package ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropPractice {
    @Test
    public void validateDragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().fullscreen();
        //or driver.navigate().to()

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(1000);

        WebElement source = driver.findElement(By.id("draggable"));

         WebElement target = driver.findElement(By.xpath("//div[@class = 'test2']"));
        System.out.println("Before Drop");

         String actualText = target.getText();
         String actualTargetText = target.getText();
         String expectedTargetText = "You did great!";

         String expectedText = "... Or here.";
        Assert.assertEquals(actualText,expectedText);

        Actions action = new Actions(driver);
        action.dragAndDrop(source,target).perform();
        Thread.sleep(1000);

        System.out.println("After Drop");
        target = driver.findElement(By.xpath("//div[@class = 'test2']"));

    }
    @Test
    public void validatedDragAndDrop2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().fullscreen();
        //or driver.navigate().to()

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(1000);

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.xpath("//div[@class = 'test1']"));

        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.clickAndHold(source).moveToElement(target).release().perform();



    }
}
