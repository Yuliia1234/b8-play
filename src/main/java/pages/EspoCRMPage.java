package pages;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class EspoCRMPage {


    public EspoCRMPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    @FindBy(xpath = "//button[@id='btn-login']")
    WebElement loginButton;

    @FindBy(xpath = "/li/@data-name")
    List<WebElement> optionsList;


    @FindBy(xpath = "//span[.='Accounts']")
    WebElement account;

    @FindBy(xpath = "//a[@class='btn btn-default action']")
    WebElement createAccount;

    @FindBy(xpath = "//div[@data-name='name']//input")
    public WebElement name;

    @FindBy(xpath = "//div[@class='input-group email-address-block']//input")
    public WebElement email;

    @FindBy(xpath = "//button[@class='btn btn-primary action']")
    public WebElement save;


    public void createNewAccount(){
        wait.until(ExpectedConditions.visibilityOf(createAccount));
        createAccount.click();
    }

    public void navigateToAccount(){
        wait.until(ExpectedConditions.visibilityOf(account));
        account.click();
    }

    public void login(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();

    }
    public List<String>  getTextFronOptions(){
        List <String> fun = new ArrayList<>();
        for (WebElement options: optionsList) {
          fun.add(options.getText().trim());


        }return fun;
    }

    public void clickSave(){
        save.click();
    }
}
