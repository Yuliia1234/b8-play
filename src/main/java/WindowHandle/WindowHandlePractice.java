package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlePractice {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();


    }
    @Test
     public void validateMultipleWindow (){
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getTitle());

        WebElement click_here =driver.findElement(By.xpath("//a[.='Click Here']"));
        click_here.click();
        String mainWindow= driver.getWindowHandle();
        System.out.println(mainWindow);
        Set<String > ids=  driver.getWindowHandles();
//if the id is not equals to the main window switch to that id
        for (String id :ids) {
            if (!id.equals(mainWindow)) {
                driver.switchTo().window(id);
            }

            System.out.println(driver.getTitle());


        }

    }
    @Test
    public void validateWindow(){
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getTitle());

        WebElement click_here =driver.findElement(By.xpath("//a[.='Click Here']"));
        click_here.click();
        click_here.click();
        click_here.click();
        String mainWindow= driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();

        for (String id :ids){
            if (!id.equals(mainWindow)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getTitle());
    }
}
