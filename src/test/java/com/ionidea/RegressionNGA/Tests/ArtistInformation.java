/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.ArtistInformationPage;
import org.testng.annotations.Test;

/**
 * Class verified all elements on the page
 * @author TestQA
 */
public class ArtistInformation extends TestNgTestBase{

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
         */
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
        assertTextIsPresent(driver, artistInformationPage.biographyTitle,"BIOGRAPHY");
        assertTextIsPresent(driver, artistInformationPage.textBegin,"Nicolaes Berchem was one of the most popular and successful Italianate landscape painters of his day. Aside from views of Italy, his extensive oeuvre of paintings, drawings, and etchings consists of depictions of the hunt and biblical and mythological scenes. Born in Haarlem in 1620, Berchem received his early training under his father, the still-life painter Pieter Claesz (Dutch, 1596/1597 - 1660). Houbra­ken, however, enumerated other teachers, including Jan van Goyen (Dutch, 1596 - 1656), Claes Moeyaert (1591–1655), Pieter de Grebber (c. 1600–1652/1653), Jan Wils (c. 1600–1666), and, somewhat improbably, Berchem’s younger cousin Jan Baptist Weenix (1621–1660/1661).");
        assertTextIsPresent(driver, artistInformationPage.theAuthorName,"Arthur K. Wheelock Jr.");
        assertTextIsPresent(driver, artistInformationPage.dateOfArticle,"April 24, 2014");
  
    }
}

    
    
    

