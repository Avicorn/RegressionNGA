package com.ionidea.RegressionNGA.Tests.pages;

import static java.awt.SystemColor.menu;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
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
   

    
    public MainPage(WebDriver driver) {
        super(driver);
    }
    

}
