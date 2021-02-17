package com.automation.stepDefinitions;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import javax.security.auth.login.Configuration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("application.url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }


}
