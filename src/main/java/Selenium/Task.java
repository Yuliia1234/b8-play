package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Task {
    @Test
    public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        WebElement newAccount = driver.findElement(By.xpath("//div[@class='_6ltg']//a"));
        newAccount.click();

        Thread.sleep(1000);

        WebElement mount = driver.findElement(By.xpath("//div//span//span//select"));
        Select select = new Select(mount);
        select.selectByVisibleText("Jul");

        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select select1 = new Select(day);
        select1.selectByVisibleText("4");

        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        Select select2 = new Select(year);
        select2.selectByVisibleText("1905");

    }

    @Test
    public void validateDefaultSelected() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        WebElement newAccount = driver.findElement(By.xpath("//div[@class='_6ltg']//a"));
        newAccount.click();

        Thread.sleep(1000);
        WebElement mount = driver.findElement(By.xpath("//div//span//span//select"));
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        Select select = new Select(mount);
        Select select1 = new Select(day);
        Select select2 = new Select(year);

        String mountName = select.getFirstSelectedOption().getText();
        String dayName = select1.getFirstSelectedOption().getText();
        String yearName = select2.getFirstSelectedOption().getText();

        //LocalDate
        //LocalTime
        //LocalDateTime
        Assert.assertEquals(mountName.toUpperCase(), LocalDate.now().getMonth().toString().substring(0, 3));
        Assert.assertEquals(Integer.parseInt(dayName), LocalDate.now().getDayOfMonth());
        Assert.assertEquals(yearName, String.valueOf(LocalDate.now().getYear()));

        //String to Primitive -Integer.paseInt();
        //String to Wrapper Class -Integer.valueOf();
        //Primitive to String --String.valueOf();
    }

    @Test
    public void validateAvailableOptions() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        WebElement newAccount = driver.findElement(By.xpath("//div[@class='_6ltg']//a"));
        newAccount.click();

        Thread.sleep(1000);

        WebElement mount = driver.findElement(By.xpath("//div//span//span//select"));
        Select select = new Select(mount);

        List<WebElement> option = select.getOptions();
        System.out.println(option);

        List<String> actualOption = new ArrayList<>();//actual options comes from the website


        for (WebElement options : option) {
            actualOption.add(options.getText());

        }
        //Expected option comes from the Business Requirment
        List<String> expectedOption = Arrays.asList("Month","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        Assert.assertEquals(actualOption, expectedOption);




    }



}
