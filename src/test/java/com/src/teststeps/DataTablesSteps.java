package com.src.teststeps;

import com.qa.utils.CommonMethodsSelenium;
import com.test.pages.DataTablePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DataTablesSteps {
    private final WebDriver driver= CommonMethodsSelenium.getDriver();
    DataTablePage dataTablePage = new DataTablePage(driver);

    @And("user navigates to data table page site launch page")
    public void userGetsDataLoginPage() {
        String browserName = ApplicationHooks.prop.getProperty("dataTablePageURL");
        dataTablePage.launchDataTableSite(browserName);
        System.out.println("Data Table site launch is done");
    }
    @When("user verify if required {string} data table page is present")
    public void userVerifyDataTableIsPresent(String employeeTable) {

        System.out.println("Data Table site launch is done");
    }
}
