package com.test.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.utils.CommonMethodsSelenium;

public class LoginOrange extends CommonMethodsSelenium {
	private final WebDriver driver;

	// Declare Page Objects here
	private final By loginUserName= By.xpath("//input[@name='username']");
	private final By loginPassword= By.xpath("//input[@name='password']");
	private final By loginButton= By.xpath("//button[text()[normalize-space() = 'Login']]");
 //example objects:
	//div[@class='oxd-table']//div[@class='oxd-table-row oxd-table-row--with-border']

	public LoginOrange(WebDriver driver) {
		this.driver=driver;
	}
	public void launchSite(String homePagelink) {
		driver.get(homePagelink);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	public boolean enterLoginCredentials(String userName, String password) {
		boolean flagValue = false;
		try {
			waitStatementMethod(driver, loginUserName);
			enterText(driver, loginUserName, userName);
			enterText(driver, loginPassword, password);
			clickElement(driver, loginButton);
			if(driver.getCurrentUrl().contains("orangehrmlive.com/web/index.php/pim/viewEmployeeList")) {
				flagValue= true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return flagValue;
	}
}
