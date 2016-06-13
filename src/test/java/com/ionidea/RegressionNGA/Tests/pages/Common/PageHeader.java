package com.ionidea.RegressionNGA.Tests.pages.Common;

import com.ionidea.RegressionNGA.Tests.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Avicorn
 */
public class PageHeader extends Page {

//    @FindBy(how = How.XPATH, using = "//*[@id='mainnav']/li/a[contains(text(),'Collection')]")
//    public WebElement ngaMenuLink;
    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;
    
    @FindBy(how = How.XPATH, using = "//*[@id='header']/h1/a[contains(text(),'National Gallery of Art')]")
    @CacheLookup //Now what cachelookup does is it stores elements having @cachelookup annotation applied over it and then stores this element for further reference/s.
    public WebElement ngaHomeLink;
    
    @FindBy(how = How.XPATH, using = "//*[@id='nga-your-favorites-link']")
    @CacheLookup //Now what cachelookup does is it stores elements having @cachelookup annotation applied over it and then stores this element for further reference/s.
    public WebElement ngaFavoritesLink;
    
    @FindBy(id = "///*[@id='userSignOutLink']")
    public WebElement userSignOutLink;
    
    

    public void OpenMenuByText(WebDriver webDriver, String menuText) {
        Actions action = new Actions(driver);
        
        WebElement ngaMenuLink = driver.findElement(By.xpath("//*[@id='mainnav']/li/a[contains(text(),'"+ menuText +"')]"));
        action. moveToElement(ngaMenuLink).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 1); // this will wait for 1 second
        
        wait.until(ExpectedConditions.visibilityOf(ngaMenuLink)); //this will wait for elememt to be visible for 1 second
        action.click(ngaMenuLink).build().perform();
    }
  
    public PageHeader(WebDriver webDriver) {
      super(webDriver);
    }
}
