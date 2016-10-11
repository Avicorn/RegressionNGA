/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests;

import static com.ionidea.RegressionNGA.Tests.TestNgTestBase.m_baseUrl;
import com.ionidea.RegressionNGA.Tests.pages.ArtistInformationPage;
import com.ionidea.RegressionNGA.Tests.pages.MainPage;
import com.ionidea.RegressionNGA.Tests.pages.ProvenanceInformationPage;
import com.ionidea.RegressionNGA.Tests.pages.WidgetBibliographyPage;
import com.ionidea.RegressionNGA.Tests.pages.WidgetBiographyPage;
import com.ionidea.RegressionNGA.Tests.pages.WidgetRelatedContentPage;
import com.ionidea.RegressionNGA.Tests.pages.WidgetWorksOfArtPage;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author TestQA
 */
public class ProvenanceInformation extends TestNgTestBase{
    
    
    @Test
    
    public void provenanceStaticElementsExist(){
        ProvenanceInformationPage provenanceInformationPage = new ProvenanceInformationPage(driver);
        driver.get(m_baseUrl+"/content/ngaweb/Collection/provenance-info.6747.html#works");
        driver.manage().window().maximize();
        m_wait.until(ExpectedConditions.visibilityOf(provenanceInformationPage.artistDescription));
        
        //Verify all static page elements
        provenanceInformationPage.assertElementIsPresent(driver,provenanceInformationPage.relatedContentLink);
        provenanceInformationPage.assertElementIsPresent(driver,provenanceInformationPage.worksOfArtLink);
        provenanceInformationPage.assertTextIsPresent(driver,provenanceInformationPage.artistNameTitle,"Frank, Robert");
        provenanceInformationPage.assertTextIsPresent(driver,provenanceInformationPage.artistDescription,"Robert Frank c/o Pace/MacGill Gallery");
        provenanceInformationPage.assertTextIsPresent(driver,provenanceInformationPage.artistLifeSpan,"American, born Switzerland, 1924");
        
        //Open another page example
        driver.get(m_baseUrl+"/content/ngaweb/Collection/provenance-info.29368.html");
        driver.manage().window().maximize();
        m_wait.until(ExpectedConditions.visibilityOf(provenanceInformationPage.artistDescription));
        provenanceInformationPage.assertElementIsPresent(driver,provenanceInformationPage.biographyLink);
        provenanceInformationPage.assertElementIsPresent(driver,provenanceInformationPage.artistBibliographyLink);
        
    }
    
    
    @Test
    
    public void provenanceWorksOfArtExist() throws InterruptedException{
        
        ProvenanceInformationPage provenanceInformationPage = new ProvenanceInformationPage(driver);   
        WidgetWorksOfArtPage widget = new WidgetWorksOfArtPage(driver);
        
        driver.get(m_baseUrl+"/content/ngaweb/Collection/provenance-info.6747.html#works");
        driver.manage().window().maximize();
        provenanceInformationPage.worksOfArtLink.click();
        m_wait.until(ExpectedConditions.visibilityOf(widget.leftAccordionsClosed.get(1)));
        
        //Verify number  of folter accordions        
        Assert.assertEquals(widget.leftAccordionsClosed.size(),4);  
        System.out.println("the number of accordions is correct");
        
        //Expand all accordions
        widget.clickAllElements(widget.leftAccordionsClosed, (FluentWait) m_wait);
        System.out.println("all closed accordions are displayed");
        
        //verify all left accordions
        widget.verifyAllElementsAreDisplayed(widget.leftAccordionsOpen, (FluentWait) m_wait);
        System.out.println("all open accordions are displayed");
        
        //verify all check-boxes and respective labels
        Assert.assertEquals(widget.allCheckBoxes.size(),widget.allLabels.size());
        Assert.assertEquals(widget.allCheckBoxes.size(),8);
        widget.verifyAllElementsAreDisplayed(widget.allCheckBoxes, (FluentWait) m_wait);
        widget.verifyAllElementsAreDisplayed(widget.allLabels, (FluentWait) m_wait);
        
        //verify all check-boxes are unselected
        widget.verifyAllCheckBoxesAreUnselected(widget.allCheckBoxes, (FluentWait) m_wait);
        System.out.println("all checkboxes are verified, the number is:" +widget.allCheckBoxes.size());
        
        

        //Verify the number of the works of art
        int worksNumber;
        worksNumber = widget.addToListallWorkObjects(widget,widget.artistNameLabels,2, (FluentWait) m_wait);
        Assert.assertEquals(worksNumber,40);
        System.out.println("The number of author labels is "+worksNumber );
  
        
    }
    
    
    
