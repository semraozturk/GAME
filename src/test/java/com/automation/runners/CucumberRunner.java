package com.automation.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json"
        },
        features= "src/test/resources/Features",
        glue = "com/automation/stepDefinitions",
        dryRun = false,
        tags = " @test",
        publish = true
)

public class CucumberRunner {

}
