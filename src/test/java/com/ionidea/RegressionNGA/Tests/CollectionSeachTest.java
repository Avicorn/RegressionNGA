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
}
