package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    public static void switchByURL(WebDriver driver, String targetUrl) {

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            String currentUrl = driver.getCurrentUrl();

            if (!currentUrl.equals(targetUrl)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String targetTitle) {

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            String currentTitle = driver.getTitle();

            if (!currentTitle.equals(targetTitle)) {
                driver.switchTo().window(id);
            }
        }
    }
    public static void closeWindow(WebDriver driver, String mainWindow) {

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {

            if (!id.equals(mainWindow)) {
                driver.switchTo().window(id);
                driver.close();
            }

        }
    }
    public static void takeScreenShot(WebDriver driver){

        File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String currentLocation =System.getProperty("user.dir")+"/src/main/java/ScreenShots/";//current prodject location
        try {

        FileUtils.copyFile(screenShot,new File(currentLocation+System.currentTimeMillis()+ ".png"));
        } catch (IOException e) {
            System.out.println("The screenshot was not taken");
            e.printStackTrace();
        }
    }
}