    @Test
    
    public void provenanceBibliographyExist() throws InterruptedException{
        
        //Initiate page (+ widget Page)
        ProvenanceInformationPage provenanceInformationPage = new ProvenanceInformationPage(driver);
        WidgetBibliographyPage widget = new WidgetBibliographyPage(driver);
        
        //move to widget page
        driver.get(m_baseUrl+"/content/ngaweb/Collection/provenance-info.29368.html");
        driver.manage().window().maximize();
        m_wait.until(ExpectedConditions.visibilityOf(provenanceInformationPage.artistBibliographyLink));
        provenanceInformationPage.artistBibliographyLink.click();;
        
                
        //Verify all static  elements of the page
        provenanceInformationPage.assertTextIsPresent(driver,widget.bibliographyLabel,"BIBLIOGRAPHY");
        System.out.println("the label is displayed");
        
        //Add all text elements to array
        String years[][] = new String[10][2];
        years[0][0] = "1993";
        years [0][1]= "Heijbroek, Jan Frederik. Kunst, kennis en commercie: de kunsthandelaar J.H. de Bois (1878-1946). Amsterdam, 1993.";
                         
        //Verify all found static web elemnts contain respective text

        provenanceInformationPage.assertTextIsPresent(driver,widget.yearLabel.get(0),years[0][0]);
        System.out.println("The element verified: "+widget.yearLabel.get(0));
        MainPage.assertTextIsPresent(driver,widget.yearDescriptionLabel.get(0),years[0][1]);
        System.out.println("The element verified: "+widget.yearDescriptionLabel.get(0));

        }
    
    
    @Test
    public void provenanceBiographyExist(){
        
        //Initiate page (+ widget Page)
        ProvenanceInformationPage provenanceInformationPage = new ProvenanceInformationPage(driver);
        WidgetBiographyPage widget = new WidgetBiographyPage(driver);
        
        //move to widget page
        driver.get(m_baseUrl+"/content/ngaweb/Collection/provenance-info.29368.html");
        driver.manage().window().maximize();
        m_wait.until(ExpectedConditions.visibilityOf(provenanceInformationPage.biographyLink));
        provenanceInformationPage.biographyLink.click();
        
        //Test the objects of #Biography 
        provenanceInformationPage.assertTextIsPresent(driver, widget.biographyTitle,"BIOGRAPHY");
        provenanceInformationPage.assertElementIsPresent(driver, widget.biographyAll);
                
    }
    
    @Test
    
    public void provenanceRelatedContentExist(){
        
        //Initiate page (+ widget Page)
        ProvenanceInformationPage provenanceInformationPage = new ProvenanceInformationPage(driver);
        WidgetRelatedContentPage widget = new WidgetRelatedContentPage(driver);
        
        //move to widget page
        driver.get(m_baseUrl+"/content/ngaweb/Collection/provenance-info.6747.html#works");
        driver.manage().window().maximize();
        m_wait.until(ExpectedConditions.visibilityOf(provenanceInformationPage.relatedContentLink));
        provenanceInformationPage.relatedContentLink.click();
        
        //Verify all elements
        Assert.assertTrue(widget.relatedContentDescription.size()==3, "The quantity of related content elements is not correct");
        Assert.assertTrue(widget.relatedContentImage.size()==3,"The quantity of related content elements is not correct");
        Assert.assertTrue(widget.relatedContentResultLink.size()==4, "The quantity of related content elements is not correct");
        Assert.assertTrue(widget.relatedContentResultTitle.size()==4, "The quantity of related content elements is not correct");
        Assert.assertTrue(widget.relatedContentTitle.isDisplayed(), "The titlw is not displayed");
        System.out.println("The array size check is completed");
        
        //Verify all Elelemnts are visible
        provenanceInformationPage.verifyAllElementsAreDisplayed(widget.relatedContentDescription,(FluentWait) m_wait);
        provenanceInformationPage.verifyAllElementsAreDisplayed(widget.relatedContentImage,(FluentWait) m_wait);
        provenanceInformationPage.verifyAllElementsAreDisplayed(widget.relatedContentResultLink,(FluentWait) m_wait);
        provenanceInformationPage.verifyAllElementsAreDisplayed(widget.relatedContentResultTitle,(FluentWait) m_wait);
        System.out.println("The display size check is completed");
    }
    
    
    
    
}
