package com.test.pages;

import com.qa.utils.CommonMethodsSelenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DataTablePage extends CommonMethodsSelenium {
    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(DataTablePage.class);
    // Declare Page Objects here

    private By tableRow= By.xpath("//input[@id='txtPassword']");
    private By tableColumn= By.xpath("//input[@id='txtUsername']");
    private By tableName= By.id("example");

    public DataTablePage(WebDriver driver){
        this.driver=driver;

    }
    public void launchDataTableSite(String dataTablePageLink) {
        try{
            driver.get(dataTablePageLink);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public boolean verifyTableName(){
       boolean  flagCheck=false;
        waitStatementMethod(driver,tableName);
        try{
          WebElement tableName= driver.findElement(By.id("example"));
          if(tableName.isDisplayed()){
              flagCheck=true;
          }
        }catch(NoSuchElementException elementException){
            elementException.printStackTrace();
            LOGGER.warn("Exception in Data Table element Identification");
        }
        return flagCheck;
    }
    public void testHeader(){
        try{
            WebElement tableHeader= driver.findElement(By.xpath("//table[@id='example']/thead//th[1]"));
            if(tableHeader.isDisplayed()){
                LOGGER.info("DATA HEADER PASS");
            }
        }catch(NoSuchElementException elementException){
            elementException.printStackTrace();
            LOGGER.error("Exception in Data Table HEADER Identification");
        }
    }
}
