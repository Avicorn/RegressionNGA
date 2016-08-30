package com.ionidea.RegressionNGA.Tests;

import com.google.inject.Inject;
import com.ionidea.RegressionNGA.Tests.pages.CollectionSearchPage;
import com.ionidea.RegressionNGA.Tests.pages.CollectionSearchResultsPage;
import com.ionidea.RegressionNGA.Tests.util.DriverExtension;
import com.ionidea.RegressionNGA.Tests.util.GlobalCommonModule;
import com.ionidea.RegressionNGA.Tests.util.IDriverExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(modules = GlobalCommonModule.class)
public class CollectionSeachByProvenanceName extends TestNgTestBase {
    @Inject
    protected IDriverExtension m_driverExtension;
    
    private String SearchTerm = "Red"; //TODO Find a way to store test data outside the test to make tests "data-driven"
    
    private CollectionSearchPage collectionSearch;
    private CollectionSearchResultsPage collectionSearchResults;

    @BeforeMethod
    public void initPageObjects() {
        collectionSearch = PageFactory.initElements(driver, CollectionSearchPage.class);
        collectionSearch.Initialize(m_config);
        
        collectionSearchResults = PageFactory.initElements(driver, CollectionSearchResultsPage.class);
        collectionSearch.Initialize(m_config);
    }

    private void hoverElement(WebElement element) {
        //    new Actions(driver).moveToElement(element).perform();
        String mouseOverScript = ""
                + "if (document.createEvent) {"
                + "     var evObj = document.createEvent('MouseEvents'); "
                + "     evObj.initEvent('mouseover', true, false); "
                + "     arguments[0].dispatchEvent(evObj);"
                + "} else if (document.createEventObject) {"
                + "     arguments[0].fireEvent('onmouseover');"
                + "}";

        ((JavascriptExecutor) driver).executeScript(mouseOverScript, element);
    }
    
    /*
        "Search by Artist" form contains 3 components: Artist, Keyword and Images only checkbox
        We need to verify them all solo and combined are functional and produce valuable search queries
        Search results may differ depending on searchterm, e.g. stoplist or special symbols
    */
    
    
    /*
        Open Collection Search page
        Enter Search term in to target field
        Click on Search button
        Verify collection-search-result page opened
        Verify Search term is present as both search filter and part of the page URL
        Verify number of results is > 0
        
        Note: this test doesn't verify quality of search results
    */
    
    // Verify Artist search by Artist field ONLY, on simple data, letters and digits only.
    @Test
    public void testCollectionSearchByArtistName() {
        driver.get(m_baseUrl + collectionSearch.pageURL);
        //Enter Search term in to target field
        collectionSearch.artistNameTextInput.sendKeys(SearchTerm); 
        collectionSearch.artistSearchButton.click();
        //Verify collection-search-result page opened
        Assert.assertTrue(driver.getCurrentUrl().contains(m_baseUrl + collectionSearchResults.pageURL)); 
        //Verify Search term is present as a part of the page URL
        Assert.assertTrue(driver.getCurrentUrl().contains(SearchTerm)); 
        //Verify Search term is present as a search filter
        WebElement firstSearchTerm = collectionSearchResults.SearchTerms(driver).get(0);
        Assert.assertEquals(SearchTerm, firstSearchTerm.getText());
        //Verify number of results is > 0
        Assert.assertTrue(collectionSearchResults.SearchResultsTotal(driver) > 0);
    }
    
    // Verify Artist search by Key words in title field ONLY, on simple data, letters and digits only.
    @Test
    public void testCollectionSearchByKeyWordsInTitle() {
        driver.get(m_baseUrl + collectionSearch.pageURL);
        //Enter Search term in to target field
        collectionSearch.keyWordsInTitleTextInput.sendKeys(SearchTerm); 
        collectionSearch.artistSearchButton.click();
        //Verify collection-search-result page opened
        Assert.assertTrue(driver.getCurrentUrl().contains(m_baseUrl + collectionSearchResults.pageURL)); 
        //Verify Search term is present as a part of the page URL
        Assert.assertTrue(driver.getCurrentUrl().contains(SearchTerm)); 
        //Verify Search term is present as a search filter
        WebElement firstSearchTerm = collectionSearchResults.SearchTerms(driver).get(0);
        Assert.assertEquals(SearchTerm, firstSearchTerm.getText());
        //Verify number of results is > 0
        Assert.assertTrue(collectionSearchResults.SearchResultsTotal(driver) > 0);
    }
    
    // Verify Artist search with Images Only Checkbox checked, without key terms.
    @Test
    public void testCollectionSearchByImagesOnlyCheckbox() {
        driver.get(m_baseUrl + collectionSearch.pageURL);
        //Check checkbox
        collectionSearch.imagesOnlyCheckbox.click(); 
        collectionSearch.artistSearchButton.click();
        //Verify collection-search-result page opened
        Assert.assertTrue(driver.getCurrentUrl().contains(m_baseUrl + collectionSearchResults.pageURL)); 
        //Verify Checkbox filter is present as a part of the page URL
        Assert.assertTrue(driver.getCurrentUrl().contains("Images_online")); 
        //Verify Checkbox filter is present as a search filter
        WebElement firstSearchTerm = collectionSearchResults.SearchTerms(driver).get(0);
        Assert.assertEquals("Images online", firstSearchTerm.getText());
        //Verify number of results is > 0
        Assert.assertTrue(collectionSearchResults.SearchResultsTotal(driver) > 0);
    }    
    
    
    // Verify Collection search on Provenance Name. This one is different, it works only with exact value, selected wrom dropdown after initial search term input
    @Test
    public void testCollectionSearchByProvenanceName() {
        String SearchTerm = "A.R. Ball";
        
        driver.get(m_baseUrl + collectionSearch.pageURL);
        //Enter Search term in to target field
        collectionSearch.provenanceNameTextInput.sendKeys(SearchTerm);
        //mouse over target term
        
        hoverElement(driver.findElement(By.id("ui-id-3")));
        driver.findElement(By.id("ui-id-3")).click();
        //hoverElementxxx(driver.findElement(By.xpath("//li[@class='ui-menu-item']/a[contains(text(),'A.R. Ball')]")));
        hoverElement(driver.findElement(By.xpath("//li[@class='ui-menu-item']")));
        driver.findElement(By.xpath("//li[@class='ui-menu-item']")).click();
        
        //li[@class='ui-menu-item']/a[contains(text(),'A.R. Ball')]
        collectionSearch.provenanceNameTextInput.click();
        //Verify collection-search-result page opened
        Assert.assertTrue(driver.getCurrentUrl().contains(m_baseUrl + collectionSearchResults.pageURL)); 
        //Verify Search term is present as a part of the page URL
        Assert.assertTrue(driver.getCurrentUrl().contains(SearchTerm)); 
        //Verify Search term is present as a search filter
        WebElement firstSearchTerm = collectionSearchResults.SearchTerms(driver).get(0);
        Assert.assertEquals(SearchTerm, firstSearchTerm.getText());
        //Verify number of results is > 0
        Assert.assertTrue(collectionSearchResults.SearchResultsTotal(driver) > 0);
    }
    
}
