package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.Common.PageHeader;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ionidea.RegressionNGA.Tests.pages.HomePage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Avicorn
 */
public class TopMenu extends TestNgTestBase {
    
    private final String CNST_DESKTOP_MAIN_MENU_GROUP_ANCHOR_BY_NAME = "//*[@id='header-wrap']/*[@id='header']/ul[@id='mainnav']/li/a[contains(text(), '{{group-alias}}')]/..";
    private final String CNST_COMMON_MAIN_MENU_GROUP_ITEM_ANCHOR_BY_NAME = "ul/li/a[contains(text(), '{{item-alias}}')]/..";
    
    
    private PageHeader pageHeader;

    
    @BeforeMethod
    public void initPageObjects() {
        pageHeader = PageFactory.initElements(driver, PageHeader.class);
    }

    private void hoverElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    private WebElement getMainMenuElement(String groupAlias, String groupItemAlias, By elementSelector) throws NotImplementedException {
        return getMainMenuElement(groupAlias, groupItemAlias).findElement(elementSelector);
    }
    
    private WebElement getMainMenuElement(String groupAlias, String groupItemAlias) throws NotImplementedException {
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
            .findElement(By.xpath(CNST_COMMON_MAIN_MENU_GROUP_ITEM_ANCHOR_BY_NAME.replace("{{item-alias}}", groupItemAlias)));
    }

    @Test
    public void testHomePageHasAHeader() throws NotImplementedException {
        driver.get(m_baseUrl);

        getMainMenuElement("Collection", "Highlights", By.tagName("a")).click();


    /*
         Actions action = new Actions(driver);
         action.moveToElement(pageHeader.ngaHomeLink);
         WebDriverWait wait = new WebDriverWait(driver, 1); // this will wait for 1 second
         wait.until(ExpectedConditions.visibilityOf(pageHeader.ngaHomeLink)); //this will wait for elememt to be visible for 1 second
         System.out.println("x " + pageHeader.ngaHomeLink.getLocation().x + " " + "y " + pageHeader.ngaHomeLink.getLocation().y + " " + pageHeader.ngaHomeLink.isDisplayed());
         //action.click(pageHeader.ngaHomeLink).build().perform();

         WebElement ngaMenuLink = driver.findElement(By.xpath("//ul[@id='mainnav']/li/a[contains(text(),'"+ "Collection" +"')]"));

         //    System.out.println("123" + pageHeader.ngaHomeLink.getText());
         //    System.out.println("123" + ngaMenuLink.getText());
         //    action.moveToElement(ngaMenuLink);
         //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //driver.wait.until(ExpectedConditions.visibilityOf(ngaMenuLink)); //this will wait for elememt to be visible for 1 second
    
         //How to click on something invisible 
         //        int locy0 = 0, locy1 = 0;
         //        if (ngaMenuLink.isDisplayed()) {
         //            locy1 = ngaMenuLink.getLocation().y;
         //            System.out.println(ngaMenuLink.getText() + locy1);
         //        } else {
         //            while (!ngaMenuLink.isDisplayed() && locy0 < locy1) {
         //                locy0++;
         //                action.moveToElement(ngaMenuLink, 0, locy0).perform();
         //            }
         //        }
    
         //    WebElement test = driver.findElement(By.xpath("//*[@id='footer']/ul[2]/li[4]/a"));
         //    System.out.println("x " + test.getLocation().x + " " + "y " + test.getLocation().y + " " + test.isDisplayed());
         //    
         System.out.println("x " + ngaMenuLink.getLocation().x + " " + "y " + ngaMenuLink.getLocation().y + " " + ngaMenuLink.isDisplayed());
         action.moveToElement(ngaMenuLink).build();
         int locy0 = 0, locy1 = 0;
         while (!ngaMenuLink.isDisplayed() && locy0 < locy1) {
         locy0++;
         action.moveToElement(ngaMenuLink, 0, locy0).perform();
         System.out.println(action.toString());
         wait.until(ExpectedConditions.visibilityOf(ngaMenuLink));
         }
         //action.moveToElement(ngaMenuLink, 1, 1).build();
         action.moveByOffset(132, 22).perform();
         System.out.println("x " + ngaMenuLink.getLocation().x + " " + "y " + ngaMenuLink.getLocation().y + " " + ngaMenuLink.getText());
         action.click(ngaMenuLink).perform();
         */
    }
}
