/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author TestQA
 */
public class ArtistInformationPage extends MainPage{
    
    /**
     * Constructor of the  class
     * @param driver 
     */
    public ArtistInformationPage(WebDriver driver) {
        super(driver);
    }    
    
    /**
     * the URL of the page
     */
    public String pageUrl=("/content/ngaweb/Collection/artist-info.2377.html");
     
    
    /**
     * The Web Elements of the page (Biography is selected)
     */
    
//MAIN
    
    //Links to widget pages
    @FindBy(how = How.XPATH, using ="//li[@id='works-link']")
    public WebElement worksOfArtLink;
    
    @FindBy(how = How.XPATH, using ="//li[@id='biography-link']")
    public WebElement biographyLink;
    
    @FindBy(how = How.XPATH, using ="//li[@id='bibliography-link']")
    public WebElement artistBibliographyLink;
    
    
    //Other UI elements
    @FindBy(how = How.XPATH, using = "(//a[contains(text(),'NGA Online Editions')])[3]")
    public WebElement onlineEditions;
    
    @FindBy(how = How.XPATH, using = "(//a[contains(text(),'Berchem, Nicolaes Pietersz')])[2]")
    public WebElement nameBreadCrumb;            
    
    @FindBy(how = How.XPATH, using ="//div[@id='isOSCIObject']/div/div[2]/dl/dt")
    public WebElement nameTitle;
    
    @FindBy(how = How.XPATH, using ="//div[@id='isOSCIObject']/div/div[2]/dl/dd")
    public WebElement descriptionDate;    
    
    @FindBy(how = How.XPATH, using ="//div[@id='isOSCIObject']/div/div[2]/dl/dd[2]")
    public WebElement descriptionName ;    
    
    @FindBy(how = How.XPATH, using ="//img[@alt='Constituent Image']")
    public WebElement artistImage;    
    
    @FindBy(how = How.XPATH, using ="//button[@name='toolbar-cite']")
    public WebElement citeLink;
            
    @FindBy(how = How.XPATH, using ="//button[@name='toolbar-export']")
    public WebElement pdfLink ;
    
    @FindBy(how = How.XPATH, using ="//button[@name='toolbar-archived']")
    public WebElement archivedVersionsLink ;
    
    @FindBy(how = How.XPATH, using ="//input[@id='ot-search']")
    public WebElement searchInputField;
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Artist bibliography
    //@FindBy(how = How.XPATH, using ="//li[@id='bibliography-link']")
   // public WebElement bibliographyLink;
    
    
    
    
    @Override
    public String getUrl(){
    return pageUrl;
    }
    

}