package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayResearchPage {

    public EbayResearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']")
    WebElement resultsNumber;


    public boolean compareResults(int expectedm) {
        int actuall = getResult();
        return actuall > expectedm;
    }

    public int getResult() {
        String resultText = resultsNumber.getText().trim();
        //360 results for java for dummies
        String[] resultArr = resultText.split(" ");
        // 360,results,for,java,for,dummies
        String result = resultArr[0];
        //360
        int finallResult = Integer.parseInt(result);
        return finallResult;
    }
}
