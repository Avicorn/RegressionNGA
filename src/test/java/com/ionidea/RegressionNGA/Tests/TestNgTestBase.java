package com.ionidea.RegressionNGA.Tests;

import com.google.inject.Inject;
import com.ionidea.RegressionNGA.Tests.util.GlobalCommonModule;
import com.ionidea.RegressionNGA.Tests.util.IConfiguration;
import com.ionidea.RegressionNGA.Tests.util.IDriverExtension;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Guice;
import com.ionidea.RegressionNGA.Tests.util.IFileHelper;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Base class for TestNG-based test classes
 */
@Guice(modules = GlobalCommonModule.class)
public class TestNgTestBase {

    @Inject
    protected IConfiguration m_config;
    @Inject
    protected IFileHelper m_fileHelper;
    @Inject
    protected IDriverExtension m_driverExtension;

    protected static String m_gridHubUrl;
    protected static String m_baseUrl;
    protected static String m_ngaUserLogin;
    protected static String m_ngaUserPassword;
    protected static int m_standartWaitTime;
    
    protected static Capabilities m_capabilities;

    protected WebDriver driver;

    public void init() {

    }

    @BeforeSuite
    public void initTestSuite() {

        try {
            m_baseUrl = m_config.getProperty("site.url");
            m_gridHubUrl = m_config.getProperty("grid.url");
            m_ngaUserLogin = m_config.getProperty("ngaUserLogin");
            m_ngaUserPassword = m_config.getProperty("ngaUserPassword");
            m_standartWaitTime = Integer.valueOf(m_config.getProperty("standartWaitTime"));
            m_capabilities = m_config.getCapabilities();
        } catch (IOException ex) {
            Logger.getLogger(TestNgTestBase.class.getName()).log(Level.SEVERE, null, ex);

            System.exit(1);
        }
        
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.CLIENT, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        logs.enable(LogType.PERFORMANCE, Level.ALL);
        logs.enable(LogType.PROFILER, Level.ALL);
        logs.enable(LogType.SERVER, Level.ALL);

        ((DesiredCapabilities) m_capabilities).setCapability(CapabilityType.LOGGING_PREFS, logs);

        if ("".equals(m_gridHubUrl)) {
            m_gridHubUrl = null;
        }

        WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    }

    @BeforeMethod
    public void initWebDriver() throws IOException {
        driver = WebDriverFactory.getDriver(m_gridHubUrl, m_capabilities);
        //TODO: move this to config for test suit, so that it would be possible to run suit with diff dims
        driver.manage().window().setSize(new Dimension(1024 + 50, 768));
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed " + testResult.getName());
            m_fileHelper.insurePathExists(m_config.getOutputPath());

//TODO: modify folder/files naming strategy to incorporate getTestName() for test classes with lots of tests inside
            //screenshot
            byte[] screenshootBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String onFailureFilePath = m_config.getOutputPath() + m_fileHelper.getNewFileName(this.getClass(), ".jpg");
            FileUtils.writeByteArrayToFile(new File(onFailureFilePath), screenshootBytes);

            onFailureFilePath = m_config.getOutputPath() + m_fileHelper.getNewFileName(this.getClass(), ".log");
            File driverLog = new File(onFailureFilePath);
            FileOutputStream fos = new FileOutputStream(driverLog);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            //log file
            Logs logs = driver.manage().logs();
            LogEntries logEntries = logs.get(LogType.DRIVER);
            String logLine;

            for (LogEntry logEntry : logEntries) {
                logLine = logEntry.getMessage();
                bw.write(logLine);
                bw.newLine();
                //System.out.println(logLine);
            }
//            
//            logEntries = logs.get(LogType.BROWSER);
//            for (LogEntry logEntry : logEntries) {
//                logLine = logEntry.getMessage();
//                bw.write(logLine);
//                bw.newLine();
//                System.out.println(logLine);
//            }
//            
            bw.close();
        } else {
            System.out.println("Test succeed " + testResult.getName());
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.dismissAll();
    }
}
