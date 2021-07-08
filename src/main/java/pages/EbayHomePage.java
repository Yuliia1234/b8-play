package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomePage {

    public EbayHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy (xpath = "//input[@class='gh-tb ui-autocomplete-input']")
    WebElement searchbox;

    public void search(String text) {
        searchbox.sendKeys(text);
        searchbox.sendKeys(Keys.RETURN);


    }
}
