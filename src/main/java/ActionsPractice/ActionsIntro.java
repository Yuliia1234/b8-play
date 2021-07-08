package ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class ActionsIntro {
    @Test
    public void validateRightClick() {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement menuBox = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(menuBox).perform();//right click
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement user1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));


    }

    @Test
    public void validateHoverOver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> names = driver.findElements(By.xpath("//h5"));

    //  for (WebElement name : names) {


        //    System.out.println(name.getText());
       // }

        List<WebElement> images = driver.findElements(By.xpath("//div/img"));

        Actions actions = new Actions(driver);
        for (int i = 0; i < images.size(); i++) {
            actions.moveToElement(images.get(i)).perform();
            System.out.println(names.get(i).getText());
        }

    }
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");

        List<WebElement> click = driver.findElements(By.xpath("//div[@class='ui-panel-content ui-widget-content']"));

       Actions hello = new Actions(driver);
        for (WebElement clicks:click){
          //  System.out.println(clicks.getText());
           // hello.doubleClick(clicks).perform();
            if (clicks.getText().equals("doubleclick")){
                hello.doubleClick(clicks).perform();

            }else if (clicks.getText().equals("click")){
                hello.click(clicks).perform();

            }


        }
    }
    @Test
    public void validateKeyActions(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement search = driver.findElement(By.name("q"));

        Actions actions = new Actions(driver);

        actions.moveToElement(search)
                .click(search)
                .keyDown(search, Keys.SHIFT)
                .sendKeys("Selenium")
                .keyUp(search,Keys.SHIFT)
                .doubleClick()
                .contextClick()//right click
                .perform();


        search.sendKeys(Keys.ARROW_DOWN);//final static
        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.ENTER);



    }
    @Test
    public void validateCopyPaste(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement search = driver.findElement(By.name("q"));

        Actions actions = new Actions(driver);

        actions.moveToElement(search).//moveToElement-hover over
                sendKeys("Selenuim")
                .doubleClick()
                .keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .click(search)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .doubleClick(search)
                .keyUp(Keys.COMMAND)//important to delete element
                .sendKeys(Keys.DELETE)
                .perform();
    }
}