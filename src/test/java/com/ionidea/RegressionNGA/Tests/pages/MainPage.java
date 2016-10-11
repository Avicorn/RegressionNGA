package com.ionidea.RegressionNGA.Tests.pages;

import com.ionidea.RegressionNGA.Tests.TestNgTestBase;
import static java.awt.SystemColor.menu;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public List<WebElement> subMenuVisit;   
           
    //Exhibitions - menu option   
    @FindBy (xpath = "//div/div/ul/li[2]/ul/li/a")
    public List<WebElement> subMenuCollection;
        
    //Education - menu option  
    @FindBy (xpath = "//div/div/ul/li[3]/ul/li/a")
    public List<WebElement> subMenuExhibitions;
    
     //Conservation - main menu 
    @FindBy (xpath = "//div/div/ul/li[4]/ul/li/a")
    public List<WebElement> subMenuEducation;
       
    //Research - main menu option   
    @FindBy (xpath = "//div/div/ul/li[5]/ul/li/a")
    public List<WebElement> subMenuConservation;

    //Calendar  
    @FindBy (xpath = "//div/div/ul/li[6]/ul/li/a")
    public List<WebElement> subMenuResearch;  
    
    //Visit   
    @FindBy (xpath = "//div/div/ul/li[7]/ul/li/a")
    public List<WebElement> subMenuCalendar;
    
    //Support
    @FindBy (xpath = "//div/div/ul/li[8]/ul/li/a")
    public List<WebElement> subMenuSupport;
    
    //Shop   
    @FindBy (xpath = "//div/div/ul/li[9]/ul/li/a")
    public List<WebElement> subMenuShop;

    
// FOOTER
    @FindBy (xpath = "//div[@id='footer']/ul[@class='footer-nav']/li/a")
    public List<WebElement> footerMenu;
    
    @FindBy (xpath = "//span[2]/a[@class='directions']")
    public WebElement directions;
       
    @FindBy (xpath = "//a/i[@class='fa fa-twitter-square']")
    public WebElement twitterLink;
    
    @FindBy (xpath = "//a/i[@class='fa fa-facebook-official']")
    public WebElement facebookLink;
    
    @FindBy (xpath = "//a/i[@class='fa fa-instagram']")
    public WebElement instagramLink;
    
    @FindBy (xpath = "//a/i[@class='fa fa-pinterest']")
    public WebElement pinterestLink;
    
    @FindBy (xpath = "//div/span[@class='copyright']")
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
            Assert.assertTrue(list.get(index1).isDisplayed(), "the element is not displayed");
            System.out.println("The element is displayed" + list.get(index1));
            index1++;
        }
        return true;
    }
    
    public Integer resultsOnPageNumber(WebElement element){
        String resultText =element.getText();              
        String[] resultArray = resultText.split(" ");
        int result = Integer.parseInt(resultArray[3]);
        return result;
    }

    //action perfoms manual selection of the main menu
    public void selectMenuOption(WebElement menuIndex, WebElement subMenuIndex, TestNgTestBase testNgTestBase) throws InterruptedException {
        TestNgTestBase.m_wait.until(ExpectedConditions.elementToBeClickable(menuIndex));
        Thread.sleep(2000);
        //Open the main menu
        mouseOver(menuIndex);
        mouseOver(subMenuIndex);
        Thread.sleep(2000);
        //create new action
        Actions action = new Actions(testNgTestBase.driver);
        //action.clickAndHold(menuIndex).perform();
        action.click(subMenuIndex).build().perform();
    }
    
    //uses JavaScript to emulate mouse hover action and focus on the sub menu option
    public void mouseOver(WebElement element) {
        String code = "var fireOnThis = arguments[0].focus();" 
                + "var fireOnThis = arguments[0];" 
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );" 
                + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(code, element);
    }
    
        //Custom verification method - waits the element before check
    public static boolean assertElementIsPresent(WebDriver driver, WebElement element1) {
        WebDriverWait wait = new WebDriverWait(driver, TestNgTestBase.m_standartWaitTime);
        TestNgTestBase.m_wait.until(ExpectedConditions.visibilityOf(element1));
        Assert.assertTrue(element1.isDisplayed(), "The element is not displayed");
        System.out.println("The element  is found:" + element1.toString());
        return true;
    }

    //Custom verification method - waits the element and verifies the text containing in the web element
    public static boolean assertTextIsPresent(WebDriver driver, WebElement element2, String text) {
        TestNgTestBase.m_wait.until(ExpectedConditions.visibilityOf(element2));
        Assert.assertEquals(element2.getText(), text, "The text is not correct");
        System.out.println("The element  is found:" + element2.getText());
        return true;
    }
    
    

    

}
