package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMRSHomePage {

    public OpenMRSHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h4")
    public WebElement welcomeMassage;


    public boolean validateWelcomeMassage(String expectedMassage){
        return welcomeMassage.getText().trim().equals(expectedMassage);

    }
}
