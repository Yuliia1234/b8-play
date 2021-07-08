package OurProdject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Task4 {
    @Test
    public void test1() {
        String productValue = "ScreenSaver";
        String quantityValue = "5";
        String customerNameValue = "Techtorial Academy";
        String streetValue = "2200 E devon";
        String cityValue = "Des Plaines";
        String stateValue ="Illinois";
        String zipValue ="60018";
        String cardNrValue ="444993876233";
        String expirationDateValue ="03/21";


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement login_button = driver.findElement(By.id("ctl00_MainContent_login_button"));
        login_button.click();

        WebElement order_button = driver.findElement(By.xpath("//a[.='Order']"));
        order_button.click();

        WebElement Static_drop_down = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select drop_down = new Select(Static_drop_down);

        drop_down.selectByVisibleText("ScreenSaver");

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys(quantityValue);

        WebElement customer_name = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customer_name.sendKeys(customerNameValue);

        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys(streetValue);

        WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys(cityValue);

        WebElement state = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys(stateValue);

        WebElement zip_code = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zip_code.sendKeys(zipValue);

        WebElement typeOfCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
        typeOfCard.click();

        WebElement card_number = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        card_number.sendKeys(cardNrValue);

        WebElement expiration_date = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expiration_date.sendKeys(expirationDateValue);

        WebElement process_button = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        process_button.click();

        String text = driver.findElement(By.tagName("strong")).getText();

        Assert.assertEquals(text, "New order has been successfully added.");

        WebElement view_all_orders = driver.findElement(By.xpath("//ul[@id='ctl00_menu']//a"));
        view_all_orders.click();

        List<WebElement> newOrder = driver.findElements(By.xpath("//tbody//tr[2] //td"));

        String[] expectedValues = {null,customerNameValue,productValue,quantityValue,null,streetValue,cityValue,
                stateValue,zipValue,"MasterCard",cardNrValue,expirationDateValue,null};
        for(int i=0; i<newOrder.size(); i++){
            if(expectedValues[i] != null){
                Assert.assertEquals(newOrder.get(i).getText(), expectedValues[i]);
            }
        }

    }
}
