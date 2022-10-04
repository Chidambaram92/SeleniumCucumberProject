package com.test.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.qa.utils.CommonMethodsSelenium;

public class HomePage extends CommonMethodsSelenium{
	private final WebDriver driver;

	// Declare Page Objects here
	private final By siteLogo= By.xpath("//img[@class='logo img-responsive']");
	private final By contactUsLink= By.xpath("//a[text()='Contact us']");
	private final By signInLink= By.linkText("Sign in");
	private final By searchText= By.xpath("//input[@name='search_query']");
	private final By headerText= By.xpath("//span[contains(text(),'Dresses')]");
	

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	// Declare Page specific methods
	public void navigateToHomePage(String homePagelink) {
		driver.get(homePagelink);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public boolean verifyHomePageLoad() {

		boolean flagValue= false;
		waitStatementMethod(driver, siteLogo);
		waitStatementMethod(driver, contactUsLink);
		WebElement searchBox= driver.findElement(contactUsLink);
		if(searchBox.isDisplayed()) {
			flagValue= true;
		}
		return flagValue;
	}

	public boolean enterSearchText(String searchValue) {
		boolean flagValue = false;
		waitStatementMethod(driver, searchText);
		WebElement searchBox= driver.findElement(searchText);
		// Enter search text
		searchBox.sendKeys(searchValue);
		searchBox.sendKeys(Keys.ENTER);
		System.out.println("Print search value: "+searchValue);
		// Navigated to search Page
		waitStatementMethod(driver, headerText);
		if(driver.getTitle().contains("Dresses")) {
			flagValue= true;
		}
		return flagValue;

	}
	
}
