package com.test.Sentrifugo.TestData;

import org.testng.annotations.DataProvider;

public class LoginCredentials {

    @DataProvider(name="credentials")
    public Object[][] getCredentials(){
        return new Object[][]{
                {"EM01", "test"},
                {"test","sentrifugo"},
                {"test","test"}
        };
    }

}
