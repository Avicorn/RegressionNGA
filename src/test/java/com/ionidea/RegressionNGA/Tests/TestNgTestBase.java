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
import com.ionidea.RegressionNGA.Tests.util.IFileHelper;

/**
 * Base class for TestNG-based test classes
 */
@Guice(modules = GlobalCommonModule.class)
public class TestNgTestBase {

    @Inject
    protected IConfiguration m_config;
    @Inject
    protected IFileHelper m_fileHelper;

    protected static String m_gridHubUrl;
    protected static String m_baseUrl;
    protected static String m_ngaUserLogin;
    protected static String m_ngaUserPassword;
    protected static Capabilities m_capabilities;

  //protected static LoggingPreferences logs;
    protected WebDriver driver;

    public void init() {
    
    }
    
    @BeforeSuite
    public void initTestSuite() throws IOException {
        m_baseUrl = m_config.getProperty("site.url");
        m_gridHubUrl = m_config.getProperty("grid.url");
        m_ngaUserLogin = m_config.getProperty("ngaUserLogin");
        m_ngaUserPassword = m_config.getProperty("ngaUserPassword");
        m_capabilities = m_config.getCapabilities();

        if ("".equals(m_gridHubUrl)) {
            m_gridHubUrl = null;
        }

        //    logs = new LoggingPreferences();
        //    logs.enable(LogType.BROWSER, Level.ALL);
        //    logs.enable(LogType.CLIENT, Level.ALL);
        //    logs.enable(LogType.DRIVER, Level.ALL);
        //    logs.enable(LogType.PERFORMANCE, Level.ALL);
        //    logs.enable(LogType.PROFILER, Level.ALL);
        //    logs.enable(LogType.SERVER, Level.ALL);
        
        WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);



    }

    @BeforeMethod
    public void initWebDriver() throws IOException {
        driver = WebDriverFactory.getDriver(m_gridHubUrl, m_capabilities);
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());

            m_fileHelper.insurePathExists(m_config.getOutputPath());

            byte[] screenshootBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            
            String screenshootFilePath = m_config.getOutputPath() + m_fileHelper.getNewFileName(this.getClass(), ".jpg");
            FileUtils.writeByteArrayToFile(new File(screenshootFilePath), screenshootBytes);
       }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.dismissAll();
    }
}
