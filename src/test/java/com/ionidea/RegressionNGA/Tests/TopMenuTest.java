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
        pageHeader.initialize(m_config);
        
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
            System.out.println(e.getCause());
        }
        Assert.assertEquals(driver.getTitle(), targetPageTitle);
    }
    
     /**
     * the method verifies that the opened page is respective to the used sub menu option
     * @param  
     * @param int menuGroup
     * @param int menuItem
     * @param String menuItemText
     * @param String targetPageURL
     * @param String targetPageTitle
     * @param String targetPageText
     * @param Boolean isNGAPage
     * 
     * 
        Opens landing page
        Compares target menu item text with expected one.
        Tries to click on it by index. This should help to make sure menu order is fine.
        Compares Title, URL and some text value on page with desired. This should help to make sure menu item is linked to the correct page.
    
        In case any of the above fails - test is considered failed.
    */    
    
    // Menu groups
    
    @Parameters(value = { "menuGroup", "menuItem", "menuItemText", "targetPageURL", "targetPageTitle", "targetPageText", "isNGAPage" })
    @Test
    
    public void menuGroups(int menuGroup, int menuItem, String menuItemText, String targetPageURL, String targetPageTitle, String targetPageText, Boolean isNGAPage) throws NotImplementedException{
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
            System.out.println(e.getCause());
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
            System.out.println(e.getCause());
        }
        Assert.assertEquals(driver.getTitle(), targetPageTitle, "Target page title");
        
        //Dirty hack to make sure page header will be loaded at least. Does not work for nonNGA pages though, so needs another dirty hack to speed up tests on nonNGA pages
        
        if (isNGAPage){
            try {
                //System.out.println("is www.nga.gov page");
                m_wait.until(ExpectedConditions.elementToBeClickable(pageHeader.ngaHomeLink));
            } catch (TimeoutException e) {
                System.out.println(e.getCause());
            }
        }
        Assert.assertTrue(driver.getPageSource().contains(targetPageText), "Text \"" + targetPageText +"\" to be present on target page" );
    }
}
