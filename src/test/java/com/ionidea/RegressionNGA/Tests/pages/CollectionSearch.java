package com.ionidea.RegressionNGA.Tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class CollectionSearch extends Page {

  
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
    public WebElement KeywordsInObjectInformationTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='keyword']/following-sibling::input[@name='search']")
    public WebElement KeywordsInObjectInformationSearchButton;

    @FindBy(how = How.ID, using = "credit")
    public WebElement CreditLineTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='credit']/following-sibling::input[@name='search']")
    public WebElement CreditLineSearchButton;
    
    @FindBy(how = How.ID, using = "provenance")
    public WebElement ProvenanceNameTextInput;
    
    @FindBy(how = How.ID, using = "provenanceSearch")
    public WebElement ProvenanceNameSearchButton;
    
    @FindBy(how = How.ID, using = "accession")
    public WebElement AccessionNumberTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='accession']/following-sibling::input[@name='search']")
    public WebElement AccessionNumberSearchButton;
    
    @FindBy(how = How.ID, using = "exhistory")
    public WebElement ExhibitionHistoryTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='exhistory']/following-sibling::input[@name='search']")
    public WebElement ExhibitionHistorySearchButton;    

    @FindBy(how = How.ID, using = "catalogue")
    public WebElement CatalogueRaisonneTextInput;
    
    @FindBy(how = How.XPATH, using = "//input[@id='catalogue']/following-sibling::input[@name='search']")
    public WebElement CatalogueRaisonneSearchButton;    

    
    
    @FindBy(how = How.ID, using = "s2id_oe-catalogues")
    public WebElement OnlineEditionsSelect;
    
    
    
    @FindBy(how = How.ID, using = "oe-search-submit")
    public WebElement OnlineEditionsSearchButton;       


    
    public String pageURL = "/content/ngaweb/Collection/collection-search.html";
    
    public void SignInWithNGA(WebDriver webDriver, String ngaUserLogin, String password) {

    }
  
    public CollectionSearch(WebDriver driver) {
        super(driver);
    }
    
}
