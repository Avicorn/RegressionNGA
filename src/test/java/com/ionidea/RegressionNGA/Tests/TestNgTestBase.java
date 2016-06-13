package com.ionidea.RegressionNGA.Tests;

import com.google.inject.Inject;
import com.ionidea.RegressionNGA.Tests.util.GlobalCommonModule;
import com.ionidea.RegressionNGA.Tests.util.IConfiguration;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import com.ionidea.RegressionNGA.Tests.util.PropertyLoader;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.lang.*;
import org.testng.annotations.Guice;

/**
 * Base class for TestNG-based test classes
 */
@Guice(modules = GlobalCommonModule.class)
public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static String ngaUserLogin;
  protected static String ngaUserPassword;
  protected static Capabilities capabilities;
  
  //protected static LoggingPreferences logs;

  protected WebDriver driver;
  @Inject
  private IConfiguration _configuration;
  
  @BeforeSuite
  public void initTestSuite() throws IOException{
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    ngaUserLogin = PropertyLoader.loadProperty("ngaUserLogin");
    ngaUserPassword = PropertyLoader.loadProperty("ngaUserPassword");
    
//    logs = new LoggingPreferences();
//    logs.enable(LogType.BROWSER, Level.ALL);
//    logs.enable(LogType.CLIENT, Level.ALL);
//    logs.enable(LogType.DRIVER, Level.ALL);
//    logs.enable(LogType.PERFORMANCE, Level.ALL);
//    logs.enable(LogType.PROFILER, Level.ALL);
//    logs.enable(LogType.SERVER, Level.ALL);
    
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }

    @BeforeMethod
    public void initWebDriver() {
      driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
            //get current date time with Date()
            
            (new File(_configuration.getOutputPath())).mkdirs();
            FileUtils.copyFile(scrFile, new File(_configuration.getOutputPath() + this.getClass().getName()+dateFormat.format(new Date())+".jpg"));
            //TODO: Modify. Should create new date named folder on each run, screenshot should contain name of the test          
          
      }        
    }

  
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
      WebDriverFactory.dismissAll();
    }
}
