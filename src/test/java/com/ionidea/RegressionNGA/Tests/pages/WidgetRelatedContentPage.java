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
public class WidgetRelatedContentPage extends MainPage{
    
    public WidgetRelatedContentPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH, using ="//div[@id='relatedcontent']/h5")
    public WebElement relatedContentTitle;
    
    @FindBy(how = How.XPATH, using ="//div[@id='artistListing']/div/ul[@id='returns']/li/span[@class='category']")
    public List<WebElement> relatedContentResultTitle;
    
    @FindBy(how = How.XPATH, using ="//div[@id='artistListing']/div/ul[@id='returns']/li/dl/dt[@class='artist']/a")
    public List<WebElement> relatedContentResultLink;
    
    @FindBy(how = How.XPATH, using ="//div[@id='artistListing']/div/ul/li/dl/dd[@class='description']")
    public List<WebElement> relatedContentDescription;
    
    @FindBy(how = How.XPATH, using ="//div[@id='artistListing']//dd/a/img[@class='thumbnail']")
    public List<WebElement> relatedContentImage;
    
    
    
    
    
    
    
    

    
    
    
}
