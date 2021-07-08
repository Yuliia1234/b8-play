package TestNGAnnotaitions;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
    @DataProvider(name = "names")
    public Object[][] getData() {
        return new Object[][]{
                {"Kushal", "Patel", "Kushal Patel"},
                {"Gaj", "Ravi", "Gaj Ravi"},
                {"Peter", "Pen", "Peter Pen"}
        };
    }

    @Test(dataProvider = "names")//value of test should be the same as value for Data Provider
    public void validateContact(String first,String last,String full) {

        String fName = first;
        String lName = last;
        String fullName = fName + " " + lName;
        Assert.assertEquals(fullName, full);
    }
}
