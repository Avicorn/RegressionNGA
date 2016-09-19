package com.ionidea.RegressionNGA.Tests.pages.Common;

import com.google.inject.Inject;
import com.ionidea.RegressionNGA.Tests.TestNgTestBase;
import com.ionidea.RegressionNGA.Tests.pages.*;
import com.ionidea.RegressionNGA.Tests.util.IConfiguration;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
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
    public final String CNST_XPATH_MENU_DESKTOP = "//*[@id='wrapper']/*[@id='header-wrap']/*[@id='header']/ul[@id='mainnav']";
    public final String CNST_XPATH_MENU_GROUP_DESKTOP = CNST_XPATH_MENU_DESKTOP + "/li[{{group-index}}]";
    public final String CNST_XPATH_MENU_ITEM_DESKTOP = "ul/li[{{item-index}}]";
    
    @FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li/a)[10]")
    public WebElement header1;       
    
    @FindBy(how = How.XPATH, using = "(//ul[@id='mainnav']/li/ul/li/a)[56]")
    public WebElement header2; 
    
    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    @FindBy(how = How.XPATH, using = "//*[@id='header']/h1/a[contains(text(),'National Gallery of Art')]")
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
        //    new Actions(driver).moveToElement(element).perform();
        String mouseOverScript = ""
                + "if (document.createEvent) {"
                + "     var evObj = document.createEvent('MouseEvents'); "
                + "     evObj.initEvent('mouseover', true, false); "
                + "     arguments[0].dispatchEvent(evObj);"
                + "} else if (document.createEventObject) {"
                + "     arguments[0].fireEvent('onmouseover');"
                + "}";

        ((JavascriptExecutor) driver).executeScript(mouseOverScript, element);
    }


    public By getMainMenuLocator(int groupIndex) {
        return By.xpath(CNST_XPATH_MENU_GROUP_DESKTOP.replace("{{group-index}}", Integer.toString(groupIndex + 1)));
    }

    public By getMainMenuLocator(int groupIndex, int groupItemIndex) {
        return getMainMenuLocator(groupIndex, groupItemIndex, null);
    }

    public By getMainMenuLocator(int groupIndex, int groupItemIndex, String subPath) {
        String xPath
                = CNST_XPATH_MENU_GROUP_DESKTOP.replace("{{group-index}}", Integer.toString(groupIndex + 1))
                + "/"
                + CNST_XPATH_MENU_ITEM_DESKTOP.replace("{{item-index}}", Integer.toString(groupItemIndex + 1));

        if (subPath != null) {
            xPath += '/' + subPath;
        }

        return By.xpath(xPath);
    }

    public WebElement getMainMenuElement(int groupIndex, int groupItemIndex) {
        WebElement groupElement = getMainMenuElement(groupIndex);

        hoverElement(groupElement);

        By menuItemALocator = getMainMenuLocator(groupIndex, groupItemIndex, "a");
        By menuItemLocator = getMainMenuLocator(groupIndex, groupItemIndex);

        (new WebDriverWait(driver, m_standartWaitTime))
                .until(ExpectedConditions.elementToBeClickable(menuItemALocator));

        WebElement groupItemElement = groupElement.findElement(menuItemLocator);

        return groupItemElement;
    }

    public WebElement getMainMenuElement(int groupNumber) {
        untilMenuNotInit();

        return driver.findElement(getMainMenuLocator(groupNumber));
    }

    public void untilMenuNotInit() {
        By menuItemLocator;

        if (IsDesktop()) {
            menuItemLocator = By.xpath(CNST_XPATH_MENU_DESKTOP);
        } else if (IsTablet()) {
            throw new NotImplementedException();
        } else if (IsMobile()) {
            throw new NotImplementedException();
        } else {
            throw new NotImplementedException();
        }
        
        new WebDriverWait(driver, m_standartWaitTime)
                .until(ExpectedConditions.attributeContains(menuItemLocator, "class", "set"));
    }
    
    public PageHeader(WebDriver driver) {
        super(driver);
    }
}
