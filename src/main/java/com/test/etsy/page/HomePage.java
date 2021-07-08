package com.test.etsy.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search_query")
    WebElement searchBox;

    @FindBy(xpath = "//h3[contains(@class,'wt-mb-xs-0 wt-text-truncate wt-text-caption')]")
    List<WebElement> searchResult;

    public void searchValue(String value){
        searchBox.sendKeys(value);
        searchBox.sendKeys(Keys.RETURN);
    }

public  List<String> getSearchList(){
        List<String> allList=new ArrayList<>();
        for (WebElement result : searchResult){
            allList.add(result.getText().toLowerCase().trim());
        }
        return allList;
}

}
