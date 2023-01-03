package com.src.teststeps;

import com.qa.utils.CommonMethodsSelenium;
import com.test.pages.DataTablePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DataTablesSteps {
    private final WebDriver driver= CommonMethodsSelenium.getDriver();
    DataTablePage dataTablePage = new DataTablePage(driver);
    private static final Logger LOGGER = LogManager.getLogger(DataTablesSteps.class);
    @And("user navigates to data table page site launch page")
    public void userGetsDataLoginPage() {
        String applicationUrl = ApplicationHooks.prop.getProperty("dataTablePageURL");
        dataTablePage.launchDataTableSite(applicationUrl);
        LOGGER.info("Data Table site launch is done");
    }
    @When("user verify if required {string} data table page is present")
    public void userVerifyDataTableIsPresent(String employeeTable) {
        if(dataTablePage.verifyTableName()){
            LOGGER.info("Data Table: " +employeeTable+ " is displayed in Web site");
            dataTablePage.testHeader();
        }else{
      LOGGER.error("Data Table: " +employeeTable+ " is not displayed in Web site");
        }

    }

  @When("user verify if able iterate through tables as expected")
  public void userVerifyDataTableIterationIsFeasible() {
    if (dataTablePage.verifyTableIteration()) {
      LOGGER.info("Data Table: able iterate through Employee table");
    } else {
      LOGGER.error("Data Table: not able iterate through Employee table");
    }
        }
}
