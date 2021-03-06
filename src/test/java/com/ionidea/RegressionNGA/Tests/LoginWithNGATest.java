package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.Common.*;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithNGATest extends TestNgTestBase {

  private SignIn signIn;
  private PageHeader pageHeader;

  @BeforeMethod
  public void initPageObjects() {
    signIn = PageFactory.initElements(driver, SignIn.class);
    signIn.initialize(m_config);

    pageHeader = PageFactory.initElements(driver, PageHeader.class);
  }

  @Test
  public void correctPasswordPositiveCase() {
    
    driver.manage().deleteAllCookies();
    driver.get(m_baseUrl);
    
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, m_standartWaitTime);
    
    wait.until(ExpectedConditions.visibilityOf(pageHeader.ngaFavoritesLink));
    pageHeader.ngaFavoritesLink.click();
    
    wait.until(ExpectedConditions.visibilityOf(signIn.ngaLoginButton));
    //Make sure it's a right page.
    Assert.assertTrue("Sign In".equals(driver.getTitle())); 
    
    action.moveToElement(signIn.ngaLoginButton);
    action.click(signIn.ngaLoginButton).build().perform();
    
    //correct user correct login password positive case
    signIn.SignInWithNGA(driver, m_ngaUserLogin, m_ngaUserPassword);
    Assert.assertTrue(driver.getPageSource().contains("Sign Out"));
    Assert.assertTrue("Favorites".equals(driver.getTitle())); //Check page Header.
  }
  
  @Test
  public void incorrectPasswordNegativeCase() throws InterruptedException {
    driver.manage().deleteAllCookies();
    driver.get(m_baseUrl);
          
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, m_standartWaitTime); //seconds
    
    wait.until(ExpectedConditions.visibilityOf(pageHeader.ngaFavoritesLink));
    pageHeader.ngaFavoritesLink.click();
    
    wait.until(ExpectedConditions.visibilityOf(signIn.ngaLoginButton));
    Assert.assertTrue("Sign In".equals(driver.getTitle())); //Make sure it's a right page.
    
    wait.until(ExpectedConditions.visibilityOf(signIn.ngaLoginButton));
    action.moveToElement(signIn.ngaLoginButton);
    action.click(signIn.ngaLoginButton).build().perform();
    
    //correct user incorrect password negative case
    signIn.SignInWithNGA(driver, m_ngaUserLogin, "totallyrandomtext");
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Assert.assertTrue(driver.getPageSource().contains("User name and password do not match"));
  }
}
