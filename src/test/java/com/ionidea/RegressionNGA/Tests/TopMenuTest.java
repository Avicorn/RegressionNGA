package com.ionidea.RegressionNGA.Tests;

import static com.ionidea.RegressionNGA.Tests.TestNgTestBase.m_wait;
import com.ionidea.RegressionNGA.Tests.pages.Common.PageHeader;
import com.ionidea.RegressionNGA.Tests.util.GlobalCommonModule;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Avicorn
 */
@Guice(modules = GlobalCommonModule.class)
public class TopMenuTest extends TestNgTestBase {
    
    private PageHeader pageHeader;
    
  
    @BeforeMethod
    public void initPageObjects() {
        pageHeader = PageFactory.initElements(driver, PageHeader.class);
        pageHeader.Initialize(m_config);
        
        PageFactory.initElements(driver, this);
    }

    // NGA Home
    @Test
    public void ngaHomeLink() throws NotImplementedException {
        String targetPageTitle = "National Gallery of Art";
        driver.get(m_baseUrl);
        Assert.assertEquals("National Gallery of Art", pageHeader.ngaHomeLink.getText());
        pageHeader.ngaHomeLink.click();
           
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.nga.gov/content/ngaweb.html");
        try {
            m_wait.until(ExpectedConditions.titleIs(targetPageTitle));
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(driver.getTitle(), targetPageTitle);
    }
    
     /*
        1. Open landing page
        2. Compare target menuitem text with expected one.
        3. Try to click on it index
        This helps to make sure menu order is fine.
        4. Compare Title, URL and <H2> value on new page with desired 
        This helps to make sure menuitem linked to correct page.
    
        In case any of above fails - test is considered failed.
    */    
    
    // Menu groups
    
    @Parameters(value = { "menuGroup", "menuItem", "menuItemText", "targetPageURL", "targetPageTitle", "targetPageText" })
    @Test(threadPoolSize = 2, invocationCount = 1, invocationTimeOut = 60000)
    
    public void menuGroups(int menuGroup, int menuItem, String menuItemText, String targetPageURL, String targetPageTitle, String targetPageText) throws NotImplementedException{
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement;
        if (menuItem == -1){
            liElement = pageHeader.getMainMenuElement(menuGroup);
        }else{
            liElement = pageHeader.getMainMenuElement(menuGroup, menuItem);
        }
        
        WebElement aElement = liElement.findElement(By.tagName("a"));
        //wait for menu element text to be as expected 
        try {
            m_wait.until(ExpectedConditions.attributeToBe(aElement, "textContent", menuItemText));
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(m_driverExtension.getElementText(aElement), menuItemText, "Menu item text expected " + menuItemText);

        aElement.click();
        
        if (!targetPageURL.contains("nga.gov")){
            targetPageURL = m_baseUrl + targetPageURL;
        }
        
        Assert.assertEquals(driver.getCurrentUrl(), targetPageURL, "Target url");
        try {
            m_wait.until(ExpectedConditions.titleIs(targetPageTitle));
        } catch (TimeoutException e) {
        }
        Assert.assertEquals(driver.getTitle(), targetPageTitle, "Target page title");
        Assert.assertTrue(driver.getPageSource().contains(targetPageText), "Text \"" + targetPageText +"\" to be present on target page" );
    }
}
