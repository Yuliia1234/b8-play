package ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderPractice {
    @Test
    public void validateSlider() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider)
                .moveByOffset(50, 0)
                .release().perform();//click and hold moving element to the middle
        System.out.println("Slider Validation");


    }

    @Test
    public void validateSlider1() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement numberText = driver.findElement(By.xpath("range"));



        move_to_target(driver,slider,numberText,"3.5");

    }

    public void move_to_target(WebDriver driver,WebElement slider, WebElement numberText,String target) {



        Actions action = new Actions(driver);

        double db = Double.parseDouble(target);
        if (db >2.5){
            int xOffset=0;
            while (!target.equals(numberText.getText())){
                action.clickAndHold(slider).moveByOffset(10,0).perform();
                xOffset+=10;

            }

            }


        }



    }

