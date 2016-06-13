package com.ionidea.RegressionNGA.Tests.pages;

import com.ionidea.RegressionNGA.Tests.util.GlobalCommonModule;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Guice;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

}
