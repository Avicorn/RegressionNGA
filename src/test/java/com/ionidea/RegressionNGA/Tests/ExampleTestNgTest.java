package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.ExamplePage;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ionidea.RegressionNGA.Tests.TestNgTestBase;

public class ExampleTestNgTest extends TestNgTestBase {

  private ExamplePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, ExamplePage.class);
    homepage.initialize(m_config);

  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(m_baseUrl);
    Assert.assertFalse("".equals(homepage.header.getText()));
    
  }
}
