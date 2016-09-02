/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.ArtistInformationPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Class verified all elements on the page
 * @author TestQA
 * v. - Draft (be supplemented and improved)
 */
public class ArtistInformation extends TestNgTestBase{
    
    
// DRAFT
    @Test              
    public void elementsExist(){
        
        /** Creates new page object  */
        ArtistInformationPage artistInformationPage = new ArtistInformationPage(driver);   
        
        /** Opens the page URL
         @param - URL of the page 
         @see - ArtistInformationPage#getUrl
         */
        driver.get(artistInformationPage.getUrl());  
        
        /**
         * Verifies all web elements on the page
         @param - example of WebDriver
         @param - example of WebElement
         @param - text for verifying
         */
        
        //Test objects of Main page
        assertElementIsPresent(driver, artistInformationPage.onlineEditions);         
        assertElementIsPresent(driver, artistInformationPage.nameBreadCrumb);    
        assertElementIsPresent(driver, artistInformationPage.nameTitle);
        assertElementIsPresent(driver, artistInformationPage.descriptionName);
        assertElementIsPresent(driver, artistInformationPage.descriptionDate);
        assertElementIsPresent(driver, artistInformationPage.artistImage);
        assertElementIsPresent(driver, artistInformationPage.citeLink);
        assertElementIsPresent(driver, artistInformationPage.pdfLink);
        assertElementIsPresent(driver, artistInformationPage.archivedVersionsLink);
        assertElementIsPresent(driver, artistInformationPage.searchInputField);
        assertElementIsPresent(driver, artistInformationPage.biographyLink);
        assertElementIsPresent(driver, artistInformationPage.worksOfArtLink);
        assertElementIsPresent(driver, artistInformationPage.artistBibliographyLink);
        
        //Test the objects of #Biography
        assertTextIsPresent(driver, artistInformationPage.biographyTitle,"BIOGRAPHY");
        assertTextIsPresent(driver, artistInformationPage.textBegin,"Nicolaes Berchem was one of the most popular and successful Italianate landscape painters of his day. Aside from views of Italy, his extensive oeuvre of paintings, drawings, and etchings consists of depictions of the hunt and biblical and mythological scenes. Born in Haarlem in 1620, Berchem received his early training under his father, the still-life painter Pieter Claesz (Dutch, 1596/1597 - 1660). Houbra­ken, however, enumerated other teachers, including Jan van Goyen (Dutch, 1596 - 1656), Claes Moeyaert (1591–1655), Pieter de Grebber (c. 1600–1652/1653), Jan Wils (c. 1600–1666), and, somewhat improbably, Berchem’s younger cousin Jan Baptist Weenix (1621–1660/1661).");
        assertTextIsPresent(driver, artistInformationPage.theAuthorName,"Arthur K. Wheelock Jr.");
        assertTextIsPresent(driver, artistInformationPage.dateOfArticle,"April 24, 2014");
        
        //Test the objects of the #works of art
        artistInformationPage.worksOfArtLink.click();
        Assert.assertEquals(artistInformationPage.leftAccordionsClosed.size(),7);
                
        
        //Expand all accordions
        int index =0;
        while(index<artistInformationPage.leftAccordionsClosed.size()){
            wait.until(ExpectedConditions.elementToBeClickable(artistInformationPage.leftAccordionsClosed.get(index)));
            artistInformationPage.leftAccordionsClosed.get(index).click(); 
            index++;
        }        
        
        //verify all accordions are expanded
        index =0;
        while(index<artistInformationPage.leftAccordionsOpen.size());{
            wait.until(ExpectedConditions.elementToBeClickable(artistInformationPage.leftAccordionsOpen.get(index)));
            Assert.assertTrue(artistInformationPage.leftAccordionsOpen.get(index).isDisplayed());        
            index++;
        }
                
        //Verify all elements under the accordions
        index =0;        
        while(index<artistInformationPage.allCheckBoxes.size());{
            wait.until(ExpectedConditions.elementToBeClickable(artistInformationPage.allCheckBoxes.get(index)));
            Assert.assertTrue(artistInformationPage.allCheckBoxes.get(index).isDisplayed()); 
            index++;
        }
        
        index =0;        
        while(index<artistInformationPage.allCheckBoxes.size()){
            wait.until(ExpectedConditions.elementToBeClickable(artistInformationPage.allCheckBoxes.get(index)));
            Assert.assertTrue(artistInformationPage.allCheckBoxes.get(index).isDisplayed());  
            index++;
        }        
       
        
        // TBD
        
    }
}

    
    

