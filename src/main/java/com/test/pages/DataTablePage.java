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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataTablePage extends CommonMethodsSelenium {
    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(DataTablePage.class);
    // Declare Page Objects here
    private By tableColumn= By.xpath("//input[@id='txtUsername']");
    private By tableName= By.id("example");

    public DataTablePage(WebDriver driver){
        this.driver=driver;

    }
    public void launchDataTableSite(String dataTablePageLink) {
        try{
            driver.get(dataTablePageLink);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            LOGGER.info("Able to launch Site successfully");
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
    public boolean verifyTableIteration(){
        boolean  flagCheck=false;
        try{
            WebElement tableName= driver.findElement(By.id("example"));
            List<WebElement> rows=tableName.findElements(By.tagName("tr"));
           // List<WebElement> rows=tableName.findElements(By.xpath("//table[@id='example']/tbody/tr"));
            for(int rowNum=0;rowNum<rows.size();rowNum++){
               // List<WebElement>columns=rows.get(rowNum).findElements(By.tagName("td"));
                List<WebElement>columns=rows.get(rowNum).findElements(By.xpath("(//table[@id='example']/tbody/tr)['" +rowNum+ "']/td"));
                System.out.println("Number of columns:"+columns.size());
                for(int colNum=0;colNum<columns.size();colNum++){
                   System.out.println("Column Value: "+columns.get(colNum).getText());

                }
            }
            if(tableName.isDisplayed()){
                flagCheck=true;
            }
        }catch(NoSuchElementException elementException){
            elementException.printStackTrace();
            LOGGER.warn("Exception in Data Table element Identification");
        }
        return flagCheck;
    }
}
