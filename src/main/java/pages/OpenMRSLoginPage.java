package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMRSLoginPage {

    public OpenMRSLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy (id = "password")
    public WebElement passwordField;

    @FindBy(id = "Pharmacy")
    public WebElement location;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    public void login (String username,String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        location.click();
        loginButton.click();
    }


}


