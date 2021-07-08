package com.test.Sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnPage {

    public OnPage(WebDriver driver) {
        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath = "//a[@title='Departments']")
    WebElement department_button;

    @FindBy(xpath = "//a[@title='Gender']")
    WebElement gender;

    @FindBy(id = "86")
    WebElement genderSelection;

    public void clickDepartment() {
        department_button.click();
    }

    public void clickGender() {
        gender.click();
    }

    public String getSelectedOption() {

        return genderSelection.getAttribute("class");
    }
}
