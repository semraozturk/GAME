package com.automation.stepDefinitions;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.Arrays;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ImpersonatedCredentials;
import com.google.cloud.bigquery.*;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ImpersonatedCredentials;

import javax.security.auth.login.Configuration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        //Driver.getDriver().get(ConfigurationReader.getProperty("application.url"));
        //Driver.getDriver().manage().window().maximize();
        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        //Driver.closeDriver();
        
        String projectId = "imposing-timer-420716";
        String impersonatedServiceAccount = "automation@imposing-timer-420716.iam.gserviceaccount.com";
        GoogleCredentials googleCredentials = GoogleCredentials.getApplicationDefault();
        BigQuery bigquery = BigQueryOptions.newBuilder().setCredentials(googleCredentials).setProjectId(projectId).build().getService();
        System.out.println("after big query");

    }


}
