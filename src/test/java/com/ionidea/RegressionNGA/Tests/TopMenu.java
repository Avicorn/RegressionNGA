package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.Common.PageHeader;
import com.ionidea.RegressionNGA.Tests.util.GlobalCommonModule;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Guice;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Avicorn
 */
@Guice(modules = GlobalCommonModule.class)
public class TopMenu extends TestNgTestBase {
    
    private PageHeader pageHeader;
    
  
    @BeforeMethod
    public void initPageObjects() {
        pageHeader = PageFactory.initElements(driver, PageHeader.class);
        pageHeader.Initialize(m_config);
        
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Calendar of Events')]")
    private WebElement calendarHeader;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'ARTISTS')]")
    private WebElement artists;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'About Learning Resources')]")
    private WebElement aboutLearningResources;
    
     /*
        1. Open landing page
        2. Compare target menuitem text with expected one.
        3. Try to click on it index
        This helps to make sure menu order is fine.
        4. Compare Title, URL and <H2> value on new page with desired 
        This helps to make sure menuitem linked to correct page.
    
        In case any of above fails - test is considered failed.
    */
    
    // Collection menu group
    @Test
    public void menuGroupCollection() throws NotImplementedException {
        driver.get(m_baseUrl);        
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(0);
        WebElement aElement = liElement.findElement(By.tagName("a"));
               
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Collection");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/Collection.html");
        Assert.assertEquals(driver.getTitle(),"The Collection");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "The Collection");
    }
    
    @Test
    public void menuGroupCollectionHighlights() throws NotImplementedException, InterruptedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(0,0);
        WebElement aElement = liElement.findElement(By.tagName("a"));

        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Highlights");

        aElement.click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/Collection/highlights.html");
        Assert.assertEquals(driver.getTitle(), "Highlights");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Highlights");
    }
  
    @Test
    public void menuGroupCollectionCollectionSearchs() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(0,1);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Search the Collection");

        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/Collection/collection-search.html");
        Assert.assertEquals(driver.getTitle(),"Collection Search");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Search the Collection");
    }

    @Test
    public void menuGroupCollectionArtists() throws NotImplementedException, InterruptedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(0,2);
        WebElement aElement = liElement.findElement(By.tagName("a"));
               
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Artists");
        
        aElement.click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/Collection/artists.html");
        Assert.assertEquals(driver.getTitle(),"Artists");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(artists.isDisplayed());
    }

    @Test
    public void menuGroupCollectionRecentAcquisitions() throws NotImplementedException, InterruptedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(0,3);
        WebElement aElement = liElement.findElement(By.tagName("a"));
               
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Recent Acquisitions");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/Collection/recent_acquisitions.html");
        Assert.assertEquals(driver.getTitle(),"Recent Acquisitions");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Recent Acquisitions");
    }
    
    // Exhibitions menu group
    @Test
    public void menuGroupExhibitions() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(1);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Exhibitions");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/exhibitions.html");
        Assert.assertEquals(driver.getTitle(),"Exhibitions");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Current Exhibitions");
    }
    
    @Test
    public void menuGroupExhibitionsCurrent() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(1,0);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Current");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/exhibitions/current.html");
        Assert.assertEquals(driver.getTitle(),"Current");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Current Exhibitions and Installations");
    }
  
    @Test
    public void menuGroupExhibitionsUpcoming() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(1,1);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Upcoming");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/exhibitions/upcoming.html");
        Assert.assertEquals(driver.getTitle(),"Upcoming");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Upcoming Exhibitions");
    }    

    @Test
    public void menuGroupExhibitionsOnTour() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(1,2);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "On Tour");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/exhibitions/ontour.html");
        Assert.assertEquals(driver.getTitle(),"On Tour");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Exhibitions On Tour");
    }     

    @Test
    public void menuGroupExhibitionsPast() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(1,3);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Past");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/exhibitions/past.html");
        Assert.assertEquals(driver.getTitle(),"Past");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Past Exhibitions");
    }    
    
    // Education menu group
    @Test
    public void menuGroupEducation() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(2);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Education");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/education.html");
        Assert.assertEquals(driver.getTitle(),"Education");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Education");
    }

    @Test
    public void menuGroupEducationTeachers() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(2,0);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Teachers");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/education/teachers.html");
        Assert.assertEquals(driver.getTitle(),"Teachers");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Teachers");
    }

    @Test
    public void menuGroupEducationFamilies() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(2,1);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Families");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/education/families.html");
        Assert.assertEquals(driver.getTitle(),"Families");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Families");
    }    

    @Test
    public void menuGroupEducationNGAkids() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(2,2);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "NGAkids");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/education/kids.html");
        Assert.assertEquals(driver.getTitle(),"NGAkids Art Zone");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"NGAkids Art Zone");
    }    
 
    @Test
    public void menuGroupEducationTeens() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(2,3);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Teens");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/education/teens.html");
        Assert.assertEquals(driver.getTitle(),"Teens");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Teens");
    }      
  
    @Test
    public void menuGroupEducationAdults() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(2,4);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Adults");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/education/adults.html");
        Assert.assertEquals(driver.getTitle(),"Adults");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Adults");
    }    

    @Test
    public void menuGroupEducationInternsAndFellows() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(2,5);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Interns and Fellows");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/education/interns-fellows.html");
        Assert.assertEquals(driver.getTitle(),"Interns & Fellows");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Interns & Fellows");
    }     

    @Test
    public void menuGroupEducationInternsLearningResources() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(2,6);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Learning Resources");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.nga.gov/content/ngaweb/education/learningresources.html");
        Assert.assertEquals(driver.getTitle(), "About Learning Resources");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(aboutLearningResources.isDisplayed());
    }    
    
    // Conservation menu group
    @Test
    public void menuGroupConservation() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(3);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Conservation");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/conservation.html");
        Assert.assertEquals(driver.getTitle(),"Conservation");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Conservation");
    }
    
    @Test
    public void menuGroupResearch() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(4);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Research");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/research.html");
        Assert.assertEquals(driver.getTitle(),"Research");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Research");
    }
    
    @Test
    public void menuGroupCalendar() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(5);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Calendar");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/calendar.html");
        Assert.assertEquals(driver.getTitle(),"Calendar");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(calendarHeader.isDisplayed());
    }
    
    @Test
    public void menuGroupVisit() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(6);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Visit");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/visit.html");
        Assert.assertEquals(driver.getTitle(),"Visit");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Visit");
    }      
    
    @Test
    public void menuGroupSupport() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(7);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Support");
                
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/support.html");        
        Assert.assertEquals(driver.getTitle(),"Support Us");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Support Us");
    }
    
    @Test
    public void menuGroupShop() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(8);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Shop");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"https://shop.nga.gov/");
        Assert.assertEquals(driver.getTitle(),"National Gallery of Art Shops | Fine Museum Gifts | shop.nga.gov");
    }

}
