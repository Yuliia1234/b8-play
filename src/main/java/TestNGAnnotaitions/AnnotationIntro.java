package TestNGAnnotaitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AnnotationIntro {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.out.println("Before class Annnotation");
        System.out.println("it will run one time before everything inside the class ");

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method will run before each test annotation");
        System.out.println("Test1");
        System.out.println("Test 2 ");
        System.out.println("Test3");
        System.out.println("Test 4");
    }
    @Test
    public void test1(){
        driver.get("https://www.google.com/");
    }
    @Test
    public void test2(){
        driver.get("https://www.facebook.com/");

    }
    @Test
    public void test3(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After each method");
        System.out.println("will be executed after each method");

    }
    @AfterClass
    public void afterClass(){
        System.out.println("Only one time and after evething inside this class  ");
        driver.quit();
    }
}
