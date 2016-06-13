package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.Common.*;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ionidea.RegressionNGA.Tests.pages.HomePage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithNGA extends TestNgTestBase {

  private SignIn signIn;
  private PageHeader pageHeader;

  @BeforeMethod
  public void initPageObjects() {
    signIn = PageFactory.initElements(driver, SignIn.class);
    pageHeader = PageFactory.initElements(driver, PageHeader.class);
  }

  @Test
  public void correctPasswordPositiveCase() {
    driver.get(baseUrl);
      
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 1); //seconds
    
    wait.until(ExpectedConditions.visibilityOf(pageHeader.ngaFavoritesLink));
    pageHeader.ngaFavoritesLink.click();
    
    wait.until(ExpectedConditions.visibilityOf(pageHeader.header));
    Assert.assertFalse("Sign In".equals(pageHeader.header.getText())); //Check page Header.
    
    wait.until(ExpectedConditions.visibilityOf(signIn.ngaLoginButton));
    action.moveToElement(signIn.ngaLoginButton);
    action.click(signIn.ngaLoginButton).build().perform();
    
    //correct user correct login password positive case
    signIn.SignInWithNGA(driver, ngaUserLogin, ngaUserPassword);
    Assert.assertTrue(driver.getPageSource().contains("Sign Out"));
    Assert.assertTrue("Favorites".equals(pageHeader.header.getText()));
  }
  
  @Test
  public void incorrectPasswordNegativeCase() throws InterruptedException {
    driver.get(baseUrl);
      
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 30); //seconds
    
    wait.until(ExpectedConditions.visibilityOf(pageHeader.ngaFavoritesLink));
    pageHeader.ngaFavoritesLink.click();
    
    wait.until(ExpectedConditions.visibilityOf(pageHeader.header));
    Assert.assertFalse("Sign In".equals(pageHeader.header.getText())); //Check page Header.
    
    wait.until(ExpectedConditions.visibilityOf(signIn.ngaLoginButton));
    action.moveToElement(signIn.ngaLoginButton);
    action.click(signIn.ngaLoginButton).build().perform();
    
    //correct user incorrect password negative case
    //TODO: figure out how to read properties from pom.xml
    //NOTE: add desired property inside <profile> section as on of <properties>, to application.properties, to TestNgTestBase and read it inside it in initTestSuite method.
    signIn.SignInWithNGA(driver, ngaUserLogin, "totallyrandomtext");
    wait.withTimeout(Long.valueOf("30"),TimeUnit.SECONDS);
    Assert.assertTrue(driver.getPageSource().contains("User name and password do not match"));
  }
}
