package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utils.CommonMethodsSelenium;

public class EmployeePage extends CommonMethodsSelenium {
	private WebDriver driver;
	private By employeeName = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
	private By searchButton= By.xpath("//div[@class='oxd-form-actions']//button[text()[normalize-space() = 'Search']]");
	private By employeeId = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']");
	public EmployeePage(WebDriver driver) {
		this.driver=driver;
	}

}
