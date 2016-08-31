package com.ionidea.RegressionNGA.Tests.pages;

import com.ionidea.RegressionNGA.Tests.TestNgTestBase;
import com.ionidea.RegressionNGA.Tests.util.IConfiguration;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page{

    protected WebDriver driver;

    IConfiguration m_config;
    protected static String m_gridHubUrl;
    protected static String m_baseUrl;
    protected static String m_ngaUserLogin;
    protected static String m_ngaUserPassword;
    protected static int m_standartWaitTime;
    public String pageUrl;
    

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void initialize(IConfiguration configuration) {

        m_config = configuration;

        try {
            m_baseUrl = m_config.getProperty("site.url");
            m_gridHubUrl = m_config.getProperty("grid.url");
            m_ngaUserLogin = m_config.getProperty("ngaUserLogin");
            m_ngaUserPassword = m_config.getProperty("ngaUserPassword");
            m_standartWaitTime = Integer.valueOf(m_config.getProperty("standartWaitTime"));
        } catch (IOException ex) {
            Logger.getLogger(TestNgTestBase.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }
     
    public String getUrl(){
        return this.pageUrl;
    }
    
        //action perfoms manual selection of the main menu
    public void selectMenuOption(WebElement menuIndex, WebElement subMenuIndex){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        Actions action = new Actions(driver);
        action.moveToElement(menuIndex);
        action.build().perform();
        wait.until(ExpectedConditions.visibilityOf(subMenuIndex));
        action.moveToElement(subMenuIndex);        
        action.click().perform();
    }

 

}
