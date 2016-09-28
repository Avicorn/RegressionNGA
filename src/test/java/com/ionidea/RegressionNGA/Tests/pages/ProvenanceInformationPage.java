/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author TestQA
 */
public class ProvenanceInformationPage extends MainPage{
    
    public ProvenanceInformationPage(WebDriver driver) {
        super(driver);
    }
    
    
    
        //Links 
    @FindBy(how = How.XPATH, using ="//li[@id='relatedcontent-link']")
    public WebElement relatedContentLink;
    
    @FindBy(how = How.XPATH, using ="//li[@id='works-link']")
    public WebElement worksOfArtLink;
    
    @FindBy(how = How.XPATH, using ="//li[@id='biography-link']")
    public WebElement biographyLink;
    
    @FindBy(how = How.XPATH, using ="//li[@id='bibliography-link']")
    public WebElement artistBibliographyLink;
    
       //Static links
    @FindBy(how = How.XPATH, using ="//div [@class='artist-intro detailheader']/dl/dt[@class='artist']")
    public WebElement artistNameTitle;
    
    @FindBy(how = How.XPATH, using ="//div[@class='artist-intro detailheader']/dl/dd[@class='lifespan']")
    public WebElement artistLifeSpan;
    
    @FindBy(how = How.XPATH, using ="//div[@class='artist-intro detailheader']/dl/dd[@class='description']")
    public WebElement artistDescription;
    
    
    
    
}
