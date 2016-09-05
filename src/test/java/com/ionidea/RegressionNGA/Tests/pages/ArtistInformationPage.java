/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author TestQA
 */
public class ArtistInformationPage extends MainPage{
    
    /**
     * Constructor of the  class
     * @param driver 
     */
    public ArtistInformationPage(WebDriver driver) {
        super(driver);
    }    
    
    /**
     * the URL of the page
     */
    public String pageUrl=("/content/ngaweb/Collection/artist-info.2377.html");
     
    
    /**
     * The Web Elements of the page (Biography is selected)
     */
    
//MAIN
    
    @FindBy(how = How.XPATH, using = "(//a[contains(text(),'NGA Online Editions')])[3]")
    public WebElement onlineEditions;
    
    @FindBy(how = How.XPATH, using = "(//a[contains(text(),'Berchem, Nicolaes Pietersz')])[2]")
    public WebElement nameBreadCrumb;            
    
    @FindBy(how = How.XPATH, using ="//div[@id='isOSCIObject']/div/div[2]/dl/dt")
    public WebElement nameTitle;
    
    @FindBy(how = How.XPATH, using ="//div[@id='isOSCIObject']/div/div[2]/dl/dd")
    public WebElement descriptionDate;    
    
    @FindBy(how = How.XPATH, using ="//div[@id='isOSCIObject']/div/div[2]/dl/dd[2]")
    public WebElement descriptionName ;    
    
    @FindBy(how = How.XPATH, using ="//img[@alt='Constituent Image']")
    public WebElement artistImage;    
    
    @FindBy(how = How.XPATH, using ="//button[@name='toolbar-cite']")
    public WebElement citeLink;
            
    @FindBy(how = How.XPATH, using ="//button[@name='toolbar-export']")
    public WebElement pdfLink ;
    
    @FindBy(how = How.XPATH, using ="//button[@name='toolbar-archived']")
    public WebElement archivedVersionsLink ;
    
    @FindBy(how = How.XPATH, using ="//input[@id='ot-search']")
    public WebElement searchInputField;
    
    @FindBy(how = How.XPATH, using ="//li[@id='biography-link']")
    public WebElement biographyLink;
    
//  #Biography
    
    @FindBy(how = How.XPATH, using ="//li[@id='works-link']")
    public WebElement worksOfArtLink;
    
    @FindBy(how = How.XPATH, using ="//li[@id='bibliography-link']")
    public WebElement artistBibliographyLink;
       
    @FindBy(how = How.XPATH, using ="//div[@id='biography']/h5")
    public WebElement biographyTitle;
    
    @FindBy(how = How.XPATH, using ="//div[@id='biography']/p")
    public WebElement textBegin;
    
    @FindBy(how = How.XPATH, using ="//div[@id='biography']/p[6]")
    public WebElement theAuthorName;
    
    @FindBy(how = How.XPATH, using ="//div[@id='biography']/p[7]")
    public WebElement dateOfArticle;
    
    
    
    
//  #Works  of art  
    
    //Left accordions: 
    
    @FindBy(how = How.XPATH, using ="//li[@id='works-link']")
    public WebElement worksOfArtistLink;
    
    @FindBy(how = How.XPATH, using ="//fieldset[@id='artobject-fieldset']/div/h3")
    public List<WebElement> leftAccordionsClosed;
    
    @FindBy(how = How.XPATH, using ="//fieldset[@id='artobject-fieldset']/div/h3")
    public List<WebElement> leftAccordionsOpen;
    
    @FindBy(how = How.XPATH, using ="*//fieldset [@Id='artobject-fieldset']/div/div/ul/li/input")
    public List<WebElement> allCheckBoxes;
    
    @FindBy(how = How.XPATH, using ="//fieldset[@id='artobject-fieldset']/div/div/ul/li/label")
    public List<WebElement> allLabels;
      
    @FindBy(how = How.XPATH, using ="//select[@id='year1']")
    public WebElement yearsFromSelector;
    
    @FindBy(how = How.XPATH, using ="//select[@id='year2']")
    public WebElement yearsToSelector;
    

    
    //Main
    @FindBy(how = How.XPATH, using ="//div[@id='constituentWorks']/div[2]/div/ul/li")
    public WebElement filterLabel;
    
    @FindBy(how = How.XPATH, using ="//div[@id='collectionListing']/div/span")
    public WebElement sortWorksByLabel;
    
    @FindBy(how = How.XPATH, using ="//ul[@id='sortOrder']/li/a")
    public WebElement defaultSortOption;    
    
    @FindBy(how = How.XPATH, using ="//ul[@id='sortOrder']/li[2]/a")
    public WebElement chronologicalSortOption;
    
    @FindBy(how = How.XPATH, using ="//ul[@id='sortOrder']/li[3]")
    public WebElement titleSortOption;
    
    @FindBy(how = How.XPATH, using ="//div [@class='pagination']/ul/li[@id='page1']/a[@class='current']")
    public List<WebElement> pageButton1;
    
    @FindBy(how = How.XPATH, using ="//div [@class='pagination']/ul/li[@id='pageNext']/a")
    public List <WebElement> pageButtonNext;
    
    
    //  List of Results
    @FindBy(how = How.XPATH, using ="//li/span")
    public List<WebElement> categoryLabels;
    
    @FindBy(how = How.XPATH, using ="(//dt[@class='artist']/a[contains(@href, '/content/ngaweb/Collection/artist-info.2377.html')])")
    public List<WebElement> artistNameLabels;
    
    @FindBy(how = How.XPATH, using ="//ul[@id='returns']/li/dl/dd[@class='lifespan']")
    public List<WebElement> lifeSpanLabels;
    
    @FindBy(how = How.XPATH, using ="//ul[@id='returns']/li/dl[2]/dt/a")
    public List<WebElement> artNameLabels;
    
    @FindBy(how = How.XPATH, using ="//dd/a/img")
    public List<WebElement> imagesThumbnails;
    
    @FindBy(how = How.XPATH, using = "//dl[@class='return-art']/dd[@class='created']")
    public WebElement createdLabelsList;
    
    @FindBy(how = How.XPATH, using = "//dl[@class='return-art']/dd[@class='medium']")
    public WebElement mediumLabelsList;
        
    @FindBy(how = How.XPATH, using = "//dl[@class='return-art']/dd[@class='dimensions']")
    public WebElement dimensionsLabelsList;
    
    @FindBy(how = How.XPATH, using = "//dl[@class='return-art']/dd[@class='credit']")
    public WebElement creditLabelsList;
    
    @FindBy(how = How.XPATH, using = "//dl[@class='return-art']/dd[@class='accession']")
    public WebElement acessionLabelsList;
    
    @FindBy(how = How.XPATH, using = "//dl[@class='return-art']/dd[@class='onview']")
    public WebElement onViewLabelsList;

    
// #Bibliography
    
    @FindBy(how = How.XPATH, using = "//div[@id='bibliography']/h5")
    public WebElement bibliographyLabel;
    
    @FindBy(how = How.XPATH, using = "//div[@id='bibliography']/dl/dt")
    public List<WebElement> yearLabel;
    
    @FindBy(how = How.XPATH, using = "//div[@id='bibliography']/dl/dd")
    public List<WebElement> yearDescriptionLabel;


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Artist bibliography
    @FindBy(how = How.XPATH, using ="//li[@id='bibliography-link']")
    public WebElement bibliographyLink;
    
    
    
    
    @Override
    public String getUrl(){
    return pageUrl;
    }
    

}
