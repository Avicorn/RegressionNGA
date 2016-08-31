package com.ionidea.RegressionNGA.Tests.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author TestQA
 */

public class MainPage extends Page {
    
    //Main Menu points
    @FindBy (xpath = "//div[@id='header-wrap']/div/ul[@id='mainnav']/li/a")
    public List<WebElement> mainMenuOptions;  

    //Collection -  menu option    
    
    //@FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li/a)[10]")
    //public WebElement mainMenuCollection;   
    @FindBy (xpath = "//div/div/ul/li[1]/ul/li/a")
    public List<WebElement> subMenuCollection;   
    
   
    
    //Exhibitions - menu option
        
    //@FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li[2]/a)[2]")
    //public WebElement mainMenuExhibitions;    
    @FindBy (xpath = "//div/div/ul/li[2]/ul/li/a")
    public List<WebElement> subMenuExhibitions;
    
    
    //Education - menu option 
        
    //@FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li[3]/a)[2]")
   // public WebElement mainMenuEducation;    
    @FindBy (xpath = "//div/div/ul/li[3]/ul/li/a")
    public List<WebElement> subMenuEducation;
    
    
    //Conservation - main menu
    
    //@FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li[4]/a)[2]")
    //public WebElement mainMenuConservation;    
    @FindBy (xpath = "//div/div/ul/li[4]/ul/li/a")
    public List<WebElement> subMenuConservation;
    
    
    
    
    //Research - main menu option
    
    //@FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li[5]/a)[2]")
    //public WebElement mainMenuResearch;    
    @FindBy (xpath = "//div/div/ul/li[5]/ul/li/a")
    public List<WebElement> subMenuResearch;
    
    
    
    //Calendar
    //@FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li[6]/a)[2]")
    //public WebElement mainMenuCalendar;    
    @FindBy (xpath = "//div/div/ul/li[6]/ul/li/a")
    public List<WebElement> subMenuCalendar;
    
    
    
    
    //Visit
    //public WebElement mainMenuVisit;    
    @FindBy (xpath = "//div/div/ul/li[7]/ul/li/a")
    public List<WebElement> subMenuVisit;
    
    
    //Support
    //@FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li[8]/a)[2]")
   // public WebElement mainMenuSupport;    
    @FindBy (xpath = "//div/div/ul/li[8]/ul/li/a")
    public List<WebElement> subMenuSupport;
    
    
    //Shop
    //@FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li[9]/a)[2]")
   // public WebElement mainMenuShop;    
    @FindBy (xpath = "//div/div/ul/li[9]/ul/li/a")
    public List<WebElement> subMenuShop;
      
    
    
    
    
    public MainPage(WebDriver driver) {
        super(driver);
    }
}
