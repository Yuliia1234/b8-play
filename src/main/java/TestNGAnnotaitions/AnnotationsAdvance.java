package TestNGAnnotaitions;

import org.testng.annotations.*;

public class AnnotationsAdvance {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }


    @Test
    public void test1() {
        System.out.println("Test-1");

    }

    @Test
    public void test2() {
        System.out.println("Test-2");
    }

    @AfterMethod
    public void afterMethos() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
}
