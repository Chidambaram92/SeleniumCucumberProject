package com.test.pages;

import com.qa.utils.CommonMethodsSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DataTablePage extends CommonMethodsSelenium {
    private WebDriver driver;

    // Declare Page Objects here

    private By tableRow= By.xpath("//input[@id='txtPassword']");
    private By tableColumn= By.xpath("//input[@id='txtUsername']");
    private By tableName= By.id("example");

    public DataTablePage(WebDriver driver){
        this.driver=driver;

    }
    public void launchDataTableSite(String dataTablePageLink) {
        driver.get(dataTablePageLink);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        }
        return flagCheck;

    }
}
