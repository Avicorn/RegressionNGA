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
public class TopMenuTest extends TestNgTestBase {
    
    private PageHeader pageHeader;
    
  
    @BeforeMethod
    public void initPageObjects() {
        pageHeader = PageFactory.initElements(driver, PageHeader.class);
        pageHeader.initialize(m_config);
        
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Calendar of Events')]")
    private WebElement calendarHeader;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'ARTISTS')]")
    private WebElement artists;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'About Learning Resources')]")
    private WebElement aboutLearningResources;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Conservation Projects')]")
    private WebElement aboutConservationProjects;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Division Publications')]")
    private WebElement divisionPublications;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Conservation Resources')]")
    private WebElement conservationResources;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'National Gallery of Art Publications')]")
    private WebElement ngaPublications;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'NGA Online Editions')]")
    private WebElement ngaOnlineEditions;   
        
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Tours & Guides')]")
    private WebElement toursAndGuides;  

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Accessibility')]")
    private WebElement accessibility;  

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Cafés')]")
    private WebElement cafés;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Shops')]")
    private WebElement shops;        

    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Museum Policies')]")
    private WebElement museumPolicies;   
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Ice Rink')]")
    private WebElement iceRink;   
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Copyist Program')]")
    private WebElement copyistProgram;  
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Vital Partnerships')]")
    private WebElement vitalPartnerships;     
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Membership')]")
    private WebElement membership;     
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Major Giving')]")
    private WebElement majorGiving; 
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Planned Giving')]")
    private WebElement plannedGiving;    
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Corporate Giving')]")
    private WebElement corporateGiving;
    
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Gifts of Art')]")
    private WebElement giftsOfArt;    

    
    
    
     /*
        1. Open landing page
        2. Compare target menuitem text with expected one.
        3. Try to click on it index
        This helps to make sure menu order is fine.
        4. Compare Title, URL and <H2> value on new page with desired 
        This helps to make sure menuitem linked to correct page.
    
        In case any of above fails - test is considered failed.
    */

    // NGA Home
    @Test
    public void ngaHomeLink() throws NotImplementedException {
        driver.get(m_baseUrl);
        Assert.assertEquals("National Gallery of Art", pageHeader.ngaHomeLink.getText());
        pageHeader.ngaHomeLink.click();
        
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.nga.gov/content/ngaweb.html");
        Assert.assertEquals(driver.getTitle(), "National Gallery of Art");
    }
    
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
    public void menuGroupConservationProjects() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(3,0);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Projects");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/conservation/projects.html");
        Assert.assertEquals(driver.getTitle(),"Projects");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(aboutConservationProjects.isDisplayed());
    }    

    @Test
    public void menuGroupConservationPublications() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(3,1);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Publications");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/conservation/publications.html");
        Assert.assertEquals(driver.getTitle(),"Publications");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(divisionPublications.isDisplayed());
    }     
    
    @Test
    public void menuGroupConservationResources() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(3,2);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Resources");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/conservation/resources.html");
        Assert.assertEquals(driver.getTitle(),"Resources");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(conservationResources.isDisplayed());
    }
    
    // Research menu group
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
    public void menuGroupResearchCASVA() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(4,0);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "CASVA");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/research/casva.html");
        Assert.assertEquals(driver.getTitle(),"CASVA");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Center for Advanced Study in the Visual Arts (CASVA)");
    }    
    
    @Test
    public void menuGroupResearchPublications() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(4,1);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Publications");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/research/publications.html");
        Assert.assertEquals(driver.getTitle(),"Publications");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(ngaPublications.isDisplayed());
    }      
  
     @Test
    public void menuGroupResearchMakeAnAppointment() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(4,2);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Make an Appointment");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/research/make-an-appointment.html");
        Assert.assertEquals(driver.getTitle(),"Make an Appointment");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Make an Appointment");
    }    
 
    @Test
    public void menuGroupResearchGalleryArchives() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(4,3);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Gallery Archives");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/research/gallery-archives.html");
        Assert.assertEquals(driver.getTitle(),"Gallery Archives");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Gallery Archives");
    }     

    @Test
    public void menuGroupResearchLibrary() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(4,4);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Library");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/research/library.html");
        Assert.assertEquals(driver.getTitle(),"Library");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"National Gallery of Art Library");
    }     

    @Test
    public void menuGroupResearchNGAOnlineEditions() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(4,5);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "NGA Online Editions");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/research/online-editions.html");
        Assert.assertEquals(driver.getTitle(),"Online Editions");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(ngaOnlineEditions.isDisplayed());
    }       
    
    // Calendar menu group
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
    public void menuGroupCalendarFilmPrograms() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(5,0);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Film Programs");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/calendar/film-programs.html");
        Assert.assertEquals(driver.getTitle(),"Film Programs");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Film Programs");
    }    
    
    @Test
    public void menuGroupCalendarConcerts() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(5,1);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Concerts");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/calendar/concerts.html");
        Assert.assertEquals(driver.getTitle(),"Concerts");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Concerts");
    } 
    
    @Test
    public void menuGroupCalendarJazzPrograms() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(5,2);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Jazz Programs");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/calendar/jazz.html");
        Assert.assertEquals(driver.getTitle(),"Jazz Programs");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Jazz Programs");
    } 
    
    @Test
    public void menuGroupCalendarGalleryTalks() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(5,3);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Gallery Talks");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/calendar/gallery-talks.html");
        Assert.assertEquals(driver.getTitle(),"Gallery Talks");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Gallery Talks");
    }    

    @Test
    public void menuGroupCalendarLectures() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(5,4);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Lectures");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/calendar/lectures.html");
        Assert.assertEquals(driver.getTitle(),"Lectures");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Lectures");
    } 
    
    @Test
    public void menuGroupCalendarGuidedTours() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(5,5);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Guided Tours");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/calendar/guided-tours.html");
        Assert.assertEquals(driver.getTitle(),"Guided Tours");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Guided Tours");
    }    
    
    @Test
    public void menuGroupCalendarFamilyActivities() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(5,6);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Family Activities");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/calendar/family-activities.html");
        Assert.assertEquals(driver.getTitle(),"Family Activities");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Family Activities");
    }  
    
    @Test
    public void menuGroupCalendarChildrenAndTeenFilms() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(5,7);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Children and Teen Films");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/calendar/films-for-children.html");
        Assert.assertEquals(driver.getTitle(),"Films for Children");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Films for Children");
    }     
    
    // Visit menu group
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
    public void menuGroupVisitMapsAndHours() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(6,0);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Maps & Hours");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/visit/maps-and-information.html");
        Assert.assertEquals(driver.getTitle(),"Maps & Hours");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Maps & Hours");
    }      
    
    @Test
    public void menuGroupVisitToursAndGuides() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(6,1);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Tours & Guides");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/visit/tours-and-guides.html");
        Assert.assertEquals(driver.getTitle(),"Tours & Guides");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(toursAndGuides.isDisplayed());
    }    
    
    @Test
    public void menuGroupVisitAccessibility() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(6,2);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Accessibility");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/visit/accessibility.html");
        Assert.assertEquals(driver.getTitle(),"Accessibility");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(accessibility.isDisplayed());
    }    
    
    @Test
    public void menuGroupVisitCafes() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(6,3);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Cafés");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/visit/cafe.html");
        Assert.assertEquals(driver.getTitle(),"Cafés");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(cafés.isDisplayed());
    }   
    
    @Test
    public void menuGroupVisitShops() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(6,4);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Shops");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/visit/shops.html");
        Assert.assertEquals(driver.getTitle(),"Shops");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(shops.isDisplayed());
    }    
    
    @Test
    public void menuGroupVisitMuseumPolicies() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(6,5);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Museum Policies");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/visit/museum-policies.html");
        Assert.assertEquals(driver.getTitle(),"Museum Policies");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(museumPolicies.isDisplayed());
    }    
    
    @Test
    public void menuGroupVisitIceRink() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(6,6);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Ice Rink");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/visit/ice-rink.html");
        Assert.assertEquals(driver.getTitle(),"Ice Rink");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(iceRink.isDisplayed());
    } 
    
    @Test
    public void menuGroupCopyistProgram() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(6,7);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Copyist Program");
        
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/visit/copyist.html");
        Assert.assertEquals(driver.getTitle(),"Copyist Program");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(copyistProgram.isDisplayed());
    }    
  
    // Support menu group
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
    public void menuGroupSupportVitalPartnerships() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(7,0);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Vital Partnerships");
                
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/support/vital-partnerships.html");        
        Assert.assertEquals(driver.getTitle(),"Vital Partnerships");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(vitalPartnerships.isDisplayed());
    }    
    
    @Test
    public void menuGroupSupportMembership() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(7,1);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Membership");
                
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/support/membership.html");        
        Assert.assertEquals(driver.getTitle(),"Membership");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(membership.isDisplayed());
    }    
    
    @Test
    public void menuGroupSupportMajorGiving() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(7,2);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Major Giving");
                
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/support/major-giving.html");        
        Assert.assertEquals(driver.getTitle(),"Major Giving");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(majorGiving.isDisplayed());
    }    
    
    @Test
    public void menuGroupSupportPlannedGiving() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(7,3);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Planned Giving");
                
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/support/planned-giving.html");        
        Assert.assertEquals(driver.getTitle(),"Planned Giving");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(plannedGiving.isDisplayed());
    }    
    
    @Test
    public void menuGroupSupportCorporateGiving() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(7,4);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Corporate Giving");
                
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/support/corporate-giving.html");        
        Assert.assertEquals(driver.getTitle(),"Corporate Giving");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(corporateGiving.isDisplayed());
    } 
    
    @Test
    public void menuGroupSupportGiftsOfArt() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(7,5);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Gifts of Art");
                
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/support/gifts-of-art.html");        
        Assert.assertEquals(driver.getTitle(),"Gifts of Art");
        //in this particular case target h2 isn't the first in the DOM
        Assert.assertTrue(giftsOfArt.isDisplayed());
    }    
    
    @Test
    public void menuGroupSupportDonateNow() throws NotImplementedException {
        driver.get(m_baseUrl);
        //mouseover on menuitem to make it visible
        WebElement liElement = pageHeader.getMainMenuElement(7,6);
        WebElement aElement = liElement.findElement(By.tagName("a"));
        
        Assert.assertEquals(m_driverExtension.getElementText(aElement), "Donate Now");
                
        aElement.click();
        
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.nga.gov/content/ngaweb/support/donate-now.html");        
        Assert.assertEquals(driver.getTitle(),"Donate Now");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Donate Now");
    }
    
    // Shop menu group
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
