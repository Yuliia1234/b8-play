package Verification;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftPractice {
    @Test
    public void test1(){
        Assert.assertEquals(10,10);
        Assert.assertTrue("Test".equals("test"));
        System.out.println("Hard Assert");

        SoftAssert soft = new SoftAssert();
    }
    @Test
    public void test2(){
        SoftAssert soft = new SoftAssert();
       soft.assertEquals(10,10);
       soft.assertEquals("TEST","test","Validation of Text ");
        soft.assertTrue(12.5==12,"Validaion of numbers");
        soft.assertAll();//We use it at the end of the test annotation
        System.out.println("Soft Assert");
    }
}
