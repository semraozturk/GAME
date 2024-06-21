package com.automation.stepDefinitions;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.Arrays;

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
        String scope = "https://www.googleapis.com/auth/cloud-platform";

        // The name of the privilege-bearing service account for whom the credential is created.
        String impersonatedServiceAccount = "automation@imposing-timer-420716.iam.gserviceaccount.com";

            // Construct the GoogleCredentials object which obtains the default configuration from your
            // working environment.
            GoogleCredentials googleCredentials = GoogleCredentials.getApplicationDefault();

            // delegates: The chained list of delegates required to grant the final accessToken.
            // For more information, see:
            // https://cloud.google.com/iam/docs/create-short-lived-credentials-direct#sa-credentials-permissions
            // Delegate is NOT USED here.
            List<String> delegates = null;

            // Create the impersonated credential.
            ImpersonatedCredentials impersonatedCredentials =
                    ImpersonatedCredentials.newBuilder()
                            .setSourceCredentials(googleCredentials)
                            .setTargetPrincipal(impersonatedServiceAccount)
                            .setScopes(Arrays.asList(scope))
                            .setLifetime(300)
                            .setDelegates(delegates)
                            .build();

            // Get the OAuth2 token.
            // Once you've obtained the OAuth2 token, you can use it to make an authenticated call.
            impersonatedCredentials.refresh();
            String accessToken = impersonatedCredentials.getAccessToken().getTokenValue();
            System.out.println("Generated access token." + accessToken);

        
    }


}
