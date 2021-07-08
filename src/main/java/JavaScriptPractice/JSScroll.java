package JavaScriptPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JSScroll {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.techtorialacademy.com/programs");
        WebElement getStarted = driver.findElement(By.xpath("//h4[.='Online Course']/following-sibling::div/a"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",getStarted);

        Thread.sleep(1000);
        WebElement program= driver.findElement(By.xpath("//h1"));
        js.executeScript("arguments[0].scrollIntoView(true)",program);//Scroll up

        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");//scrolling page to the end of page
    }
    @Test
    public void validationScrollPage(){

           driver.get("https://www.techtorialacademy.com");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement get_info=driver.findElement(By.xpath("//a[.='Get More Info']"));
        Point element = get_info.getLocation();
        int xCord = element.getX();
        int yCord = element.getY();

        js.executeScript("window.scrollTo("+xCord+","+yCord+")");

        js.executeScript("history,go(0)");//refresh the page
    }
}
