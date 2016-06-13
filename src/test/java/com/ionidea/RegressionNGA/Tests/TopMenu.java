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

/**
 * @author Avicorn
 */

public class TopMenu extends TestNgTestBase {

  private PageHeader pageHeader;

  @BeforeMethod
  public void initPageObjects() {
    pageHeader = PageFactory.initElements(driver, PageHeader.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
        
    Actions action = new Actions(driver);
    action. moveToElement(pageHeader.ngaHomeLink);
    WebDriverWait wait = new WebDriverWait(driver, 1); // this will wait for 1 second

    wait.until(ExpectedConditions.visibilityOf(pageHeader.ngaHomeLink)); //this will wait for elememt to be visible for 1 second
    action.click(pageHeader.ngaHomeLink).build().perform();
    
    WebElement ngaMenuLink = driver.findElement(By.xpath("//*[@id='mainnav']/li/a[contains(text(),'"+ "Shop" +"')]"));
    System.out.println("123"+ngaMenuLink.getText());
    action.moveToElement(ngaMenuLink);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //driver.wait.until(ExpectedConditions.visibilityOf(ngaMenuLink)); //this will wait for elememt to be visible for 1 second
    action.click(ngaMenuLink).build().perform();
  }
}
