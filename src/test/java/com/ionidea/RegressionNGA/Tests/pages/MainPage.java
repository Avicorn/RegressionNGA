package com.ionidea.RegressionNGA.Tests.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author TestQA
 */

public class MainPage extends Page {
    
//MAIN MENU (HEADER)
    
    @FindBy (xpath = "//div[@id='header-wrap']/div/ul[@id='mainnav']/li/a")
    public List<WebElement> mainMenuOptions;  

    //Collection -  menu option        
    @FindBy (xpath = "//div/div/ul/li[1]/ul/li/a")
    public List<WebElement> subMenuCollection;   
           
    //Exhibitions - menu option   
    @FindBy (xpath = "//div/div/ul/li[2]/ul/li/a")
    public List<WebElement> subMenuExhibitions;
        
    //Education - menu option  
    @FindBy (xpath = "//div/div/ul/li[3]/ul/li/a")
    public List<WebElement> subMenuEducation;
    
     //Conservation - main menu 
    @FindBy (xpath = "//div/div/ul/li[4]/ul/li/a")
    public List<WebElement> subMenuConservation;
       
    //Research - main menu option   
    @FindBy (xpath = "//div/div/ul/li[5]/ul/li/a")
    public List<WebElement> subMenuResearch;

    //Calendar  
    @FindBy (xpath = "//div/div/ul/li[6]/ul/li/a")
    public List<WebElement> subMenuCalendar;  
    
    //Visit   
    @FindBy (xpath = "//div/div/ul/li[7]/ul/li/a")
    public List<WebElement> subMenuVisit;
    
    //Support
    @FindBy (xpath = "//div/div/ul/li[8]/ul/li/a")
    public List<WebElement> subMenuSupport;
    
    //Shop   
    @FindBy (xpath = "//div/div/ul/li[9]/ul/li/a")
    public List<WebElement> subMenuShop;
    
    //Search input field
    @FindBy (xpath = "(//input[@id='searchterm'])[2]")
    public WebElement searchInputField;  

    
    
// FOOTER
    @FindBy (xpath = "(//a[contains(text(),'About')])[2]")
    public WebElement aboutLink;
    
    @FindBy (xpath = "(//a[contains(text(),'Opportunities')])[2]")
    public WebElement opportunitiesLink;
    
    @FindBy (xpath = "(//a[contains(text(),'Press')])[2]")
    public WebElement pressLink;
    
    @FindBy (xpath = "(//a[contains(text(),'NGA Images')])[2]")
    public WebElement ngaImagesLink;
    
    @FindBy (xpath = "(//a[contains(text(),'Newsletters')])[2]")
    public WebElement newsLettersLink;
    
    @FindBy (xpath = "(//a[contains(text(),'Notices')])[2]")
    public WebElement noticesLink;
    
    @FindBy (xpath = "(//a[contains(text(),'Contact Us')])[2]")
    public WebElement contactUsLink;
    
    @FindBy (xpath = "(//a[contains(text(),'Audio/Video')])[2]")
    public WebElement audioVideoLink;
    
    @FindBy (xpath = "//div[@id='footer']/div/a")
    public WebElement directionsLink;
    
    @FindBy (xpath = "//a[contains(@href, 'https://twitter.com/ngadc')]")
    public WebElement twitterNGALink;
    
    @FindBy (xpath = "//a[contains(@href, 'https://www.facebook.com/nationalgalleryofart')]")
    public WebElement facebookNGALink;
    
    @FindBy (xpath = "//a[@href='http://instagram.com/ngadc']")
    public WebElement instagramNGALink;
    
    @FindBy (xpath = "//a[@href='http://pinterest.com/ngadc']")
    public WebElement pinterestNGALink;
    
    @FindBy (xpath = "//div[@id='footer']/div[2]/span")
    public WebElement copyrightInformation;
    

    
    public MainPage(WebDriver driver) {
        super(driver);
    }
    

}
