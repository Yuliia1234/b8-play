package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2ProductsLowPriceToHigh {
    @Test
    public void test2() {
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
        Select select = new Select(drop_down);
        select.selectByValue("lohi");

        List<WebElement> price = driver.findElements(By.className("inventory_item_price"));

        List<WebElement> all_information = driver.findElements(By.className("inventory_list"));

        for (WebElement prices : price) {
            for (WebElement info : all_information) {
                String product_prices = prices.getText();

                Assert.assertTrue(info.getText().contains(product_prices));
            }
        }
        for(int i=0; i<price.size()-1; i++){
            double current = Double.parseDouble(price.get(i).getText().substring(1));
            double next = Double.parseDouble(price.get(i+1).getText().substring(1));
            if(current>next) {
                Assert.fail();
            }
        }
    }
}


