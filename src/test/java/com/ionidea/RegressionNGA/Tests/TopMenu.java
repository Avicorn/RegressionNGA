package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.Common.PageHeader;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Avicorn
 */
public class TopMenu extends TestNgTestBase {
    
    private PageHeader pageHeader;

    
    @BeforeMethod
    public void initPageObjects() {
        pageHeader = PageFactory.initElements(driver, PageHeader.class);
    }

    @Test
    public void testHomePageHasAHeader() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
//        System.out.println("top " + pageHeader.getMainMenuElement(0).findElement(By.tagName("a")).getText());
//        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(0, 0))));
//        System.out.println("items " + pageHeader.getMainMenuElement(0, 0).getText());
        
        pageHeader.getMainMenuElement(1).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        pageHeader.getMainMenuElement(0, 0).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Highlights".equals(driver.getTitle()));
        Assert.assertTrue(driver.getPageSource().contains("Highlights"));
        
        pageHeader.getMainMenuElement("Collection", "Highlights").click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Highlights".equals(driver.getTitle()));
        Assert.assertTrue(driver.getPageSource().contains("Highlights"));
    }
}
