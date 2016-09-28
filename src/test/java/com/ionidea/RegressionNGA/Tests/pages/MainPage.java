package com.ionidea.RegressionNGA.Tests.pages;

import static java.awt.SystemColor.menu;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

/**
 * @author TestQA
 */

public class MainPage extends Page {
    
    public MainPage(WebDriver driver) {
        super(driver);
    }
    
//Main Menu points    
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

    
// FOOTER
    @FindBy (xpath = "//div[@id='footer']/ul[@class='footer-nav']/li/a")
    public List<WebElement> footerMenu;
    
    @FindBy (xpath = "//div[@class='quick-info']/a")
    public WebElement directions;
       
    @FindBy (xpath = "//a[contains(@href, 'https://twitter.com/ngadc')]")
    public WebElement twitterLink;
    
    @FindBy (xpath = "//a[contains(@href, 'https://www.facebook.com/nationalgalleryofart')]")
    public WebElement facebookLink;
    
    @FindBy (xpath = "//a[@href='http://instagram.com/ngadc']")
    public WebElement instagramLink;
    
    @FindBy (xpath = "//a[@href='http://pinterest.com/ngadc']")
    public WebElement pinterestLink;
    
    @FindBy (xpath = "//div[@id='footer']/div[2]/span")
    public WebElement copyRightLabel;
    
    
    public <P extends Page> void openPageWidget(P page, String baseUrl, WebElement uiElement) throws InterruptedException{
        driver.get(baseUrl+page.getUrl());
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        uiElement.click();
    } 

    public boolean verifyAllElementsAreDisplayed(List<WebElement> list, FluentWait wait) {
        int index1 = 0;
        //verify all elements from the list
        while (index1 < list.size()) {
            wait.until(ExpectedConditions.elementToBeClickable(list.get(index1)));
            Assert.assertTrue(list.get(index1).isDisplayed());
            System.out.println("The element is displayed" + list.get(index1));
            index1++;
        }
        return true;
    }
    

    

}
