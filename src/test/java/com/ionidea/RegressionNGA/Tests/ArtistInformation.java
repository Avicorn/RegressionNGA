/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests;


import static com.ionidea.RegressionNGA.Tests.TestNgTestBase.m_standartWaitTime;
import com.ionidea.RegressionNGA.Tests.pages.ArtistInformationPage;
import static com.ionidea.RegressionNGA.Tests.util.CustomVerifications.assertElementIsPresent;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.PageFactory.initElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
        assertElementIsPresent(driver, artistInformationPage.biographyTitle);
        assertElementIsPresent(driver, artistInformationPage.textBegin);
        assertElementIsPresent(driver, artistInformationPage.textEnd);
        assertElementIsPresent(driver, artistInformationPage.dateOfArticle);
  
    }
}

    
    
    

