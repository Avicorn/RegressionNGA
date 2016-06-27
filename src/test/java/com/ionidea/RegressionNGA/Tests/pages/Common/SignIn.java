package com.ionidea.RegressionNGA.Tests.pages.Common;

import com.ionidea.RegressionNGA.Tests.pages.*;
import com.ionidea.RegressionNGA.Tests.util.IConfiguration;
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
 * Sample page
 */
public class SignIn extends Page {

  
    @FindBy(how = How.XPATH, using = "//div[@id='loginoptions']/button[@id='ngaloginbutton']")
    @CacheLookup //Now what cachelookup does is it stores elements having @cachelookup annotation applied over it and then stores this element for further reference/s.
    public WebElement ngaLoginButton;
    
    @FindBy(how = How.XPATH, using = "//*[@id='cqLoginForm_username']")
    public WebElement ngaLoginUsernameField;
    
    @FindBy(how = How.XPATH, using = "//*[@id='cqLoginForm_password']")
    public WebElement ngaLoginPasswordField;

    @FindBy(how = How.XPATH, using = "//*[@id='cqLoginForm']/button")
    public WebElement ngaLoginSignInButton;
    
    public void SignInWithNGA(WebDriver webDriver, String ngaUserLogin, String password) {
        ngaLoginUsernameField.sendKeys(ngaUserLogin);
        ngaLoginPasswordField.sendKeys(password);
        ngaLoginSignInButton.click();
    }
  
    public SignIn(WebDriver driver) {
        super(driver);
    }
    
}
