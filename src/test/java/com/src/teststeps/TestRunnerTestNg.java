package com.src.teststeps;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/feature"},
		glue = {"com/src/teststeps"},
		plugin = {"pretty","html:target/cucumber-html/report.html"},
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome= true,
		tags="@SearchTest or @OrangeTest"
		)
public class TestRunnerTestNg extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
