package com.orangehrmlive.opensourcedemo.runner.administrativemodule.job.workshifts;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        features = {"src\\test\\resources\\features.webui\\administrativemodule\\administrativemoduleworkshifts.feature"},
        glue = {"com.orangehrmlive.opensourcedemo.stepdefinition.administrativemodule.job.workshifts"},
        tags = "not @ignore"
)
public class WorkshiftsTest {
}