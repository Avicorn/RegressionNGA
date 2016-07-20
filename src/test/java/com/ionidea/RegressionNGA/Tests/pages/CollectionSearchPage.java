package com.ionidea.RegressionNGA.Tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class CollectionSearchPage extends Page {

  
    @FindBy(how = How.ID, using = "artist")
    //@CacheLookup //Now what cachelookup does is it stores elements having @cachelookup annotation applied over it and then stores this element for further reference/s.
    public WebElement artistNameTextInput;

    @FindBy(how = How.ID, using = "title")
    public WebElement keyWordsInTitleTextInput;
    
    @FindBy(how = How.ID, using = "img_avail")
    public WebElement imagesOnlyCheckbox;
    
    @FindBy(how = How.ID, using = "artistSearch")
    public WebElement artistSearchButton;


    
    @FindBy(how = How.ID, using = "keyword")
    public WebElement keywordsInObjectInformationTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='keyword']/following-sibling::input[@name='search']")
    public WebElement keywordsInObjectInformationSearchButton;

    @FindBy(how = How.ID, using = "credit")
    public WebElement creditLineTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='credit']/following-sibling::input[@name='search']")
    public WebElement creditLineSearchButton;
    
    @FindBy(how = How.ID, using = "provenance")
    public WebElement provenanceNameTextInput;
    
    @FindBy(how = How.ID, using = "provenanceSearch")
    public WebElement provenanceNameSearchButton;
    
    @FindBy(how = How.ID, using = "accession")
    public WebElement accessionNumberTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='accession']/following-sibling::input[@name='search']")
    public WebElement accessionNumberSearchButton;
    
    @FindBy(how = How.ID, using = "exhistory")
    public WebElement exhibitionHistoryTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='exhistory']/following-sibling::input[@name='search']")
    public WebElement exhibitionHistorySearchButton;    

    @FindBy(how = How.ID, using = "catalogue")
    public WebElement catalogueRaisonneTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='catalogue']/following-sibling::input[@name='search']")
    public WebElement catalogueRaisonneSearchButton;    

    
    
    @FindBy(how = How.ID, using = "s2id_oe-catalogues")
    public WebElement onlineEditionsSelect;
    
    
    
    @FindBy(how = How.ID, using = "oe-search-submit")
    public WebElement onlineEdiitonsSearchButton;       


    
    public String pageURL = "/content/ngaweb/Collection/collection-search.html";
    
    public void SignInWithNGA(WebDriver webDriver, String ngaUserLogin, String password) {

    }
  
    public CollectionSearchPage(WebDriver driver) {
        super(driver);
    }
    
}
