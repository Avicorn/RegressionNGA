/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author TestQA
 */
public class WidgetBiographyPage extends MainPage{
    
    public WidgetBiographyPage(WebDriver driver) {
        super(driver);
    }

       
    @FindBy(how = How.XPATH, using ="//div[@id='biography']/h5")
    public WebElement biographyTitle;
    
    @FindBy(how = How.XPATH, using ="//div[@id='biography']/p")
    public WebElement textBegin;
    
    @FindBy(how = How.XPATH, using ="//div[@id='biography']/p[6]")
    public WebElement theAuthorName;
    
    @FindBy(how = How.XPATH, using ="//div[@id='biography']/p[7]")
    public WebElement dateOfArticle;


    
}
