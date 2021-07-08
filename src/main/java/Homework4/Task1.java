package Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Task1 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void task1() {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        WebElement circle = driver.findElement(By.id("draggable"));
        String expected = "(Drop here)";
        Actions actions = new Actions(driver);

        actions.clickAndHold(circle).moveByOffset(10, 0).perform();

        WebElement blue_box = driver.findElement(By.xpath("//div[@class = 'test1']"));
        Assert.assertEquals(blue_box.getText(), expected);

        WebElement orange_box = driver.findElement(By.xpath("//div[@class = 'test2']"));
        Assert.assertEquals(orange_box.getText(), expected);


    }

    @Test
    public void task2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(1000);

        WebElement circle = driver.findElement(By.id("draggable"));
        WebElement blue_box = driver.findElement(By.xpath("//div[@class = 'test1']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(circle).moveToElement(blue_box).perform();

        WebElement blue_box_result = driver.findElement(By.xpath("//div[@class = 'test1']"));
        Assert.assertEquals(blue_box_result.getText(), "Now you can drop it.");

        WebElement orange_box = driver.findElement(By.xpath("//div[@class = 'test2']"));
        Assert.assertEquals(orange_box.getText(), "(Drop here)");
    }

    @Test
    public void task3() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(1000);

        WebElement circle = driver.findElement(By.id("draggable"));
        WebElement orange_box = driver.findElement(By.xpath("//div[@class = 'test2']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(circle).moveToElement(orange_box).perform();

        WebElement orange_box_result = driver.findElement(By.xpath("//div[@class = 'test2']"));
        Assert.assertEquals(orange_box_result.getText(), "Now you can drop it.");

        WebElement blue_box = driver.findElement(By.xpath("//div[@class = 'test1']"));
        Assert.assertEquals(blue_box.getText(), "(Drop here)");

    }

    @Test
    public void task4() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement button_5000 = driver.findElement(By.xpath("//li[@id='fourth']/a"));
        WebElement second_button_5000 = driver.findElement(By.xpath("//li[@id='fourth'][2]"));
        WebElement bank_button = driver.findElement(By.xpath("//li[@id='credit2']/a"));
        WebElement sales_button = driver.findElement(By.xpath("//li[@id='credit1']/a"));
        WebElement button_minus=driver.findElement(By.id("credit0"));

        WebElement debit_amount = driver.findElement(By.id("amt7"));
        WebElement credit_amount = driver.findElement(By.id("amt8"));

        WebElement DebitMovement = driver.findElement(By.id("t7"));
        WebElement CreditMovement = driver.findElement(By.id("t8"));
        WebElement DebitSideAccount = driver.findElement(By.xpath("//ol[@class='field14 ui-droppable ui-sortable']//li"));
        WebElement CreditSideAccount = driver.findElement(By.id("loan"));


        Actions actions = new Actions(driver);
       actions.clickAndHold(button_minus).moveByOffset(10,0).perform();
        WebElement text = driver.findElement(By.xpath("//div[contains(text(),'Please select another block')]"));
       Assert.assertEquals(text.getText(),"Please select another block");
        //Drag and drop first 5000 to Debit side Amount
        actions.dragAndDrop(button_5000, debit_amount).perform();
        //Validate "Debit Movement 5000 Credit Movement 0"
        Assert.assertEquals(DebitMovement.getText(), "5000");
        Assert.assertEquals(CreditMovement.getText(), "0");
        Thread.sleep(1000);
        //Drag and drop Second 5000 to Credit side Amount
        actions.dragAndDrop(second_button_5000, credit_amount).perform();
        //Validate "Debit Movement 5000 Credit Movement 5000"
        Assert.assertEquals(credit_amount.getText(), "5000");
        Assert.assertEquals(DebitMovement.getText(), "5000");

        Thread.sleep(1000);
        //Drag and drop the "BANK" Debit side Account
        actions.dragAndDrop(bank_button, DebitSideAccount).perform();
        WebElement ValidateBankAccount = driver.findElement(By.xpath("//ol[@id='bank']/li"));
        //Validate BANK is displayed
        Assert.assertEquals(ValidateBankAccount.getText(), "BANK");
       // Drag and drop the "SALES" Credit side Account
        actions.dragAndDrop(sales_button, CreditSideAccount).perform();
        WebElement ValidateCreditSideAccount = driver.findElement(By.xpath("//ol[@id='loan']/li"));
        //Validate SALES is displayed
        Assert.assertEquals(ValidateCreditSideAccount.getText(), "SALES");


    }
    @Test
    public void test5() throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2017/");

        WebElement facebook = driver.findElement(By.xpath("//a[.=' Click here for Facebook ']"));
        facebook.click();
        System.out.println(driver.getCurrentUrl());

        String mainId=driver.getWindowHandle();
        String url ="https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2Fseleniumeasy";
        BrowserUtils.switchByURL(driver,url);

                WebElement create_account = driver.findElement(By.xpath("//a[.='Create New Account']"));
                create_account.click();

                Thread.sleep(1000);
                WebElement first_name = driver.findElement(By.xpath("//div[@class='_5dbb']/input "));
                first_name.sendKeys("Techtorial");

                WebElement last_name = driver.findElement(By.xpath("//input[@name='lastname']"));
                last_name.sendKeys("Academy");

                WebElement phone_number = driver.findElement(By.name("reg_email__"));
                phone_number.sendKeys("2223334455");

                WebElement password = driver.findElement(By.xpath("//input[@id='password_step_input']"));
                password.sendKeys("techtorial123");


             List <WebElement> dropDown = driver.findElements(By.xpath("//span[@data-name='birthday_wrapper']"));

               WebElement mount = driver.findElement(By.xpath("//select[@id='month']"));
                Select select = new Select(mount);
                select.selectByVisibleText("Apr");
                WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
                Select select1 = new Select(day);
                select1.selectByValue("20");
                WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
                Select select2 = new Select(year);
                select2.selectByVisibleText("2020");

                WebElement radio_button =driver.findElement(By.xpath("//input[@value=-1]"));
                radio_button.click();

        String targettitle = "http://seleniumpractise.blogspot.com/2017/";
        BrowserUtils.switchByTitle(driver,targettitle);
        System.out.println(driver.getTitle());

        BrowserUtils.closeWindow(driver,mainId);

            }
        }


