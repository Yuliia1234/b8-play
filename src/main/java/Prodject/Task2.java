package Prodject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Task2 extends Base {

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        List<WebElement> allPrices = driver.findElements(By.xpath("//ul[@id='homefeatured']"));

        int index = 0;
        double MaxPrice = Double.parseDouble(findElementInside(allPrices.get(0),
                By.xpath("//div[@class='right-block']//span")).getText().replace("$", ""));

        for (int i = 1; i < allPrices.size(); i++) {
            double current = Double.parseDouble(findElementInside(allPrices.get(i),
                    By.xpath("//div[@class='right-block']//span")).getText().replace("$", ""));
            System.out.println(current);

            if (current > MaxPrice) {
                MaxPrice = current;
                index = i;
                System.out.println("Max Price :" + MaxPrice);
            }
        }
        List<String> price_product = new ArrayList<>();
        List<WebElement> allPrices1 = driver.findElements(By.xpath("//span[@class='price product-price']"));
        allPrices.removeIf(element -> !element.getText().contains("$"));
        for (WebElement element : allPrices) {
            System.out.println("Product " + (allPrices.indexOf(element) + 1) + " price is: " + element.getText());

            for (WebElement element1 : allPrices) {
                System.out.println("Product " + (allPrices.indexOf(element) + 1) + " price is: " + element.getText());
                price_product.add(element.getText());
            }
            List<Double> numbers = new ArrayList<>();
            for (int i = 0; i < price_product.size(); i++) {
                double current = Double.parseDouble(price_product.get(i).substring(1));
                numbers.add(current);
            }

            System.out.println("ALL PRICES :" + numbers);
            List<Double> highest_price = new ArrayList<>();
            highest_price.add(Collections.max(numbers));
            System.out.println("HIGHEST PRICE : " + highest_price);


            List<WebElement> prices_with_names = driver.findElements(By.xpath("//div[@class = 'right-bl ock']"));
            List<WebElement> abc = driver.findElements(By.xpath("//a[@class='product-name']"));
            for (WebElement check : abc) {
                System.out.println(check.getText());
            }


            WebElement move_button = driver.findElement(By.xpath("//a[@class='button lnk_view btn btn-default']/span"));
            WebElement hover_over = driver.findElement(By.xpath("//*[@id='homefeatured']/li"));
            Actions actions = new Actions(driver);
            actions.moveToElement(hover_over).click(move_button).release().perform();
            //Price after navigating to new page
            WebElement price_after = driver.findElement(By.id("our_price_display"));
            System.out.println(abc.size());


//       List<String> price_product = new ArrayList<>();
//
//        for (WebElement element : allPrices) {
//            System.out.println("Product " + (allPrices.indexOf(element) + 1) + " price is: " + element.getText());
//            price_product.add(element.getText());
//        }
//        List<Double> numbers = new ArrayList<>();
//        for (int i = 0; i < price_product.size(); i++) {
//            double current = Double.parseDouble(price_product.get(i).substring(1));
//            numbers.add(current);
//        }
//
//        System.out.println("ALL PRICES :" + numbers);
//        List<Double> highest_price = new ArrayList<>();
//        highest_price.add(Collections.max(numbers));
//        System.out.println("HIGHEST PRICE : " + highest_price);


        }
    }
}


//List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='price product-price']"));
//        allPrices.removeIf(element -> !element.getText().contains("$"));



