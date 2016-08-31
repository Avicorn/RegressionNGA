package com.ionidea.RegressionNGA.Tests.pages;

import com.ionidea.RegressionNGA.Tests.pages.Page;
import com.ionidea.RegressionNGA.Tests.util.IConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class ExamplePage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup //cachelookup stores elements having @cachelookup annotation applied over it for further reference with out new search in DOM
    public WebElement header;

    public ExamplePage(WebDriver webDriver) {
        super(webDriver);
    }
}
