package Homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Task {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demo.openemr.io/openemr");
        WebElement user_name = driver.findElement(By.id("authUser"));
        user_name.sendKeys("admin");

        WebElement password = driver.findElement(By.id("clearPass"));
        password.sendKeys("pass");

        WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']"));
        login.click();

        WebElement search = driver.findElement(By.id("anySearchBox"));
        search.sendKeys("Phil");
        WebElement search_goal = driver.findElement(By.id("search_globals"));
        search_goal.click();
        Thread.sleep(2000);
        driver.switchTo().frame("fin");


        WebElement name = driver.findElement(By.xpath("//tr[@id='pid_1']//td[1]/a"));
        Assert.assertEquals(name.getText(), "Belford, Phil");
        WebElement phone_number = driver.findElement(By.xpath("//tr[@id='pid_1']//td[2]"));
        Assert.assertEquals(phone_number.getText(), "333-444-2222");
        WebElement ssn = driver.findElement(By.xpath("//tr[@id='pid_1']//td[3]"));
        Assert.assertEquals(ssn.getText(), "333222333");
        WebElement dateOfBirth = driver.findElement(By.xpath("//tr[@id='pid_1']//td[4]"));
        Assert.assertEquals(dateOfBirth.getText(), "1972-02-09");

        WebElement externalId = driver.findElement(By.xpath("//tr[@id='pid_1']//td[5]"));
        Assert.assertEquals(externalId.getText(), "1");
        String try_externalID = externalId.getText();
       name.click();



        driver.switchTo().parentFrame();
        driver.switchTo().frame("pat");
        Thread.sleep(2000);
        //Validate external ID are matching in Home page and Patient Dashboard
        WebElement dashboardId = driver.findElement(By.xpath("//td[@id='text_pubpid']"));
        String try_dashboardId= dashboardId.getText();
        Assert.assertEquals(try_externalID,try_dashboardId);

        driver.switchTo().defaultContent();
        WebElement DOB = driver.findElement(By.xpath("//span[@data-bind='text:patient().str_dob()']"));
        Assert.assertTrue(DOB.isDisplayed());

        String[] array = DOB.getText().split(" ");
        int expectedAge = Integer.parseInt(array[3]);
        System.out.println(expectedAge);
        Period period = Period.between(LocalDate.parse(array[1]),LocalDate.now());
        int actualAge = period.getYears();
        System.out.println(actualAge);



    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demo.openemr.io/openemr");
        WebElement user_name = driver.findElement(By.id("authUser"));
        user_name.sendKeys("admin");

        WebElement password = driver.findElement(By.id("clearPass"));
        password.sendKeys("pass");

        WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']"));
        login.click();

        WebElement search = driver.findElement(By.id("anySearchBox"));
        search.sendKeys("Phil");
        WebElement search_goal = driver.findElement(By.id("search_globals"));
        search_goal.click();
        Thread.sleep(2000);

        driver.switchTo().frame("fin");
        WebElement name = driver.findElement(By.xpath("//tr[@id='pid_1']//td[1]/a"));
        name.click();
        // driver.switchTo().frame("pat");

        WebElement edit_massage = driver.findElement(By.xpath("//span[.='Messages']"));
        edit_massage.click();
        WebElement click_to_massages = driver.findElement(By.xpath("//a[contains(text(),'Click here to view them')]"));
        click_to_massages.click();

    }

    @Test
    public void test3() {

    }
}




