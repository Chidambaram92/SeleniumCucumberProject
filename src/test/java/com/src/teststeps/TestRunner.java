package com.src.teststeps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/feature"},
		glue = {"com/src/teststeps"},
		plugin = {"pretty","html:target/cucumber-output/report.html", "json:target/cucumber-output2/report.json"},
		monochrome= true,
		//tags="@HomeTest or @SearchTest or @OrangeTest"
		tags="@DataTable or @OrangeTest2"
		)

public class TestRunner {

}
