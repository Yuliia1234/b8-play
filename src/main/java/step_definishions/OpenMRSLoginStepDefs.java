package step_definishions;

import Utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.OpenMRSHomePage;
import pages.OpenMRSLoginPage;

import java.util.List;
import java.util.Map;

public class OpenMRSLoginStepDefs {

    private String username;
    private String password;
    private WebDriver driver;


    @Given("user has valid credentials")
    public void user_has_valid_credentials() {
      username = "admin";
      password="Admin123";

    }

    @Given("user is on OpenMRS login page")
    public void user_is_on_open_mrs_login_page() {
       driver= Driver.getDriver();
       driver.get("https://demo.openmrs.org/openmrs/login.htm");

    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        OpenMRSLoginPage openMRSLoginPage = new OpenMRSLoginPage(driver);
        openMRSLoginPage.login(username,password);
    }

    @Then("user sees welcome massage")
    public void user_sees_welcome_massage() {
        OpenMRSHomePage openMRSHomePage = new OpenMRSHomePage(driver);
        boolean validMassage = openMRSHomePage.validateWelcomeMassage("Logged in as Super User (admin) at Pharmacy.");
        Assert.assertTrue(validMassage);
    }

    @Given("I am logging in with credentials:")
    public void I_am_logging_in_with_credentials(DataTable dataTable) {
        List<Map<String, String>> mapList = dataTable.asMaps();
        Map<String, String> usernameMap = mapList.get(0);
        Map<String, String> passwordMap = mapList.get(0);
        Map<String, String> departmentMap = mapList.get(0);

        System.out.println("This is map list " +mapList);
        String usernameValue = usernameMap.get("username");
        String passwordValue = passwordMap.get("password");
        String departmentValue = departmentMap.get("department");
        driver= Driver.getDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        WebElement username =driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        WebElement department = driver.findElement(By.id(departmentValue));
        department.click();
        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();
        WebElement register = driver.findElement(By.xpath("//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']"));
        register.click();


    }

    @When("i register a new patient")
    public void i_register_a_new_patient(DataTable dataTable){
        List<String> example = dataTable.asList();
        int k = 1;
        for (int i = 0; i <example.size() ; i++) {

            if(example.get(i).equals("given name")){
                String givenName = example.get(i + 1);
                System.out.println(example.get(i + 1)+ "this is what we need ");
                WebElement given =driver.findElement(By.xpath("//input[@name='givenName']"));
                given.sendKeys(givenName);
                if(example.get(i).equals("")){

                }
            }
        }
        List<Map<String, String>> mapList = dataTable.asMaps();
        System.out.println("bla bla " + mapList);
        Map<String, String>  givenMap = mapList.get(0);
        Map<String, String> familyNamedMap = mapList.get(1);
        System.out.println("family name map " +familyNamedMap);
        String givenValue = givenMap.get("given name");
        String familyNameValue = familyNamedMap.get("family name");

        WebElement familyName = driver.findElement(By.xpath("//input[@name='familyName']"));

        familyName.sendKeys(familyNameValue);
        WebElement nextPage = driver.findElement(By.id("next-button"));
        nextPage.click();

        Map<String, String>  genderMap = mapList.get(0);
        String genderValue = genderMap.get(0);
        WebElement gender = driver.findElement(By.tagName("//option[.='Female']"));





    }
    @Then("i see conformation page has")
    public void i_see_conformation_page_has(DataTable dataTable){

    }


}
