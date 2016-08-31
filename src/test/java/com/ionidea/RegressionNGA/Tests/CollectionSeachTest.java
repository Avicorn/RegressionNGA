package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.CollectionSearchPage;
import com.ionidea.RegressionNGA.Tests.pages.CollectionSearchResultsPage;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CollectionSeachTest extends TestNgTestBase {
    private String SearchTerm = "Red"; //TODO Find a way to store test data outside the test to make tests "data-driven"
    
    private CollectionSearchPage collectionSearch;
    private CollectionSearchResultsPage collectionSearchResults;

    @BeforeMethod
    public void initPageObjects() {
        collectionSearch = PageFactory.initElements(driver, CollectionSearchPage.class);
        collectionSearch.initialize(m_config);
        
        collectionSearchResults = PageFactory.initElements(driver, CollectionSearchResultsPage.class);
        collectionSearch.initialize(m_config);

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
    
    
    
    
    
    
    // Verify Collection search on Key words in object information, on simple data, letters and digits only.
    @Test
    public void testCollectionSearchByKeyWordsInObjectInformation() {
        driver.get(m_baseUrl + collectionSearch.pageURL);
        //Enter Search term in to target field
        collectionSearch.keywordsInObjectInformationTextInput.sendKeys(SearchTerm); 
        collectionSearch.keywordsInObjectInformationSearchButton.click();
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
    
    // Verify Collection search on Credit Line, on simple data, letters and digits only.
    @Test
    public void testCollectionSearchByCreditLine() {
        driver.get(m_baseUrl + collectionSearch.pageURL);
        //Enter Search term in to target field
        collectionSearch.creditLineTextInput.sendKeys(SearchTerm); 
        collectionSearch.creditLineSearchButton.click();
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
    
    // Verify Collection search on Accession number.
    @Test
    public void testCollectionSearchByAccessionNumber() {
        String SearchTerm = "2010.1";
        
        driver.get(m_baseUrl + collectionSearch.pageURL);
        //Enter Search term in to target field
        collectionSearch.accessionNumberTextInput.sendKeys(SearchTerm); 
        collectionSearch.accessionNumberSearchButton.click();
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

    // Verify Collection search on Exhibition history.
    @Test
    public void testCollectionSearchByExhibitionHistory() {
        driver.get(m_baseUrl + collectionSearch.pageURL);
        //Enter Search term in to target field
        collectionSearch.exhibitionHistoryTextInput.sendKeys(SearchTerm); 
        collectionSearch.exhibitionHistorySearchButton.click();
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
    
    // Verify Collection search on Catalogue raisonne.
    @Test
    public void testCollectionSearchByCatalogueRaisonne() {
        String SearchTerm = "Rembrandt";
        driver.get(m_baseUrl + collectionSearch.pageURL);
        //Enter Search term in to target field
        collectionSearch.catalogueRaisonneTextInput.sendKeys(SearchTerm); 
        collectionSearch.catalogueRaisonneSearchButton.click();
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
