package com.test.Sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.XpiDriverService;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenderPage {

    public GenderPage(WebDriver driver){
        PageFactory.initElements(driver,this);


    }
    @FindBy(xpath = "//tr[@class='row1']//a[last()]")
    WebElement deleteButton;

    @FindBy (id = "popup_ok")
    WebElement okayButton;

    @FindBy (id = "messageData")
    WebElement successMassage;

    public void clickDeleteButton(){
        deleteButton.click();
    }
    public void clickOkayButton(){
        okayButton.click();
    }

    public String getsucessMassage(){
      return successMassage.getText().trim();

    }
}
