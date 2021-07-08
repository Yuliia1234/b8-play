package ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeworkAction {
    @Test
    public void validate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement blue_box = driver.findElement(By.xpath("//div[@class = 'test1']"));
        String text_blue_box = blue_box.getText();
        String expected_blue_box = "Drag the small circle here ...";

        WebElement orange_box = driver.findElement(By.xpath("//div[@class = 'test2']"));
        String text_orange_box = orange_box.getText();
        String expected_orange_box = "... Or here.";

        Assert.assertEquals(text_blue_box, expected_blue_box);
        Assert.assertEquals(text_orange_box, expected_orange_box);

        WebElement circle = driver.findElement(By.id("draggable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(blue_box, circle).perform();

        Thread.sleep(3000);
        WebElement orange_box_result = driver.findElement(By.xpath("//div[@class = 'test2']"));
        System.out.println(blue_box.getText());
        System.out.println(orange_box_result.getText());

        Thread.sleep(3000);
        WebElement orange_box_result1 = driver.findElement(By.xpath("//div[@class = 'test2']"));

        WebElement blue_box_result1 = driver.findElement(By.xpath("//div[@class = 'test1']"));

        actions.dragAndDrop(orange_box_result1, circle);
        System.out.println(orange_box_result1.getText());
        System.out.println(blue_box_result1.getText());


    }

}
