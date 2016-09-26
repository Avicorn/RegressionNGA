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
public class WidgetBibliographyPage extends MainPage {
    
    public WidgetBibliographyPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(how = How.XPATH, using = "//div[@id='bibliography']/h5")
    public WebElement bibliographyLabel;
    
    @FindBy(how = How.XPATH, using = "//div[@id='bibliography']/dl/dt")
    public List<WebElement> yearLabel;
    
    @FindBy(how = How.XPATH, using = "//div[@id='bibliography']/dl/dd")
    public List<WebElement> yearDescriptionLabel;


    
}
