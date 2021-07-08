package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Task1 {

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");

        WebElement user_name = driver.findElement(By.id("user-name"));
        user_name.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        WebElement drop_down = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        drop_down.click();
        Select select = new Select(drop_down);
        select.selectByVisibleText("Name (Z to A)");

        List<WebElement> actual = driver.findElements(By.className("inventory_item_name"));
        ArrayList<String> product = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();

        for (WebElement type : actual){
            product.add(type.getText());
            set.add(type.getText());

        }

        Assert.assertEquals(product,set);



    }

}

