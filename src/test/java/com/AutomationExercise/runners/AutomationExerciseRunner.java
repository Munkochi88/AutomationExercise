package com.AutomationExercise.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/AutomationExercise",
        glue = "com/AutomationExercise/stepDefinitions",
        dryRun = false,
        tags = "@regression2",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class AutomationExerciseRunner {
}
