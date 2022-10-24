package com.src.teststeps;



import java.time.Duration;
import java.util.List;

import com.test.pages.DataTablePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utils.CommonMethodsSelenium;
import com.qa.utils.LoadExcelData;
import com.test.pages.HomePageOrange;
import com.test.pages.LoginOrange;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPageOrangeSteps {
	private final WebDriver driver= CommonMethodsSelenium.getDriver();
	LoginOrange loginPageOrange=new LoginOrange(driver);
	HomePageOrange homeOrange= new HomePageOrange(driver);
	private static final Logger LOGGER = LogManager.getLogger(LoginPageOrangeSteps.class);


	@And("user navigates to orange site launch page")
	public void userGetsDataLoginPage() {
		String browserName = ApplicationHooks.prop.getProperty("orangePageURL");
		loginPageOrange.launchSite(browserName);
		LOGGER.info("Orange site launch is done");

	}

	@When("verify if orange site home page is navigated")
	public void verificationOfLoginPage(){
		String userName = ApplicationHooks.prop.getProperty("orangeUser");
		String passWord = ApplicationHooks.prop.getProperty("orangePassword");
		Assert.assertTrue(loginPageOrange.enterLoginCredentials(userName, passWord));
		LOGGER.info("Orange site home page is navigated");
	}
	@And("click on PIM link present in the home page")
	public void userGetPiPage() {
		homeOrange.clickLinkDashboard();
	}
	@And("I verify the tabs present in Home page")
	public void returnTabsSelection(DataTable testData) {
		List<String> categoryList = testData.asList();
		System.out.println("Expected accounts section list: " + categoryList);
		List<String> applicationCategoryList = homeOrange.getCategorySectionsList();
		LOGGER.info("Actual accounts section list in Application is: " + applicationCategoryList);

	}
	@And("load excel test data with testid {string} testcase name {string} and browser {string}")
	public void loadExcelData(String id,String name, String browser) {
		homeOrange.validateExcelSheet(id,name,browser);
	}

}
