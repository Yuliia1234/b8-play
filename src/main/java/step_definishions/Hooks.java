package step_definishions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setup(){
        System.out.println("Executing before hook form Cucumber");
    }
    @After
    public void teardown(){
        System.out.println("Executing after hook from Cucumber");
    }

}
