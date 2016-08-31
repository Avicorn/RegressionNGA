/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ionidea.RegressionNGA.Tests;

import com.ionidea.RegressionNGA.Tests.pages.MainPage;
import static java.lang.Boolean.TRUE;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author TestQA
 */
public class MainPageHeaderTest extends TestNgTestBase{ 
    
    /**
     * the method verifies that the opened page is respective to the used submenu option
     * @param relativeUrl 
     * @param keyElement 
     * @return 
     */
    
    
    public boolean verifyOpenedPage(String relativeUrl,String title){
        //wait until the page title is displayed the correct value
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        System.out.println(title);
        wait.until(ExpectedConditions.titleContains(title));   
        //verify that the title contains the same value as selected sub menu option
        Assert.assertTrue(driver.getTitle().contains(title));
        System.out.println(title);
        //verify that the URL of opened page is correct 
        Assert.assertTrue(driver.getCurrentUrl().contains(m_baseUrl+relativeUrl));
        System.out.println("the page is opened");        
        return TRUE;
    }

    @Test
    public void testMenu() throws InterruptedException{
        MainPage menu = new MainPage(driver);
        driver.get("http://www.nga.gov");        
        
//COLLECTION        
        int subMenuNumber = 0;
        String [] urlAddresses = {"/content/ngaweb/Collection/highlights.html",
                                  "/content/ngaweb/Collection/collection-search.html",
                                  "/content/ngaweb/Collection/artists.html",
                                  "/content/ngaweb/Collection/recent_acquisitions.html"};
        String [] titles ={"Highlights",
                          "Collection Search",
                          "Artists",
                          "Recent Acquisitions"
                         };
       
                
        while (subMenuNumber<4){
            menu.selectMenuOption(menu.mainMenuOptions.get(0), menu.subMenuCollection.get(subMenuNumber)); 
            verifyOpenedPage(urlAddresses[subMenuNumber], titles[subMenuNumber]);
            System.out.println("The submenu verified: "+menu.subMenuCollection.get(subMenuNumber));
            subMenuNumber++;
        }
    }
}
  