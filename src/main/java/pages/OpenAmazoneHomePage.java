package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpenAmazoneHomePage {

    public OpenAmazoneHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement seleniumText;

    @FindBy(xpath ="//span[@class='a-size-medium a-color-base a-text-normal']" )
    public List<WebElement> itemList;



    public void search(String text){
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.RETURN);

    }
    public boolean validateAmazoneMassage(String expectedMassage) {
        return seleniumText.getText().trim().equalsIgnoreCase(expectedMassage);
    }

    public boolean checkItemNumber(int expectedm){
        return itemList.size() > expectedm;
    }
}
