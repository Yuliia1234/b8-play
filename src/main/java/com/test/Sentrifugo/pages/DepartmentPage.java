package com.test.Sentrifugo.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DepartmentPage {


    public DepartmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;

    @FindBy(id = "deptname")
    WebElement departmentName;

    @FindBy(id="deptcode")
    WebElement departmentCode;

    @FindBy(id="submitbutton")
    WebElement saveButton;

    @FindBy(className = "ml-alert-1-success")
    WebElement successMessage;

    public void sendDepartmentDetails(String deptName, String deptCode){
        departmentName.sendKeys(deptName);
        departmentCode.sendKeys(deptCode);
    }

    public String getSuccessMessage(){
        return successMessage.getText().trim();
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public void clickAddButton(){
        addButton.click();
    }
}