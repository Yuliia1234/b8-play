package TestNGAnnotaitions;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrPractice {

    @Parameters("school")

    @Test
    public void test1(String sname){
        System.out.println(sname);
    }
    @Test
    public void test2(){
        System.out.println("Academy");
    }
    @Test
    public void test3(){
        System.out.println("Selenium");


    }

}
