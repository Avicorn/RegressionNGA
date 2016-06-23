package com.ionidea.RegressionNGA.Tests.pages.Common;

import com.ionidea.RegressionNGA.Tests.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Avicorn
 */

/*
function getElementByXpath(path) {
  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
}
*/

public class PageHeader extends Page {
    private final String CNST_DESKTOP_MAIN_MENU_GROUP_ANCHOR_BY_NAME = "//*[@id='header-wrap']/*[@id='header']/ul[@id='mainnav']/li/a[contains(text(), '{{group-alias}}')]/..";
    private final String CNST_DESKTOP_MAIN_MENU_GROUP_ITEM_ANCHOR_BY_NAME = "ul/li/a[contains(text(), '{{item-alias}}')]/..";
    
//    @FindBy(how = How.XPATH, using = "//*[@id='mainnav']/li/a[contains(text(),'Collection')]")
//    public WebElement ngaMenuLink;
    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;
    
    @FindBy(how = How.XPATH, using = "//*[@id='header']/h1/a[contains(text(),'National Gallery of Art')]")
    //@CacheLookup //Now what cachelookup does is it stores elements having @cachelookup annotation applied over it and then stores this element for further reference/s.
    public WebElement ngaHomeLink;
    
    @FindBy(how = How.XPATH, using = "//*[@id='nga-your-favorites-link']")
    public WebElement ngaFavoritesLink;
    
    @FindBy(id = "///*[@id='userSignOutLink']")
    public WebElement userSignOutLink;
    
    
    
    
    

    public boolean IsMobile() {
        //TODO: add actual value
        return driver.manage().window().getSize().width < 0;
    }
    public boolean IsTablet() {
        int width = driver.manage().window().getSize().width;
        //TODO: add actual value
        return 0 < width && width < 1024; 
    }
    public boolean IsDesktop() {
        return driver.manage().window().getSize().width >= 1024;
    }
    
    
    
    private void hoverElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public WebElement getMainMenuElement(String groupAlias, String groupItemAlias, By elementSelector) throws NotImplementedException {
        return getMainMenuElement(groupAlias, groupItemAlias).findElement(elementSelector);
    }
    
    public WebElement getMainMenuElement(String groupAlias, String groupItemAlias) throws NotImplementedException {
        WebElement groupElement;
        
        if (IsDesktop()) {
            groupElement = driver
                    .findElement(By.xpath(CNST_DESKTOP_MAIN_MENU_GROUP_ANCHOR_BY_NAME.replace("{{group-alias}}", groupAlias)));
        } else if (IsTablet()) {
            throw new NotImplementedException();
        } else if (IsMobile()) {
            throw new NotImplementedException();
        } else {
            throw new NotImplementedException();
        }

        hoverElement(groupElement.findElement(By.tagName("a")));

        return groupElement
            .findElement(By.xpath(CNST_DESKTOP_MAIN_MENU_GROUP_ITEM_ANCHOR_BY_NAME.replace("{{item-alias}}", groupItemAlias)));
    }
    
    public WebElement getMainMenuElement(int groupNumber, int groupItemNumber){
        return getMainMenuElement(groupNumber)
                .findElements(By.xpath(CNST_DESKTOP_MAIN_MENU_GROUP_ITEM_ANCHOR_BY_NAME.replace("/a[contains(text(), '{{item-alias}}')]/..", "")))
                .get(groupItemNumber);
    }
    
    public WebElement getMainMenuElement(int groupNumber){
        WebElement groupElement;
        groupElement = driver
                    .findElements(By.xpath(CNST_DESKTOP_MAIN_MENU_GROUP_ANCHOR_BY_NAME.replace("/a[contains(text(), '{{group-alias}}')]/..", "")))
                    .get(groupNumber);
        hoverElement(groupElement.findElement(By.tagName("a")));        
        
        return groupElement;
    }
    

    
    public PageHeader(WebDriver webDriver) {
      super(webDriver);
    }
}
