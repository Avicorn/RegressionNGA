/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

/**
 *
 * @author TestQA
 */
public class WidgetWorksOfArtPage extends MainPage{
    
    public WidgetWorksOfArtPage(WebDriver driver) {
        super(driver);
    }
    
    //  #Works  of art  
    
    //Left accordions: 
    
    @FindBy(how = How.XPATH, using ="//li[@id='works-link']")
    public WebElement worksOfArtistLink;
    
    @FindBy(how = How.XPATH, using ="//fieldset/div[not(@style='display: none;')]/h3")
    public List<WebElement> leftAccordionsClosed;
    
    @FindBy(how = How.XPATH, using ="//fieldset[@id='artobject-fieldset']/div[not(@style='display: none;')]/h3")
    public List<WebElement> leftAccordionsOpen;
    
    @FindBy(how = How.XPATH, using ="*//fieldset [@Id='artobject-fieldset']/div/div/ul/li/input [not(@disabled='disabled')]")
    public List<WebElement> allCheckBoxes;
    
    @FindBy(how = How.XPATH, using ="//fieldset[@id='artobject-fieldset']/div [not(@style='display: none;')]/div/ul/li/label")
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

    
    public boolean verifyAllElementsAreDisplayed(List<WebElement> list, FluentWait wait){
        int index1 =0;
        //verify all elements from the list
        while(index1<list.size()){             
             wait.until(ExpectedConditions.elementToBeClickable(list.get(index1)));
             Assert.assertTrue(list.get(index1).isDisplayed());               
             System.out.println("The element is displayed"+list.get(index1));
             index1++; 
        }
        return true;
    }
    /**
     * 
     * @param list the list of check-boxes
     * @return 
     */    
    public boolean verifyAllCheckBoxesAreUnselected(List<WebElement> list, FluentWait wait){
        int index2 =0;
        
        //verify all elements from the list
        while(index2<list.size()){
             wait.until(ExpectedConditions.elementToBeClickable(list.get(index2)));
             Assert.assertFalse(list.get(index2).isSelected());                
             System.out.println("The element is not selected"+list.get(index2));
             index2++;
        }
        return true;
    }    
    /**
     * 
     * @param listToClick - list of WebElements
     * @return boolean 
     */    
    public boolean clickAllElements(List<WebElement> listToClick, FluentWait wait){
        int index1 =0;
        //verify all elements from the list
        while(index1<listToClick.size()){
             wait.until(ExpectedConditions.elementToBeClickable(listToClick.get(index1)));
             listToClick.get(index1).click();  
             index1++; 
        }
        System.out.println("All elements are selected");
        return true;
    }
    /**
     * 
     * @param page - the page 
     * @param list - the list of elements to count across all pages
     * @return - number of Works of Art
     * @throws InterruptedException 
     */
    public  int addToListallWorkObjects(WidgetWorksOfArtPage page,List<WebElement> list,Integer pageNumber, FluentWait wait) throws InterruptedException{
        int number;
        
        // the list will contain elemtns from all pages
        List<WebElement> entireList = new ArrayList<WebElement>();
        entireList.addAll(list);
        //open all pages one by one and add work objects to the entire list
        int currentPage=0;
        while(currentPage<pageNumber){
            Thread.sleep(2000);
            page.pageButtonNext.get(0).click();
            wait.until(ExpectedConditions.visibilityOfAllElements(list));
            entireList.addAll(page.artistNameLabels); 
            System.out.println("the entire number is:"+entireList.size());
            currentPage++;
        }
       
        System.out.println("The full number of works of art is: 50!");
        
        //get the number of the ojects 
        number=entireList.size();        
        return number;
    
    }
}