package Prodject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Task2Try2 extends Base {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        List<WebElement> price = driver.findElements(By.xpath("//span[@class='price product-price']"));
        price.removeIf(element -> !element.getText().contains("$"));
        for (WebElement element : price) {
            System.out.println("Product " + (price.indexOf(element) + 1) + " price is: " + element.getText());
        }

        List<WebElement> productsInfo = driver.findElements(By.cssSelector("#homefeatured li"));

        double MaxPrice = Double.parseDouble(findElementInside(productsInfo.get(0),
                By.cssSelector(".right-block .price")).getText().replace("$", ""));
        for (int i = 1; i < productsInfo.size(); i++) {
            double allPrices = Double.parseDouble(findElementInside(productsInfo.get(i),
                    By.cssSelector(".right-block .price")).getText().replace("$", ""));
            if (allPrices > MaxPrice) {
                MaxPrice = allPrices;
            }
        }
        System.out.println("Max price " + MaxPrice);
         //The most expensive product and the name of product
        String max_price = String.valueOf(MaxPrice);
        for (int i = 0; i < productsInfo.size(); i++) {
            if (productsInfo.get(i).getText().contains(max_price)) {
                System.out.println(productsInfo.get(i).getText());

            }
        }
        WebElement move_button = driver.findElement(By.xpath("//a[@class='button lnk_view btn btn-default']/span"));
        WebElement hover_over = driver.findElement(By.cssSelector("#homefeatured li"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hover_over).click(move_button).release().perform();
        //Price after pressing button more
        WebElement price_after_HoveringOver = driver.findElement(By.id("our_price_display"));
        Assert.assertEquals(price_after_HoveringOver.getText(), "$16.51", "PRICE ARE NOT THE SAME");
       // Product name after clicking the MORE button
        WebElement product_name = driver.findElement(By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']/h1"));
        Assert.assertEquals(product_name.getText(), "Faded Short Sleeve T-shirts", "PRODUCT NAME DIDN'T MATCH");
        //Change the color of product
        WebElement change_color = driver.findElement(By.id("color_14"));
        change_color.click();
         // url ending with selected color name
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.endsWith("color-blue"));


    }
}
