package com.ionidea.RegressionNGA.Tests.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class CollectionSearchResults extends Page {

  
//    @FindBy(how = How.ID, using = "artist")
//    //@CacheLookup //Now what cachelookup does is it stores elements having @cachelookup annotation applied over it and then stores this element for further reference/s.
//    public WebElement artistNameTextInput;
    
    public String pageURL = "/content/ngaweb/collection-search-result.html";
    
    public List<WebElement> SearchResultsOnPage(WebDriver webDriver) {
        return webDriver.findElements(By.xpath("//*[@id='returns']/li"));
    }
    
    
    
    public int SearchResultsTotal(WebDriver webDriver) {
        //read bottom results counter and convert it to int
        String total = webDriver.findElement(By.xpath("//*[@id='collectionsResultListings']/div[@class='nav-returns btm']/div[@class='results']/span")).getText();
        int x1 = total.lastIndexOf(" of ") + 4;
        int x2 = total.lastIndexOf(" results");
        total = (String)total.subSequence(x1, x2);
        total = total.replace(",", "");
        return Integer.parseInt(total);        
    }
    
    public List<WebElement> SearchTerms(WebDriver webDriver) {
        return webDriver.findElements(By.xpath("//div[@class='results-filters']/ul[@class='filters-list']/li[@class='term']/span"));
    }    
    
    public CollectionSearchResults(WebDriver driver) {
        super(driver);
    }
    
}
