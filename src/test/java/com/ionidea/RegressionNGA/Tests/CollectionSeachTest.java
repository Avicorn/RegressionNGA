package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.CollectionSearch;
import com.ionidea.RegressionNGA.Tests.pages.CollectionSearchResults;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CollectionSeachTest extends TestNgTestBase {
    String SearchTerm = "Red"; //TODO Find a way to store test data outside the test to make tests "data-driven"
    private CollectionSearch collectionSearch;
    private CollectionSearchResults collectionSearchResults;

    @BeforeMethod
    public void initPageObjects() {
        collectionSearch = PageFactory.initElements(driver, CollectionSearch.class);
        collectionSearch.Initialize(m_config);
        
        collectionSearchResults = PageFactory.initElements(driver, CollectionSearchResults.class);
        collectionSearch.Initialize(m_config);

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
        Verify Search term presents as search filter
        Verify number of results is > 0
        
        Note: this test doesn't verify quality of search results
    */
    
    // Verify search by Artist ONLY on simple data
    @Test
    public void testCollectionSearchByArtist() {
        driver.get(m_baseUrl + collectionSearch.pageURL);
        
        collectionSearch.artistNameTextInput.sendKeys(SearchTerm); 
        collectionSearch.artistSearchButton.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(m_baseUrl + collectionSearchResults.pageURL);
        Assert.assertTrue(driver.getCurrentUrl().contains(m_baseUrl + collectionSearchResults.pageURL)); 

        WebElement firstSearchTerm = collectionSearchResults.SearchTerms(driver).get(0);
        Assert.assertEquals(SearchTerm, firstSearchTerm.getText());
        Assert.assertTrue(collectionSearchResults.SearchResultsTotal(driver) > 0);
    }
}
