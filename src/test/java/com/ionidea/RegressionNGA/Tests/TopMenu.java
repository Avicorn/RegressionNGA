package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.Common.PageHeader;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Calendar of Events')]")
    private WebElement calendarHeader;    
    
//    @Test
//    public void testHomePageHasAHeader() throws NotImplementedException {
//        driver.get(m_baseUrl);
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        
//        System.out.println("top " + pageHeader.getMainMenuElement(0).findElement(By.tagName("a")).getText());
//        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(0, 0))));
//        System.out.println("items " + pageHeader.getMainMenuElement(0, 0).getText());
//        
//        pageHeader.getMainMenuElement(1).click();
//        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
//        
//        pageHeader.getMainMenuElement(0, 0).click();
//        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
//        
//        Assert.assertTrue("Highlights".equals(driver.getTitle()));
//        Assert.assertTrue(driver.getPageSource().contains("Highlights"));
//        
//        pageHeader.getMainMenuElement("Collection", "Highlights").click();
//        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
//        
//        Assert.assertTrue("Highlights".equals(driver.getTitle()));
//        Assert.assertTrue(driver.getPageSource().contains("Highlights"));
//    }
    
    /*
        1. Open landing page
        2. Compare target menuitem text with expected one.
        3. Try to click on it in two ways, by in menu name and by order number
        This helps to make sure menu order is fine.
        4. Compare Title, URL and <H2> value on new page with desired 
        This helps to make sure menuitem linked to correct page.
    
        In case any of above fails - all test is failed.
    */
    
    // Collection menu group
    @Test
    public void menuGroupCollection() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(0))));
        Assert.assertEquals(pageHeader.getMainMenuElement(0).findElement(By.tagName("a")).getText(), "Collection");
        
        pageHeader.getMainMenuElement(0).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("The Collection".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/Collection.html".equals(driver.getCurrentUrl()));
        Assert.assertTrue("The Collection".equals(driver.findElement(By.tagName("h2")).getText()));
    }
    
    @Test
    public void menuGroupCollectionHighlights() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(0,0))));
        Assert.assertEquals(pageHeader.getMainMenuElement(0,0).findElement(By.tagName("a")).getText(), "Highlights");
        
        pageHeader.getMainMenuElement(0,0).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Highlights".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/Collection/highlights.html".equals(driver.getCurrentUrl()));
        Assert.assertTrue("Highlights".equals(driver.findElement(By.tagName("h2")).getText()));
    }    

    @Test
    public void menuGroupCollectionArtists() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(0,1))));
        Assert.assertEquals(pageHeader.getMainMenuElement(0,1).findElement(By.tagName("a")).getText(), "Artists");
        
        pageHeader.getMainMenuElement(0,1).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("artists".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/Collection/artists.html".equals(driver.getCurrentUrl()));
        Assert.assertTrue("ARTISTS".equals(driver.findElement(By.tagName("h2")).getText()));
    }
    
    // Exhibitions menu group
    @Test
    public void menuGroupExhibitions() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(1))));
        Assert.assertEquals(pageHeader.getMainMenuElement(1).findElement(By.tagName("a")).getText(), "Exhibitions");
        
        pageHeader.getMainMenuElement(1).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Exhibitions".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/exhibitions.html".equals(driver.getCurrentUrl()));
        Assert.assertTrue("Current Exhibitions".equals(driver.findElement(By.tagName("h2")).getText()));
    }
    
    @Test
    public void menuGroupEducation() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(2))));
        Assert.assertEquals(pageHeader.getMainMenuElement(2).findElement(By.tagName("a")).getText(), "Education");
        
        pageHeader.getMainMenuElement(2).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Education".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/education.html".equals(driver.getCurrentUrl()));
        Assert.assertTrue("Education".equals(driver.findElement(By.tagName("h2")).getText()));
    }
    
    @Test
    public void menuGroupConservation() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(3))));
        Assert.assertEquals(pageHeader.getMainMenuElement(3).findElement(By.tagName("a")).getText(), "Conservation");
        
        pageHeader.getMainMenuElement(3).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Conservation".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/conservation.html".equals(driver.getCurrentUrl()));
        Assert.assertTrue("Conservation".equals(driver.findElement(By.tagName("h2")).getText()));
    }
    
    @Test
    public void menuGroupResearch() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(4))));
        Assert.assertEquals(pageHeader.getMainMenuElement(4).findElement(By.tagName("a")).getText(), "Research");
        
        pageHeader.getMainMenuElement(4).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Research".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/research.html".equals(driver.getCurrentUrl()));
        Assert.assertTrue("Research".equals(driver.findElement(By.tagName("h2")).getText()));
    }
    
    @Test
    public void menuGroupCalendar() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(5))));
        Assert.assertEquals(pageHeader.getMainMenuElement(5).findElement(By.tagName("a")).getText(), "Calendar");
        
        pageHeader.getMainMenuElement(5).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Calendar".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/calendar.html".equals(driver.getCurrentUrl()));
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(calendarHeader.isDisplayed());
    }
    
    @Test
    public void menuGroupVisit() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(6))));
        Assert.assertEquals(pageHeader.getMainMenuElement(6).findElement(By.tagName("a")).getText(), "Visit");
        
        pageHeader.getMainMenuElement(6).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Visit".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/visit.html".equals(driver.getCurrentUrl()));
        Assert.assertTrue("Visit".equals(driver.findElement(By.tagName("h2")).getText()));
    }      
    
    @Test
    public void menuGroupSupport() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(7))));
        Assert.assertEquals(pageHeader.getMainMenuElement(7).findElement(By.tagName("a")).getText(), "Support");
        
        pageHeader.getMainMenuElement(7).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("Support Us".equals(driver.getTitle()));
        Assert.assertTrue("http://www.nga.gov/content/ngaweb/support.html".equals(driver.getCurrentUrl()));
        Assert.assertTrue("Support Us".equals(driver.findElement(By.tagName("h2")).getText()));
    }
    
    @Test
    public void menuGroupShop() throws NotImplementedException {
        driver.get(m_baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pageHeader.getMainMenuElement(8))));
        Assert.assertEquals(pageHeader.getMainMenuElement(8).findElement(By.tagName("a")).getText(), "Shop");
        
        pageHeader.getMainMenuElement(8).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Connecting...")));
        
        Assert.assertTrue("National Gallery of Art Shops | Fine Museum Gifts | shop.nga.gov".equals(driver.getTitle()));
        Assert.assertTrue("https://shop.nga.gov/".equals(driver.getCurrentUrl()));
        //Assert.assertTrue("Support Us".equals(driver.findElement(By.tagName("h2")).getText()));
    }    
}
